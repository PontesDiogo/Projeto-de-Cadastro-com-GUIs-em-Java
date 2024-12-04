/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.control;
import fatec.poo.model.Vendedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author diogo
 */
public class DaoVendedor {
    
    private Connection conn;
    
    public DaoVendedor(Connection conn) {
         this.conn = conn;
    }    
    
    public Vendedor consultar (int cpf) {
        Vendedor objVendedor = null;         
       
        PreparedStatement ps;
        try {
          ps = conn.prepareStatement("SELECT * from TBL_Vendedor where cpf = ?");
            
          ps.setInt(1, cpf);
          ResultSet rs = ps.executeQuery();          
          if (rs.next() == true) {
             objVendedor = new Vendedor(rs.getString("cpf"), rs.getString("nome"), rs.getDouble("salarioBase"));
             objVendedor.setEndereco(rs.getString("endereco"));
             objVendedor.setCidade(rs.getString("cidade"));
             objVendedor.setUf(rs.getString("uf"));
             objVendedor.setDdd(rs.getString("ddd"));
             objVendedor.setTelefone(rs.getString("telefone"));
             
             
           }
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }
        return(objVendedor);
    }    
     
    public void inserir(Vendedor objVendedor) {
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("INSERT INTO TBL_Vendedor(cpf, nome,"+
                                       "endereco, cidade, ddd, telefone, uf, cep, salarioBase, taxaComissao) VALUES(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, objVendedor.getCpf());
            ps.setString(2, objVendedor.getNome());
            ps.setString(3, objVendedor.getEndereco());
            ps.setString(4, objVendedor.getCidade());
            ps.setString(5, objVendedor.getDdd());
            ps.setString(6, objVendedor.getTelefone());
            ps.setString(7, objVendedor.getUf());
            ps.setString(8, objVendedor.getCep());
            ps.setDouble(9, objVendedor.getsalarioBase());
            ps.setDouble(10, objVendedor.getTaxaComissao());
            
            ps.execute(); //envia a instrução SQL para o SGBD
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }  
    
    public void alterar(Vendedor vendedor) {
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("UPDATE TBL_Vendedor set nome = ?, " +
                                       "endereco = ?, " +
                                       "cidade = ? " +
                                       "ddd = ?"+
                                       "telefone = ?"+
                                       "uf = ?"+
                                       "cep = ?"+
                                       "salarioBase = ?"+
                                       "taxaComissao = ?"+
                                       "where cpf = ?");
            ps.setString(1, vendedor.getNome());
            ps.setString(2, vendedor.getEndereco());
            ps.setString(3, vendedor.getCidade());
            ps.setString(4, vendedor.getDdd());
            ps.setString(5, vendedor.getTelefone());
            ps.setString(6, vendedor.getUf());
            ps.setString(7, vendedor.getCep());
            ps.setDouble(8, vendedor.getsalarioBase());
            ps.setDouble(9, vendedor.getTaxaComissao());
            ps.setString(10, vendedor.getCpf());
           
            ps.execute(); //Envia a instrução SQL para o SGBD
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public void excluir(Vendedor vendedor) {
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("DELETE FROM TBL_Vendedor where cpf = ?");
            
            ps.setString(1, vendedor.getNome());
                      
            ps.execute(); //Envia a instrução SQL para o SGBD
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
}





