/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author apsenior
 */
public class Horario {
    int IdPersonal;
    String HoraInicio;
    String HoraFin;
    String CantidadHora;
    String Curso;
    String CantidadDiaLab;
    String Dias;

    public Horario(int IdPersonal, String HoraInicio, String HoraFin, String CantidadHora, String Curso, String CantidadDiaLab, String Dias) {
        this.IdPersonal = IdPersonal;
        this.HoraInicio = HoraInicio;
        this.HoraFin = HoraFin;
        this.CantidadHora = CantidadHora;
        this.Curso = Curso;
        this.CantidadDiaLab = CantidadDiaLab;
        this.Dias = Dias;
    }

}
