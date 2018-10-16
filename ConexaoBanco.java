package projetojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matheus
 */
public class ConexaoBanco {

    private static final String url = "jdbc:postgresql://localhost:5433/PROJETOJDBC";
    private static final String usuario = "Ronan";
    private static final String senha = "root";
    

   

    public static Connection getConnection() throws SQLException {
        Connection conexao = null;
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver carregado com sucesso\n");

        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }

        try {

            conexao = (Connection) DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão efetuada com sucesso\n");
            return conexao;

        } catch (SQLException ex) {
            System.out.println("Erro ao se conectar ao banco " + ex.getMessage());
            ex.printStackTrace();

        }
        return null;

    }

    public static void fechaConexao(Connection conexao) throws SQLException {

        try {
            if (conexao != null) {
                conexao.close();
                System.out.println("Conexao fechada");
            }
        } catch (Exception e) {
            System.out.println("Erro ao fechar conexao");
        }

    }

}
