// servidor de eco
// recebe uma linha e ecoa a linha recebida.

import java.io.*;
import java.net.*;
import org.json.JSONObject;

public class Servidor{

    public static void main(String args[]) {
        //Rotina para entrada de dados via teclado
        DataInputStream teclado = new DataInputStream(System.in);

        System.out.println("Servidor carregado na porta 7000");
        ServerSocket echoServer = null;     // cria o socket do servidor
        String line;                        // string para conter informações transferidas
        String verificacao;                 // string psrs encerramento do servidor
        DataInputStream is;                 // cria um duto de entrada
        DataOutputStream os;                     // cria um duto de saída
        Socket clientSocket = null;         // cria o socket do cliente

        try {
            echoServer = new ServerSocket(22345);  // *** socket() + bind()  // instancia o socket do servidor na porta 9999. 
        } catch (IOException e) {
            System.out.println(e);
        }
        while (true) {
            try {
                System.out.println("Aguardando conexao");
                clientSocket = echoServer.accept();        // *** listen() + accept() // aguarda conexão do cliente
                is = new DataInputStream(clientSocket.getInputStream());    // aponta o duto de entrada para o socket do cliente
                os = new DataOutputStream(clientSocket.getOutputStream());       // aponta o duto de saída para o socket do cliente
                //os.writeUTF("Servidor responde: Conexao efetuada com o servidor");
                while (true) {
                    line = is.readUTF(); // *** recv()  // recebe dados do cliente
                    System.out.println("Cliente enviou: " + line);
                    os.writeUTF(line.toUpperCase());  //*** send()   // envia dados para o cliente
                    if (line.equals("fim")) // recebendo 'fim' possibilita o encerramento do servidor
                    {
                        System.out.println("Deseja parar o servidor? ");
                        verificacao = teclado.readLine();
                        break;
                    }
                }
                if (verificacao.equals("sim")) // encerra o servidor
                {
                    echoServer.close();   // *** close() do servidor
                    break;
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    } // main

} // classe
