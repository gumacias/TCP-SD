
package Tela;

public abstract class Model{
    private String ipServidor;
    private int porta;
    
public Model(String ipServidor, int porta){
    this.ipServidor = ipServidor;
    this.porta = porta;
}


public String getIpServidor(){
    return this.ipServidor;
}

public int getPorta(){
    return this.porta;
}

public void setIpServidor(String ipServidor){
    this.ipServidor = ipServidor;
}

public void setPorta (int porta){
    this.porta = porta;
}
}
