/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Servidor;

import Frames.ConectarSerivodorRMI;
import Fecha.ObtFecha;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author neogeek
 */
public class ejemplos {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        ConectarSerivodorRMI obj = new ConectarSerivodorRMI();
        obj.conectarseAlservidor();
        String arreglo[] = obj.objetoRemoto.ConsultarUnProducto("87654323");

        int contador = 0;
        System.out.println(arreglo.length /5);
        for (int i = 0; i < arreglo.length / 5 ; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println(arreglo[contador]);
                contador++;
            }

        }
    }
}
