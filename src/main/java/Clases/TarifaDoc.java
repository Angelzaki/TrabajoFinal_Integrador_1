/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author apsenior
 */
public class TarifaDoc {
    String IdTarifaDoc ;
    int IdTarifa ;
    int IdPersonal;
    String CodigoTarifa;
    String CodigoPersonal;
    String Nombre;
    String Apellidos;
    String Categoria ;

    public TarifaDoc(String IdTarifaDoc, int IdTarifa, int IdPersonal, String CodigoTarifa, String CodigoPersonal, String Nombre, String Apellidos, String Categoria) {
        this.IdTarifaDoc = IdTarifaDoc;
        this.IdTarifa = IdTarifa;
        this.IdPersonal = IdPersonal;
        this.CodigoTarifa = CodigoTarifa;
        this.CodigoPersonal = CodigoPersonal;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Categoria = Categoria;
    }



    
    
}
