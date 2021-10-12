

package modelos;

import beans.Problema;
import datos.cadito;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Modelo_Problema {

    public Modelo_Problema() {
    
    }

    // INSERTAR PROBLEMA
    public int insertarProblema(Problema problema){
        
        try {
        
            cadito cado = new cadito();

            String sql="insert into tb_problema (codigo_problema,"
                    + "descripcion_problema,"
                    + "prioridad_problema) values(?,?,?)";

            Object[] parametros = new Object[3];

            parametros[0]=problema.getCodigo_problema();
            parametros[1]=problema.getDescripcion_problema();
            parametros[2]=problema.getPrioridad_problema();
            
            return cado.ejecutar1(sql, parametros);
            
        } catch (SQLException ex) {
            return 0;
        }
        
    }
    
    // MODIFICAR PROBLEMA
    public int modificarProblema(Problema problema){

        try {
            
            cadito cado = new cadito();
            
            String sql="update tb_problema set codigo_problema=?,"
                    + "descripcion_problema=?,"
                    + "prioridad_problema=? where id_problema=?";
                
            Object[] parametros = new Object[4];

            parametros[0]=problema.getCodigo_problema();
            parametros[1]=problema.getDescripcion_problema();           
            parametros[2]=problema.getPrioridad_problema();           
            parametros[3]=problema.getId_problema();               
        
            return cado.ejecutar1(sql, parametros);
            
        } catch (SQLException e) {
            return 0;
        }
        
    }
    
    //ELIMINAR PROBLEMA
    public int eliminarProblema(int id){
        
        String sql="delete from tb_problema where id_problema="+id+"";
        
        cadito cado = new cadito();
        
        try {
            return cado.ejecutarEliminar(sql);
        } catch (SQLException e) {
            return 0;
        }
    }
    
    // VER SI EXISTE EL CÓDIGO
    public int existe(String codigo){

        try {

            ResultSet rs;
            cadito cd = new cadito();
            
            String sql="";

            sql="SELECT COUNT(codigo_problema) FROM tb_problema WHERE codigo_problema='"+codigo+"'";
        
            rs=cd.Recuperar(sql);
            
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return -1;
        }

    }

    //LISTA DE PROBLEMAS
    public static List<Problema> listaProblemas(int codigo) throws SQLException{
        
        String sql;
        
        if(codigo==-1)
            sql="select * from tb_problema";
        else        
            sql="select * from tb_problema WHERE codigo_problema='"+codigo+"'";
        
        cadito cado = new cadito();
        
        Statement st = null;
        ResultSet re = null;
        List<Problema> problemas = new ArrayList<>();
        
        Connection c = cado.conexion();
        
        try {
            st = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            re = st.executeQuery(sql);

            while (re.next()) {
                
                Problema problema = new Problema();
                    
                problema.setId_problema(re.getInt("id_problema"));
                problema.setCodigo_problema(re.getString("codigo_problema"));
                problema.setDescripcion_problema(re.getString("descripcion_problema"));
                problema.setPrioridad_problema(Integer.parseInt(re.getString("prioridad_problema")));
 
                problemas.add(problema);
            }
        
            return problemas;

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
    
    //BUSCA DE PROBLEMA POR ID
    public static Problema buscaProblemaId(int id) throws SQLException{
        
        String sql="select * from tb_problema where id_problema="+id;
        
        cadito cado= new cadito();
        
        Statement st = null;
        ResultSet re = null;
        
        Connection c = cado.conexion();

        try {
            
            Problema problema = new Problema();
                
            st = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            re = st.executeQuery(sql);
            
            while (re.next()) {                
                
                problema.setId_problema(re.getInt("id_problema"));
                problema.setCodigo_problema(re.getString("codigo_problema"));
                problema.setDescripcion_problema(re.getString("descripcion_problema"));
                problema.setPrioridad_problema(Integer.parseInt(re.getString("prioridad_problema")));
 
            }
              
            return problema;
            
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
