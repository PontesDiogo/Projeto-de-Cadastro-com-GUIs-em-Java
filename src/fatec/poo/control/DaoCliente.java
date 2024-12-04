/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.control;
import fatec.poo.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author diogo
 */
public class DaoCliente {
    
    private Connection conn;
    
    public DaoCliente(Connection conn) {
         this.conn = conn;
    }    
    
    public Cliente consultar (int cpf) {
        Cliente objCliente = null;         
       
        PreparedStatement ps;
        try {
          ps = conn.prepareStatement("SELECT * from TBL_Cliente where cpf = ?");
            
          ps.setInt(1, cpf);
          ResultSet rs = ps.executeQuery();          
          if (rs.next() == true) {
             objCliente = new Cliente(rs.getString("cpf"), rs.getString("nome"), rs.getDouble("limiteCredito"));
             objCliente.setEndereco(rs.getString("endereco"));
             objCliente.setCidade(rs.getString("cidade"));
             objCliente.setUf(rs.getString("uf"));
             objCliente.setDdd(rs.getString("ddd"));
             objCliente.setTelefone(rs.getString("telefone"));
             
             
           }
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }
        return(objCliente);
    }    
     
    public void inserir(Cliente objCliente) {
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("INSERT INTO TBL_Cliente(cpf, nome,"+
                                       "endereco, cidade, ddd, telefone, uf, cep, limiteCredito, limiteDisponivel) VALUES(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, objCliente.getCpf());
            ps.setString(2, objCliente.getNome());
            ps.setString(3, objCliente.getEndereco());
            ps.setString(4, objCliente.getCidade());
            ps.setString(5, objCliente.getDdd());
            ps.setString(6, objCliente.getTelefone());
            ps.setString(7, objCliente.getUf());
            ps.setString(8, objCliente.getCep());
            ps.setDouble(9, objCliente.getLimiteCredito());
            ps.setDouble(10, objCliente.getLimiteDisponivel());
            
            ps.execute(); //envia a instrução SQL para o SGBD
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }  
    
    public void alterar(Cliente cliente) {
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("UPDATE TBL_Cliente set nome = ?, " +
                                       "endereco = ?, " +
                                       "cidade = ? " +
                                       "ddd = ?"+
                                       "telefone = ?"+
                                       "uf = ?"+
                                       "cep = ?"+
                                       "limiteCredotp = ?"+
                                       "limiteDisponivel = ?"+
                                       "where cpf = ?");
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEndereco());
            ps.setString(3, cliente.getCidade());
            ps.setString(4, cliente.getDdd());
            ps.setString(5, cliente.getTelefone());
            ps.setString(6, cliente.getUf());
            ps.setString(7, cliente.getCep());
            ps.setDouble(8, cliente.getLimiteCredito());
            ps.setDouble(9, cliente.getLimiteDisponivel());
            ps.setString(10, cliente.getCpf());
           
            ps.execute(); //Envia a instrução SQL para o SGBD
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public void excluir(Cliente cliente) {
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("DELETE FROM TBL_Cliente where cpf = ?");
            
            ps.setString(1, cliente.getNome());
                      
            ps.execute(); //Envia a instrução SQL para o SGBD
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
}


