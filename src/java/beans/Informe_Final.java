
package beans;

import java.util.Date;

public class Informe_Final {
    
    private int id_informe;
    private Date hora_final_informe;
    private String descripcion;
    
    private int id_incidente_fk;
    private Incidente oIncidente;
    
    private int id_problema_fk;
    private Problema oProblema;
    
    private int id_solucion_fk;
    private Solucion oSolucion;

    public Informe_Final() {
    }

    public Informe_Final(String descripcion, int id_incidente_fk, int id_problema_fk, int id_solucion_fk) {
        this.descripcion = descripcion;
        this.id_incidente_fk = id_incidente_fk;
        this.id_problema_fk = id_problema_fk;
        this.id_solucion_fk = id_solucion_fk;
    }
    
    public Informe_Final(int id_informe,String descripcion, int id_incidente_fk, int id_problema_fk, int id_solucion_fk) {
        this.id_informe = id_informe;
        this.descripcion = descripcion;
        this.id_incidente_fk = id_incidente_fk;
        this.id_problema_fk = id_problema_fk;
        this.id_solucion_fk = id_solucion_fk;
    }

    public Informe_Final(int id_informe, Date hora_final_informe, String descripcion, int id_incidente_fk, Incidente oIncidente, int id_problema_fk, int id_solucion_fk) {
        this.id_informe = id_informe;
        this.hora_final_informe = hora_final_informe;
        this.descripcion = descripcion;
        this.id_incidente_fk = id_incidente_fk;
        this.oIncidente = oIncidente;
        
        this.id_problema_fk = id_problema_fk;
        this.id_solucion_fk = id_solucion_fk;
    }
    
    public Informe_Final(int id_informe, Date hora_final_informe, String descripcion, int id_incidente_fk, Incidente oIncidente, Problema oProblema, Solucion oSolucion) {
        this.id_informe = id_informe;
        this.hora_final_informe = hora_final_informe;
        this.descripcion = descripcion;
        this.id_incidente_fk = id_incidente_fk;
        this.oIncidente = oIncidente;
        
        this.oProblema = oProblema;
        this.oSolucion = oSolucion;
    }

    public int getId_informe() {
        return id_informe;
    }

    public void setId_informe(int id_informe) {
        this.id_informe = id_informe;
    }

    public Date getHora_final_informe() {
        return hora_final_informe;
    }

    public void setHora_final_informe(Date hora_final_informe) {
        this.hora_final_informe = hora_final_informe;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_incidente_fk() {
        return id_incidente_fk;
    }

    public void setId_incidente_fk(int id_incidente_fk) {
        this.id_incidente_fk = id_incidente_fk;
    }

    public Incidente getoIncidente() {
        return oIncidente;
    }

    public void setoIncidente(Incidente oIncidente) {
        this.oIncidente = oIncidente;
    }

    public int getId_problema_fk() {
        return id_problema_fk;
    }

    public void setId_problema_fk(int id_problema_fk) {
        this.id_problema_fk = id_problema_fk;
    }

    public Problema getoProblema() {
        return oProblema;
    }

    public void setoProblema(Problema oProblema) {
        this.oProblema = oProblema;
    }

    public int getId_solucion_fk() {
        return id_solucion_fk;
    }

    public void setId_solucion_fk(int id_solucion_fk) {
        this.id_solucion_fk = id_solucion_fk;
    }

    public Solucion getoSolucion() {
        return oSolucion;
    }

    public void setoSolucion(Solucion oSolucion) {
        this.oSolucion = oSolucion;
    }
    
}
