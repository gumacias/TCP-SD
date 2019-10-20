package Cliente;


import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

    static DataInputStream in;                  // cria um duto de entrada
    static DataOutputStream out;                     // cria um duto de saída

    public static void main(String[] args) throws IOException {

        //Rotina para entrada de dados via teclado
        //DataInputStream teclado = new DataInputStream(System.in);
        Scanner input = new Scanner(System.in);

        //Geração do socket
        Socket ClientSocket;

        try {
            ClientSocket = new Socket("localhost", 22345);
            in = new DataInputStream(ClientSocket.getInputStream());    // aponta o duto de entrada para o socket do cliente
            out = new DataOutputStream(ClientSocket.getOutputStream());       // aponta o duto de saída para o socket do cliente
            Gson gson = new Gson();

            System.out.print("Digite: ");
            Protocolo protocolo = new Protocolo(input.next(), "login");
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
                    ClientSocket.close();
                    break;
                }
            }
        } catch (UnknownHostException e) {
            System.err.println("Host desconhecido: ");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("IP ou Porta não existe ");
            System.exit(1);
        } catch (Exception e) {
            System.out.println("Falha na conexão com o servidor");
        }
    }
}
