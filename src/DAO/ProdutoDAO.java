package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.ProdutoDTO;
public class ProdutoDAO {
    Connection conn;
    PreparedStatement pstm;
    public void cadastrar(ProdutoDTO produto) {
        String sql = "INSERT INTO PRODUTOS (NOME, PRECO) VALUES (?, ?)";
        conn = new ConexaoDAO().conectaDB();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, produto.getNome());
            pstm.setFloat(2, produto.getPreco());
            
            pstm.execute();
            pstm.close();
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "ProdutoDAO " + error);
        }

    }
    public ArrayList<ProdutoDTO> lista() {
        String sql = "SELECT * FROM PRODUTOS";
        ArrayList<ProdutoDTO> produtos = new ArrayList<ProdutoDTO>();
        ResultSet rs;
        conn = new ConexaoDAO().conectaDB();
        try {
            pstm = conn.prepareStatement(sql);
            rs =  pstm.executeQuery();
            while (rs.next()) {
                ProdutoDTO produto = new ProdutoDTO(rs.getString("nome"), rs.getFloat("preco"), rs.getInt("cod"));
                produtos.add(produto);
            }
            pstm.close();
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "ProdutoDAO " + error);
        }
        return produtos;
    }
}
