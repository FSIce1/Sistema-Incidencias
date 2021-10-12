

package modelos;

import beans.Usuario;
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

public class Modelo_Usuario {

    public Modelo_Usuario() {
    
    }

    // INSERTAR INSERTAR USUARIO
    public int insertarUsuario(Usuario usuario){
        
        try {
        
            cadito cado = new cadito();

            String sql="insert into tb_usuario (nombres_usuario,"
                    + "apellidos_usuario,"
                    + "correo_usuario,"
                    + "telefono_usuario,"
                    + "codigo_usuario,"
                    + "contra_usuario,"
                    + "tipo_usuario,"
                    + "estado_usuario) values(?,?,?,?,?,?,?,?)";

            Object[] parametros = new Object[8];

            parametros[0]=usuario.getNombres_usuario();
            parametros[1]=usuario.getApellidos_usuario();
            parametros[2]=usuario.getCorreo_usuario();
            parametros[3]=usuario.getTelefono_usuario();
            parametros[4]=usuario.getCodigo_usuario();
            parametros[5]=usuario.getContra_usuario();
            parametros[6]=0; // ADMI
            parametros[7]=0; // ACTIVO
            
            return cado.ejecutar1(sql, parametros);
            
        } catch (SQLException ex) {
            return 0;
        }
        
    }
    
    // INSERTAR INSERTAR USUARIO2
    public int insertarUsuario2(Usuario usuario){
        
        try {
        
            cadito cado = new cadito();

            String sql="insert into tb_usuario (nombres_usuario,"
                    + "apellidos_usuario,"
                    + "correo_usuario,"
                    + "telefono_usuario,"
                    + "codigo_usuario,"
                    + "contra_usuario,"
                    + "tipo_usuario,"
                    + "estado_usuario) values(?,?,?,?,?,?,?,?)";

            Object[] parametros = new Object[8];

            parametros[0]=usuario.getNombres_usuario();
            parametros[1]=usuario.getApellidos_usuario();
            parametros[2]=usuario.getCorreo_usuario();
            parametros[3]=usuario.getTelefono_usuario();
            parametros[4]=usuario.getCodigo_usuario();
            parametros[5]=usuario.getContra_usuario();
            parametros[6]=usuario.getTipo_usuario();
            parametros[7]=usuario.getEstado_usuario();
            
            return cado.ejecutar1(sql, parametros);
            
        } catch (SQLException ex) {
            return 0;
        }
        
    }
    
    // MODIFICAR USUARIO
    public int modificarUsuario(Usuario usuario){

        try {
            
            cadito cado = new cadito();
            
            String sql="update tb_usuario set nombres_usuario=?,"
                    + "apellidos_usuario=?,"
                    + "correo_usuario=?,"
                    + "telefono_usuario=?,"
                    + "codigo_usuario=?,"
                    + "contra_usuario=?,"
                    + "tipo_usuario=?,"
                    + "estado_usuario=? where id_usuario=?";
                
            Object[] parametros = new Object[9];

                parametros[0]=usuario.getNombres_usuario();
                parametros[1]=usuario.getApellidos_usuario();
                parametros[2]=usuario.getCorreo_usuario();
                parametros[3]=usuario.getTelefono_usuario();
                parametros[4]=usuario.getCodigo_usuario();
                parametros[5]=usuario.getContra_usuario();
                parametros[6]=usuario.getTipo_usuario();               
                parametros[7]=usuario.getEstado_usuario();               
                parametros[8]=usuario.getId_usuario();               
        
            return cado.ejecutar1(sql, parametros);
            
        } catch (SQLException e) {
            return 0;
        }
        
    }
    
    //ELIMINAR USUARIOS
    public int eliminarUsuario(int id){
        
        String sql="delete from tb_usuario where id_usuario="+id+"";
        
        cadito cado = new cadito();
        
        try {
            return cado.ejecutarEliminar(sql);
        } catch (SQLException e) {
            return 0;
        }
    }
    
