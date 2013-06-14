package Servidor;

import Frames.*;
import Servidor.*;
import java.rmi.Remote;
import java.rmi.RemoteException;
import javax.swing.JTextField;

public interface Operaciones extends Remote {

    public void Insertar(String id,String nombre,String cantidad,String precio,String descripcion) throws RemoteException;

    public void Eliminar(String id) throws RemoteException;

    public void Actulizar(String id,String nombre,String cantidad,String precio,String descripcion) throws RemoteException;

    public boolean logeo(String usuario,String contrasenia) throws RemoteException;

    public void recibirMensaje(String cadena) throws RemoteException;
      
    public String []Consultar(int columna,String dato) throws RemoteException;

    public String []actualizarTabla() throws RemoteException;

       public String []ConsultarUnProducto(String id) throws RemoteException;
}