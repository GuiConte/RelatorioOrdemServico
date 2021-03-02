/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorioos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LAB
 */
public class ManipuladorFB {

    public static ArrayList<Relatorio> consultaOS(String funcionario,
            String data_inicio, String data_fim) throws SQLException, ClassNotFoundException {
        Connection con = new Conexao().getConnectionFirebird();
        String SQL = "select s.id_os,o.dt_lancamento, s.descricao, s.vr_servico, f.funcionario\n"
                + "from vd_os_servico s\n"
                + "inner join vd_os o on o.id_os = s.id_os\n"
                + "inner join VD_OS_FUNCIONARIO f on f.id_os = s.id_os\n"
                + "WHERE o.id_empresa = 1 AND UPPER(f.FUNCIONARIO) LIKE UPPER('%" + funcionario + "%')\n"
                + "AND CAST(o.dt_lancamento AS DATE)  BETWEEN '" + data_inicio + "' AND '" + data_fim + "'\n"
                + "order by f.funcionario;";

        PreparedStatement pst = con.prepareStatement(SQL);
        ResultSet rs = pst.executeQuery();

        ArrayList<Relatorio> servicos = new ArrayList();

        try {
            if (rs.next()) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
                LocalDateTime myDate = null;

                do {
                    try {
                        myDate = LocalDateTime.parse(rs.getString("dt_lancamento"),
                                formatter);
                    } catch (Exception ex) {
                    }

                    String data = myDate.getDayOfMonth() + "/" + myDate.getMonthValue() + "/" + myDate.getYear();

                    servicos.add(new Relatorio(
                            rs.getString("id_os"),
                            data,
                            rs.getString("descricao").replace("\r\n", "/ "),
                            rs.getString("vr_servico"),
                            rs.getString("funcionario")
                    ));

                    Relatorio.total += Double.parseDouble(rs.getString("vr_servico"));

                } while (rs.next());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        //stm.close();
        con.close();

        return servicos;
    }

    public static ArrayList<String> consultaFuncionario() throws SQLException, ClassNotFoundException {
        Connection con = new Conexao().getConnectionFirebird();
        String SQL = "select distinct f.funcionario "
                + "from vd_os_servico s "
                + "inner join VD_OS_FUNCIONARIO f on f.id_os = s.id_os";

        PreparedStatement pst = con.prepareStatement(SQL);
        ResultSet rs = pst.executeQuery();

        ArrayList<String> funcionarios = new ArrayList();

        try {
            if (rs.next()) {
                do {
                    funcionarios.add(rs.getString("funcionario"));
                } while (rs.next());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        //stm.close();
        con.close();

        return funcionarios;
    }
}
