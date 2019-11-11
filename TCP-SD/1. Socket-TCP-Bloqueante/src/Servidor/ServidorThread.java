package Servidor;

// servidor de eco
// recebe uma linha e ecoa a linha recebida.
import Cliente.Usuario;
import Cliente.ListaClientes;
import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Observable;

public class ServidorThread extends Observable{

    public Socket clientSocket;
    private final ListaClientes lista = ListaClientes.getInstance();
    private final ArrayList<DataOutputStream> broadcast = lista.getSaida();
    private final ListaServicos lServico = ListaServicos.getInstance();
    int porta;
    Protocolo protocol;
    Gson gson = new Gson();
    
    public ServidorThread(int porta)
    {
        this.porta = porta;
        /*Writer writer;
        try {
            writer = new FileWriter("clientes.json");
            writer.write("[]");
            writer.close();
        } catch (IOException ex) {
            System.out.println("Erro ao criar o arquivo Json");
        }*/
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
                        new ServidorThread(serverSocket.accept());
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

    private ServidorThread(Socket clientSoc) {
        clientSocket = clientSoc;
        new Thread(server).start();
    }
private final Runnable server = new Runnable() {
    @Override
    public void run() {
        Usuario user = null;
        String line; // string para conter informações transferidas
        DataInputStream is; // cria um duto de entrada
        DataOutputStream os; // cria um duto de saída
        //FileWriter writer;
        //FileReader reader;
        try {
            is = new DataInputStream(clientSocket.getInputStream());    // aponta o duto de entrada para o socket do cliente
            os = new DataOutputStream(clientSocket.getOutputStream());       // aponta o duto de saída para o socket do cliente
            
            //reader = new FileReader("clientes.json");
            line = is.readUTF();
            protocol = gson.fromJson(line, Protocolo.class);
            user = new Usuario( protocol.getNome(), 
                    clientSocket.getInetAddress().toString().replace("/", ""),
                    clientSocket.getPort() );
            lista.add(user);
            lista.add(os);
            
            do {
                switch (protocol.getAction()) {
                    case "login":
                        protocol = new Protocolo("listarUsuarios", lista.getCliente() );
                        //os.writeUTF("Conectado");
                        for(DataOutputStream cliente : broadcast)
                            cliente.writeUTF(gson.toJson(protocol));
                        //writer.write(gson.toJson(lista));
                        //writer.close();
                        break;
                    case "logout":
                        protocol.setAction("logout");
                        os.writeUTF(gson.toJson(protocol.getAction()));
                        lista.remove(user);
                        lista.remove(os);
                        protocol = new Protocolo("listarUsuarios", lista.getCliente());
                        for(DataOutputStream cliente : broadcast)
                            cliente.writeUTF(gson.toJson(protocol));
                        //writer.write(gson.toJson(lista));
                        //writer.close();
                        clientSocket.close();
                        return;
                    case "broadcast":
                        protocol = new Protocolo(user.getNome() + ": " + protocol.getMensagem());
                        for(DataOutputStream cliente : broadcast)
                            cliente.writeUTF(gson.toJson(protocol));
                        break;
                    case "cadastrarServico":
                        protocol.getServico().setEmpregador(user);
                        lServico.add(protocol.getServico());
                        protocol = new Protocolo(lServico.getServicos());
                        protocol.setAction("listarServicos");
                        for(DataOutputStream cliente : broadcast)
                            cliente.writeUTF(gson.toJson(protocol));
                        break;    
                    default:
                        break;
                }
                System.out.println("Cliente enviou: " + line);
                line = is.readUTF();
                protocol = gson.fromJson(line, Protocolo.class);
            }while(line != null);
        } catch (IOException ex) {
            System.out.println("Cliente desconectado");
        } 
    }
};
public void update()
{
    setChanged();
    notifyObservers();
}
    
    public void sendMessage(String msg)
    {
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
