/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author apsenior
 */
public class cPlanillaCrud {
    
    
     public  void cGenerarPlanilla(Connection conexion, Planilla planilla){
    String sql ="{call cGenerarPlanillaporMes (?,?,?)}";
    try{
        PreparedStatement statement= conexion.prepareStatement(sql);
        statement.setString(1, planilla.CodigoPersonal);
        statement.setString(2, planilla.Mes);
        statement.setString(3, planilla.Anio);

        int registroAdd=statement.executeUpdate();
        
        if (registroAdd>0){
          System.out.println("OK");
           JOptionPane.showMessageDialog(null,"Se proceso la Planilla Correctamente"); 
        }
        
        }catch(SQLException e){
         e.printStackTrace();
         JOptionPane.showMessageDialog(null,"error"+e.toString()); 
        }
    }
}
