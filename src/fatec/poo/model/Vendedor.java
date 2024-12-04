/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.model;

import java.util.ArrayList;

/**
 *
 * @author diogo
 */
public class Vendedor extends Pessoa{
    private double salarioBase, taxaComissao;
    private ArrayList<Pedido> pedidos;

    public Vendedor( String cpf, String nome, double salarioBase) {
        super(cpf, nome);
        this.salarioBase = salarioBase;
        this.pedidos = new ArrayList<>();
    }

    public double getsalarioBase() {
        return salarioBase;
    }

    public void setsalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double getTaxaComissao() {
        return taxaComissao;
    }

    public void setTaxaComissao(double taxaComissao) {
        this.taxaComissao = taxaComissao;
    }
    
    
    
}
