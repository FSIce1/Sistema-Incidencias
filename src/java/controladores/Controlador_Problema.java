
package controladores;

import beans.Problema;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Modelo_Problema;

@WebServlet(name = "Controlador_Problema", urlPatterns = {"/Controlador_Problema"})
public class Controlador_Problema extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
        //request.setCharacterEncoding("UTF-8");

        try (PrintWriter out = response.getWriter()) {
            
            Modelo_Problema mod;
            //HttpSession session = request.getSession();
            
            switch(request.getParameter("opcion").charAt(0)){
                
            // MANDAR A LA LISTA DE PROBLEMAS    
            case 'L': 
                
                request.getRequestDispatcher("Lista_Problemas.jsp").forward(request, response);

                break;
                
            // INSERTAR PROBLEMA
            case 'I': 
                
                mod= new Modelo_Problema();

                Problema problema;
                
                try {
                
                // LLENO CON LOS DATOS ENVIADOS POR EL FORMULARIO
                problema= new Problema();
                
                problema.setCodigo_problema(request.getParameter("txtCodigo"));
                
                problema.setDescripcion_problema(request.getParameter("txtDescripcion"));
                //problema.setDescripcion_problema(URLDecoder.decode(request.getParameter("txtDescripcion"), "UTF-8"));
                problema.setPrioridad_problema(Integer.parseInt(request.getParameter("txtPrioridad")));
                
                
                int existe=mod.existe(request.getParameter("txtCodigo"));
                
                if(existe==1){ // EXISTE EL CODIGO
                    request.setAttribute("ALERTA", "EXISTE_PROBLEMA");
                } else {

                    if(mod.insertarProblema(problema)==1){
                        request.setAttribute("ALERTA", "INGRESADO");
                    } else {
                        request.setAttribute("ALERTA", "NO_INGRESADO");
                    }

                }    
                
                request.getRequestDispatcher("Lista_Problemas.jsp").forward(request, response);

                } catch (IOException | ServletException e) {
                    request.setAttribute("ALERTA", "ERROR");
                    request.getRequestDispatcher("Lista_Problemas.jsp").forward(request, response);
                }
                
            break;
                
            // MODIFICAR PROBLEMA
            case 'D': 
                
                mod= new Modelo_Problema();

                //Problema problema;
                
                try {
                
                // LLENO CON LOS DATOS ENVIADOS POR EL FORMULARIO
                problema= new Problema();
                
                problema.setId_problema(Integer.parseInt(request.getParameter("txtId")));
                problema.setCodigo_problema(request.getParameter("txtCodigo"));
                
                problema.setDescripcion_problema(request.getParameter("txtDescripcion"));
                //problema.setDescripcion_problema(URLDecoder.decode(request.getParameter("txtDescripcion"), "UTF-8"));
                problema.setPrioridad_problema(Integer.parseInt(request.getParameter("txtPrioridad")));

                int existe=0;
                
                if(request.getParameter("txtCodigoAntiguo").equals(problema.getCodigo_problema())){
                    existe = 0;
                } else {
                    existe=mod.existe(request.getParameter("txtCodigo"));
                }
                
                if(existe==1){ // EXISTE EL PROBLEMA
                    request.setAttribute("ALERTA", "EXISTE_PROBLEMA");
                } else {

                    if(mod.modificarProblema(problema)==1){
                        request.setAttribute("ALERTA", "MODIFICADO");
                    } else {
                        request.setAttribute("ALERTA", "NO_MODIFICADO");
                    }

                }    
                
                request.getRequestDispatcher("Lista_Problemas.jsp").forward(request, response);

                } catch (IOException | ServletException e) {
                    request.setAttribute("ALERTA", "ERROR");
                    request.getRequestDispatcher("Lista_Problemas.jsp").forward(request, response);
                }
                
            break;
                
            /*
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

            // ELIMINAR
            case 'E':
            
                try {
                
                    mod= new Modelo_Problema();

                    //mod.eliminarProblema(Integer.parseInt(request.getParameter("txtId")));
                    
                    if(mod.eliminarProblema(Integer.parseInt(request.getParameter("txtId")))==1){
                        request.setAttribute("ALERTA", "ELIMINADO");
                    } else {
                        request.setAttribute("ALERTA", "NO_ELIMINADO");
                    }
                    
                    request.getRequestDispatcher("Lista_Problemas.jsp").forward(request, response);

                    //response.sendRedirect("Lista_Problemas.jsp");
                
                } catch (IOException | NumberFormatException e) {
                    request.setAttribute("ALERTA", "ERROR");
                    request.getRequestDispatcher("Lista_Problemas.jsp").forward(request, response);
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
