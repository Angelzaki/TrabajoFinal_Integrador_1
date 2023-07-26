/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import java.sql.*;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
 *
 * @author apsenior
 */
public class conexion 
{

       
    Connection conectar=null;
    String usuario="usersql";
    String contrasenia="1234";
    String bd="dbPlanillaColegio";
    String ip="localhost\\SQLEXPRESS";
    String puerto="1433";
   // public Connection cn=null;
   // public Statement st =null;
    
    String cadena="jdbc:sqlserver://"+ip+":"+puerto+"/"+bd;
   
    public Connection establecerConexion(){
       try{
        String cadena="jdbc:sqlserver://localhost:"+puerto+";"+"datebaseName="+bd+";TrustServerCertificate=True;";
        conectar =DriverManager.getConnection(cadena,usuario,contrasenia);
        
     //   st=cn.createStatementResultSettement(createStatementResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        //JOptionPane.showMessageDialog(null,"Ok, Conexión Correcta"); 
       }catch (Exception e){
          JOptionPane.showMessageDialog(null,"Error al conectar a la base datos, error:"+ e.toString()); 
       } 
        return conectar;
    }
}
