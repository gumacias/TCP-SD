/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Servidor.ServidorThread;
import java.awt.CardLayout;

/**
 *
 * @author Gustavo
 */
public class Servidor extends javax.swing.JFrame {

    ServidorThread servidor = null;
    
    /**
     * Creates new form Servidor
     */
    public Servidor() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnTela = new javax.swing.JPanel();
        pnConect = new javax.swing.JPanel();
        lblPorta = new javax.swing.JLabel();
        txtPorta = new javax.swing.JTextField();
        btConectar = new javax.swing.JButton();
        pnPrincipal = new javax.swing.JPanel();
        pnChat = new javax.swing.JPanel();
        scrollChat = new javax.swing.JScrollPane();
        txtChat = new javax.swing.JTextArea();
        txtMensagem = new javax.swing.JTextField();
        btEnviar = new javax.swing.JButton();
        scrollServicos = new javax.swing.JScrollPane();
        pnServicos = new javax.swing.JPanel();
        pnClientes = new javax.swing.JPanel();
        lblOnline = new javax.swing.JLabel();
        lblServico = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnTela.setLayout(new java.awt.CardLayout());

        lblPorta.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblPorta.setText("Digite a porta do servidor:");

        txtPorta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btConectar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btConectar.setText("Conectar");
        btConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConectarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnConectLayout = new javax.swing.GroupLayout(pnConect);
        pnConect.setLayout(pnConectLayout);
        pnConectLayout.setHorizontalGroup(
            pnConectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnConectLayout.createSequentialGroup()
                .addGroup(pnConectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPorta, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnConectLayout.createSequentialGroup()
                        .addGroup(pnConectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnConectLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblPorta))
                            .addGroup(pnConectLayout.createSequentialGroup()
                                .addGap(232, 232, 232)
                                .addComponent(btConectar)))
                        .addGap(0, 240, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnConectLayout.setVerticalGroup(
            pnConectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnConectLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPorta)
                .addGap(18, 18, 18)
                .addComponent(txtPorta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btConectar)
                .addContainerGap(181, Short.MAX_VALUE))
        );

        pnTela.add(pnConect, "card2");

        txtChat.setEditable(false);
        txtChat.setColumns(20);
        txtChat.setRows(5);
        scrollChat.setViewportView(txtChat);

        btEnviar.setText("Enviar");
        btEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnChatLayout = new javax.swing.GroupLayout(pnChat);
        pnChat.setLayout(pnChatLayout);
        pnChatLayout.setHorizontalGroup(
            pnChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChatLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnChatLayout.createSequentialGroup()
                        .addComponent(txtMensagem)
                        .addGap(2, 2, 2)
                        .addComponent(btEnviar))
                    .addComponent(scrollChat, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                .addGap(0, 8, Short.MAX_VALUE))
        );
        pnChatLayout.setVerticalGroup(
            pnChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChatLayout.createSequentialGroup()
                .addComponent(scrollChat, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btEnviar)))
        );

        scrollServicos.setViewportView(pnServicos);

        pnClientes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout pnClientesLayout = new javax.swing.GroupLayout(pnClientes);
        pnClientes.setLayout(pnClientesLayout);
        pnClientesLayout.setHorizontalGroup(
            pnClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 151, Short.MAX_VALUE)
        );
        pnClientesLayout.setVerticalGroup(
            pnClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lblOnline.setText("Clientes Online :");

        lblServico.setText("Serviços Disponiveis :");

        javax.swing.GroupLayout pnPrincipalLayout = new javax.swing.GroupLayout(pnPrincipal);
        pnPrincipal.setLayout(pnPrincipalLayout);
        pnPrincipalLayout.setHorizontalGroup(
            pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnPrincipalLayout.createSequentialGroup()
                        .addComponent(scrollServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnChat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblServico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblOnline)
                    .addComponent(pnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnPrincipalLayout.setVerticalGroup(
            pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOnline)
                    .addComponent(lblServico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollServicos)
                    .addComponent(pnClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnTela.add(pnPrincipal, "main");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnTela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnTela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConectarActionPerformed
        if(!txtPorta.getText().equals(""))
        {
            servidor = new ServidorThread(Integer.parseInt(txtPorta.getText()));
            CardLayout cl = (CardLayout) pnTela.getLayout();
            cl.show(pnTela, "main");
        }
        else
        {
            System.out.println("Todos campos devem ser preenchidos");
        }
    }//GEN-LAST:event_btConectarActionPerformed

    private void btEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEnviarActionPerformed
        if(!txtMensagem.getText().equals(""))
        {
            servidor.sendMessage(txtMensagem.getText());
            txtMensagem.setText("");
        }
        btEnviar.transferFocusBackward();
    }//GEN-LAST:event_btEnviarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Servidor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConectar;
    private javax.swing.JButton btEnviar;
    private javax.swing.JLabel lblOnline;
    private javax.swing.JLabel lblPorta;
    private javax.swing.JLabel lblServico;
    private javax.swing.JPanel pnChat;
    private javax.swing.JPanel pnClientes;
    private javax.swing.JPanel pnConect;
    private javax.swing.JPanel pnPrincipal;
    private javax.swing.JPanel pnServicos;
    private javax.swing.JPanel pnTela;
    private javax.swing.JScrollPane scrollChat;
    private javax.swing.JScrollPane scrollServicos;
    private javax.swing.JTextArea txtChat;
    private javax.swing.JTextField txtMensagem;
    private javax.swing.JTextField txtPorta;
    // End of variables declaration//GEN-END:variables
}
