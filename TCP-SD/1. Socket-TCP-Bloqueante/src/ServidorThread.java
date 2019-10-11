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
import org.json.JSONObject;
import sun.tools.asm.TryData;

public class ServidorThread extends Thread {

    protected Socket clientSocket;

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
                    new ServidorThread(echoServer.accept());
                }
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
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
        JSONObject my_obj = new JSONObject();
        Writer output = null;
        File file = new File("X.json");

        try {
            output = new BufferedWriter(new FileWriter(file));
        } catch (IOException ex) {
            Logger.getLogger(ServidorThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (true) {
            try {
                System.out.println("Aguardando conexao");

                is = new DataInputStream(clientSocket.getInputStream());    // aponta o duto de entrada para o socket do cliente
                os = new DataOutputStream(clientSocket.getOutputStream());       // aponta o duto de saída para o socket do cliente
                //os.writeUTF("Servidor responde: Conexao efetuada com o servidor");
                while (true) {
                    line = is.readUTF(); // *** recv()  // recebe dados do cliente
                    my_obj.put("ip", clientSocket.getLocalSocketAddress().toString());
                    my_obj.put("nome", line);
                    my_obj.write(output);
                    output.close();

                    os.writeUTF(line.toUpperCase());  //*** send()   // envia dados para o cliente
                    if (line.equals("fim")) // recebendo 'fim' possibilita o encerramento do servidor
                    {
                        clientSocket.close();
                        break;
                    }
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }

    }
} // classe
