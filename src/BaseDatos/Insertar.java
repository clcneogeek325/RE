package BaseDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Insertar {

    public Conexion db = new Conexion();
    ResultSet Resultados;
    Statement objetoDB;
    boolean ejecucion;

    public Insertar(String campos, int lanzaMensaje, String mensaje) {
        db.conectar();
        try {
            objetoDB = db.conexion.createStatement();
            ejecucion = objetoDB.execute(campos);
            if (lanzaMensaje == 1)
            JOptionPane.showMessageDialog(null, mensaje);
            db.desconectar();
        } catch (SQLException ex) {
            System.out.println("Este es el error "+ex);
        }
    }
}
