/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Forms;

import Clases.AsistenciaDetalle;
import Clases.Boleta;
import Clases.EnviarCorreo;
import Clases.Planilla;
import Clases.cAsistenciaCrud;
import Clases.cAsistenciaDetalleCrud;
import Clases.cGenerarPdf2;
import Clases.cPlanillaCrud;
import Clases.conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class PrincipalDocente extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public PrincipalDocente() {
        initComponents();
       this.setLocationRelativeTo(null);
    }
      String Asistencia="";
       String Tardanza=""; 
       String Faltas="";
       String Justificacion="";
    String UsuarioSQL;
    String NombreCompleto;
    String DNI;
    String CorreoElectronico;
    String FechaNacimiento;
    String Nivel;
    
      String NombresBoleta;
    String ApellidosBoleta;
    String SueldoxHoraBoleta;
    String HorasDictadasBoleta;
    String MontoDescporCategoriaBoleta;
    String MontoDescporSeguroBoleta;
    String MontoBonificacionBoleta;
    String SueldoNetoBoleta;
    String CuentaBancariaBoleta;
    String TipoBonificacionBoleta;
    String NivelBoleta;
    String SeguroSaludBoleta;
    String CodigoUsuarioBoleta;
    String MesBoleta;
    String AnioBoleta;
    String CategoriaBoleta;
    String DeduccionBoleta;
    String CorreoDestinoBoleta;
    
      conexion con= new conexion();
       Connection conectar=con.establecerConexion();
    
     void usuariologin(String Usuario) {
         UsuarioSQL=Usuario;
           LabelBienvenido.setText("BIENVENIDO: "+Usuario.toUpperCase());
           ListarDatosPersonales(conectar,UsuarioSQL);
          jtextNombre.setText(NombreCompleto);
              jtextDNI.setText(DNI);
              jtextNacimiento.setText (FechaNacimiento);
                jtextEmail.setText(CorreoElectronico);
                  jtextNivel.setText(Nivel);
     }
     
      public  void ListarDatosPersonales(Connection conexion,String Usuario){
          try{
             CallableStatement cmd=conexion.prepareCall("{call ListarDatosPersonales(?)}");
            cmd.setString(1, Usuario);

            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
             NombreCompleto= rs.getString(1);
             DNI= rs.getString(2);
             CorreoElectronico= rs.getString(3);
                FechaNacimiento= rs.getString(4);
                  Nivel= rs.getString(5);
            } 
            }catch(SQLException e){
             e.printStackTrace();
             JOptionPane.showMessageDialog(null,"error"+e.toString()); 
            }
              
   } 
 
        
       public  void ListarDetalleAsistencia(Connection conexion,String Usuario,String Mes,String Anio){
          try{
             CallableStatement cmd=conexion.prepareCall("{call ListarDetalleAsistenciaxMesAnio(?,?,?)}");
            cmd.setString(1, Usuario);
            cmd.setString(2, Mes);
            cmd.setString(3, Anio);
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
             Asistencia= rs.getString(1);
             Tardanza= rs.getString(2);
             Faltas= rs.getString(3);
                Justificacion= rs.getString(4);
            }
          
             JOptionPane.showMessageDialog(null,"ok"); 
            }catch(SQLException e){
             e.printStackTrace();
             JOptionPane.showMessageDialog(null,"error"+e.toString()); 
            }
              
   } 
       
       public  void ListarBoletaPorMes(Connection conexion,String Usuario,String Mes,String Anio){
          try{
             CallableStatement cmd=conexion.prepareCall("{call SP_LISTAR_BOLETAxMES(?,?,?)}");
            cmd.setString(1, Usuario);
            cmd.setString(2, Mes);
            cmd.setString(3, Anio);
  
           
            ResultSet rs= cmd.executeQuery();
            while(rs.next()){
             NombresBoleta= rs.getString(1);
             ApellidosBoleta= rs.getString(2);
             SueldoxHoraBoleta= rs.getString(3);
                HorasDictadasBoleta= rs.getString(4);
                MontoDescporCategoriaBoleta= rs.getString(5);
             MontoDescporSeguroBoleta= rs.getString(6);
             MontoBonificacionBoleta= rs.getString(7);
                SueldoNetoBoleta= rs.getString(8);
                CuentaBancariaBoleta= rs.getString(9);
             TipoBonificacionBoleta= rs.getString(10);
             NivelBoleta= rs.getString(11);
                SeguroSaludBoleta= rs.getString(12);
                CodigoUsuarioBoleta= rs.getString(13);
             MesBoleta= rs.getString(14);
             AnioBoleta= rs.getString(15);
                CategoriaBoleta= rs.getString(16);
                  DeduccionBoleta= rs.getString(17);
                CorreoDestinoBoleta= rs.getString(18);
            }
         
            }catch(SQLException e){
             e.printStackTrace();
             JOptionPane.showMessageDialog(null,"error"+e.toString()); 
            }
              
   } 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelBlanco = new javax.swing.JPanel();
        LabelBienvenido = new javax.swing.JLabel();
        BotonCerrar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        PanelInicioDocente = new javax.swing.JPanel();
        PanelAmarillo1 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        FondoDocente1 = new javax.swing.JLabel();
        PanelAsistenciaDocente = new javax.swing.JPanel();
        PanelAmarillo2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtextAsistencias = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtextTardanzas = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtextFaltas = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtextJustificadas = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jcAnio = new javax.swing.JComboBox<>();
        jcMes = new javax.swing.JComboBox<>();
        FondoDocente2 = new javax.swing.JLabel();
        PanelDatosDocente = new javax.swing.JPanel();
        PanelAmarillo3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtextNombre = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtextDNI = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtextEmail = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jtextNacimiento = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jtextNivel = new javax.swing.JTextField();
        FondoDocente3 = new javax.swing.JLabel();
        PanelBoletaDocente = new javax.swing.JPanel();
        PanelAmarillo4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnEnviarBoleta = new javax.swing.JButton();
        jcMesBoleta = new javax.swing.JComboBox<>();
        jcAnioBoleta = new javax.swing.JComboBox<>();
        FondoDocente4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelBlanco.setBackground(new java.awt.Color(255, 255, 255));
        PanelBlanco.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelBienvenido.setText("BIENVENIDO");
        PanelBlanco.add(LabelBienvenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 260, 30));

        BotonCerrar.setText("CERRAR");
        BotonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCerrarActionPerformed(evt);
            }
        });
        PanelBlanco.add(BotonCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 0, 140, 30));

        getContentPane().add(PanelBlanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 30));

        PanelInicioDocente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelAmarillo1.setBackground(new java.awt.Color(255, 193, 7));

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon("C:\\Users\\apsenior\\Downloads\\ProyectoCasiCasiFinal\\SendMailBasic_Maven-main\\src\\main\\java\\Imagenes\\LogoPrincipalColegio.png")); // NOI18N

        javax.swing.GroupLayout PanelAmarillo1Layout = new javax.swing.GroupLayout(PanelAmarillo1);
        PanelAmarillo1.setLayout(PanelAmarillo1Layout);
        PanelAmarillo1Layout.setHorizontalGroup(
            PanelAmarillo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAmarillo1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        PanelAmarillo1Layout.setVerticalGroup(
            PanelAmarillo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAmarillo1Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );

        PanelInicioDocente.add(PanelAmarillo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 380, 500));

        FondoDocente1.setIcon(new javax.swing.ImageIcon("C:\\Users\\apsenior\\Downloads\\ProyectoCasiCasiFinal\\SendMailBasic_Maven-main\\src\\main\\java\\Imagenes\\ImagenFondoDocen.jpeg")); // NOI18N
        PanelInicioDocente.add(FondoDocente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 580));

        jTabbedPane1.addTab("Inicio", PanelInicioDocente);

        PanelAsistenciaDocente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelAmarillo2.setBackground(new java.awt.Color(255, 193, 7));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ASISTENCIA POR MES");

        jLabel3.setText("Anio");

        jtextAsistencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtextAsistenciasActionPerformed(evt);
            }
        });

        jLabel4.setText("Tardanzas");

        jLabel5.setText("Faltas");

        jLabel6.setText("Faltas Justificadas");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel16.setText("Asistencias");

        jLabel17.setText("Mes");

        jcAnio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "2022", "2023", "2024", "2025", "2026" }));
        jcAnio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcAnioActionPerformed(evt);
            }
        });

        jcMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        javax.swing.GroupLayout PanelAmarillo2Layout = new javax.swing.GroupLayout(PanelAmarillo2);
        PanelAmarillo2.setLayout(PanelAmarillo2Layout);
        PanelAmarillo2Layout.setHorizontalGroup(
            PanelAmarillo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelAmarillo2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143))
            .addGroup(PanelAmarillo2Layout.createSequentialGroup()
                .addGroup(PanelAmarillo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelAmarillo2Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(PanelAmarillo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(PanelAmarillo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtextJustificadas, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtextFaltas, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtextTardanzas, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtextAsistencias, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelAmarillo2Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(PanelAmarillo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelAmarillo2Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelAmarillo2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        PanelAmarillo2Layout.setVerticalGroup(
            PanelAmarillo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAmarillo2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(PanelAmarillo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelAmarillo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(PanelAmarillo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelAmarillo2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jtextAsistencias, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelAmarillo2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(PanelAmarillo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtextTardanzas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelAmarillo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtextFaltas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelAmarillo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtextJustificadas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76))
        );

        PanelAsistenciaDocente.add(PanelAmarillo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 380, 500));

        FondoDocente2.setIcon(new javax.swing.ImageIcon("C:\\Users\\apsenior\\Downloads\\ProyectoCasiCasiFinal\\SendMailBasic_Maven-main\\src\\main\\java\\Imagenes\\ImagenFondoDocen.jpeg")); // NOI18N
        PanelAsistenciaDocente.add(FondoDocente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 580));

        jTabbedPane1.addTab("Control de Asistencia", PanelAsistenciaDocente);

        PanelDatosDocente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelAmarillo3.setBackground(new java.awt.Color(255, 193, 7));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("MIS DATOS DOCENTE");

        jLabel8.setText("Nombre Completo");

        jLabel9.setText("Documento Identidad");

        jLabel10.setText("Email");

        jLabel11.setText("FechaNacimiento");

        jLabel12.setText("Nivel");

        javax.swing.GroupLayout PanelAmarillo3Layout = new javax.swing.GroupLayout(PanelAmarillo3);
        PanelAmarillo3.setLayout(PanelAmarillo3Layout);
        PanelAmarillo3Layout.setHorizontalGroup(
            PanelAmarillo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelAmarillo3Layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addGroup(PanelAmarillo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelAmarillo3Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtextNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelAmarillo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelAmarillo3Layout.createSequentialGroup()
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jtextNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PanelAmarillo3Layout.createSequentialGroup()
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jtextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PanelAmarillo3Layout.createSequentialGroup()
                            .addGroup(PanelAmarillo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(PanelAmarillo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jtextDNI, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                .addComponent(jtextNombre)))))
                .addGap(50, 50, 50))
        );
        PanelAmarillo3Layout.setVerticalGroup(
            PanelAmarillo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAmarillo3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(PanelAmarillo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(PanelAmarillo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtextDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(PanelAmarillo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(PanelAmarillo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtextNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(PanelAmarillo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtextNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(84, 84, 84))
        );

        PanelDatosDocente.add(PanelAmarillo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 380, 500));

        FondoDocente3.setIcon(new javax.swing.ImageIcon("C:\\Users\\apsenior\\Downloads\\ProyectoCasiCasiFinal\\SendMailBasic_Maven-main\\src\\main\\java\\Imagenes\\ImagenFondoDocen.jpeg")); // NOI18N
        PanelDatosDocente.add(FondoDocente3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 580));

        jTabbedPane1.addTab("Datos Personales", PanelDatosDocente);

        PanelBoletaDocente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelAmarillo4.setBackground(new java.awt.Color(255, 193, 7));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("BOLETA DE PAGO");

        jLabel14.setText("Año");

        jLabel15.setText("Mes");

        btnEnviarBoleta.setText("Enviar Boleta");
        btnEnviarBoleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarBoletaActionPerformed(evt);
            }
        });

        jcMesBoleta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        jcAnioBoleta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "2022", "2023", "2024", "2025", "2026" }));
        jcAnioBoleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcAnioBoletaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelAmarillo4Layout = new javax.swing.GroupLayout(PanelAmarillo4);
        PanelAmarillo4.setLayout(PanelAmarillo4Layout);
        PanelAmarillo4Layout.setHorizontalGroup(
            PanelAmarillo4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelAmarillo4Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(PanelAmarillo4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelAmarillo4Layout.createSequentialGroup()
                        .addGroup(PanelAmarillo4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PanelAmarillo4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcAnioBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcMesBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelAmarillo4Layout.createSequentialGroup()
                        .addComponent(btnEnviarBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(77, Short.MAX_VALUE))))
        );
        PanelAmarillo4Layout.setVerticalGroup(
            PanelAmarillo4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAmarillo4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addGroup(PanelAmarillo4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcAnioBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(PanelAmarillo4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcMesBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addComponent(btnEnviarBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
        );

        PanelBoletaDocente.add(PanelAmarillo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 380, 500));

        FondoDocente4.setIcon(new javax.swing.ImageIcon("C:\\Users\\apsenior\\Downloads\\ProyectoCasiCasiFinal\\SendMailBasic_Maven-main\\src\\main\\java\\Imagenes\\ImagenFondoDocen.jpeg")); // NOI18N
        PanelBoletaDocente.add(FondoDocente4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 580));

        jTabbedPane1.addTab("Boleta de pago", PanelBoletaDocente);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 960, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_BotonCerrarActionPerformed

    private void jtextAsistenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtextAsistenciasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtextAsistenciasActionPerformed

    private void jcAnioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcAnioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcAnioActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
       String Mes =String.valueOf(jcMes.getSelectedItem());
        String Anio =String.valueOf(jcAnio.getSelectedItem());
        ListarDetalleAsistencia (conectar,UsuarioSQL,Mes,Anio);
        
         jtextAsistencias.setText(Asistencia);
              jtextTardanzas.setText(Tardanza);
                jtextFaltas.setText(Faltas);
                  jtextJustificadas.setText(Justificacion);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jcAnioBoletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcAnioBoletaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcAnioBoletaActionPerformed

    private void btnEnviarBoletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarBoletaActionPerformed
  String Mes =String.valueOf(jcMesBoleta.getSelectedItem());
        String Anio =String.valueOf(jcAnioBoleta.getSelectedItem());
        String CodigoPersonal=UsuarioSQL;
        
        ListarBoletaPorMes(conectar,UsuarioSQL,Mes,Anio);
   Boleta b = new Boleta(NombresBoleta,ApellidosBoleta,SueldoxHoraBoleta,HorasDictadasBoleta,MontoDescporCategoriaBoleta,MontoDescporSeguroBoleta,MontoBonificacionBoleta,SueldoNetoBoleta,CuentaBancariaBoleta,TipoBonificacionBoleta,NivelBoleta,SeguroSaludBoleta,CodigoUsuarioBoleta,MesBoleta,AnioBoleta,CategoriaBoleta,DeduccionBoleta,CorreoDestinoBoleta);
        cGenerarPdf2 c = new cGenerarPdf2();
         c.generar(b);
         EnviarCorreo e = new EnviarCorreo();
          try {
              e.main(CorreoDestinoBoleta);
                JOptionPane.showMessageDialog(null,"Correo enviado con éxito"); 
              // TODO add your handling code here:
          } catch (MessagingException ex) {
              Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
          }        // TODO add your handling code here:
    }//GEN-LAST:event_btnEnviarBoletaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrincipalDocente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalDocente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalDocente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalDocente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalDocente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonCerrar;
    private javax.swing.JLabel FondoDocente1;
    private javax.swing.JLabel FondoDocente2;
    private javax.swing.JLabel FondoDocente3;
    private javax.swing.JLabel FondoDocente4;
    private javax.swing.JLabel LabelBienvenido;
    private javax.swing.JPanel PanelAmarillo1;
    private javax.swing.JPanel PanelAmarillo2;
    private javax.swing.JPanel PanelAmarillo3;
    private javax.swing.JPanel PanelAmarillo4;
    private javax.swing.JPanel PanelAsistenciaDocente;
    private javax.swing.JPanel PanelBlanco;
    private javax.swing.JPanel PanelBoletaDocente;
    private javax.swing.JPanel PanelDatosDocente;
    private javax.swing.JPanel PanelInicioDocente;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEnviarBoleta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox<String> jcAnio;
    private javax.swing.JComboBox<String> jcAnioBoleta;
    private javax.swing.JComboBox<String> jcMes;
    private javax.swing.JComboBox<String> jcMesBoleta;
    private javax.swing.JTextField jtextAsistencias;
    private javax.swing.JTextField jtextDNI;
    private javax.swing.JTextField jtextEmail;
    private javax.swing.JTextField jtextFaltas;
    private javax.swing.JTextField jtextJustificadas;
    private javax.swing.JTextField jtextNacimiento;
    private javax.swing.JTextField jtextNivel;
    private javax.swing.JTextField jtextNombre;
    private javax.swing.JTextField jtextTardanzas;
    // End of variables declaration//GEN-END:variables
}
