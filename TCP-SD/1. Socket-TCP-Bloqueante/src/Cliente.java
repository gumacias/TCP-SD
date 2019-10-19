
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
        System.out.print("Digite o ip do servidor: ");
        String host = input.next();
        System.out.print("Digite a porta do servidor: ");
        int port = input.nextInt();
        
        //Geração do socket
        Socket ClientSocket = null;

        try {
            /* cria o socket do cliente para conexao com o servidor
           que esta na maquina 127.0.0.1 operando na porta 7000 */
            
            ClientSocket = new Socket(host, port);
            System.out.print("Digite o nome: ");
            String enviar = input.next();
            /* associa um buffer de entrada e outro de saida ao socket */
            in = new DataInputStream(ClientSocket.getInputStream());    // aponta o duto de entrada para o socket do cliente
            out = new DataOutputStream(ClientSocket.getOutputStream());       // aponta o duto de saída para o socket do cliente
            
            out.writeUTF(enviar);
            //aguarda uma digitação pelo teclado para enviar ao servidor
            //System.out.println(in.readLine());
            while (true) {
                System.out.print("Digite: ");
                enviar = input.next();
                out.writeUTF(enviar);
                if (enviar.equals("fim")) {
                    ClientSocket.close();
                    break;
                }
                String receber = in.readUTF();
                System.out.println("Servidor retornou: " + receber);
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
