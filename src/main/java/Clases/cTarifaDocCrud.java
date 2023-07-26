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
public class cTarifaDocCrud {
    public  void insertarTarifaDoc(Connection conexion, TarifaDoc tarifadoc){
    String sql ="INSERT INTO TarifaDocente VALUES (?,?);";
    try{
        PreparedStatement statement= conexion.prepareStatement(sql);
        statement.setInt(1, tarifadoc.IdTarifa);
        statement.setInt(2, tarifadoc.IdPersonal);

        
        int registroAdd=statement.executeUpdate();
        
        if (registroAdd>0){
        //   JOptionPane.showMessageDialog(null,"Ok, Registro Correcto"); 
        }
        
        }catch(SQLException e){
         e.printStackTrace();
         JOptionPane.showMessageDialog(null,"error"+e.toString()); 
        }
    }
          public  int ObtenerIdPersonal(Connection conexion,String Usuario){
       Integer valor=0;
       String sql="SELECT IdPersonal FROM PERSONAL P INNER JOIN USUARIO U ON "
               + "P.IdUsuario=U.Id_Usuario WHERE Usuario='"+Usuario+"'";   
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
    public  DefaultTableModel ListarTarifaDoc(Connection conexion,Integer idtarifa){
        DefaultTableModel modelo=new  DefaultTableModel();
        modelo.addColumn("IdTarifaDoc");
        modelo.addColumn("IdTarifa");
        modelo.addColumn("IdDocente");
        modelo.addColumn("CodigoTarifa");
        modelo.addColumn("CodigoPersonal");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellidos");          
          try{
            CallableStatement cmd=conexion.prepareCall("{CALL SP_LISTAR_TARIFADOC(?)}");
            cmd.setInt(1,idtarifa);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
               Object dato []= new Object[6];
             for (int i=0;i<6;i++){
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
    public  void eliminarTarifaDoc(Connection conexion, String IdUsuario){      
    try{
         CallableStatement cmd=conexion.prepareCall("{call SP_ELIMINAR_TARIFADOC(?)}");
           
         cmd.setString(1, IdUsuario);
            ResultSet rs= cmd.executeQuery();
       
        
        }catch(SQLException e){
         e.printStackTrace();
         JOptionPane.showMessageDialog(null,"error"+e.toString()); 
        }
    }
}
