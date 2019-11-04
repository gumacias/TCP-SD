package Servidor;

// servidor de eco
// recebe uma linha e ecoa a linha recebida.
import Cliente.Protocolo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServidorThread extends Thread {

    public Socket clientSocket;
    private ArrayList<InfoCliente> lista;
    private ArrayList<DataOutputStream> broadcast = new ArrayList();;
    int porta;
    
    public ServidorThread(int porta)
    {
        this.porta = porta;
        Writer writer;
        try {
            writer = new FileWriter("X.json");
            writer.write("[]");
            writer.close();
        } catch (IOException ex) {
            System.out.println("Erro ao criar o arquivo Json");
        }
        new Thread(openServer).start();
    }
    
    private Runnable openServer = new Runnable() {
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
        start();
    }

    @Override
    public void run() {
        String line; // string para conter informações transferidas
        DataInputStream is; // cria um duto de entrada
        DataOutputStream os; // cria um duto de saída
        Protocolo protocol;
        FileWriter writer;
        FileReader reader;
        Gson gson = new Gson();
        try {
            is = new DataInputStream(clientSocket.getInputStream());    // aponta o duto de entrada para o socket do cliente
            os = new DataOutputStream(clientSocket.getOutputStream());       // aponta o duto de saída para o socket do cliente
            broadcast.add(os);
                reader = new FileReader("X.json");
                lista = (ArrayList<InfoCliente>) gson.fromJson(reader,
                        new TypeToken<ArrayList<InfoCliente>>() {
                        }.getType());
                if (lista == null) {
                    lista = new ArrayList();
                }
                line = is.readUTF();
                protocol = gson.fromJson(line, Protocolo.class);
                lista.add(new InfoCliente(protocol.getNome(), 
                        clientSocket.getInetAddress().toString().replace("/", ""),
                        clientSocket.getPort()/*, protocol.getAction()*/));
                
            do {
                writer = new FileWriter("X.json");
                switch (protocol.getAction()) {
                    case "login":
                        os.writeUTF("Conectado");
                        os.writeUTF(gson.toJson(lista));
                        writer.write(gson.toJson(lista));
                        writer.close();
                        break;
                    case "logout":
                        os.writeUTF("Tchau!");
                        InfoCliente aux = null;
                        /*for (InfoCliente cliente : lista) {
                            if (cliente.getIP().equals(clientSocket.getInetAddress().toString().replace("/", ""))
                                    && cliente.getPorta() == clientSocket.getPort() ) 
                            {
                                aux = cliente;
                            }
                        }                   
                        lista.remove(aux);*/
                        lista.stream().filter((infoCliente) -> (infoCliente.getIP().equals(clientSocket.getInetAddress().toString().replace("/", "")))).forEachOrdered((infoCliente) -> {
                            lista.remove(infoCliente);
                        });
                        System.out.println(gson.toJson(lista));
                        writer.write(gson.toJson(lista));
                        writer.close();
                        clientSocket.close();
                        break;
                    case "broadcast":
                            for (DataOutputStream cliente : broadcast) {
                                cliente.writeUTF(protocol.getNome());
                            }
                            break;
                    default:
                        System.out.println("Cliente enviou: " + line);
                        break;
                }
                line = is.readUTF();
                protocol = gson.fromJson(line, Protocolo.class);
            }while(true);
        } catch (IOException e) {
            System.out.println("Cliente desconectado");
        }
    }
} // classe
