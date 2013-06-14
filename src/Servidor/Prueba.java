package Servidor;

import BaseDatos.Consultar;
import com.mysql.jdbc.*;
import java.sql.SQLException;

/**
 *
 * @author neogeek
 */
public class Prueba {
    
    public static void main(String[] args) throws SQLException {
        ResultSet res = (ResultSet) new Consultar().Consultar("select *from administrador");
        while (res.next()){
            System.out.println(res.getString("usuario"));
           
        }
    }
}
