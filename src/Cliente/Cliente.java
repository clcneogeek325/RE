
package Cliente;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.UnknownHostException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {

    static Operaciones objetoRemoto;
    Registry registro;
    String direccionServidor="127.0.1.1";
    int puertoServidor=8080;

    void conectarseAlservidor() throws RemoteException, NotBoundException{
        registro = LocateRegistry.getRegistry(direccionServidor, puertoServidor);
        objetoRemoto = (Operaciones) (registro.lookup("rmi"));
    }

    public static void main(String[] args) throws RemoteException , NotBoundException,UnknownHostException{
        Cliente cliente = new Cliente();
        cliente.conectarseAlservidor();
        objetoRemoto.recibirMensaje("Eqipo Fake Security");
        if (objetoRemoto.logeo("maria", "123")) {
            System.out.println("la cont correcta");
        }else{
            System.out.println("no");
        }
    }
}