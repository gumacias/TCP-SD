/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Cliente.ListaClientes;
import Cliente.Usuario;
import Servidor.ListaServicos;
import Servidor.Servico;
import Servidor.ServidorThread;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Gustavo
 */
public class Servidor extends javax.swing.JFrame implements AttCli {

    public void notifica() {
        atualizaCliente();
        atualizaServico();
    }

    public void notifica(String msg) {
        atualizaMensagem(msg);
    }

    private ArrayList<Usuario> lista = ListaClientes.getInstance().getCliente();
    private ArrayList<Servico> lServico = ListaServicos.getInstance().getServicos();
    ServidorThread servidor = null;

    /**
     * Creates new form Servidor
     */
    public Servidor() {
        initComponents();
        this.setTitle("Servidor");
    }

    public void atualizaCliente() {
        pnClientes.removeAll();
        lista.forEach((user) -> {
            pnClientes.add(addCliente(user));
        });
        pnClientes.revalidate();
        pnClientes.repaint();
    }

    public void atualizaServico() {
        System.out.println("Servidor att");
        pnServicos.removeAll();
        lServico.forEach((servico) -> {
            pnServicos.add(addServico(servico));
        });
        pnServicos.revalidate();
        pnServicos.repaint();
    }

    public void atualizaMensagem(String msg) {
        txtChat.setText(txtChat.getText() + msg + "\n");
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
        btConectar = new javax.swing.JButton();
        txtPorta = new javax.swing.JFormattedTextField();
        pnPrincipal = new javax.swing.JPanel();
        pnChat = new javax.swing.JPanel();
        scrollChat = new javax.swing.JScrollPane();
        txtChat = new javax.swing.JTextArea();
        txtMensagem = new javax.swing.JTextField();
        btEnviar = new javax.swing.JButton();
        scrollServicos = new javax.swing.JScrollPane();
        pnServicos = new javax.swing.JPanel();
        lblOnline = new javax.swing.JLabel();
        lblServico = new javax.swing.JLabel();
        scrollClientes = new javax.swing.JScrollPane();
        pnClientes = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnTela.setLayout(new java.awt.CardLayout());

        lblPorta.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblPorta.setText("Digite a porta do servidor:");

        btConectar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btConectar.setText("Conectar");
        btConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConectarActionPerformed(evt);
            }
        });

        try {
            txtPorta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtPorta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout pnConectLayout = new javax.swing.GroupLayout(pnConect);
        pnConect.setLayout(pnConectLayout);
        pnConectLayout.setHorizontalGroup(
            pnConectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnConectLayout.createSequentialGroup()
                .addGroup(pnConectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnConectLayout.createSequentialGroup()
                        .addGroup(pnConectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnConectLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblPorta))
                            .addGroup(pnConectLayout.createSequentialGroup()
                                .addGap(232, 232, 232)
                                .addComponent(btConectar)))
                        .addGap(0, 240, Short.MAX_VALUE))
                    .addComponent(txtPorta))
                .addContainerGap())
        );
        pnConectLayout.setVerticalGroup(
            pnConectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnConectLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPorta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPorta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btConectar)
                .addContainerGap(189, Short.MAX_VALUE))
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
                .addComponent(scrollChat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btEnviar)))
        );

        scrollServicos.setViewportView(pnServicos);

        lblOnline.setText("Clientes Online :");

        lblServico.setText("Serviços Disponiveis :");

        pnClientes.setMaximumSize(new java.awt.Dimension(145, 32767));
        pnClientes.setPreferredSize(new java.awt.Dimension(145, 286));
        scrollClientes.setViewportView(pnClientes);

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
                    .addGroup(pnPrincipalLayout.createSequentialGroup()
                        .addComponent(lblOnline)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(scrollClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                .addContainerGap())
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
                    .addComponent(pnChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnPrincipalLayout.createSequentialGroup()
                        .addComponent(scrollClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(scrollServicos))
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
        if (!txtPorta.getText().equals("")) {
            servidor = new ServidorThread(Integer.parseInt(txtPorta.getText()), this);
            CardLayout cl = (CardLayout) pnTela.getLayout();
            cl.show(pnTela, "main");
        } else {
            System.out.println("Todos campos devem ser preenchidos");
        }
    }//GEN-LAST:event_btConectarActionPerformed

    private void btEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEnviarActionPerformed
        //atualizaCliente();
        //atualizaServico();
        if (!txtMensagem.getText().equals("")) {
            servidor.sendBroadcast(txtMensagem.getText());
            txtChat.setText(txtChat.getText() + "Server: " + txtMensagem.getText() + "\n");
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

    private JPanel addCliente(Usuario user) {
        JLabel lblNome = new javax.swing.JLabel();
        JLabel usrNome = new javax.swing.JLabel();
        JPanel nCliente = new JPanel();
        nCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nCliente.setSize(145, 25);
        lblNome.setText("Nome: ");

        usrNome.setText(user.getNome());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(nCliente);
        nCliente.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lblNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usrNome)
                                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblNome)
                                .addComponent(usrNome))
        );

        return nCliente;
    }

    private JPanel addServico(Servico servico) {
        JPanel nServico = new JPanel();
        JLabel lblCargo = new JLabel();
        JLabel lblSalario = new JLabel();
        JLabel srvSalario = new JLabel();
        JLabel lblDescricao = new JLabel();
        JLabel srvDescricao = new JLabel();

        nServico.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nServico.setSize(145, 75);

        lblCargo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblCargo.setText(servico.getCargo());
        lblSalario.setText("Salario:");
        srvSalario.setText(Float.toString(servico.getSalario()));
        lblDescricao.setText("Descricao:");
        srvDescricao.setText(servico.getDescricao());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(nServico);
        nServico.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addComponent(lblSalario)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblCargo)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(srvSalario)
                                                .addGap(0, 2, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblDescricao)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(srvDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblCargo)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblSalario)
                                                        .addComponent(srvSalario))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblDescricao)
                                        .addComponent(srvDescricao))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        return nServico;
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
    private javax.swing.JScrollPane scrollClientes;
    private javax.swing.JScrollPane scrollServicos;
    private javax.swing.JTextArea txtChat;
    private javax.swing.JTextField txtMensagem;
    private javax.swing.JFormattedTextField txtPorta;
    // End of variables declaration//GEN-END:variables

}
