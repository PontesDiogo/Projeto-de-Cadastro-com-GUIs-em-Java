/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fatec.poo.model.Pedido;

/**
 *
 * @author diogo
 */
public class DaoPedido {
    private Connection conn;

    public DaoPedido(Connection conn) {
        this.conn = conn;
    }

    public Pedido consultar(int numero) {
        Pedido objPedido = null;
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("SELECT * from TBL_Pedido where cpf = ?");

            ps.setInt(1, numero);
            ResultSet rs = ps.executeQuery();
            if (rs.next() == true) {
                objPedido = new Pedido(rs.getString(numero));
                objPedido.setDataEmissao(rs.getString("dataEmissao"));
                objPedido.setValor(rs.getDouble("valor"));

            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return (objPedido);
    }


    public Pedido inserir(Pedido objpedido) {
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("INSERT INTO TBL_pedido(numero," +
                    "dataEmissao, valor) VALUES(?,?,?)");
            ps.setString(1, objpedido.getNumero());
            ps.setString(2, objpedido.getDataEmissao());
            ps.setDouble(3, objpedido.getValor());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return (objpedido);
    }

    public Pedido alterar(Pedido pedido) {
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("UPDATE TBL_pedido set dataEmissao = ?, " +
                    "valor = ?, ");
            ps.setString(1, pedido.getDataEmissao());
            ps.setDouble(2, pedido.getValor());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return (pedido);
    }

    public Pedido excluir(Pedido pedido) {
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("DELETE FROM TBL_pedido where numero = ?");
            ps.setString(1, pedido.getNumero());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return (pedido);
    }

}

