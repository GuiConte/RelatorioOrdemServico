package relatorioos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author LAB
 */
public class Conexao {

    private static String user = "SYSDBA";
    private static String pass = "masterkey";
    
    public static String bancoPath = "";
    public static String server = "";
    

    public static java.sql.Connection getConnectionFirebird() throws SQLException, ClassNotFoundException {

        Connection c = null;
        
        //String bancoPath = "C:\\NTS\\SIGEWIN\\SIGE.FDB";
        
        String driver = "org.firebirdsql.jdbc.FBDriver";
        Class.forName(driver);

        String url = "jdbc:firebirdsql:" + server + ":" + bancoPath + "?encoding=ISO8859_1";

        c = DriverManager.getConnection(url, user, pass);

        if (c != null) {

           // String status = ("STATUS--->Conectado com sucesso!\n");
           // Main.txtLog.append(status);
        } else {

           // String status = ("STATUS--->Não foi possivel realizar conexão\n");
           // Main.txtLog.append(status);
        }
        return c;

    }

}
