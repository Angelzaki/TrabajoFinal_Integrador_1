/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author apsenior
 */
public class cUsuarioCrud {
     public  void insertarUsuario(Connection conexion, Usuario usuario){
    String sql ="INSERT INTO Usuario VALUES (?,?);";
    
    try{
        PreparedStatement statement= conexion.prepareStatement(sql);
        statement.setString(1, usuario.usuario);
        statement.setString(2, usuario.clave);
        int registroAdd=statement.executeUpdate();
        
        if (registroAdd>0){
          
        }
        
    }catch(SQLException e){
     e.printStackTrace();
     JOptionPane.showMessageDialog(null,"error"+e.toString()); 
    }
    }
    
      public  int ObtenerIdUsuario(Connection conexion,String Usuario){
       Integer valor=0;
       String sql="SELECT * FROM usuario WHERE Usuario='"+Usuario+"'";
       
          try{
            Statement statement = conexion.createStatement();
            ResultSet rs= statement.executeQuery(sql);
            while(rs.next()){
             valor= rs.getInt(1);
            }
            }catch(SQLException e){
             e.printStackTrace();
             JOptionPane.showMessageDialog(null,"error"+e.toString()+sql); 
            }
              
       
       return valor;
   } 
     
    
   public  int ValidarLoginUsuario(Connection conexion,String Usuario,String Clave){
       Integer valor=0;
       String sql="SELECT CASE  Puesto WHEN 'Docente' THEN 2 ELSE 1 END AS Valor  FROM usuario U INNER JOIN PERSONAL P ON P.IdUsuario=U.ID_Usuario WHERE Usuario='"+Usuario+"' AND Clave='"+Clave+"'";
       
          try{
            Statement statement = conexion.createStatement();
            ResultSet rs= statement.executeQuery(sql);
             while(rs.next()){
                 valor= rs.getInt(1);
            }
             
            }catch(SQLException e){
             e.printStackTrace();
             JOptionPane.showMessageDialog(null,"error"+e.toString()); 
            }
              
       
       return valor;
   } 
    
    
}

