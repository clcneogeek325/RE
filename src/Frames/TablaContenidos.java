package Frames;

import java.awt.event.MouseEvent;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Interface.java
 *
 * Created on 12/06/2013, 07:58:21 AM
 */

/**
 *
 * @author neogeek
 */
public class TablaContenidos extends javax.swing.JFrame {
    Object datos[]=new Object[5];

    DefaultTableModel modelotablaActualizar;
     DefaultTableModel modelotablaEliminar;
     DefaultTableModel modelotablaBuscar;

    ConectarSerivodorRMI obj= new ConectarSerivodorRMI();
    /** Creates new form Interface */
    public TablaContenidos() throws RemoteException, NotBoundException {
        obj.conectarseAlservidor();
        initComponents();
        modelotablaActualizar = (DefaultTableModel) tabla_actualizar.getModel();
        modelotablaEliminar = (DefaultTableModel) tabla_eliminar.getModel();
            modelotablaBuscar = (DefaultTableModel) tabla_busqueda.getModel();
        actualizarTablas();
        setEventoMouseClicked(tabla_actualizar);
        setEventoMouseClicked2(tabla_eliminar);
        
    }


   public void actualizarTablas() throws RemoteException{
        String datosParaTabla[] = obj.objetoRemoto.actualizarTabla();

        for (int i = 0; i < modelotablaActualizar.getRowCount(); i++) {
           modelotablaActualizar.removeRow(i);
           modelotablaEliminar.removeRow(i);
           
       }


        int contador = 0;

        for (int i = 0; i < datosParaTabla.length / 5; i++) {
                 for (int j = 0; j < 5; j++) {
                        datos[j]=datosParaTabla[contador];
                        contador++;
            }
                 modelotablaActualizar.addRow(datos);
                 modelotablaEliminar.addRow(datos);


        }

   }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        Ntxt_codigoBarras = new javax.swing.JTextField();
        Ntxt_nombreProductos = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Ntxt_cantidad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Ntxt_precio = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Ntxt_descripcion = new javax.swing.JTextField();
        btn_agregar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        Atxt_codigoBarras = new javax.swing.JTextField();
        Atxt_nombreProductos = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        Atxt_cantidad = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        Atxt_precio = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        Atxt_descripcion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_actualizar = new javax.swing.JTable();
        btn_actualizar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        Etxt_codigoBarras = new javax.swing.JTextField();
        Etxt_nombreProductos = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        Etxt_cantidad = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        Etxt_precio = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        Etxt_descripcion = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_eliminar = new javax.swing.JTable();
        btn_Eliminar = new javax.swing.JButton();
        btn_regresar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla_busqueda = new javax.swing.JTable();
        cbx_busqueda = new javax.swing.JComboBox();
        btn_buscar = new javax.swing.JButton();
        txt_busqueda = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBorder(new javax.swing.border.MatteBorder(null));

        jPanel1.setLayout(null);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del producto"));
        jPanel5.setLayout(null);

        jLabel1.setText("Codigo de Barra");
        jPanel5.add(jLabel1);
        jLabel1.setBounds(60, 62, 112, 25);
        jPanel5.add(jTextField1);
        jTextField1.setBounds(190, 62, 148, 33);
        jPanel5.add(jTextField2);
        jTextField2.setBounds(190, 113, 148, 33);

        jLabel2.setText("Codigo de Barra");
        jPanel5.add(jLabel2);
        jLabel2.setBounds(60, 113, 112, 25);
        jPanel5.add(jTextField3);
        jTextField3.setBounds(190, 158, 148, 33);

        jLabel3.setText("Codigo de Barra");
        jPanel5.add(jLabel3);
        jLabel3.setBounds(60, 140, 112, 25);
        jPanel5.add(jTextField4);
        jTextField4.setBounds(200, 168, 148, 33);

        jLabel4.setText("Codigo de Barra");
        jPanel5.add(jLabel4);
        jLabel4.setBounds(50, 170, 112, 25);

