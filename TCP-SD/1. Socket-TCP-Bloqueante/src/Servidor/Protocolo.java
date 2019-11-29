package Servidor;

import Cliente.Usuario;
import Servidor.Servico;
import java.util.ArrayList;

public class Protocolo {
    private String action;
    private String nome;
    private String tipo;
    private String mensagem;
    private Servico servico;
    private Usuario destinatario;
    private Usuario remetente;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Servico> servicos;
    private ArrayList<Usuario> interessados;

    public Protocolo()
    {
        this.action = "logout";
    }
    
    public Protocolo(Servico servico, Usuario user)
    {
        this.action = "contratacao";
        this.servico = servico;
        this.destinatario = user;
    }
    
    public Protocolo(ServEmp serv)
    {
        this.action = "listarInteressados";
        this.servico = serv.getServico();
        this.interessados = serv.getListaInteressados();
    }
    
    public Protocolo(String mensagem)
    {
        this.action = "broadcast";
        this.mensagem = mensagem;
    }
    public Protocolo(String action, Servico s)
    {
        this.action = action;
        this.servico = s;
    }
    public Protocolo(String mensagem, Usuario destinatario)
    {
        this.action = "mensagemDireta";
        this.mensagem = mensagem;
        this.destinatario = destinatario;
    }
    public Protocolo(String action, String nome, String tipo) {
        this.action = action;
        this.nome = nome;
        this.tipo = tipo;
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
        this.servicos = servico;
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

    public Usuario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Usuario user) {
        this.destinatario = user;
    }

    public Usuario getRemetente() {
        return remetente;
    }

    public void setRemetente(Usuario remetente) {
        this.remetente = remetente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Usuario> getInteressados() {
        return interessados;
    }

    public void setInteressados(ArrayList<Usuario> interessados) {
        this.interessados = interessados;
    }
}
