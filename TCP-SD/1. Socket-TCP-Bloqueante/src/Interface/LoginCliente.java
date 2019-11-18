/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Cliente.Cliente;
import Cliente.ListaClientes;
import Cliente.Usuario;
import Servidor.ListaServicos;
import Servidor.Servico;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Gustavo
 */
public class LoginCliente extends javax.swing.JFrame implements AttCli {
    
    @Override
    public void notifica()
    {
        atualizaCliente();
        atualizaServico();
    }
    
    public void notifica(String msg)
    {
        txtChat.setText(txtChat.getText() + msg + "\n");
        txtChat1.setText(txtChat1.getText() + msg + "\n");
    }
    
    Cliente cliente = null;
    private final ListaClientes lista = ListaClientes.getInstance();
    private final ListaServicos lServico = ListaServicos.getInstance();

    /**
     * Creates new form LoginCliente
     */
    public LoginCliente() {
        //painel.setBorder(BorderFactory.createTitledBorder("Borda"));
        initComponents();
        this.setTitle("Intermediador de servicos");
    }

    public void atualizaCliente() {
        pnClientes.removeAll();
        pnClientes1.removeAll();
        lista.getCliente().forEach((user) -> {
            pnClientes.add(addCliente((Usuario)user));
            pnClientes1.add(addCliente((Usuario)user));
        });
        pnClientes.revalidate();
        pnClientes.repaint();
        pnClientes1.revalidate();
        pnClientes1.repaint();
    }

