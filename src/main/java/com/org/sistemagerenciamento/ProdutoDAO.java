package com.org.sistemagerenciamento;
import java.sql.*;

public class ProdutoDAO {
    
    public void salvarProduto(Produto produto){
        String sql = "INSERT INTO protudos(id, nome, categoria, quantidade)"
                + "VALUES(?,?,?,?)";
        try (Connection conn = DataBaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1,produto.getId());
            pstmt.setString(2, produto.getNome());
            pstmt.setString(3, produto.getCategoria());
            pstmt.setInt(4, produto.getQuantidade());
            pstmt.executeUpdate();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public Produto buscarProdutoPorId(int id){
        String sql = "SELECT * FROM produtos WHERE id = ?";
        
        try (Connection conn = DataBaseConnection.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Produto (
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("categoria"),
                rs.getInt("quantidade")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
