/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Cliente.Usuario;

/**
 *
 * @author Gustavo
 */
public class Servico {
    private String cargo;
    private String descricao;
    private float salario;
    private Usuario empregador;
    
    public Servico(String cargo, String descricao, float salario, Usuario empregador)
    {
        this.cargo = cargo;
        this.descricao = descricao;
        this.salario = salario;
        this.empregador = empregador;
    }
    public Servico(String cargo, String descricao, float salario)
    {
        this.cargo = cargo;
        this.descricao = descricao;
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public Usuario getEmpregador() {
        return empregador;
    }

    public void setEmpregador(Usuario empregador) {
        this.empregador = empregador;
    }
    
    public static boolean isEmp(Servico servico, Usuario empregador)
    {
        return servico.getEmpregador().getNome().equals(empregador.getNome())&&
                servico.getEmpregador().getIp().equals(empregador.getIp())&&
                servico.getEmpregador().getPorta() == empregador.getPorta();
    }
    
}