    //LISTA DE USUARIOS
    public static List<Usuario> listaUsuarios(int tipo) throws SQLException{
        
        String sql;
        
        if(tipo==-1)
            sql="select * from tb_usuario";
        else        
            sql="select * from tb_usuario WHERE tipo_usuario="+tipo;
        
        cadito cado = new cadito();
        
        Statement st = null;
        ResultSet re = null;
        List<Usuario> usuarios = new ArrayList<>();
        
        Connection c = cado.conexion();
        
        try {
            st = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            re = st.executeQuery(sql);

            while (re.next()) {
                
                Usuario usuario = new Usuario();
                    
                usuario.setId_usuario(re.getInt("id_usuario"));
                usuario.setNombres_usuario(re.getString("nombres_usuario"));
                usuario.setApellidos_usuario(re.getString("apellidos_usuario"));
                usuario.setCorreo_usuario(re.getString("correo_usuario"));
                usuario.setTelefono_usuario(re.getInt("telefono_usuario"));
                usuario.setCodigo_usuario(re.getString("codigo_usuario"));
                usuario.setContra_usuario(re.getString("contra_usuario"));
                usuario.setTipo_usuario(re.getInt("tipo_usuario"));
                usuario.setEstado_usuario(re.getInt("estado_usuario"));
 
                usuarios.add(usuario);
            }
        
            return usuarios;

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
    
    //BUSCA DE USUARIO POR CODIGO
    public static Usuario buscaUsuario(String codigo,String contra) throws SQLException{
        
        cadito cd= new cadito();
        ResultSet re;
        
        String sql;
        Object a[]= new Object[2];
            
        if(contra.equals("")){
            //sql="select * from usuario where dni_usuario="+codigo+"";
            sql="select * from tb_usuario where codigo_usuario='"+codigo+"'";
        }else{
            sql="select * from tb_usuario where codigo_usuario=? and contra_usuario=?";
            
            a[0]=codigo;
            a[1]=contra;
        }
        
        re= cd.recuperarPrpStm(sql,a);
        
        try {
            
            while (re.next()) {                
                
                Usuario usuario = new Usuario();
                
                usuario.setId_usuario(re.getInt("id_usuario"));
                usuario.setNombres_usuario(re.getString("nombres_usuario"));
                usuario.setApellidos_usuario(re.getString("apellidos_usuario"));
                usuario.setCorreo_usuario(re.getString("correo_usuario"));
                usuario.setTelefono_usuario(re.getInt("telefono_usuario"));
                usuario.setCodigo_usuario(re.getString("codigo_usuario"));
                usuario.setContra_usuario(re.getString("contra_usuario"));
                usuario.setTipo_usuario(re.getInt("tipo_usuario"));
                usuario.setEstado_usuario(re.getInt("estado_usuario"));
                
                return usuario;
            }
              
            return new Usuario();
            
        } catch (SQLException e) {
            return null;
        }
        
    }
    
    //BUSCA DE USUARIO POR ID
    public static Usuario buscaUsuarioId(int id) throws SQLException{
        
        String sql="select * from tb_usuario where id_usuario="+id;
        
        cadito cado= new cadito();
        
        Statement st = null;
        ResultSet re = null;
        
        Connection c = cado.conexion();

        try {
            
            Usuario usuario = new Usuario();
                
            st = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            re = st.executeQuery(sql);
            
            while (re.next()) {                
                
                usuario.setId_usuario(re.getInt("id_usuario"));
                usuario.setNombres_usuario(re.getString("nombres_usuario"));
                usuario.setApellidos_usuario(re.getString("apellidos_usuario"));
                usuario.setCorreo_usuario(re.getString("correo_usuario"));
                usuario.setTelefono_usuario(re.getInt("telefono_usuario"));
                usuario.setCodigo_usuario(re.getString("codigo_usuario"));
                usuario.setContra_usuario(re.getString("contra_usuario"));
                usuario.setTipo_usuario(re.getInt("tipo_usuario"));
                usuario.setEstado_usuario(re.getInt("estado_usuario"));
                
            }
              
            return usuario;
            
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
    
    
    // CAMBIA ESTADO A ----> ACTIVO / INACTIVO
    public int cambiarEstado(int estado,int id){

        String sql="update tb_usuario set estado_usuario=? where id_usuario=?";
        
        cadito cado = new cadito();
        
        try {
            
              Object[] parametros = new Object[2];

            parametros[0]=estado;
            parametros[1]=id;
            
            return cado.ejecutar1(sql, parametros);
        } catch (SQLException e) {
            return 0;
        }
        
    }
    
    // LOGUEO
    public int existe(String usu, String email, String contra){

        try {

            ResultSet rs;
            cadito cd = new cadito();
            
            String sql="";

            if(!email.equals("")){
                System.out.println("EMA");
                sql="SELECT COUNT(correo_usuario) FROM tb_usuario WHERE correo_usuario='"+email+"'";

            } else if(!usu.equals("") && contra.equals("")){
                System.out.println("USU");
                sql="SELECT COUNT(codigo_usuario) FROM tb_usuario WHERE codigo_usuario='"+usu+"'";

            } else if(!contra.equals("")){
                System.out.println("CONTRA");
               sql="SELECT COUNT(codigo_usuario) FROM tb_usuario WHERE codigo_usuario='"+usu+"' "
                         + "AND contra_usuario='"+contra+"' AND estado_usuario="+0;

            }
            
            rs=cd.Recuperar(sql);
            
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return -1;
        }

    }

    
    // ENCRIPTA CONTRASEÑA
    public static String getMD5(String contraseña) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] mensaje = md.digest(contraseña.getBytes());
            BigInteger numero = new BigInteger(1, mensaje);
            String siguiente = numero.toString(16);

            while (siguiente.length() < 32) {
                siguiente = "0" + siguiente;
            }
            return siguiente;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }
    
}
