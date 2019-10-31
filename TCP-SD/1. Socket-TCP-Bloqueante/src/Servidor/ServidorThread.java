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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServidorThread extends Thread {

    public Socket clientSocket;
    private ArrayList<InfoCliente> lista;

    public static void main(String args[]) {
        ServerSocket serverSocket = null; // cria o socket do servidor
        System.out.println("Conexão Socket criada.");
        try {
            serverSocket = new ServerSocket(22003);  // *** socket() + bind()  // instancia o socket do servidor na porta 9999. 
            try {
                while (true) {
                    System.out.println("Aguardando conexão");
                    new ServidorThread(serverSocket.accept());
                    System.out.println("Cliente de ip " + serverSocket.getInetAddress().getHostAddress() + " conectado.");
                }
            } catch (IOException e) {
                System.err.println("Conexão falhou");
                System.exit(1);
            }
        } catch (IOException e) {
            System.err.println("Não foi possível escutar a porta: 22345.");
            System.exit(1);
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                System.err.println("Não foi possível fechar a porta: 22345.");
                System.exit(1);
            }
        }
    } // main

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
            while ((line = is.readUTF()) != null) {
                reader = new FileReader("X.json");
                lista = (ArrayList<InfoCliente>) gson.fromJson(reader,
                        new TypeToken<ArrayList<InfoCliente>>() {
                        }.getType());
                if (lista == null) {
                    lista = new ArrayList();
                }
                protocol = gson.fromJson(line, Protocolo.class);
                writer = new FileWriter("X.json");
                lista.add(new InfoCliente(clientSocket.getInetAddress().toString(),
                        protocol.getNome(), protocol.getAction()));
                switch (protocol.getAction()) {
                    case "login":
                        os.writeUTF("Conectado");
                        os.writeUTF(gson.toJson(lista));
                        writer.write(gson.toJson(lista));
                        writer.close();
                        break;
                    case "logout":
                        os.writeUTF("Tchau!");
                        lista.stream().filter((infoCliente) -> (infoCliente.getIP().equals(clientSocket.getRemoteSocketAddress().toString()))).forEachOrdered((infoCliente) -> {
                            lista.remove(infoCliente);
                        });
                        writer.write(gson.toJson(lista));
                        writer.close();
                        clientSocket.close();
                        break;
                    default:
                        System.out.println("Cliente enviou: " + line);
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
} // classe
