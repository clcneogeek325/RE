package BaseDatos;

import com.mysql.jdbc.*;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    public Connection conexion;
    public String driver = "com.mysql.jdbc.Driver";
    public String URL = "jdbc:mysql://127.0.0.1/inventarioTienda?user=root&password=";

    public void conectar() {
        try {
            Class.forName(driver);

            conexion = (Connection) DriverManager.getConnection(URL);

        } catch (ClassNotFoundException e) {
            System.out.println(e);

        }catch (SQLException e){
            System.out.println(e);
        }
    }
    
    public void desconectar() throws SQLException {
        conexion.close();
    }
}