package Cliente;

import BaseDatos.Actualizar;
import BaseDatos.Consultar;
import BaseDatos.Eliminar;
import BaseDatos.Insertar;
import Fecha.ObtFecha;
import Fecha.ObtHora;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Servidor extends UnicastRemoteObject implements Operaciones {
    DefaultTableModel modeloTabla;
    Object datos[]=new Object[3];
    int contador;
    public GUIServidor gui;
   
    int puerto;
    String ip;
    Registry registro;

    public Servidor() throws UnknownHostException, RemoteException
    {
        gui=new GUIServidor();
        gui.setVisible(true);
        modeloTabla=(DefaultTableModel) gui.tabla_Ejecutando.getModel();
        ip = (InetAddress.getLocalHost().toString());
        // ip = "loopHost/192.168.1.10";
        puerto = 8080;
        System.out.println("conexion establecida diccion ip: "+ip+" y puerto: "+puerto);
        registro = LocateRegistry.createRegistry(puerto);
        registro.rebind("rmi", this);
    }

    public static void main(String[] args) throws UnknownHostException, RemoteException {
        new Servidor();
    }

    public void Insertar(String nombre,String genero,String editorial,String autor) throws RemoteException {
            new Insertar("insert into libros (nombre,genero,aditorial,autor) values ('"+nombre+"','"+genero+"','"+editorial+"','"+autor+"')", 1, "El registro ha sido guardado correctamente");
    }

    public void Eliminar(int id) throws RemoteException {
            new Eliminar("delete from libros where id="+id);        
    }

    public void  Actulizar(int id,String nombre,String genero,String editorial,String autor) throws RemoteException {
            new Actualizar("update libros set nombre='"+nombre+"',genero='"+genero+"',aditorial='"+editorial+"',autor='"+autor+"' where id="+id);       
    }

    public boolean logeo(String usuario, String contrasenia) throws RemoteException {
            boolean respuesta=false;

            String contraseniaobt="";
            
            ResultSet resultados = new Consultar().Consultar("select contrasenia from usuarios where usuario='" + usuario + "'");
        
            try {
                while (resultados.next()) {
                contraseniaobt = resultados.getString(1);
                if (contrasenia.equals(contraseniaobt)) {
                   respuesta =true;
                }
            }
            
            } catch (SQLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }       
            
        return respuesta;
    }

    public void recibirMensaje(String cadena) throws RemoteException {
           datos[0]=cadena;
           datos[1]=new ObtFecha().ObtFecha();
           datos[2]=new ObtHora().ObtHora();
           modeloTabla.addRow(datos);
           System.out.println("Se atendió a --> ** "+cadena+" **");
           new Insertar("insert into registroDia (host, fecha, hora) values ('"+cadena+"', '"+datos[1].toString()+"', '"+datos[2].toString()+"')", 0, "");
           contador++;
    }

    public void insertaUsuario(String a, String b) throws RemoteException {
           new Insertar("insert into usuarios (usuario, contrasenia) values ('"+a+"', '"+b+"')", 0, "Usuario "+a+ " agregado correctamente!");
    }

    public void consultaCambioLibro(JTextField a, JTextField b, JTextField c, JTextField d, int n) throws RemoteException {
        try {
            ResultSet resultado = new Consultar().Consultar("select * from libros where id="+n);
            while (resultado.next()) {
                a.setText(String.valueOf(resultado.getObject("nombre")));
                b.setText(String.valueOf(resultado.getObject("genero")));
                c.setText(String.valueOf(resultado.getObject("autor")));
                d.setText(String.valueOf(resultado.getObject("editoria")));                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void consultaUltimoLibro(int i) throws RemoteException {
        try {
            ResultSet resultado = new Consultar().Consultar("select * from libros");
            
            while (resultado.next()) {            
                i = Integer.valueOf(String.valueOf(resultado.getObject("id")));                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void agregaLibro(int n) throws RemoteException {
       // throw new UnsupportedOperationException("Not supported yet.");
    }
}