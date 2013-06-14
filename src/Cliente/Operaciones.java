package Cliente;

import java.rmi.Remote;
import java.rmi.RemoteException;
import javax.swing.JTextField;

public interface Operaciones extends Remote {

    public void Insertar(String nombre,String genero,String editorial,String autor) throws RemoteException;

    public void Eliminar(int id) throws RemoteException;

    public void Actulizar(int id,String nombre,String genero,String editorial,String autor) throws RemoteException;

    public boolean logeo(String usuario,String contrasenia) throws RemoteException;

    public void recibirMensaje(String cadena) throws RemoteException;
    
    public void insertaUsuario (String a, String b) throws RemoteException;
    
    public void consultaCambioLibro(JTextField a, JTextField b, JTextField c, JTextField d, int n) throws RemoteException;
    
    public void consultaUltimoLibro(int ultimoLibro) throws RemoteException;
    
    public void agregaLibro(int n) throws RemoteException;
    
}