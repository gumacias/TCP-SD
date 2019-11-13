/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class ListaServicos {
    private static ListaServicos uniqueInstance;
    private ArrayList <Servico> listaServico = new ArrayList();
    
    public ListaServicos() {
    }

    public static synchronized ListaServicos getInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new ListaServicos();
        }
        return uniqueInstance;
    }
    
    public void add(Servico servico)
    {
        listaServico.add(servico);
    }
    
    public void remove(Servico user)
    {
        listaServico.remove(user);
    }
    
    public ArrayList getServicos()
    {
        return listaServico;
    }

    public void setListaServico(ArrayList<Servico> listaServico) {
        this.listaServico = listaServico;
    }
    
}
