// servidor de eco
// recebe uma linha e ecoa a linha recebida.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class ServidorThread extends Thread {

    protected Socket clientSocket;
    private File file = new File("X.json");

    public static void main(String args[]) {
        //Rotina para entrada de dados via teclado
        /*DataInputStream teclado = new DataInputStream(System.in);

        System.out.println("Servidor carregado na porta 7000");
        
        String line;                        // string para conter informações transferidas
        String verificacao;                 // string psrs encerramento do servidor
        DataInputStream is;                 // cria um duto de entrada
        DataOutputStream os;                     // cria um duto de saída
        Socket clientSocket = null;         // cria o socket do cliente*/
        ServerSocket echoServer = null; // cria o socket do servidor

        try {
            echoServer = new ServerSocket(22345);  // *** socket() + bind()  // instancia o socket do servidor na porta 9999. 
            try {
                while (true) {
                    ServidorThread servidorThread;
                    servidorThread = new ServidorThread(echoServer.accept());
                }
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }
        } catch (IOException e) {
            System.out.println(e);
        }

    } // main

    private ServidorThread(Socket clientSoc) {
        clientSocket = clientSoc;
        start();
    }

    @Override
    public void run() {
        DataInputStream teclado = new DataInputStream(System.in);

        String line;                        // string para conter informações transferidas
        DataInputStream is;                 // cria um duto de entrada
        DataOutputStream os;                     // cria um duto de saída
        BufferedWriter output;
        JSONObject my_obj = new JSONObject();
        while (true) {
            try {
                System.out.println("Aguardando conexao");
                is = new DataInputStream(clientSocket.getInputStream());    // aponta o duto de entrada para o socket do cliente
                os = new DataOutputStream(clientSocket.getOutputStream());       // aponta o duto de saída para o socket do cliente
                line = is.readUTF();
                output = new BufferedWriter(new FileWriter(file));
                my_obj.put("ip",clientSocket.getLocalSocketAddress().toString());
                my_obj.put("nome",line);
                my_obj.write(output);
                output.close();
                for (Iterator<String> it = Files.readAllLines(Paths.get(file.getAbsolutePath())).iterator(); it.hasNext();) {
                    os.writeUTF(it.next());  //*** send()   // envia dados para o cliente
                }
                while (true) {
                    line = is.readUTF(); // *** recv()  // recebe dados do cliente
                    os.writeUTF(line);  //*** send()   // envia dados para o cliente
                    if (line.equals("fim")) // recebendo 'fim' possibilita o encerramento do servidor
                    {
                        my_obj.remove(clientSocket.getLocalSocketAddress().toString());
                        clientSocket.close();
                        break;
                    } else {
                        System.out.println("Cliente enviou: " + line);
                    }

                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }

    }
} // classe
