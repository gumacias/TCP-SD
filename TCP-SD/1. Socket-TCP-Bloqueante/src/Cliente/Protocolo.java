package Cliente;

public class Protocolo {
    private String nome;
    private String action;

    public Protocolo(String nome, String action) {
        this.nome = nome;
        this.action = action;
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
