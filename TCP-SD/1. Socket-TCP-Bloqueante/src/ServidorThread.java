// servidor de eco
// recebe uma linha e ecoa a linha recebida.

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;


public class ServidorThread extends Thread {

    protected Socket clientSocket;
    JSONObject my_obj = new JSONObject();
    JSONArray nomes = new JSONArray();
    JSONArray ips = new JSONArray();
    int clients = 0;
    
    public static void main(String args[]) {
        ServerSocket echoServer = null; // cria o socket do servidor
        Socket svr = null;
        try {
            echoServer = new ServerSocket(22345);  // *** socket() + bind()  // instancia o socket do servidor na porta 9999. 
            try {
                while (true) {
                    System.out.println("Aguardando conexao");
                    svr = echoServer.accept();
                    new ServidorThread(svr);
                }
            } catch (IOException e) {
                System.err.println("Accept failed.");
            }
        } catch (IOException e) {
            System.out.println(e);
        }

    } // main

    private ServidorThread(Socket clientSoc){
        clientSocket = clientSoc;
        start();
    }

    public void run() {
        DataInputStream teclado = new DataInputStream(System.in);

        String line;                        // string para conter informações transferidas
        String verificacao;                 // string psrs encerramento do servidor
        DataInputStream is;                 // cria um duto de entrada
        DataOutputStream os;                     // cria um duto de saída
        Writer output = null;
        File file = new File("X.json");

        try {
            output = new BufferedWriter(new FileWriter(file));
        } catch (IOException ex) {
            Logger.getLogger(ServidorThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            is = new DataInputStream(clientSocket.getInputStream());    // aponta o duto de entrada para o socket do cliente
            os = new DataOutputStream(clientSocket.getOutputStream());       // aponta o duto de saída para o socket do cliente
            
            String ip = clientSocket.getRemoteSocketAddress().toString();
            String nome;
            
            line = is.readUTF(); // *** recv()  // recebe dados do cliente
            ips.put(ips.length(), ip);
            nome = line;
            nomes.put(nomes.length(), nome);
            clients++;
            my_obj.put("ip", ips);
            my_obj.put("nome", nomes);
            my_obj.write(output);
            output.close();
            while (true) {
                line = is.readUTF();
                System.out.println("Cliente enviou: " + line);
                os.writeUTF(line.toUpperCase());
            }
        } catch (IOException e) {
            System.out.println(e);
        }

    }
} // classe
