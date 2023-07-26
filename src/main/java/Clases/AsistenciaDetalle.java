/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author apsenior
 */
public class AsistenciaDetalle {
    String codigo;
    String Nombre;
    String Apellido;
    String Asistencia;
    String Tardanza;
    String Falta;
    String Justificada;
    String TotalAsistencia;
    String HoraporAsistencia;
    String TotalHora;
    String Mes;
    String Anio;

    public AsistenciaDetalle(String codigo, String Nombre, String Apellido, String Asistencia, String Tardanza, String Falta, String Justificada, String TotalAsistencia, String HoraporAsistencia, String TotalHora, String Mes, String Anio) {
        this.codigo = codigo;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Asistencia = Asistencia;
        this.Tardanza = Tardanza;
        this.Falta = Falta;
        this.Justificada = Justificada;
        this.TotalAsistencia = TotalAsistencia;
        this.HoraporAsistencia = HoraporAsistencia;
        this.TotalHora = TotalHora;
        this.Mes = Mes;
        this.Anio = Anio;
    }
    
}
