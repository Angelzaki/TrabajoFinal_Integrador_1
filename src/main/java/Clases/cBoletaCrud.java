/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author apsenior
 */
public class cBoletaCrud {
     public  DefaultTableModel ListarBoleta(Connection conexion){
        DefaultTableModel modelo=new  DefaultTableModel();
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
            modelo.addColumn("SueldoxHora");
             modelo.addColumn("HorasDictadas");
             modelo.addColumn("MontoDescporCategoria");
             modelo.addColumn("MontoDescporSeguro");
             modelo.addColumn("MontoBonificacion");
             modelo.addColumn("SueldoNeto");
             modelo.addColumn("CuentaBancaria");
             modelo.addColumn("TipoBonificacion");
             modelo.addColumn("Nivel");
             modelo.addColumn("SeguroSalud");
             modelo.addColumn("CodigoUsuario");
             modelo.addColumn("Mes");
             modelo.addColumn("Anio");
             modelo.addColumn("Categoria");
             modelo.addColumn("Deduccion");
             modelo.addColumn("CorreoDestino");
          try{
            CallableStatement cmd=conexion.prepareCall("{CALL SP_LISTAR_BOLETA}");
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
               Object dato []= new Object[18];
             for (int i=0;i<18;i++){
                dato[i]=rs.getString(i+1);
             }
              modelo.addRow(dato);
            }

            }catch(SQLException e){
             e.printStackTrace();
             JOptionPane.showMessageDialog(null,"error"+e.toString()); 
            }
   return modelo;        
   } 
}
