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
public class cPersonalCrud {
     public  void insertarPersonal(Connection conexion, Personal personal){
    String sql ="INSERT INTO Personal VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";
    try{
        PreparedStatement statement= conexion.prepareStatement(sql);
        statement.setString(1, personal.Nombres);
        statement.setString(2, personal.Apellidos);
        statement.setString(3, personal.DNI);
        statement.setString(4, personal.FechaNacimiento);
        statement.setString(5, personal.NroHijos);
        statement.setString(6, personal.CuentaBancaria);
        statement.setString(7, personal.CorreoElectronico);
        statement.setString(8, personal.Deduccion);
        statement.setString(9, personal.Categoria);
        statement.setString(10, personal.Estado);
        statement.setString(11, personal.Puesto);
        statement.setString(12, personal.Nivel);
        statement.setInt(13, personal.IdUsuario);
        int registroAdd=statement.executeUpdate();
        
        if (registroAdd>0){
        }
        
        }catch(SQLException e){
         e.printStackTrace();
         JOptionPane.showMessageDialog(null,"error"+e.toString()); 
        }
    }
      public  void actualizarPersonal(Connection conexion, Personal personal){
    String sql ="{call SP_Actualizar_Personal (?,?,?,?,?,?,?,?,?,?,?,?,?)}";
    try{
        PreparedStatement statement= conexion.prepareStatement(sql);
        statement.setString(1, personal.Nombres);
        statement.setString(2, personal.Apellidos);
        statement.setString(3, personal.DNI);
        statement.setString(4, personal.FechaNacimiento);
        statement.setString(5, personal.NroHijos);
        statement.setString(6, personal.CuentaBancaria);
        statement.setString(7, personal.CorreoElectronico);
        statement.setString(8, personal.Deduccion);
        statement.setString(9, personal.Categoria);
        statement.setString(10, personal.Estado);
        statement.setString(11, personal.Puesto);
        statement.setString(12, personal.Nivel);
        statement.setInt(13, personal.IdUsuario);
        int registroAdd=statement.executeUpdate();
        
        if (registroAdd>0){
         // System.out.println("OK");
           //JOptionPane.showMessageDialog(null,"Ok, Registro Correcto"); 
        }
        
        }catch(SQLException e){
         e.printStackTrace();
         JOptionPane.showMessageDialog(null,"error"+e.toString()); 
        }
    }
      public  void eliminarPersonal(Connection conexion, String IdUsuario){
           
    try{
         CallableStatement cmd=conexion.prepareCall("{call SP_ELIMINAR_PERSONAL(?)}");
            cmd.setString(1, IdUsuario);
            ResultSet rs= cmd.executeQuery();
       
        
        }catch(SQLException e){
         e.printStackTrace();
         JOptionPane.showMessageDialog(null,"error"+e.toString()); 
        }
    }
      //ACTUALIZAR ESTADO ACTIVO.2
       public  void UpdateActivo(Connection conexion, String IdUsuario){           
    try{
         CallableStatement cmd=conexion.prepareCall("{call SP_ACTUALIZAR_ACTIVO(?)}");
            cmd.setString(1, IdUsuario);
            ResultSet rs= cmd.executeQuery();
       
        
        }catch(SQLException e){
         e.printStackTrace();
         JOptionPane.showMessageDialog(null,"error"+e.toString()); 
        }
    }
       
        public  DefaultTableModel ListarPersonal(Connection conexion){
        DefaultTableModel modelo=new  DefaultTableModel();
        modelo.addColumn("IdPersonal");
         modelo.addColumn("Nombres");
             modelo.addColumn("Apellidos");
             modelo.addColumn("Edad");
             modelo.addColumn("DNI");
             modelo.addColumn("NroHijos");
             modelo.addColumn("CuentaBancaria");
             modelo.addColumn("CorreoElectronico");
             modelo.addColumn("Deduccion");
             modelo.addColumn("Categoria");
             modelo.addColumn("Estado");
             modelo.addColumn("Puesto");
             modelo.addColumn("Nivel");
             modelo.addColumn("FechaNacimiento");
             modelo.addColumn("Usuario");
          try{
            CallableStatement cmd=conexion.prepareCall("{CALL SP_LISTAR_PERSONAL}");
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
               Object dato []= new Object[15];
             for (int i=0;i<15;i++){
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
