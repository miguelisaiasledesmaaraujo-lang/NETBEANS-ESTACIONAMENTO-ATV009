package psv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class carroDAO {

private Connection con;

public  carroDAO(Connection con) {
     this.con = con;
}

public Connection getCon() {
    return con;
}

public void setCon(Connection con) {
    this.con = con;
}

public String inserir(carrobean carro) {
    String sql = "INSERT INTO carro (placa, cor, descricao) VALUES (?, ?, ?)";

    try {
        PreparedStatement ps = getCon().prepareStatement(sql);

        ps.setString(1, carro.getPlaca());
        ps.setString(2, carro.getCor());
        ps.setString(3, carro.getDescricao());

        if (ps.executeUpdate() > 0) {
            return "Inserido com sucesso.";
        } else {
            return "Erro ao inserir.";
        }

    } catch (SQLException e) {
        return e.getMessage();
    }
}

public String alterar(carrobean cb) {
String sql = "UPDATE carro SET cor = ?, descricao = ? WHERE placa = ?";

try {
    PreparedStatement ps = getCon().prepareStatement(sql);

    ps.setString(1, cb.getCor());
    ps.setString(2, cb.getDescricao());
    ps.setString(3, cb.getPlaca());

    if (ps.executeUpdate() > 0) {
        return "Alterado com sucesso.";
    } else {
        return "Nenhum carro encontrado com essa placa.";
    }

} catch (SQLException e) {
    return e.getMessage();
}


}


public String excluir(carrobean carro) {
    String sql = "DELETE FROM carro WHERE placa = ?";

    try {
        PreparedStatement ps = getCon().prepareStatement(sql);

        ps.setString(1, carro.getPlaca());

        if (ps.executeUpdate() > 0) {
            return "Excluído com sucesso.";
        } else {
            return "Erro ao excluir.";
        }

    } catch (SQLException e) {
        return e.getMessage();
    }
}

public List<carrobean> listarTodos() {
    String sql = "SELECT * FROM carro";
    List<carrobean> listaCarro = new ArrayList<>();

    try {
        PreparedStatement ps = getCon().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            carrobean cb = new carrobean();

            cb.setPlaca(rs.getString("placa"));
            cb.setCor(rs.getString("cor"));
            cb.setDescricao(rs.getString("descricao"));

            listaCarro.add(cb);
        }

        return listaCarro;

    } catch (SQLException e) {
        return null;
    }
}
}