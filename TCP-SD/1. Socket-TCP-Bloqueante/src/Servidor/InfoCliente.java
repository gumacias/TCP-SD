package Servidor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bruno
 */
public class InfoCliente {
    private String nome;
    private String ip;
    //private String action;
    private int porta;

    public InfoCliente(String nome, String ip, int porta/*, String action*/) {
        this.ip = ip;
        this.nome = nome;
        this.porta = porta;
        //this.action = action;
    }

    public String getIP() {
        return ip;
    }

    public void setIP(String ip) {
        this.ip = ip;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    /*public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }*/
    
    
}
