/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorioos;

import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author LAB
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        ManipuladorINI.lerINI();
        View v = new View();
            v.setComboFuncionario(ManipuladorFB.consultaFuncionario());
            v.setVisible(true);
    }

}
