package Cliente;

import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {
    DataInputStream in = null;                  // cria um duto de entrada
    DataOutputStream out = null;
    String receber;
    
    public Cliente(String nome, String serverHostname, int port)
    {
        Gson gson = new Gson();
        Protocolo protocolo = new Protocolo(nome, "login");
        String enviar = gson.toJson(protocolo);
        System.out.println("Attemping to connect to host "
                + serverHostname + " on port " + port);
        
        Socket clientSocket = null;
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
        new Thread(getMessage).start();
    }
    private Runnable getMessage = new Runnable() {
        public void run() {
            try {
                while ((receber = in.readUTF()) != null) {
                    System.out.println("Servidor retornou: " + receber);
                }
            } catch (IOException ex) {
                System.out.println("Desconectado do servidor");
                System.exit(0);
            }
            
       }
    };

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

        clientSocket.close();
        out.close();
        in.close();
    }*/
}
