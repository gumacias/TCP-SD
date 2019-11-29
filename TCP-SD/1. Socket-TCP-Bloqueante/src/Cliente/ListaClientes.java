/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.io.DataOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class ListaClientes {
    private static ListaClientes uniqueInstance;
    private ArrayList <Usuario> listaCliente = new ArrayList();
    private ArrayList <DataOutputStream> saida = new ArrayList();

    public ListaClientes() {
    }
    
    public int getUsuarioIndex(Usuario user){
        int i = 0;
        for(Usuario usuario : (ArrayList<Usuario>)listaCliente)
        {
            if(usuario.getNome().equals(user.getNome())&&
                usuario.getIp().equals(user.getIp())&&
                usuario.getPorta()==user.getPorta())
                break;
            i++;
        }
        return i;
    }

    public static synchronized ListaClientes getInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new ListaClientes();
        }
        return uniqueInstance;
    }
    public void add(Usuario user)
    {
        listaCliente.add(user);
    }
    
    public void remove(Usuario user)
    {
        listaCliente.remove(user);
    }
    
    public ArrayList getCliente()
    {
        return listaCliente;
    }
    
    public void add(DataOutputStream os)
    {
        saida.add(os);
    }
    
    public void remove(DataOutputStream os)
    {
        saida.remove(os);
    }
    
    public ArrayList getSaida()
    {
        return saida;
    }

    public void setListaCliente(ArrayList<Usuario> listaCliente) {
        this.listaCliente = listaCliente;
    }
    
}
