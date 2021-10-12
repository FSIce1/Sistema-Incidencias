/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import beans.Incidente;
import beans.Informe_Final;
import beans.Problema;
import beans.Usuario;
import datos.cadito;
import java.util.ArrayList;
import java.util.List;
import modelos.Modelo_Incidente;
import modelos.Modelo_Informe;
import modelos.Modelo_Problema;
import modelos.Modelo_Usuario;

/**
 *
 * @author luisf
 */
public class Prueba {
    public static void main(String[] args) {
        
        try {
            
        cadito ca = new cadito();

            Modelo_Usuario m = new Modelo_Usuario();
            
            /*
            Usuario u = new Usuario("Cr7", "Messi", "juanito@gmail.com", 772142, "Alcachofa", "23", 0, 0);
            
            if(m.insertarUsuario(u)==1){
                System.out.println("INGRESADO");
            } else {
                System.out.println("NO INGRESADO");
            }
            */
            
            /*
            if(m.existe("Luis23", "","")==1){
                System.out.println("Ya existe");
            } else {
                System.out.println("No existe");
            }
            */
            
            /*
            if(m.existe("Luihhs23", "", "23")==1){
                System.out.println("EXISTE");
            } else {
                System.out.println("NO EXISTE");
            }
            */
            Modelo_Problema mop = new Modelo_Problema();
            
            /*
            
            List<Problema> lista = Modelo_Problema.listaProblemas(-1);

            for (int i = 0; i < lista.size(); i++) {
                System.out.println("ID: "+lista.get(i).getId_problema());
                System.out.println("CODIGO: "+lista.get(i).getCodigo_problema());
                System.out.println("DESCRIPCION: "+lista.get(i).getDescripcion_problema());
            }
            
            
            //System.out.println(mop.existe("fzxgdfgdf"));
            
            Modelo_Incidente modelo = new Modelo_Incidente();
            
            Incidente incidente = new Incidente(1,"CAMBIOO", 0, 0, 10, 1);
            
            System.out.println(modelo.eliminarIncidente(1));
            */
            /*
            Modelo_Informe mDD = new Modelo_Informe();
            
            Informe_Final in = new Informe_Final(13,"CAMBIA 2", 19, 14, 1);
            
            System.out.println(""+mDD.eliminarInforme(11));
            */
            /*
            List<Informe_Final> lista = Modelo_Informe.listaInformes();

            for (int i = 0; i < lista.size(); i++) {
                System.out.println("ID: "+lista.get(i).getId_informe());
                System.out.println("FECHA: "+lista.get(i).getHora_final_informe());
                System.out.println("DES: "+lista.get(i).getDescripcion());
                System.out.println("INCI: "+lista.get(i).getId_incidente_fk());
                System.out.println("PRO: "+lista.get(i).getId_problema_fk());
                System.out.println("SOL: "+lista.get(i).getId_solucion_fk());
            }
            */
            
            Usuario u =Modelo_Usuario.buscaUsuarioId(1);
            System.out.println(""+u.getCodigo_usuario());
            
            List<Incidente> lista = Modelo_Incidente.listaIncidentes(-1);
            
            for (int i = 0; i < lista.size(); i++) {
                System.out.println("USUARIO: "+lista.get(i).getoUsuario().getCodigo_usuario());
            }
            
        } catch (Exception e) {

        }
    }
}