    public void atualizaServico() {
        pnServicos.removeAll();
        pnServicos1.removeAll();
        lServico.getServicos().forEach((servico) -> {
            pnServicos.add(addServico((Servico)servico));
            pnServicos1.add(addServico((Servico)servico));
        });
        pnServicos.revalidate();
        pnServicos.repaint();
        pnServicos1.revalidate();
        pnServicos1.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gpTipo = new javax.swing.ButtonGroup();
        pnTela = new javax.swing.JPanel();
        pnLogin = new javax.swing.JPanel();
        lblCliente = new javax.swing.JLabel();
        lblIP = new javax.swing.JLabel();
        lbPorta = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtIp = new javax.swing.JTextField();
        btConectar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        txtPorta = new javax.swing.JFormattedTextField();
        rbEmpregador = new javax.swing.JRadioButton();
        rbEmpregado = new javax.swing.JRadioButton();
        pnPrincipalEmp = new javax.swing.JPanel();
        pnChat = new javax.swing.JPanel();
        scrollChat = new javax.swing.JScrollPane();
        txtChat = new javax.swing.JTextArea();
        txtMensagem = new javax.swing.JTextField();
        btEnviar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        lblSaud = new javax.swing.JLabel();
        scrollServicos = new javax.swing.JScrollPane();
        pnServicos = new javax.swing.JPanel();
        lblOnline = new javax.swing.JLabel();
        scrollClientes = new javax.swing.JScrollPane();
        pnClientes = new javax.swing.JPanel();
        lblCargo = new javax.swing.JLabel();
        txtCargo = new javax.swing.JTextField();
        lblSalario = new javax.swing.JLabel();
        lblDescricao = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        btCadastra = new javax.swing.JButton();
        txtSalario = new javax.swing.JFormattedTextField();
        pnPrincipal = new javax.swing.JPanel();
        pnChat1 = new javax.swing.JPanel();
        scrollChat1 = new javax.swing.JScrollPane();
        txtChat1 = new javax.swing.JTextArea();
        txtMensagem1 = new javax.swing.JTextField();
        btEnviar1 = new javax.swing.JButton();
        btSair1 = new javax.swing.JButton();
        lblSaud1 = new javax.swing.JLabel();
        scrollServicos1 = new javax.swing.JScrollPane();
        pnServicos1 = new javax.swing.JPanel();
        lblOnline1 = new javax.swing.JLabel();
        scrollClientes1 = new javax.swing.JScrollPane();
        pnClientes1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeClient(evt);
            }
        });

        pnTela.setLayout(new java.awt.CardLayout());

        lblCliente.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblCliente.setText("Nome :");

        lblIP.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblIP.setText("Ip do Servidor :");

        lbPorta.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbPorta.setText("Porta do Servidor :");

        txtNome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtIp.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btConectar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btConectar.setText("Conectar");
        btConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConectarActionPerformed(evt);
            }
        });

        btCancelar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        try {
            txtPorta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtPorta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        gpTipo.add(rbEmpregador);
        rbEmpregador.setText("Empregador");

        gpTipo.add(rbEmpregado);
        rbEmpregado.setSelected(true);
        rbEmpregado.setText("Empregado");

        javax.swing.GroupLayout pnLoginLayout = new javax.swing.GroupLayout(pnLogin);
        pnLogin.setLayout(pnLoginLayout);
        pnLoginLayout.setHorizontalGroup(
            pnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLoginLayout.createSequentialGroup()
                .addGroup(pnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnLoginLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(btConectar)
                        .addGap(155, 155, 155)
                        .addComponent(btCancelar))
                    .addGroup(pnLoginLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnLoginLayout.createSequentialGroup()
                                .addComponent(rbEmpregador)
                                .addGap(18, 18, 18)
                                .addComponent(rbEmpregado))
                            .addGroup(pnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(pnLoginLayout.createSequentialGroup()
                                    .addComponent(lblCliente)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnLoginLayout.createSequentialGroup()
                                    .addComponent(lblIP)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtIp))
                                .addGroup(pnLoginLayout.createSequentialGroup()
                                    .addComponent(lbPorta)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtPorta))))))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        pnLoginLayout.setVerticalGroup(
            pnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCliente)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIP)
                    .addComponent(txtIp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPorta)
                    .addComponent(txtPorta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbEmpregador)
                    .addComponent(rbEmpregado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(pnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btConectar)
                    .addComponent(btCancelar))
                .addGap(50, 50, 50))
        );

        pnTela.add(pnLogin, "login");

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

        btSair.setBackground(new java.awt.Color(255, 0, 0));
        btSair.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btSair.setText("Logout");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btEnviar))
                    .addComponent(scrollChat, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(btSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 8, Short.MAX_VALUE))
        );
        pnChatLayout.setVerticalGroup(
            pnChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChatLayout.createSequentialGroup()
                .addComponent(scrollChat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btEnviar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lblSaud.setText("Bem Vindo!");

        pnServicos.setMaximumSize(new java.awt.Dimension(145, 32767));
        scrollServicos.setViewportView(pnServicos);

        lblOnline.setText("Clientes Online :");

        pnClientes.setMaximumSize(new java.awt.Dimension(145, 32767));
        pnClientes.setPreferredSize(new java.awt.Dimension(145, 278));
        scrollClientes.setViewportView(pnClientes);

        lblCargo.setText("Cargo:");

        txtCargo.setNextFocusableComponent(txtSalario);

        lblSalario.setText("Salario:");

        lblDescricao.setText("Descricao:");

        txtDescricao.setNextFocusableComponent(btCadastra);

        btCadastra.setText("Cadastrar Servico");
        btCadastra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastraActionPerformed(evt);
            }
        });

        txtSalario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.##"))));
        txtSalario.setNextFocusableComponent(txtDescricao);

        javax.swing.GroupLayout pnPrincipalEmpLayout = new javax.swing.GroupLayout(pnPrincipalEmp);
        pnPrincipalEmp.setLayout(pnPrincipalEmpLayout);
        pnPrincipalEmpLayout.setHorizontalGroup(
            pnPrincipalEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnPrincipalEmpLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnPrincipalEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnPrincipalEmpLayout.createSequentialGroup()
                        .addGroup(pnPrincipalEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollServicos, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addGroup(pnPrincipalEmpLayout.createSequentialGroup()
                                .addComponent(lblCargo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCargo))
                            .addComponent(txtDescricao)
                            .addComponent(btCadastra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnPrincipalEmpLayout.createSequentialGroup()
                                .addComponent(lblDescricao)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(pnPrincipalEmpLayout.createSequentialGroup()
                                .addComponent(lblSalario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSalario)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnChat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblSaud))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnPrincipalEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnPrincipalEmpLayout.createSequentialGroup()
                        .addComponent(lblOnline)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(scrollClientes))
                .addContainerGap())
        );
        pnPrincipalEmpLayout.setVerticalGroup(
            pnPrincipalEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPrincipalEmpLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnPrincipalEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSaud)
                    .addComponent(lblOnline))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnPrincipalEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollClientes)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnPrincipalEmpLayout.createSequentialGroup()
                        .addGroup(pnPrincipalEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCargo)
                            .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnPrincipalEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSalario)
                            .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDescricao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCadastra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollServicos)))
                .addContainerGap())
        );

        pnTela.add(pnPrincipalEmp, "emp");

        txtChat1.setEditable(false);
        txtChat1.setColumns(20);
        txtChat1.setRows(5);
        scrollChat1.setViewportView(txtChat1);

        btEnviar1.setText("Enviar");
        btEnviar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEnviar1ActionPerformed(evt);
            }
        });

        btSair1.setBackground(new java.awt.Color(255, 0, 0));
        btSair1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btSair1.setText("Logout");
        btSair1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSair1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnChat1Layout = new javax.swing.GroupLayout(pnChat1);
        pnChat1.setLayout(pnChat1Layout);
        pnChat1Layout.setHorizontalGroup(
            pnChat1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChat1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnChat1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnChat1Layout.createSequentialGroup()
                        .addComponent(txtMensagem1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btEnviar1))
                    .addComponent(scrollChat1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(btSair1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 8, Short.MAX_VALUE))
        );
        pnChat1Layout.setVerticalGroup(
            pnChat1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChat1Layout.createSequentialGroup()
                .addComponent(scrollChat1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnChat1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMensagem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btEnviar1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSair1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lblSaud1.setText("Bem Vindo!");

        pnServicos1.setMaximumSize(new java.awt.Dimension(140, 150));
        scrollServicos1.setViewportView(pnServicos1);

        lblOnline1.setText("Clientes Online :");

        pnClientes1.setMaximumSize(new java.awt.Dimension(145, 32767));
        pnClientes1.setPreferredSize(new java.awt.Dimension(145, 278));
        scrollClientes1.setViewportView(pnClientes1);

        javax.swing.GroupLayout pnPrincipalLayout = new javax.swing.GroupLayout(pnPrincipal);
        pnPrincipal.setLayout(pnPrincipalLayout);
        pnPrincipalLayout.setHorizontalGroup(
            pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnPrincipalLayout.createSequentialGroup()
                        .addComponent(scrollServicos1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnChat1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblSaud1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnPrincipalLayout.createSequentialGroup()
                        .addComponent(lblOnline1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(scrollClientes1))
                .addContainerGap())
        );
        pnPrincipalLayout.setVerticalGroup(
            pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSaud1)
                    .addComponent(lblOnline1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollServicos1)
                    .addComponent(pnChat1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollClientes1))
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
            .addComponent(pnTela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConectarActionPerformed
        if (!txtPorta.getText().equals("") && !txtIp.getText().equals("")
                && !txtNome.getText().equals("")) {
            CardLayout cl = (CardLayout) pnTela.getLayout();
            if (rbEmpregador.isSelected()) {
                cliente = new Cliente(txtNome.getText(),
                        txtIp.getText(), Integer.parseInt(txtPorta.getText()),
                        "empregador", this);
                cl.show(pnTela, "emp");
            } else {
                cliente = new Cliente(txtNome.getText(),
                        txtIp.getText(), Integer.parseInt(txtPorta.getText()),
                        "empregado", this);
                cl.show(pnTela, "main");
            }

        } else {
            System.out.println("Todos campos devem ser preenchidos");
        }
    }//GEN-LAST:event_btConectarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEnviarActionPerformed
        atualizaCliente();
        atualizaServico();
        if (!txtMensagem.getText().equals("")) {
            cliente.sendBroadcast(txtMensagem.getText());
            txtMensagem.setText("");
        }
        btEnviar.transferFocusBackward();
    }//GEN-LAST:event_btEnviarActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        CardLayout cl = (CardLayout) pnTela.getLayout();
        cl.show(pnTela, "login");
        cliente.logout();
        cliente = null;
        txtChat.setText("");

    }//GEN-LAST:event_btSairActionPerformed

    private void closeClient(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeClient
        cliente.logout();
    }//GEN-LAST:event_closeClient

    private void btEnviar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEnviar1ActionPerformed
        atualizaCliente();
        atualizaServico();
        if (!txtMensagem1.getText().equals("")) {
            cliente.sendBroadcast(txtMensagem1.getText());
            txtMensagem1.setText("");
        }
        btEnviar1.transferFocusBackward();
    }//GEN-LAST:event_btEnviar1ActionPerformed

    private void btSair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSair1ActionPerformed
        CardLayout cl = (CardLayout) pnTela.getLayout();
        cl.show(pnTela, "login");
        cliente.logout();
        cliente = null;
        txtChat.setText("");
    }//GEN-LAST:event_btSair1ActionPerformed

    private void btCadastraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastraActionPerformed
        cliente.cadastrarServico(txtCargo.getText(), Float.parseFloat(txtSalario.getText()),
                txtDescricao.getText());
        txtCargo.setText("");
        txtSalario.setText("");
        txtDescricao.setText("");
    }//GEN-LAST:event_btCadastraActionPerformed

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
            java.util.logging.Logger.getLogger(LoginCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginCliente().setVisible(true);
            }
        });
    }

    private JPanel addCliente(Usuario user) {
        JLabel lblNome = new javax.swing.JLabel();
        JLabel usrNome = new javax.swing.JLabel();
        JPanel nCliente = new JPanel();
        nCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nCliente.setSize(145, 25);
        nCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mouseClick(evt, user);
            }
        });
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

    private void mouseClick(java.awt.event.MouseEvent evt, Usuario user) {
        new MsgDireta(user, cliente).setVisible(true);
    }

    private JPanel addServico(Servico servico) {
        JPanel nServico = new JPanel();
        JLabel lblCarg = new JLabel();
        JLabel lblSal = new JLabel();
        JLabel srvSalario = new JLabel();
        JLabel lblDesc = new JLabel();
        JLabel srvDescricao = new JLabel();
        JButton btInscreva = new JButton("Me inscrever");
        btInscreva.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srvClicked(evt, servico);
            }
        });

        nServico.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nServico.setSize(145, 75);

        lblCarg.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblCarg.setText(servico.getCargo());
        lblSal.setText("Salario:");
        srvSalario.setText(Float.toString(servico.getSalario()));
        lblDesc.setText("Descricao:");
        srvDescricao.setText(servico.getDescricao());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(nServico);
        nServico.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addComponent(lblSal)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblCarg)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(srvSalario)
                                                .addGap(0, 2, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblDesc)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(srvDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(btInscreva)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblCarg)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblSal)
                                                        .addComponent(srvSalario))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblDesc)
                                        .addComponent(srvDescricao))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btInscreva, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        return nServico;
    }

    private void srvClicked(java.awt.event.ActionEvent evt, Servico servico) {
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastra;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btConectar;
    private javax.swing.JButton btEnviar;
    private javax.swing.JButton btEnviar1;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btSair1;
    private javax.swing.ButtonGroup gpTipo;
    private javax.swing.JLabel lbPorta;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblIP;
    private javax.swing.JLabel lblOnline;
    private javax.swing.JLabel lblOnline1;
    private javax.swing.JLabel lblSalario;
    private javax.swing.JLabel lblSaud;
    private javax.swing.JLabel lblSaud1;
    private javax.swing.JPanel pnChat;
    private javax.swing.JPanel pnChat1;
    private javax.swing.JPanel pnClientes;
    private javax.swing.JPanel pnClientes1;
    private javax.swing.JPanel pnLogin;
    private javax.swing.JPanel pnPrincipal;
    private javax.swing.JPanel pnPrincipalEmp;
    private javax.swing.JPanel pnServicos;
    private javax.swing.JPanel pnServicos1;
    private javax.swing.JPanel pnTela;
    private javax.swing.JRadioButton rbEmpregado;
    private javax.swing.JRadioButton rbEmpregador;
    private javax.swing.JScrollPane scrollChat;
    private javax.swing.JScrollPane scrollChat1;
    private javax.swing.JScrollPane scrollClientes;
    private javax.swing.JScrollPane scrollClientes1;
    private javax.swing.JScrollPane scrollServicos;
    private javax.swing.JScrollPane scrollServicos1;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JTextArea txtChat;
    private javax.swing.JTextArea txtChat1;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtIp;
    private javax.swing.JTextField txtMensagem;
    private javax.swing.JTextField txtMensagem1;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtPorta;
    private javax.swing.JFormattedTextField txtSalario;
    // End of variables declaration//GEN-END:variables
}
