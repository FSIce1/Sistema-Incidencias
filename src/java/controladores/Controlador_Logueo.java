
package controladores;

import beans.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelos.Modelo_Usuario;

@WebServlet(name = "Controlador_Logueo", urlPatterns = {"/Controlador_Logueo"})
public class Controlador_Logueo extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            
            Modelo_Usuario mod;
            
            switch(request.getParameter("opcion").charAt(0)){
            
            // MANDAR AL ERROR   
            case 'L': 
                request.getRequestDispatcher("404.html").forward(request, response);
            break;    
                
            // MANDAR AL LOGIN DE INICIO
            case 'S': 
                response.sendRedirect("Login_Inicio.jsp");
            break;    
                
            // CUANDO LA SESIÓN ACABA
            case 'Y': 
                request.getRequestDispatcher("SesionExpirada.html").forward(request, response);
            break;    
                  
            // INGRESA AL INICIO
            case 'E': 
                request.getRequestDispatcher("Inicio.jsp").forward(request, response);
            break;
            
            //LOGUEARSE   
            case 'I': 
                
                try {
                    
                    mod= new Modelo_Usuario();

                    String usu = request.getParameter("usuario123");
                    String contraseña = request.getParameter("contra123");

                    if(mod.existe(usu, "","")==1){ // EXISTE EL USUARIO

                        if(mod.existe(usu, "",contraseña)==1){ // INICIAMOS SESIÓN

                            HttpSession ses = request.getSession(true);

                            //ses.setMaxInactiveInterval(720);

                            Usuario usuario = Modelo_Usuario.buscaUsuario(usu, contraseña);
                            
                            ses.setAttribute("idCUENTA", String.valueOf(usuario.getId_usuario()));
                            ses.setAttribute("nombresCUENTA", usuario.getNombres_usuario());
                            ses.setAttribute("apellidosCUENTA", usuario.getApellidos_usuario());
                            ses.setAttribute("correoCUENTA", usuario.getCorreo_usuario());
                            ses.setAttribute("telefonoCUENTA", String.valueOf(usuario.getTelefono_usuario()));
                            ses.setAttribute("codigoCUENTA", usuario.getCodigo_usuario());
                            ses.setAttribute("contraCUENTA", usuario.getContra_usuario());
                            ses.setAttribute("tipoCUENTA", usuario.getTipo_usuario());
                            ses.setAttribute("estadoCUENTA", usuario.getEstado_usuario()); 
                            
                            response.sendRedirect("Perfil.jsp");

                        } else {

                            request.setAttribute("ALERTA", "CONTRA_INCORRECTA");
    //
    //                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Login.jsp");
    //                        dispatcher.forward(request, response);

                            request.getRequestDispatcher("Login_Inicio.jsp").forward(request, response);
                        }
                        
                    } else {
                        
                        request.setAttribute("ALERTA", "NO_EXISTE_USUARIO");

                        request.getRequestDispatcher("Login_Inicio.jsp").forward(request, response);
                        
                    }
                    
                } catch (IOException | NumberFormatException | SQLException | ServletException e) {
                    request.setAttribute("ALERTA", "ERROR");
                    request.getRequestDispatcher("Login_Inicio.jsp").forward(request, response);
                }
                
                                
            break;
            
            // CERRAR SESIÓN
            case 'C': 
                    
                HttpSession s=request.getSession();
                s.invalidate();
                
                response.sendRedirect("Login_Inicio.jsp");
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
