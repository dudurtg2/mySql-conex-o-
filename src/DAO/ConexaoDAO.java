package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoDAO {
    public Connection conn = null;

    public Connection conectaDB() {
        try {
            String url = "jdbc:mysql://localhost:3306/loja?user=root&password=";
            conn = DriverManager.getConnection(url);
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Conexão Falhou: " + error);
        }
        return conn;
    }
}
