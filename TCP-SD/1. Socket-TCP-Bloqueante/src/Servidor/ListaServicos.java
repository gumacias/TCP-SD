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
public class ListaServicos {

    private static ListaServicos uniqueInstance;
    private ArrayList<Servico> listaServico = new ArrayList();
    private ArrayList<ServEmp> listInteresse = new ArrayList();

    public ListaServicos() {
    }
    
    public void atualizaInteressados(Servico servico, ArrayList<Usuario> interessados)
    {
        for(ServEmp s : listInteresse){
            if(s.getServico().getCargo().equals(servico.getCargo())&&
                s.getServico().getDescricao().equals(servico.getDescricao())&&
                s.getServico().getSalario() == servico.getSalario())
            {
                s.setListaInteressados(interessados);
                return;
            }
        }
        listInteresse.add(new ServEmp(servico, interessados));
    }

    public static synchronized ListaServicos getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new ListaServicos();
        }
        return uniqueInstance;
    }
    
    public ServEmp getServEmp(Servico servico)
    {
        for(ServEmp s :listInteresse){
            if(s.getServico().getCargo().equals(servico.getCargo())&&
                s.getServico().getDescricao().equals(servico.getDescricao())&&
                s.getServico().getSalario() == servico.getSalario())
                return s;
        }
        return null;
    }
    
    public int getServIndex(Servico servico)
    {
        int i = 0;
        for(Servico s :(ArrayList<Servico>) listaServico){
            if(s.getCargo().equals(servico.getCargo())&&
                s.getDescricao().equals(servico.getDescricao())&&
                s.getSalario() == servico.getSalario())
                break;
            i++;
        }
        return i;
    }

    public void add(Servico servico) {
        listaServico.add(servico);
        listInteresse.add(new ServEmp(servico));
    }

    public ServEmp addInteressado(int i, Usuario user) {
        
        listInteresse.get(i).addInteressado(user);
        return listInteresse.get(i);
            
    }

    public void remove(Servico servico) {
        int i = 0;
        for(Servico s :(ArrayList<Servico>) listaServico){
            if(s.getCargo().equals(servico.getCargo())&&
                s.getDescricao().equals(servico.getDescricao())&&
                s.getSalario() == servico.getSalario())
                break;
            i++;
        }
        listaServico.remove(i);
        listInteresse.remove(i);
    }

    public ArrayList getServicos() {
        return listaServico;
    }

    public void setListaServico(ArrayList<Servico> listaServico) {
        this.listaServico = listaServico;
    }

    public ArrayList<ServEmp> getListInteresse() {
        return listInteresse;
    }

    public void setListInteresse(ArrayList<ServEmp> listInteresse) {
        this.listInteresse = listInteresse;
    }

}
