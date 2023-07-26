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
public class cAsistenciaCrud {
    public  DefaultTableModel ListarHorario(Connection conexion){
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
