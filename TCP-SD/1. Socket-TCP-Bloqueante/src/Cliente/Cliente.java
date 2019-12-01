package Cliente;

import Interface.LoginCliente;
import Interface.MsgDireta;
import Servidor.ListaServicos;
import Servidor.Protocolo;
import Servidor.Servico;
import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Cliente {
    
    DataInputStream in = null;                  // cria um duto de entrada
    DataOutputStream out = null;
    String receber;
    public Socket clientSocket = null;
    boolean flagSair = false;
    public boolean flagMsg = false;
    Gson gson = new Gson();
    Protocolo protocolo;
    String enviar;
    private final ListaClientes lista = ListaClientes.getInstance();
    private final ListaServicos lServico = ListaServicos.getInstance();
    LoginCliente log;
    ArrayList <MsgDireta> msgs = new ArrayList();
    
    public Cliente(String nome, String serverHostname, int port, String tipo, LoginCliente log) {
        protocolo = new Protocolo("login", nome, tipo);
        enviar = gson.toJson(protocolo);
        System.out.println("Attemping to connect to host "
                + serverHostname + " on port " + port);
        
        try {
            clientSocket = new Socket(serverHostname, port);
            in = new DataInputStream(clientSocket.getInputStream());    // aponta o duto de entrada para o socket do cliente
            out = new DataOutputStream(clientSocket.getOutputStream());       // aponta o duto de saída para o socket do cliente

            out.writeUTF(enviar);
            
        } catch (UnknownHostException e) {
            System.err.println("Host desconhecido: " + serverHostname);
            System.exit(0);
        } catch (IOException e) {
            System.err.println("Não foi possível I/O para"
                    + "a conexão com:" + serverHostname);
            System.exit(0);
        }
        this.log = log;
        new Thread(getMessage).start();
    }
    
    public void sendMessage(Usuario user, String msg) {
        protocolo = new Protocolo(msg, user);
        try {
            out.writeUTF(gson.toJson(protocolo));
        } catch (IOException ex) {
            System.out.println("Não foi possivel enviar a mensagem ao servidor");
        }
    }
    
    public void sendBroadcast(String msg) {
        protocolo = new Protocolo(msg);
        try {
            out.writeUTF(gson.toJson(protocolo));
        } catch (IOException ex) {
            System.out.println("Desconectado do servidor");
            //Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cadastrarServico(String cargo, float salario, String descricao) {
        protocolo = new Protocolo("cadastrarServico", new Servico(cargo, descricao, salario));
        try {
            out.writeUTF(gson.toJson(protocolo));
        } catch (IOException ex) {
            System.out.println("Desconectado do servidor");
            //Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void interesseServico(Servico servico)
    {
        protocolo = new Protocolo("interesseServico", servico);
        try {
            out.writeUTF(gson.toJson(protocolo));
        } catch (IOException ex) {
            System.out.println("Desconectado do servidor");
            //Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    public ArrayList<Usuario> getInteressados(Servico servico)
    {
        ArrayList<Usuario> s = lServico.getServEmp(servico).getListaInteressados();
        if(s != null)
            return s;
        System.out.println("nulo");
        return null;
    }      
    
    public void contratacao(Servico servico, Usuario user)
    {
        protocolo = new Protocolo(servico, user);
        try {
            out.writeUTF(gson.toJson(protocolo));
        } catch (IOException ex) {
            System.out.println("Erro ao enviar");
        }
    }
    
    private Runnable getMessage = new Runnable() {
        
        public void run() {
            try {
                boolean flag = true;
                while ((receber = in.readUTF()) != null) {
                    System.out.println("Servidor retornou: " + receber);
                    protocolo = gson.fromJson(receber, Protocolo.class);
                    switch (protocolo.getAction()) {
                        case "listarUsuarios":
                            lista.setListaCliente(protocolo.getUsuarios());
                            log.notifica();
                            break;
                        case "broadcast":
                            log.notifica(protocolo.getMensagem());
                            break;
                        case "logout":
                            log.notifica();
                            return;
                        case "listarServicos":
                            log.notifica();
                            lServico.setListaServico(protocolo.getServicos());
                            break;
                        case "mensagemDireta":
                            for(MsgDireta ms: msgs)
                                if(ms.getUser().getNome().equals(protocolo.getRemetente().getNome()))
                                {
                                    ms.notifica(protocolo.getMensagem());
                                    flag = false;
                                }
                            if(flag)
                                log.avisa(protocolo.getRemetente(), protocolo.getMensagem());
                            flag = true;
                            break;
                        case "listarInteressados":
                            lServico.atualizaInteressados(protocolo.getServico(),
                                    protocolo.getInteressados());
                            break;
                        case "contratacao":
                            JOptionPane.showMessageDialog(null,
                                    "Você foi contratado para a vaga: " +
                                            protocolo.getServico().getCargo()+
                                            "\nEntre em contato com: "+
                                            protocolo.getServico().getEmpregador().getNome()+
                                            " para mais informações");
                            break;
                        default:
                            break;
                    }
                }
            } catch (IOException ex) {
                System.out.println("Desconectado do servidor");
                System.exit(0);
            }
            
        }
    };
    
    public void logout() {
        protocolo = new Protocolo();
        try {
            out.writeUTF(gson.toJson(protocolo));
            clientSocket.close();
            out.close();
            in.close();
        } catch (IOException ex) {
            System.out.println("Desconectado do servidor");
        }
        
    }
    
    public void addMsg(MsgDireta msger)
    {
        msgs.add(msger);
    }

    /*public static void main(String[] args) throws IOException {

        while ((receber = in.readUTF()) != null) {
            System.out.println("Servidor retornou: " + receber);
            if (input.next().equals("fim")) {
                protocolo.setAction("logout");
                enviar = gson.toJson(protocolo);
                out.writeUTF(enviar);
                System.out.println("Servidor retornou: " + receber);
                break;
            }
        }

    }*/
}
