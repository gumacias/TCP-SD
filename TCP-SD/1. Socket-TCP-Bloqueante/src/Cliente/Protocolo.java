package Cliente;

public class Protocolo {
    private String action;
    private String nome;
    //private String msg;
    private String cargo;
    private String descricao;

    public Protocolo(String action, String nome) {
        this.nome = nome;
        this.action = action;
    }
    
    public Protocolo(String nome, String action, String cargo, String descricao)
    {
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
    
    
}
