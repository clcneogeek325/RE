package Servidor;

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
        puerto = 8080;
        System.out.println("conexion establecida diccion ip: "+ip+" y puerto: "+puerto);
        registro = LocateRegistry.createRegistry(puerto);
        registro.rebind("rmi", this);
    }

    public static void main(String[] args) throws UnknownHostException, RemoteException {
        new Servidor();
    }

    public void Insertar(String id,String nombre,String cantidad,String precio,String descripcion) throws RemoteException {
            new Insertar("insert into productos (id,nombre,cantidad,precio,descripcion) values ('"+id+"','"+nombre+"','"+cantidad+"','"+precio+"','"+descripcion+"')", 1, "El registro ha sido guardado correctamente");
    }

    public void Eliminar(String id) throws RemoteException {
            new Eliminar("delete from productos where id="+id);
    }

    public void  Actulizar(String id,String nombre,String cantidad,String precio,String descripcion) throws RemoteException {
            new Actualizar("update productos set nombre='"+nombre+"',cantidad='"+cantidad+"',precio='"+precio+"',descripcion='"+descripcion+"' where id="+id);
    }

    public boolean logeo(String usuario, String contrasenia) throws RemoteException {
            boolean respuesta=false;

            String contraseniaobt="";
            
            ResultSet resultados = new Consultar().Consultar("select contrasenia from administrador where usuario='" + usuario + "'");
        
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
    }


    public String[] Consultar(int columna,String dato) throws RemoteException {

        String columnas[]={"id","nombre","cantidad","precio","descripcion"};

        int cantidadFilas=1;

        ResultSet numeroFilas = new Consultar().Consultar("select count(*) from productos where "+columnas[columna-1]+"='"+dato+"'");
        try {
            while (numeroFilas.next()) {
                cantidadFilas=numeroFilas.getInt(1);
                System.out.println("numero fillas"+cantidadFilas);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
             String arreglo[] =new String [5*cantidadFilas];

        ResultSet resultados = new Consultar().Consultar("select *from productos where "+columnas[columna-1]+"='"+dato+"'");
        try {
               int contador=0;
            while (resultados.next()) {
                for (int i = 0; i < 5; i++) {
                    arreglo[contador]=resultados.getString(i+1);
                    contador++;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arreglo;
    }

    public String[] actualizarTabla() throws RemoteException {
        int cantidadFilas=1;
        ResultSet numeroFilas = new Consultar().Consultar("select count(*) from productos");
        try {
            while (numeroFilas.next()) {
                cantidadFilas=numeroFilas.getInt(1);
                System.out.println("numero fillas"+cantidadFilas);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
             String arreglo[] =new String [5*cantidadFilas];

        ResultSet resultados = new Consultar().Consultar("select *from productos");
        try {

               int contador=0;

            while (resultados.next()) {

                for (int i = 0; i < 5; i++) {
                    arreglo[contador]=resultados.getString(i+1);
                    contador++;
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arreglo;
    }

    public String[] ConsultarUnProducto(String id) throws RemoteException {

        int cantidadFilas=1;

        ResultSet numeroFilas = new Consultar().Consultar("select count(*) from productos where id='"+id+"'");
        try {
            while (numeroFilas.next()) {
                cantidadFilas=numeroFilas.getInt(1);
                System.out.println("numero fillas"+cantidadFilas);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
             String arreglo[] =new String [5*cantidadFilas];

        ResultSet resultados = new Consultar().Consultar("select *from productos where id='"+id+"'");
        try {
               int contador=0;
            while (resultados.next()) {
                for (int i = 0; i < 5; i++) {
                    arreglo[contador]=resultados.getString(i+1);
                    contador++;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arreglo;
    }

    
}