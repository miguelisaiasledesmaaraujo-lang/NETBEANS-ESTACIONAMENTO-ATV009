package psv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {

public static Connection abrirConexao() {
    String url = "jdbc:mysql://127.0.0.1:3306/estacionamento";
    System.out.println("URL utilizada: " + url);
    String usuario = "root";
    String senha = "";

    try {
        System.out.println("Tentando conectar ao MySQL...");
        DriverManager.setLoginTimeout(5);
System.out.println("Tentando conectar ao MySQL...");

Connection con = DriverManager.getConnection(url, usuario, senha);

System.out.println("Conexão aberta.");
        return con;

    } catch (SQLException e) {
        System.out.println("Erro ao conectar: " + e.getMessage());
        return null;
    }
}

public static void fecharConexao(Connection con) {
    if (con != null) {
        try {
            con.close();
            System.out.println("Conexão fechada.");
        } catch (SQLException e) {
            System.out.println("Erro ao fechar conexão: " + e.getMessage());
        }
    }
}

}
