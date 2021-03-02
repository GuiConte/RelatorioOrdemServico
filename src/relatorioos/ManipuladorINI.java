/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorioos;

import java.io.File;
import java.io.IOException;
import org.ini4j.Ini;
import org.ini4j.IniPreferences;

/**
 *
 * @author LAB
 */
public class ManipuladorINI {

    public static void lerINI() throws IOException {
        Ini ini = new Ini(new File("C:\\NTS\\SIGEWIN\\UniCon.ini"));
        java.util.prefs.Preferences prefs = new IniPreferences(ini);
        
        Conexao.bancoPath = prefs.node("CONEXAO").get("DATABASE", null);
        Conexao.server = prefs.node("CONEXAO").get("SERVER", null);
    }

}
