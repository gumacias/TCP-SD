package Cliente;

import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) throws IOException {

        //Rotina para entrada de dados via teclado
        //DataInputStream teclado = new DataInputStream(System.in);
        DataInputStream in = null;                  // cria um duto de entrada
        DataOutputStream out = null;                     // cria um duto de saída

        Scanner input = new Scanner(System.in);
        String serverHostname = new String("192.168.0.103");
        Integer port = 22345;

        if (args.length > 0) {
            serverHostname = args[0];
        }
        System.out.println("Attemping to connect to host "
                + serverHostname + " on port" + port);

        //Geração do socket
        Socket clientSocket = null;

        try {
            clientSocket = new Socket(serverHostname, port);
            in = new DataInputStream(clientSocket.getInputStream());    // aponta o duto de entrada para o socket do cliente
            out = new DataOutputStream(clientSocket.getOutputStream());       // aponta o duto de saída para o socket do cliente
        } catch (UnknownHostException e) {
            System.err.println("Host desconhecido: " + serverHostname);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Não foi possível I/O para"
                    + "a conexão com:" + serverHostname);
            System.exit(1);
        }
        Gson gson = new Gson();

        System.out.print("Digite: ");
        Protocolo protocolo = new Protocolo(input.nextLine(), "login");
        String enviar = gson.toJson(protocolo);
        out.writeUTF(enviar);
        String receber;

        while ((receber = in.readUTF()) != null) {
            if (!input.next().equals("fim")) {
                System.out.println("Servidor retornou: " + receber);
            } else {
                protocolo.setAction("logout");
                enviar = gson.toJson(protocolo);
                out.writeUTF(enviar);
                break;
            }
        }
        
        clientSocket.close();
        out.close();
        in.close();
    }
}
