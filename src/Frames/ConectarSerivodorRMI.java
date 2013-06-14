/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Servidor.Operaciones;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author krakntoy
 */
public class ConectarSerivodorRMI {
    
     public  Operaciones objetoRemoto;
    Registry registro;
    String dirccionDelServidor="192.168.1.104";
    int puertoServidor=8080;

    public void conectarseAlservidor() throws RemoteException, NotBoundException{
        registro = LocateRegistry.getRegistry(dirccionDelServidor, puertoServidor);
        objetoRemoto = (Operaciones) (registro.lookup("rmi"));
    }

    
}
