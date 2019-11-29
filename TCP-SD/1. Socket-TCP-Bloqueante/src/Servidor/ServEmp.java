/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Cliente.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class ServEmp {
    private Servico servico;
    private ArrayList <Usuario> listaInteressados = new ArrayList();
    
    public ServEmp(Servico servico)
    {
        this.servico = servico;
    }
    public ServEmp(Servico servico, ArrayList<Usuario> interessados)
    {
        this.servico = servico;
        this.listaInteressados = interessados;
    }
    
    public void addInteressado(Usuario user)
    {
        listaInteressados.add(user);
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public ArrayList<Usuario> getListaInteressados() {
        return listaInteressados;
    }

    public void setListaInteressados(ArrayList<Usuario> listaInteressados) {
        this.listaInteressados = listaInteressados;
    }
    
}
