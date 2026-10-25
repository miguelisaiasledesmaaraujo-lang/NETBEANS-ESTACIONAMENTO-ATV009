package psv;

import java.sql.Connection;
import java.util.List;

public class teste {
public static void main(String[] args) {
Connection con = conexao.abrirConexao();

if (con != null) {
    carroDAO cd = new carroDAO(con);

    List<carrobean> lista = cd.listarTodos();

    if (lista != null) {
        for (carrobean cb : lista) {
            System.out.println("Placa: " + cb.getPlaca());
            System.out.println("Cor: " + cb.getCor());
            System.out.println("Descrição: " + cb.getDescricao());
            System.out.println("----------------------");
        }
    }

    conexao.fecharConexao(con);
}
}
}