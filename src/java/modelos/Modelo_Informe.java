

package modelos;

import beans.Informe_Final;
import datos.cadito;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Modelo_Informe {

    public Modelo_Informe() {    
    }

    // INSERTAR INFORME
    public int insertarInforme(Informe_Final informe){
        
        try {
        
            cadito cado = new cadito();

            String sql="insert into tb_informe_final (descripcion,"
                    + "id_incidente_fk,"
                    + "id_problema_fk,"
                    + "id_solucion_fk) values(?,?,?,?)";

            Object[] parametros = new Object[4];

            parametros[0]=informe.getDescripcion(); 
            parametros[1]=informe.getId_incidente_fk();
            parametros[2]=informe.getId_problema_fk();
            parametros[3]=informe.getId_solucion_fk();
            
            return cado.ejecutar1(sql, parametros);
            
        } catch (SQLException ex) {
            return 0;
        }
        
    }
    
    // MODIFICAR INCIDENTE
    public int modificarInforme(Informe_Final informe){

        try {
            
            cadito cado = new cadito();
            
            String sql="update tb_informe_final set descripcion=?,"
                    + "id_incidente_fk=?,"
                    + "id_problema_fk=?,"
                    + "id_solucion_fk=? where id_informe=?";
                
            Object[] parametros = new Object[5];
            
            System.out.println("HOLLAAAA: "+informe.getDescripcion());
            parametros[0]=informe.getDescripcion(); 
            parametros[1]=informe.getId_incidente_fk();
            parametros[2]=informe.getId_problema_fk();
            parametros[3]=informe.getId_solucion_fk();             
            parametros[4]=informe.getId_informe();              
        
            return cado.ejecutar1(sql, parametros);
            
        } catch (SQLException e) {
            return 0;
        }
        
    }
    
    //ELIMINAR INCIDENTE
    public int eliminarInforme(int id){
        
        String sql="delete from tb_informe_final where id_informe="+id+"";
        
        cadito cado = new cadito();
        
        try {
            return cado.ejecutarEliminar(sql);
        } catch (SQLException e) {
            return 0;
        }
    }
    
    // VER SI EXISTE EL CÓDIGO
    /*
    public int existe(String codigo){

        try {

            ResultSet rs;
            cadito cd = new cadito();
            
            String sql="";

            sql="SELECT COUNT(codigo_incidente) FROM tb_informe_final WHERE codigo_incidente='"+codigo+"'";
        
            rs=cd.Recuperar(sql);
            
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return -1;
        }

    }
    */
    
    //LISTA DE INFORMES
    public static List<Informe_Final> listaInformes() throws SQLException{
        
        String sql;
        
        sql="select * from tb_informe_final";
        
        cadito cado = new cadito();
        
        Statement st = null;
        ResultSet re = null;
        List<Informe_Final> informes = new ArrayList<>();
        
        Connection c = cado.conexion();
        
        try {
            st = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            re = st.executeQuery(sql);

            while (re.next()) {
                
                Informe_Final informe = new Informe_Final();
                    
                informe.setId_informe(re.getInt("id_informe"));
                informe.setHora_final_informe(re.getDate("hora_final_informe"));
                informe.setDescripcion(re.getString("descripcion"));
                
                // ID Rápidos
                
                informe.setId_incidente_fk(Integer.parseInt(re.getString("id_incidente_fk")));
                informe.setId_problema_fk(Integer.parseInt(re.getString("id_problema_fk")));
                informe.setId_solucion_fk(Integer.parseInt(re.getString("id_solucion_fk")));
                
                // OBJETOS
                
                informe.setoIncidente(Modelo_Incidente.buscaIncidenteId(re.getInt("id_incidente_fk")));
                informe.setoProblema(Modelo_Problema.buscaProblemaId(re.getInt("id_problema_fk")));
                informe.setoSolucion(Modelo_Solucion.buscaSolucionId(re.getInt("id_solucion_fk")));
                
                
                
                informes.add(informe);
            }
        
            return informes;

        } catch (SQLException e) {
            return null;
        } finally {

            if (re != null) {
                re.close();
            }

            if (st != null) {
                st.close();
            }

            cado.closeCnx(c);
        }
        
    }
    
}
