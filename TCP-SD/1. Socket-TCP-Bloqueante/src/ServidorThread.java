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
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ServidorThread extends Thread {

    protected Socket clientSocket;
    private File file = new File("X.json");
        
    public static void main(String args[]) {
        
        Writer writer;
        try {
            writer = new FileWriter("X.json");
            writer.write("[]");
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(ServidorThread.class.getName()).log(Level.SEVERE, null, ex);
        }


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

    synchronized void alteraJson(String nome, Boolean action)
    {
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            StringBuilder sb = new StringBuilder(); 
            String line;
                while((line = br.readLine()) != null){
                    sb = sb.append(line);
                }
            br.close();
            fr.close();
            JSONArray obj = new JSONArray(sb.toString());
            JSONObject my_obj = new JSONObject();
            my_obj.put("ip", clientSocket.getInetAddress().toString());
            my_obj.put("nome", nome);
            obj.put(my_obj);
            BufferedWriter output;
            output = new BufferedWriter(new FileWriter(file));
            output.write(obj.toString());
            output.close();
                
        } catch (IOException ex) {
            Logger.getLogger(ServidorThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(ServidorThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @Override
    public void run() {
        DataInputStream teclado = new DataInputStream(System.in);

        String line;                        // string para conter informações transferidas
        DataInputStream is;                 // cria um duto de entrada
        DataOutputStream os;                     // cria um duto de saída
        
        try {
            
            is = new DataInputStream(clientSocket.getInputStream());    // aponta o duto de entrada para o socket do cliente
            os = new DataOutputStream(clientSocket.getOutputStream());       // aponta o duto de saída para o socket do cliente
            line = is.readUTF();
            
            alteraJson(line, true);
            
            for (Iterator<String> it = Files.readAllLines(Paths.get(file.getAbsolutePath())).iterator(); it.hasNext();) {
                os.writeUTF(it.next());  //*** send()   // envia dados para o cliente
            }
            while (true) {
                line = is.readUTF(); // *** recv()  // recebe dados do cliente
                os.writeUTF(line);  //*** send()   // envia dados para o cliente
                if (line.equals("fim")) // recebendo 'fim' possibilita o encerramento do servidor
                {
                    clientSocket.close();
                    break;
                } else if (line.equals("lista")) // recebendo 'fim' possibilita o encerramento do servidor
                {
                    for (Iterator<String> it = Files.readAllLines(Paths.get(file.getAbsolutePath())).iterator(); it.hasNext();) {
                        os.writeUTF(it.next());  //*** send()   // envia dados para o cliente
                    }
                } else {
                    System.out.println("Cliente enviou: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        } 

    }
} // classe
