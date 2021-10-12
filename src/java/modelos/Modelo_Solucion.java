

package modelos;

import beans.Solucion;
import datos.cadito;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Modelo_Solucion {

    public Modelo_Solucion() {
    
    }

    // INSERTAR SOLUCION
    public int insertarSolucion(Solucion solucion){
        
        try {
        
            cadito cado = new cadito();

            String sql="insert into tb_solucion (codigo_solucion,"
                    + "descripcion_solucion) values(?,?)";

            Object[] parametros = new Object[2];

            parametros[0]=solucion.getCodigo_solucion();
            parametros[1]=solucion.getDescripcion_solucion();
            
            return cado.ejecutar1(sql, parametros);
            
        } catch (SQLException ex) {
            return 0;
        }
        
    }
    
    // MODIFICAR SOLUCION
    public int modificarSolucion(Solucion solucion){

        try {
            
            cadito cado = new cadito();
            
            String sql="update tb_solucion set codigo_solucion=?,"
                    + "descripcion_solucion=? where id_solucion=?";
                
            Object[] parametros = new Object[3];

            parametros[0]=solucion.getCodigo_solucion();
            parametros[1]=solucion.getDescripcion_solucion();          
            parametros[2]=solucion.getId_solucion();               
        
            return cado.ejecutar1(sql, parametros);
            
        } catch (SQLException e) {
            return 0;
        }
        
    }
    
    //ELIMINAR SOLUCION
    public int eliminarSolucion(int id){
        
        String sql="delete from tb_solucion where id_solucion="+id+"";
        
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

            sql="SELECT COUNT(codigo_solucion) FROM tb_solucion WHERE codigo_solucion='"+codigo+"'";
        
            rs=cd.Recuperar(sql);
            
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return -1;
        }

    }

    //LISTA DE SOLUCIONES
    public static List<Solucion> listaSoluciones(int codigo) throws SQLException{
        
        String sql;
        
        if(codigo==-1)
            sql="select * from tb_solucion";
        else        
            sql="select * from tb_solucion WHERE codigo_solucion='"+codigo+"'";
        
        cadito cado = new cadito();
        
        Statement st = null;
        ResultSet re = null;
        List<Solucion> soluciones = new ArrayList<>();
        
        Connection c = cado.conexion();
        
        try {
            st = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            re = st.executeQuery(sql);

            while (re.next()) {
                
                Solucion solucion = new Solucion();
                    
                solucion.setId_solucion(re.getInt("id_solucion"));
                solucion.setCodigo_solucion(re.getString("codigo_solucion"));
                solucion.setDescripcion_solucion(re.getString("descripcion_solucion"));
 
                soluciones.add(solucion);
            }
        
            return soluciones;

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
    
    //BUSCA DE SOLUCION POR ID
    public static Solucion buscaSolucionId(int id) throws SQLException{
        
        String sql="select * from tb_solucion where id_solucion="+id;
        
        cadito cado= new cadito();
        
        Statement st = null;
        ResultSet re = null;
        
        Connection c = cado.conexion();

        try {
            
            Solucion solucion = new Solucion();
                
            st = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            re = st.executeQuery(sql);
            
            while (re.next()) {                
                
                solucion.setId_solucion(re.getInt("id_solucion"));
                solucion.setCodigo_solucion(re.getString("codigo_solucion"));
                solucion.setDescripcion_solucion(re.getString("descripcion_solucion"));
 
            }
              
            return solucion;
            
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
