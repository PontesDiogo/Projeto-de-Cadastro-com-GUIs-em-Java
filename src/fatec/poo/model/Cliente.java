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
public class Cliente  extends Pessoa{
    private double limiteCredito, limiteDisponivel;
    private ArrayList<Pedido> pedidos;
    
    public Cliente( String cpf, String nome, double limiteCredito) {
        super(cpf, nome);
        this.limiteCredito = limiteCredito;
        this.pedidos = new ArrayList<>();
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public double getLimiteDisponivel() {
        return limiteDisponivel;
    }

    public void setLimiteDisponivel(double limiteDisponivel) {
        this.limiteDisponivel = limiteDisponivel;
    }
    

    
    
}
