
package controladores;

import beans.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Modelo_Usuario;

@WebServlet(name = "Controlador_Usuario", urlPatterns = {"/Controlador_Usuario"})
public class Controlador_Usuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            
            Modelo_Usuario mod;
            //HttpSession session = request.getSession();
            
            switch(request.getParameter("opcion").charAt(0)){
                
            // MANDAR A LA LISTA DE USUARIOS    
            case 'L': 
                
                request.getRequestDispatcher("Lista_Usuarios.jsp").forward(request, response);

                break;
                
            // MANDAR PARA INSERTAR USUARIO
            case 'N': 
                request.setAttribute("USUARIO", "INSERTARUSUARIO");
                request.setAttribute("ALERTA", "");
                
                request.getRequestDispatcher("Nuevo_Usuario.jsp").forward(request, response);
                break;    
                
            // INSERTAR USUARIO
            case 'I': 
                
                mod= new Modelo_Usuario();

                Usuario usuario;
                
                try {
                
                // LLENO CON LOS DATOS ENVIADOS POR EL FORMULARIO
                usuario= new Usuario();
                /*
                usuario.setNombres_usuario("Juanito");
                usuario.setApellidos_usuario("AJJa");
                usuario.setCorreo_usuario("luasdasdca@gmaail.com");
                usuario.setTelefono_usuario(34234);
                usuario.setCodigo_usuario("sdasdasdsds");
                usuario.setContra_usuario("Sss");
                */
                usuario.setNombres_usuario(request.getParameter("txtNombres"));
                usuario.setApellidos_usuario(request.getParameter("txtApellidos"));
                usuario.setCorreo_usuario(request.getParameter("txtCorreo"));
                usuario.setTelefono_usuario(Integer.parseInt(request.getParameter("txtTelefono")));
                usuario.setCodigo_usuario(request.getParameter("txtCodigo"));
                usuario.setContra_usuario(request.getParameter("txtContra"));
                
                
                //usuario.setTipo_usuario(Integer.parseInt(request.getParameter("txtTipo")));
                //usuario.setEstado_usuario(Integer.parseInt(request.getParameter("txtEstado")));
                
                int existeEmail=mod.existe("",request.getParameter("txtCorreo"),"");
                
                if(existeEmail==1){ // EXISTE EL EMAIL
                    request.setAttribute("ALERTA", "EXISTE_EMAIL");
                } else {
                
                    int existe=mod.existe(request.getParameter("txtCodigo"),"","");
                
                    if(existe==1){ // EXISTE EL USUARIO
                        request.setAttribute("ALERTA", "EXISTE_USUARIO");
                    } else {

                        if(mod.insertarUsuario(usuario)==1){
                            request.setAttribute("ALERTA", "INGRESADO");
                        } else {
                            request.setAttribute("ALERTA", "NO_INGRESADO");
                        }

                    }    
                }
                
                request.getRequestDispatcher("Login_Registro.jsp").forward(request, response);

                } catch (IOException | NumberFormatException e) {
                    request.setAttribute("ALERTA", "ERROR");
                    request.getRequestDispatcher("Login_Registro.jsp").forward(request, response);
                }
                
                break;
                
                // INSERTAR USUARIO - LISTA
            case 'X': 
                
                mod= new Modelo_Usuario();

                Usuario usuario1;
                
                try {
                
                // LLENO CON LOS DATOS ENVIADOS POR EL FORMULARIO
                usuario1= new Usuario();
                
                usuario1.setNombres_usuario(request.getParameter("txtNombres"));
                usuario1.setApellidos_usuario(request.getParameter("txtApellidos"));
                usuario1.setCorreo_usuario(request.getParameter("txtCorreo"));
                usuario1.setTelefono_usuario(Integer.parseInt(request.getParameter("txtTelefono")));
                usuario1.setCodigo_usuario(request.getParameter("txtCodigo"));
                usuario1.setContra_usuario(request.getParameter("txtContra"));
                
                usuario1.setTipo_usuario(Integer.parseInt(request.getParameter("txtTipo")));
                usuario1.setEstado_usuario(Integer.parseInt(request.getParameter("txtEstado")));
                
                int existeEmail=mod.existe("",request.getParameter("txtCorreo"),"");
                
                if(existeEmail==1){ // EXISTE EL EMAIL
                    request.setAttribute("ALERTA", "EXISTE_EMAIL");
                } else {
                
                    int existe=mod.existe(request.getParameter("txtCodigo"),"","");
                
                    if(existe==1){ // EXISTE EL USUARIO
                        request.setAttribute("ALERTA", "EXISTE_USUARIO");
                    } else {

                        if(mod.insertarUsuario2(usuario1)==1){
                            request.setAttribute("ALERTA", "INGRESADO");
                        } else {
                            request.setAttribute("ALERTA", "NO_INGRESADO");
                        }

                    }    
                }
                
                request.getRequestDispatcher("Lista_Usuarios.jsp").forward(request, response);

                } catch (IOException | NumberFormatException e) {
                    request.setAttribute("ALERTA", "ERROR");
                    request.getRequestDispatcher("Lista_Usuarios.jsp").forward(request, response);
                }
                
            break;
                
            
            //MODIFICAR     
            case 'D':
  
                try {
                    
                    mod= new Modelo_Usuario();

                    // LLENO CON LOS DATOS ENVIADOS POR EL FORMULARIO
                    usuario1= new Usuario();

                    usuario1.setId_usuario(Integer.parseInt(request.getParameter("txtId")));
                    
                    usuario1.setNombres_usuario(request.getParameter("txtNombres"));
                    usuario1.setApellidos_usuario(request.getParameter("txtApellidos"));
                    usuario1.setCorreo_usuario(request.getParameter("txtCorreo"));
                    usuario1.setTelefono_usuario(Integer.parseInt(request.getParameter("txtTelefono")));
                    usuario1.setCodigo_usuario(request.getParameter("txtCodigo"));
                    usuario1.setContra_usuario(request.getParameter("txtContra"));
                    usuario1.setTipo_usuario(Integer.parseInt(request.getParameter("txtTipo")));
                    usuario1.setEstado_usuario(Integer.parseInt(request.getParameter("txtEstado")));

                    
                    System.out.println("ID: "+request.getParameter("txtId"));
                    System.out.println("ID: "+request.getParameter("txtNombres"));
                    System.out.println("ID: "+request.getParameter("txtApellidos"));
                    System.out.println("ID: "+request.getParameter("txtCorreo"));
                    System.out.println("ID: "+request.getParameter("txtCodigo"));
                    System.out.println("ID: "+request.getParameter("txtContra"));
                    System.out.println("ID: "+request.getParameter("txtTipo"));
                    System.out.println("ID: "+request.getParameter("txtEstado"));
                    
                    // PRIMERO VERIFICAMOS SI SE REPITE EMAIL
                    int existe1=0;
                
                    System.out.println("EMAIL ANTIGUO = "+request.getParameter("txtEmailAntiguo"));
                    System.out.println("EMAIL NUEVO = "+usuario1.getEstado_usuario());
                    
                    if(request.getParameter("txtEmailAntiguo").equals(usuario1.getCorreo_usuario())){
                        existe1 = 0;
                    } else {
                        existe1=mod.existe("",request.getParameter("txtEmailAntiguo"),"");
                    }

                    if(existe1==1){ // EXISTE EL EMAIL
                        request.setAttribute("ALERTA", "EXISTE_EMAIL");
                    } else {

                        // NO EXISTE EMAIL PASAMOS A VERIFICAR USUARIO
                        
                        int existe=0;
                
                        if(request.getParameter("txtCodigoAntiguo").equals(usuario1.getCodigo_usuario())){
                            existe = 0;
                        } else {
                            existe=mod.existe(request.getParameter("txtCodigoAntiguo"),"","");
                        }

                        if(existe==1){ // EXISTE EL CODIGO
                            request.setAttribute("ALERTA", "EXISTE_CODIGO");
                        } else {

                            if(mod.modificarUsuario(usuario1)==1){
                                request.setAttribute("ALERTA", "MODIFICADO");
                            } else {
                                request.setAttribute("ALERTA", "NO_MODIFICADO");
                            }

                        } 

                    } 
                
                    request.getRequestDispatcher("Lista_Usuarios.jsp").forward(request, response);

                } catch (NumberFormatException e) {
                    request.setAttribute("ALERTA", "ERROR");
                    request.getRequestDispatcher("Lista_Usuarios.jsp").forward(request, response);
                }
                
            break; 
            
            /* MI USUARIO
            //MODIFICAR     
            case 'D':
  
                try {
                    
                    mod= new Modelo_Usuario();

                    // LLENO CON LOS DATOS ENVIADOS POR EL FORMULARIO
                    usuario= new Usuario();

                    usuario.setId_usuario(Integer.parseInt(request.getParameter("txtId")));
                    
                    usuario.setNombres_usuario(request.getParameter("txtNombres"));
                    usuario.setApellidos_usuario(request.getParameter("txtApellidos"));
                    usuario.setCorreo_usuario(request.getParameter("txtCorreo"));
                    usuario.setTelefono_usuario(Integer.parseInt(request.getParameter("txtTelefono")));
                    usuario.setCodigo_usuario(request.getParameter("txtCodigo"));
                    usuario.setContra_usuario(request.getParameter("txtContra"));
                    usuario.setTipo_usuario(Integer.parseInt(request.getParameter("txtTipo")));
                    usuario.setEstado_usuario(Integer.parseInt(request.getParameter("txtEstado")));

                    if(request.getParameter("actualiza")!=null){
                        if(request.getParameter("actualiza").equals("actualiza")){

                            session.setAttribute("idCUENTA", String.valueOf(usuario.getId_usuario()));
                            session.setAttribute("nombresCUENTA", usuario.getNombres_usuario());
                            session.setAttribute("apellidosCUENTA", usuario.getApellidos_usuario());
                            session.setAttribute("correoCUENTA", usuario.getCorreo_usuario());
                            session.setAttribute("telefonoCUENTA", String.valueOf(usuario.getTelefono_usuario()));
                            session.setAttribute("codigoCUENTA", usuario.getCodigo_usuario());
                            session.setAttribute("contraCUENTA", usuario.getContra_usuario());
                            session.setAttribute("tipoCUENTA", usuario.getTipo_usuario());
                            session.setAttribute("estadoCUENTA", usuario.getEstado_usuario()); 
                        }    
                    }
                    
                    mod.modificarUsuario(usuario,Integer.parseInt(request.getParameter("txtCargo")));
                    
                    if(request.getParameter("actualiza")!=null){
                        if(request.getParameter("actualiza").equals("actualiza")){
                            response.sendRedirect("Inicio.jsp");
                        } 
                    } else {
                            response.sendRedirect("Lista_Usuarios.jsp");
                    }
                
                } catch (IOException | NumberFormatException e) {
                }
                
            break; 
            */ 
            
            /* MI USUARIO
            //MODIFICAR     
            case 'D':
  
                try {
                    
                    mod= new Modelo_Usuario();

                    // LLENO CON LOS DATOS ENVIADOS POR EL FORMULARIO
                    usuario= new Usuario();

                    usuario.setId_usuario(Integer.parseInt(request.getParameter("txtId")));
                    
                    usuario.setNombres_usuario(request.getParameter("txtNombres"));
                    usuario.setApellidos_usuario(request.getParameter("txtApellidos"));
                    usuario.setCorreo_usuario(request.getParameter("txtCorreo"));
                    usuario.setTelefono_usuario(Integer.parseInt(request.getParameter("txtTelefono")));
                    usuario.setCodigo_usuario(request.getParameter("txtCodigo"));
                    usuario.setContra_usuario(request.getParameter("txtContra"));
                    usuario.setTipo_usuario(Integer.parseInt(request.getParameter("txtTipo")));
                    usuario.setEstado_usuario(Integer.parseInt(request.getParameter("txtEstado")));

                    if(request.getParameter("actualiza")!=null){
                        if(request.getParameter("actualiza").equals("actualiza")){

                            session.setAttribute("idCUENTA", String.valueOf(usuario.getId_usuario()));
                            session.setAttribute("nombresCUENTA", usuario.getNombres_usuario());
                            session.setAttribute("apellidosCUENTA", usuario.getApellidos_usuario());
                            session.setAttribute("correoCUENTA", usuario.getCorreo_usuario());
                            session.setAttribute("telefonoCUENTA", String.valueOf(usuario.getTelefono_usuario()));
                            session.setAttribute("codigoCUENTA", usuario.getCodigo_usuario());
                            session.setAttribute("contraCUENTA", usuario.getContra_usuario());
                            session.setAttribute("tipoCUENTA", usuario.getTipo_usuario());
                            session.setAttribute("estadoCUENTA", usuario.getEstado_usuario()); 
                        }    
                    }
                    
                    mod.modificarUsuario(usuario,Integer.parseInt(request.getParameter("txtCargo")));
                    
                    if(request.getParameter("actualiza")!=null){
                        if(request.getParameter("actualiza").equals("actualiza")){
                            response.sendRedirect("Inicio.jsp");
                        } 
                    } else {
                            response.sendRedirect("Lista_Usuarios.jsp");
                    }
                
                } catch (IOException | NumberFormatException e) {
                }
                
            break; 
            */
                

            // INHABILITAR
            case 'E':
            
                try {
                
                    mod= new Modelo_Usuario();

                    int c=0;
                    
                    if(request.getParameter("estado").equals("Activo"))
                        c=1;
                    else if(request.getParameter("estado").equals("Inactivo"))
                        c=0;
                    
                    mod.cambiarEstado(c,Integer.parseInt(request.getParameter("txtId")));
                    
                    response.sendRedirect("Lista_Usuarios.jsp");
                
                } catch (IOException | NumberFormatException e) {
                }
                
                break;
                
                default: 
                    out.print("Opción No Disponible");
                break;
            
            }
            
        }
        
    }
    
    
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
