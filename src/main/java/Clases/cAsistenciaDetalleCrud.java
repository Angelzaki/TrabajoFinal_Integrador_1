/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author apsenior
 */
public class cAsistenciaDetalleCrud {
      public  void insertarAsistenciaDet(Connection conexion, AsistenciaDetalle asistenciadet){
    String sql ="{CALL SP_INSERTAR_ASISTENCIADETALLE(?,?,?,?,?,?,?,?,?,?,?,?)};";
    try{
        PreparedStatement statement= conexion.prepareStatement(sql);
        statement.setString(1, asistenciadet.codigo);
        statement.setString(2, asistenciadet.Nombre);
        statement.setString(3, asistenciadet.Apellido);
        statement.setString(4, asistenciadet.Asistencia);
        statement.setString(5, asistenciadet.Tardanza);
        statement.setString(6, asistenciadet.Falta);
        statement.setString(7, asistenciadet.Justificada);
        statement.setString(8, asistenciadet.TotalAsistencia);
        statement.setString(9, asistenciadet.HoraporAsistencia);
        statement.setString(10, asistenciadet.TotalHora);
        statement.setString(11, asistenciadet.Mes);
        statement.setString(12, asistenciadet.Anio);

        int registroAdd=statement.executeUpdate();
        
        if (registroAdd>0){
          System.out.println("OK");
        //   JOptionPane.showMessageDialog(null,"Ok, Registro Correcto"); 
        }
        
        }catch(SQLException e){
         e.printStackTrace();
         JOptionPane.showMessageDialog(null,"error"+e.toString()); 
        }
    }
      
      
      
      public  DefaultTableModel ListarAsistenciaDetalle(Connection conexion,String Anio, String Mes){
        DefaultTableModel modelo=new  DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
          modelo.addColumn("Apellido");
             modelo.addColumn("Asistencia");
             modelo.addColumn("Tardanza");
            modelo.addColumn("Falta");
             modelo.addColumn("Justificada");
             modelo.addColumn("TotalAsistencia");
             modelo.addColumn("HoraporAsistencia");
             modelo.addColumn("TotalHora");
             modelo.addColumn("Mes");
             modelo.addColumn("Anio");
        
          try{
            CallableStatement cmd=conexion.prepareCall("{CALL SP_LISTAR_ASISTENCIADETALLE(?,?)}");
            cmd.setString(1,Anio);
            cmd.setString(2, Mes);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
               Object dato []= new Object[12];
             for (int i=0;i<12;i++){
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