        jPanel1.add(jPanel5);
        jPanel5.setBounds(134, 41, 0, 0);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("DAtos Del Producto"));
        jPanel6.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Ubuntu", 3, 18));
        jLabel5.setText("Codigo De Barras");
        jPanel6.add(jLabel5);
        jLabel5.setBounds(60, 30, 160, 40);

        Ntxt_codigoBarras.setFont(new java.awt.Font("Ubuntu", 3, 18));
        jPanel6.add(Ntxt_codigoBarras);
        Ntxt_codigoBarras.setBounds(220, 30, 310, 40);

        Ntxt_nombreProductos.setFont(new java.awt.Font("Ubuntu", 3, 18));
        jPanel6.add(Ntxt_nombreProductos);
        Ntxt_nombreProductos.setBounds(220, 90, 310, 40);

        jLabel6.setFont(new java.awt.Font("Ubuntu", 3, 18));
        jLabel6.setText("Nombre Producto");
        jPanel6.add(jLabel6);
        jLabel6.setBounds(60, 90, 150, 40);

        Ntxt_cantidad.setFont(new java.awt.Font("Ubuntu", 3, 18));
        jPanel6.add(Ntxt_cantidad);
        Ntxt_cantidad.setBounds(220, 150, 310, 40);

        jLabel7.setFont(new java.awt.Font("Ubuntu", 3, 18));
        jLabel7.setText("Cantidad");
        jPanel6.add(jLabel7);
        jLabel7.setBounds(60, 150, 130, 40);

        Ntxt_precio.setFont(new java.awt.Font("Ubuntu", 3, 18));
        jPanel6.add(Ntxt_precio);
        Ntxt_precio.setBounds(220, 200, 310, 40);

        jLabel8.setFont(new java.awt.Font("Ubuntu", 3, 18));
        jLabel8.setText("Precio");
        jPanel6.add(jLabel8);
        jLabel8.setBounds(60, 200, 130, 40);

        jLabel9.setFont(new java.awt.Font("Ubuntu", 3, 18));
        jLabel9.setText("Descripcion");
        jPanel6.add(jLabel9);
        jLabel9.setBounds(60, 250, 130, 40);

        Ntxt_descripcion.setFont(new java.awt.Font("Ubuntu", 3, 18));
        jPanel6.add(Ntxt_descripcion);
        Ntxt_descripcion.setBounds(220, 250, 310, 40);

        jPanel1.add(jPanel6);
        jPanel6.setBounds(160, 70, 610, 330);

        btn_agregar.setText("Agregar");
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_agregar);
        btn_agregar.setBounds(860, 290, 180, 100);

        jTabbedPane1.addTab("Nuevo", jPanel1);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("DAtos Del Producto"));
        jPanel7.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Ubuntu", 3, 18));
        jLabel10.setText("Codigo De Barras");
        jPanel7.add(jLabel10);
        jLabel10.setBounds(20, 30, 160, 40);

        Atxt_codigoBarras.setFont(new java.awt.Font("Ubuntu", 3, 18));
        jPanel7.add(Atxt_codigoBarras);
        Atxt_codigoBarras.setBounds(220, 30, 210, 40);

        Atxt_nombreProductos.setFont(new java.awt.Font("Ubuntu", 3, 18));
        jPanel7.add(Atxt_nombreProductos);
        Atxt_nombreProductos.setBounds(220, 90, 200, 40);

        jLabel11.setFont(new java.awt.Font("Ubuntu", 3, 18));
        jLabel11.setText("Nombre Producto");
        jPanel7.add(jLabel11);
        jLabel11.setBounds(20, 90, 150, 40);

        Atxt_cantidad.setFont(new java.awt.Font("Ubuntu", 3, 18));
        jPanel7.add(Atxt_cantidad);
        Atxt_cantidad.setBounds(220, 150, 200, 40);

        jLabel12.setFont(new java.awt.Font("Ubuntu", 3, 18));
        jLabel12.setText("Cantidad");
        jPanel7.add(jLabel12);
        jLabel12.setBounds(20, 150, 130, 40);

        Atxt_precio.setFont(new java.awt.Font("Ubuntu", 3, 18));
        jPanel7.add(Atxt_precio);
        Atxt_precio.setBounds(220, 200, 200, 40);

        jLabel13.setFont(new java.awt.Font("Ubuntu", 3, 18));
        jLabel13.setText("Precio");
        jPanel7.add(jLabel13);
        jLabel13.setBounds(20, 210, 130, 40);

        jLabel14.setFont(new java.awt.Font("Ubuntu", 3, 18));
        jLabel14.setText("Descripcion");
        jPanel7.add(jLabel14);
        jLabel14.setBounds(20, 260, 130, 40);

        Atxt_descripcion.setFont(new java.awt.Font("Ubuntu", 3, 18));
        jPanel7.add(Atxt_descripcion);
        Atxt_descripcion.setBounds(220, 250, 200, 40);

        tabla_actualizar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo d Barras", "Nombre Producto", "Precio", "Cantidad", "Descripcion"
            }
        ));
        jScrollPane1.setViewportView(tabla_actualizar);

        jPanel7.add(jScrollPane1);
        jScrollPane1.setBounds(460, 30, 720, 360);

        btn_actualizar.setText("Actualizar");
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });
        jPanel7.add(btn_actualizar);
        btn_actualizar.setBounds(200, 370, 190, 80);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 1204, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(148, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Actalizar", jPanel2);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("DAtos Del Producto"));
        jPanel8.setLayout(null);

        jLabel15.setFont(new java.awt.Font("Ubuntu", 3, 18));
        jLabel15.setText("Codigo De Barras");
        jPanel8.add(jLabel15);
        jLabel15.setBounds(20, 30, 160, 40);

        Etxt_codigoBarras.setFont(new java.awt.Font("Ubuntu", 3, 18));
        jPanel8.add(Etxt_codigoBarras);
        Etxt_codigoBarras.setBounds(220, 30, 210, 40);

        Etxt_nombreProductos.setFont(new java.awt.Font("Ubuntu", 3, 18));
        jPanel8.add(Etxt_nombreProductos);
        Etxt_nombreProductos.setBounds(220, 90, 200, 40);

        jLabel16.setFont(new java.awt.Font("Ubuntu", 3, 18));
        jLabel16.setText("Nombre Producto");
        jPanel8.add(jLabel16);
        jLabel16.setBounds(20, 90, 150, 40);

        Etxt_cantidad.setFont(new java.awt.Font("Ubuntu", 3, 18));
        jPanel8.add(Etxt_cantidad);
        Etxt_cantidad.setBounds(220, 150, 200, 40);

        jLabel17.setFont(new java.awt.Font("Ubuntu", 3, 18));
        jLabel17.setText("Cantidad");
        jPanel8.add(jLabel17);
        jLabel17.setBounds(20, 150, 130, 40);

        Etxt_precio.setFont(new java.awt.Font("Ubuntu", 3, 18));
        jPanel8.add(Etxt_precio);
        Etxt_precio.setBounds(220, 200, 200, 40);

        jLabel18.setFont(new java.awt.Font("Ubuntu", 3, 18));
        jLabel18.setText("Precio");
        jPanel8.add(jLabel18);
        jLabel18.setBounds(20, 210, 130, 40);

        jLabel19.setFont(new java.awt.Font("Ubuntu", 3, 18));
        jLabel19.setText("Descripcion");
        jPanel8.add(jLabel19);
        jLabel19.setBounds(20, 260, 130, 40);

        Etxt_descripcion.setFont(new java.awt.Font("Ubuntu", 3, 18));
        jPanel8.add(Etxt_descripcion);
        Etxt_descripcion.setBounds(220, 250, 200, 40);

        tabla_eliminar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo d Barras", "Nombre Producto", "Precio", "Cantidad", "Descripcion"
            }
        ));
        jScrollPane2.setViewportView(tabla_eliminar);

        jPanel8.add(jScrollPane2);
        jScrollPane2.setBounds(460, 30, 720, 360);

        btn_Eliminar.setText("Eliminar");
        btn_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EliminarActionPerformed(evt);
            }
        });
        jPanel8.add(btn_Eliminar);
        btn_Eliminar.setBounds(270, 340, 140, 60);

        btn_regresar.setText("Regrasar");
        btn_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 1204, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(btn_regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(btn_regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Eliminar", jPanel3);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("DAtos Del Producto"));
        jPanel9.setLayout(null);

        jLabel20.setFont(new java.awt.Font("Ubuntu", 3, 18));
        jLabel20.setText("Buscar Por :");
        jPanel9.add(jLabel20);
        jLabel20.setBounds(150, 20, 120, 40);

        tabla_busqueda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo d Barras", "Nombre Producto", "Precio", "Cantidad", "Descripcion"
            }
        ));
        jScrollPane3.setViewportView(tabla_busqueda);

        jPanel9.add(jScrollPane3);
        jScrollPane3.setBounds(80, 80, 930, 460);

        cbx_busqueda.setFont(new java.awt.Font("Ubuntu", 3, 24)); // NOI18N
        cbx_busqueda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CodigoBarras", "Nombre", "Precio", "Cantidad", "Descripcion", " " }));
        jPanel9.add(cbx_busqueda);
        cbx_busqueda.setBounds(280, 30, 210, 40);

        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        jPanel9.add(btn_buscar);
        btn_buscar.setBounds(810, 30, 160, 40);
        jPanel9.add(txt_busqueda);
        txt_busqueda.setBounds(520, 30, 260, 40);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 1192, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Buscar", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        try {
            String codigo_barras = Ntxt_codigoBarras.getText();
            String nombre = Ntxt_nombreProductos.getText();
            String descripcion = Ntxt_descripcion.getText();
            String precio = Ntxt_precio.getText();
            String cantidad = Ntxt_cantidad.getText();
            obj.objetoRemoto.Insertar(codigo_barras, nombre, cantidad, precio, descripcion);

            JOptionPane.showMessageDialog(null, "El registro ha sido insertado correctamente");
             actualizarTablas();
        } catch (RemoteException ex) {
            Logger.getLogger(TablaContenidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
        try {
            String codigo_barras = Atxt_codigoBarras.getText();
            String nombre = Atxt_nombreProductos.getText();
            String descripcion = Atxt_descripcion.getText();
            String precio = Atxt_precio.getText();
            String cantidad = Atxt_cantidad.getText();
            obj.objetoRemoto.Actulizar(codigo_barras, nombre, cantidad, precio, descripcion);
            JOptionPane.showMessageDialog(null, "El registro s eha actualizado correctamente");
            actualizarTablas();
        } catch (RemoteException ex) {
            Logger.getLogger(TablaContenidos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EliminarActionPerformed
        try {
            String codigo_barras = Etxt_codigoBarras.getText();
            obj.objetoRemoto.Eliminar(codigo_barras);
            JOptionPane.showMessageDialog(null, "El registro s eha elininado correctamente");
            actualizarTablas();
        } catch (RemoteException ex) {
            Logger.getLogger(TablaContenidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_EliminarActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        Object datos[] =new Object[5];
        System.out.println(cbx_busqueda.getSelectedIndex()+"  "+ txt_busqueda.getText());
        try {
            String[] arreglo = obj.objetoRemoto.Consultar(cbx_busqueda.getSelectedIndex()+1, txt_busqueda.getText());
            int contador = 0;
            System.out.println(arreglo.length / 5);
            for (int i = 0; i < arreglo.length / 5; i++) {
                for (int j = 0; j < 5; j++) {
                    datos[j] =arreglo[contador] ;
                    contador++;
                }
                modelotablaBuscar.addRow(datos);
                
            }
        } catch (RemoteException ex) {
            Logger.getLogger(TablaContenidos.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regresarActionPerformed
      new Principal().setVisible(true);
      this.dispose();
    }//GEN-LAST:event_btn_regresarActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TablaContenidos().setVisible(true);
                } catch (RemoteException ex) {
                    Logger.getLogger(TablaContenidos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NotBoundException ex) {
                    Logger.getLogger(TablaContenidos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Atxt_cantidad;
    private javax.swing.JTextField Atxt_codigoBarras;
    private javax.swing.JTextField Atxt_descripcion;
    private javax.swing.JTextField Atxt_nombreProductos;
    private javax.swing.JTextField Atxt_precio;
    private javax.swing.JTextField Etxt_cantidad;
    private javax.swing.JTextField Etxt_codigoBarras;
    private javax.swing.JTextField Etxt_descripcion;
    private javax.swing.JTextField Etxt_nombreProductos;
    private javax.swing.JTextField Etxt_precio;
    private javax.swing.JTextField Ntxt_cantidad;
    private javax.swing.JTextField Ntxt_codigoBarras;
    private javax.swing.JTextField Ntxt_descripcion;
    private javax.swing.JTextField Ntxt_nombreProductos;
    private javax.swing.JTextField Ntxt_precio;
    private javax.swing.JButton btn_Eliminar;
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_regresar;
    private javax.swing.JComboBox cbx_busqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    public javax.swing.JTable tabla_actualizar;
    private javax.swing.JTable tabla_busqueda;
    public javax.swing.JTable tabla_eliminar;
    private javax.swing.JTextField txt_busqueda;
    // End of variables declaration//GEN-END:variables



    private void setEventoMouseClicked(JTable tbl) {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                EventoParaLaTablaActualizar(e);



            }
        });
    }

    public void EventoParaLaTablaActualizar(java.awt.event.MouseEvent evt) {

        int fila = tabla_actualizar.rowAtPoint(evt.getPoint());
        Atxt_codigoBarras.setText(tabla_actualizar.getValueAt(fila, 0) + "");
        Atxt_nombreProductos.setText(tabla_actualizar.getValueAt(fila, 1) + "");
        Atxt_cantidad.setText(tabla_actualizar.getValueAt(fila, 2) + "");
        Atxt_precio.setText(tabla_actualizar.getValueAt(fila, 3) + "");
        Atxt_descripcion.setText(tabla_actualizar.getValueAt(fila, 4) + "");


    }


        private void setEventoMouseClicked2(JTable tbl) {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                EventoParaLaTabla2(e);



            }
        });
    }

    public void EventoParaLaTabla2(java.awt.event.MouseEvent evt) {

        int fila = tabla_eliminar.rowAtPoint(evt.getPoint());
        Etxt_codigoBarras.setText(tabla_eliminar.getValueAt(fila, 0) + "");
        Etxt_nombreProductos.setText(tabla_eliminar.getValueAt(fila, 1) + "");
        Etxt_precio.setText(tabla_eliminar.getValueAt(fila, 2) + "");
        Etxt_cantidad.setText(tabla_eliminar.getValueAt(fila, 3) + "");
        Etxt_descripcion.setText(tabla_eliminar.getValueAt(fila, 4) + "");


    }


}
