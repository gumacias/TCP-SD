
package Tela;

import Cliente.Cliente;
import Cliente.Protocolo;
import Servidor.InfoCliente;
import Servidor.ServidorThread;
import java.awt.FlowLayout;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ServidorTela implements ActionListener{
    
    JFrame tela = new JFrame();
    JPanel painel = new JPanel();
    JLabel porta = new JLabel ("Porta:" );
    JTextField textPorta = new JTextField("22345",5);
    JButton botaoOk = new JButton("Ok");
    
    
    ServidorTela(){
        tela.setTitle ("Server");
        tela.setSize(300,90);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        painel.setLayout(new FlowLayout (FlowLayout.CENTER, 20, 20));
        tela.add(porta);
        painel.add(textPorta);
        painel.add(botaoOk);
        tela.add(painel);  
        tela.setVisible(true);
         botaoOk.addActionListener(this);
    }
  
    /**
     *
     * @param e
     */
    public void ActionPerformed(ActionEvent e){
            if ((e.getSource()== botaoOk) && (!textPorta.getText().equals(""))){
                try{
                    new server (Integer.parseInt(textPorta.getText()));
            }
                catch(NumberFormatException e1){
                    JOptionPane.showMessageDialog (null, "Erro");
                }
        }
        
      
    } 
    
   
    public static void main(String[] args) {
        new ServidorTela();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
