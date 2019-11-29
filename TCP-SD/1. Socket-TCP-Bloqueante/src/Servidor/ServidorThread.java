package Servidor;

// servidor de eco
// recebe uma linha e ecoa a linha recebida.
import Cliente.Usuario;
import Cliente.ListaClientes;
import Interface.Servidor;
import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorThread {

    public Socket clientSocket;
    private final ListaClientes lista = ListaClientes.getInstance();
    private final ArrayList<DataOutputStream> broadcast = lista.getSaida();
    private final ListaServicos lServico = ListaServicos.getInstance();
    int porta;
    Protocolo protocol;
    Gson gson = new Gson();
    Servidor serv;
    
    public ServidorThread(int porta, Servidor serv) {
        this.porta = porta;
        this.serv = serv;
        new Thread(openServer).start();
    }

    private final Runnable openServer = new Runnable() {
        @Override
        public void run() {
            try {
                ServerSocket serverSocket = new ServerSocket(porta);  // *** socket() + bind()  // instancia o socket do servidor na porta 9999. 
                try {
                    while (true) {
                        System.out.println("Aguardando conexão");
                        new ServidorThread(serverSocket.accept(), serv);
                        System.out.println("Cliente conectado.");
                    }
                } catch (IOException e) {
                    System.err.println("Conexão falhou");
                    System.exit(0);
                }
            } catch (IOException e) {
                System.err.println("Não foi possível abrir na porta" + porta);
                System.exit(0);
            }
        }
    };

    private ServidorThread(Socket clientSoc, Servidor serv) {
        clientSocket = clientSoc;
        this.serv = serv;
        new Thread(server).start();
    }
    private final Runnable server = new Runnable() {
        @Override
        public void run() {
            Usuario user = null;
            String line; // string para conter informações transferidas
            DataInputStream is; // cria um duto de entrada
            DataOutputStream os = null; // cria um duto de saída
            int i;
            //FileWriter writer;
            //FileReader reader;
            try {
                is = new DataInputStream(clientSocket.getInputStream());    // aponta o duto de entrada para o socket do cliente
                os = new DataOutputStream(clientSocket.getOutputStream());       // aponta o duto de saída para o socket do cliente

                //reader = new FileReader("clientes.json");
                line = is.readUTF();
                protocol = gson.fromJson(line, Protocolo.class);
                user = new Usuario(protocol.getNome(),
                        clientSocket.getInetAddress().toString().replace("/", ""),
                        clientSocket.getPort(), protocol.getTipo());
                lista.add(user);
                lista.add(os);
                
                do {
                    switch (protocol.getAction()) {
                        case "login":
                            protocol = new Protocolo("listarUsuarios", lista.getCliente());
                            //os.writeUTF("Conectado");
                            for (DataOutputStream cliente : broadcast) {
                                cliente.writeUTF(gson.toJson(protocol));
                            }
                            protocol = new Protocolo(lServico.getServicos(), "listarServicos");
                            os.writeUTF(gson.toJson(protocol));
                            serv.notifica();
                            break;
                        case "logout":
                            protocol.setAction("logout");
                            os.writeUTF(gson.toJson(protocol));
                            System.out.println(gson.toJson(protocol));
                            lista.remove(user);
                            lista.remove(os);
                            protocol = new Protocolo("listarUsuarios", lista.getCliente());
                            for (DataOutputStream cliente : broadcast) {
                                cliente.writeUTF(gson.toJson(protocol));
                            }
                            //writer.write(gson.toJson(lista));
                            //writer.close();
                            clientSocket.close();
                            serv.notifica();
                            return;
                        case "broadcast":
                            protocol = new Protocolo(user.getNome() + ": " + protocol.getMensagem());
                            for (DataOutputStream cliente : broadcast) {
                                cliente.writeUTF(gson.toJson(protocol));
                            }
                            serv.notifica(protocol.getMensagem());
                            break;
                        case "cadastrarServico":
                            protocol.getServico().setEmpregador(user);
                            lServico.add(protocol.getServico());
                            protocol = new Protocolo(lServico.getServicos(), "listarServicos");
                            for (DataOutputStream cliente : broadcast) {
                                cliente.writeUTF(gson.toJson(protocol));
                            }
                            serv.notifica();
                            break;
                        case "mensagemDireta":
                            protocol.setRemetente(user);
                            DataOutputStream destino;
                            i = lista.getUsuarioIndex(protocol.getDestinatario());
                            destino = broadcast.get(i);
                            protocol.setDestinatario(null);
                            destino.writeUTF(gson.toJson(protocol));
                            break;
                        case "interesseServico":
                            i = lServico.getServIndex(protocol.getServico());
                            lServico.addInteressado(i, user);
                            protocol = new Protocolo(lServico.getListInteresse().get(i));
                            i = lista.getUsuarioIndex(protocol.getServico().getEmpregador());
                            destino = broadcast.get(i);
                            destino.writeUTF(gson.toJson(protocol));
                            break;
                        case "contratacao":
                            i = lista.getUsuarioIndex(protocol.getDestinatario());
                            destino = broadcast.get(i);
                            protocol.setDestinatario(null);
                            destino.writeUTF(gson.toJson(protocol));
                            lServico.remove(protocol.getServico());
                            break;
                        default:
                            break;
                    }
                    System.out.println("Cliente enviou: " + line);
                    line = is.readUTF();
                    protocol = gson.fromJson(line, Protocolo.class);
                } while (line != null);
            } catch (IOException ex) {
                lista.remove(user);
                lista.remove(os);
                protocol = new Protocolo("listarUsuarios", lista.getCliente());
                            for (DataOutputStream cliente : broadcast) {
                    try {
                        cliente.writeUTF(gson.toJson(protocol));
                    } catch (IOException ex1) {
                        System.out.println("Problema ao enviar");
                    }
                }
                serv.notifica();
                System.out.println("Cliente desconectado");
            }
        }
    };

    public void sendBroadcast(String msg) {
        protocol = new Protocolo("Server: " + msg);
        broadcast.forEach((cliente) -> {
            try {
                cliente.writeUTF(gson.toJson(protocol));
            } catch (IOException ex) {
                System.out.println("Cliente não conectado");
            }
        });
    }
} // classe
