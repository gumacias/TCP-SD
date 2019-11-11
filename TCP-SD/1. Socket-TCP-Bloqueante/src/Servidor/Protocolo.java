package Servidor;

import Cliente.Usuario;
import Servidor.Servico;
import java.util.ArrayList;

public class Protocolo {
    private String action;
    private String nome;
    String mensagem;
    private Servico servico;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Servico> servicos;

    public Protocolo(String mensagem)
    {
        this.action = "broadcast";
        this.mensagem = mensagem;
    }
    public Protocolo(String action, String nome) {
        this.action = action;
        this.nome = nome;
    }
    
    public Protocolo(String action, ArrayList<Usuario> usuarios)
    {
        this.action = action;
        this.usuarios = usuarios;
    }
    
    public Protocolo(ArrayList<Servico> servicos, String action)
    {
        this.action = action;
        this.servicos = servicos;
    }
    
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(ArrayList<Servico> servico) {
        this.servicos = servicos;
    }
    
    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }
    
}
