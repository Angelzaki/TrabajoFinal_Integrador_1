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
public class cHorarioCrud {
    public  void insertarHorario(Connection conexion, Horario horario){
    String sql ="INSERT INTO Horario(IdPersonal,HoraInicio,HoraFin,HorasSemana,Curso,NroDias,DiasLab) VALUES (?,?,?,?,?,?,?);";
    try{
        PreparedStatement statement= conexion.prepareStatement(sql);
        statement.setInt(1, horario.IdPersonal);
        statement.setString(2, horario.HoraInicio);
        statement.setString(3, horario.HoraFin);
        statement.setString(4, horario.CantidadHora);
        statement.setString(5, horario.Curso);
        statement.setString(6, horario.CantidadDiaLab);
        statement.setString(7, horario.Dias);

        
        int registroAdd=statement.executeUpdate();
        
        if (registroAdd>0){
          // JOptionPane.showMessageDialog(null,"Ok, Registro Correcto"); 
        }
        
        }catch(SQLException e){
         e.printStackTrace();
         JOptionPane.showMessageDialog(null,"error"+e.toString()); 
        }
    }
      public  void actualizarHorario(Connection conexion, Horario horario){
    String sql ="{call SP_Actualizar_Horario (?,?,?,?,?,?)}";
    try{
        PreparedStatement statement= conexion.prepareStatement(sql);
        statement.setInt(1, horario.IdPersonal);
        statement.setString(1, horario.HoraInicio);
        statement.setString(2, horario.HoraFin);
        statement.setString(3, horario.CantidadHora);
        statement.setString(4, horario.Curso);
        statement.setString(5, horario.CantidadDiaLab);
        statement.setString(6, horario.Dias);
        int registroAdd=statement.executeUpdate();
        
        if (registroAdd>0){
          System.out.println("OK");
           JOptionPane.showMessageDialog(null,"Ok, Registro Correcto"); 
        }
        
        }catch(SQLException e){
         e.printStackTrace();
         JOptionPane.showMessageDialog(null,"error"+e.toString()); 
        }
    }
      public  void eliminarHorario(Connection conexion, String IdUsuario){
           
    try{
         CallableStatement cmd=conexion.prepareCall("{call SP_ELIMINAR_Horario(?)}");
            cmd.setString(1, IdUsuario);
            ResultSet rs= cmd.executeQuery();
       
        
        }catch(SQLException e){
         e.printStackTrace();
         JOptionPane.showMessageDialog(null,"error"+e.toString()); 
        }
    }
      
        public  int ObtenerIdPersonal(Connection conexion,String Usuario){
       Integer valor=0;
       String sql="SELECT IdPersonal FROM Personal P INNER JOIN Usuario U ON P.IdUsuario=U.Id_Usuario WHERE Usuario='"+Usuario+"'";
       
          try{
            Statement statement = conexion.createStatement();
            ResultSet rs= statement.executeQuery(sql);
            while(rs.next()){
             valor= rs.getInt(1);
            }
          
             JOptionPane.showMessageDialog(null,"ok"+valor); 
            }catch(SQLException e){
             e.printStackTrace();
             JOptionPane.showMessageDialog(null,"error"+e.toString()+sql); 
            }
              
       
       return valor;
   } 
      
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
       
        public  DefaultTableModel ListarHorario(Connection conexion){
        DefaultTableModel modelo=new  DefaultTableModel();
        modelo.addColumn("IdHorario");
        modelo.addColumn("IdPersonal");
          modelo.addColumn("Codigo");
             modelo.addColumn("Nombres");
             modelo.addColumn("Apellidos");
            modelo.addColumn("HoraInicio");
             modelo.addColumn("HoraFin");
             modelo.addColumn("HorasSemana");
             modelo.addColumn("Curso");
             modelo.addColumn("NroDias");
             modelo.addColumn("DiasLab");
        
          try{
            CallableStatement cmd=conexion.prepareCall("{CALL SP_LISTAR_HORARIO}");
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
               Object dato []= new Object[11];
             for (int i=0;i<11;i++){
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
