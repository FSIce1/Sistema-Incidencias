

package modelos;

import beans.Incidente;
import datos.cadito;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Modelo_Incidente {

    public Modelo_Incidente() {    
    }

    // INSERTAR INCIDENTE
    public int insertarIncidente(Incidente incidente){
        
        try {
        
            cadito cado = new cadito();

            String sql="insert into tb_incidente (codigo_incidente,"
                    + "descripcion_incidente,"
                    + "estado_incidente,"
                    + "calificacion_incidente,"
                    + "id_usuario_fk) values(?,?,?,?,?)";

            Object[] parametros = new Object[5];

            parametros[0]=incidente.getCodigo_incidente();
            parametros[1]=incidente.getDescripcion_incidente();
            parametros[2]=incidente.getEstado_incidente(); // Estado habilitado
            parametros[3]=incidente.getCalificacion_incidente();
            parametros[4]=incidente.getId_usuario_fk();
            
            return cado.ejecutar1(sql, parametros);
            
        } catch (SQLException ex) {
            return 0;
        }
        
    }
    
    // MODIFICAR INCIDENTE
    public int modificarIncidente(Incidente incidente){

        try {
            
            cadito cado = new cadito();
            
            String sql="update tb_incidente set codigo_incidente=?,"
                    + "descripcion_incidente=?,"
                    + "estado_incidente=?,"
                    + "calificacion_incidente=?,"
                    + "id_usuario_fk=? where id_incidente=?";
                
            Object[] parametros = new Object[6];

            parametros[0]=incidente.getCodigo_incidente();
            parametros[1]=incidente.getDescripcion_incidente();
            parametros[2]=incidente.getEstado_incidente();
            parametros[3]=incidente.getCalificacion_incidente();
            parametros[4]=incidente.getId_usuario_fk();              
            parametros[5]=incidente.getId_incidente();              
        
            return cado.ejecutar1(sql, parametros);
            
        } catch (SQLException e) {
            return 0;
        }
        
    }
    
    //ELIMINAR INCIDENTE
    public int eliminarIncidente(int id){
        
        String sql="delete from tb_incidente where id_incidente="+id+"";
        
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

            sql="SELECT COUNT(codigo_incidente) FROM tb_incidente WHERE codigo_incidente='"+codigo+"'";
        
            rs=cd.Recuperar(sql);
            
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return -1;
        }

    }

    //LISTA DE INCIDENTES
    public static List<Incidente> listaIncidentes(int id_usuario) throws SQLException{
        
        String sql;
        
        if(id_usuario==-1)
            sql="select * from tb_incidente";
        else        
            sql="select * from tb_incidente WHERE id_usuario_fk ="+id_usuario;
        
        cadito cado = new cadito();
        
        Statement st = null;
        ResultSet re = null;
        List<Incidente> incidentes = new ArrayList<>();
        
        Connection c = cado.conexion();
        
        try {
            st = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            re = st.executeQuery(sql);

            while (re.next()) {
                
                Incidente incidente = new Incidente();
                    
                incidente.setId_incidente(re.getInt("id_incidente"));
                incidente.setCodigo_incidente(re.getString("codigo_incidente"));
                incidente.setDescripcion_incidente(re.getString("descripcion_incidente"));
                incidente.setFecha_incidente(re.getTimestamp("fecha_incidente"));
                
                incidente.setEstado_incidente(re.getInt("estado_incidente"));
                
                incidente.setCalificacion_incidente(re.getInt("calificacion_incidente"));
                
                
                incidente.setoUsuario(Modelo_Usuario.buscaUsuarioId(re.getInt("id_usuario_fk")));
                //incidente.setId_usuario_fk(1);
                
                incidentes.add(incidente);
            }
        
            return incidentes;

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
    
    //BUSCA DE INCIDENTE POR ID
    public static Incidente buscaIncidenteId(int id) throws SQLException{
        
        String sql="select * from tb_incidente where id_incidente="+id;
        
        cadito cado= new cadito();
        
        Statement st = null;
        ResultSet re = null;
        
        Connection c = cado.conexion();

        try {
            
            Incidente incidente = new Incidente();
                
            st = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            re = st.executeQuery(sql);
            
            while (re.next()) {                
                
                incidente.setId_incidente(re.getInt("id_incidente"));
                incidente.setCodigo_incidente(re.getString("codigo_incidente"));
                incidente.setDescripcion_incidente(re.getString("descripcion_incidente"));
                incidente.setFecha_incidente(re.getTimestamp("fecha_incidente"));
                
                incidente.setEstado_incidente(re.getInt("estado_incidente"));
                
                incidente.setCalificacion_incidente(re.getInt("calificacion_incidente"));
                
                incidente.setoUsuario(Modelo_Usuario.buscaUsuarioId(re.getInt("id_usuario_fk")));
                
            }
              
            return incidente;
            
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
