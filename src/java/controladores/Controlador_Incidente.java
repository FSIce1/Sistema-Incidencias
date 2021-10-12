
package controladores;

import beans.Incidente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Modelo_Incidente;

@WebServlet(name = "Controlador_Incidente", urlPatterns = {"/Controlador_Incidente"})
public class Controlador_Incidente extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
        //request.setCharacterEncoding("UTF-8");

        try (PrintWriter out = response.getWriter()) {
            
            Modelo_Incidente mod;
            //HttpSession session = request.getSession();
            
            switch(request.getParameter("opcion").charAt(0)){
                
            // MANDAR A LA LISTA DE INCIDENTES    
            case 'L': 
                
                request.getRequestDispatcher("Lista_Incidentes.jsp").forward(request, response);

                break;
                
            // INSERTAR INCIDENTE
            case 'I': 
                
                mod= new Modelo_Incidente();

                Incidente incidente;
                
                try {
                
                // LLENO CON LOS DATOS ENVIADOS POR EL FORMULARIO
                incidente= new Incidente();
                
                incidente.setCodigo_incidente(request.getParameter("txtCodigo"));
                incidente.setDescripcion_incidente(request.getParameter("txtDescripcion"));
                incidente.setEstado_incidente(Integer.parseInt(request.getParameter("txtEstado")));
                incidente.setCalificacion_incidente(Integer.parseInt(request.getParameter("txtCalificacion")));
                
                incidente.setId_usuario_fk(Integer.parseInt(request.getParameter("txtUsuarioFK")));
                //incidente.setId_usuario_fk(1);
                
                
                int existe=mod.existe(request.getParameter("txtCodigo"));
                
                if(existe==1){ // EXISTE EL CODIGO
                    request.setAttribute("ALERTA", "EXISTE_CODIGO");
                } else {

                    if(mod.insertarIncidente(incidente)==1){
                        request.setAttribute("ALERTA", "INGRESADO");
                    } else {
                        request.setAttribute("ALERTA", "NO_INGRESADO");
                    }

                }    
                
                request.getRequestDispatcher("Lista_Incidentes.jsp").forward(request, response);

                } catch (IOException | ServletException e) {
                    request.setAttribute("ALERTA", "ERROR");
                    request.getRequestDispatcher("Lista_Incidentes.jsp").forward(request, response);
                }
                
            break;
                
            // MODIFICAR INCIDENTE
            case 'D': 
                
                mod= new Modelo_Incidente();

                //Problema problema;
                
                try {
                
                // LLENO CON LOS DATOS ENVIADOS POR EL FORMULARIO
                incidente= new Incidente();
                
                incidente.setId_incidente(Integer.parseInt(request.getParameter("txtId")));
                
                incidente.setCodigo_incidente(request.getParameter("txtCodigo"));
                incidente.setDescripcion_incidente(request.getParameter("txtDescripcion"));
                incidente.setEstado_incidente(Integer.parseInt(request.getParameter("txtEstado")));
                incidente.setCalificacion_incidente(Integer.parseInt(request.getParameter("txtCalificacion")));
                
                incidente.setId_usuario_fk(Integer.parseInt(request.getParameter("txtUsuarioFK")));
                //incidente.setId_usuario_fk(1);
                
                    System.out.println("ID: "+request.getParameter("txtId"));
                    System.out.println("CODIGO: "+request.getParameter("txtCodigo"));
                    System.out.println("ESTADO: "+request.getParameter("txtEstado"));
                    System.out.println("CALI: "+request.getParameter("txtCalificacion"));
                    System.out.println("USU: "+request.getParameter("txtIdUsuario"));
                
                int existe=0;
                
                if(request.getParameter("txtCodigoAntiguo").equals(incidente.getCodigo_incidente())){
                    existe = 0;
                } else {
                    existe=mod.existe(request.getParameter("txtCodigo"));
                }
                
                if(existe==1){ // EXISTE EL CODIGO
                    request.setAttribute("ALERTA", "EXISTE_CODIGO");
                } else {

                    if(mod.modificarIncidente(incidente)==1){
                        request.setAttribute("ALERTA", "MODIFICADO");
                    } else {
                        request.setAttribute("ALERTA", "NO_MODIFICADO");
                    }

                }    
                
                request.getRequestDispatcher("Lista_Incidentes.jsp").forward(request, response);

                } catch (IOException | ServletException e) {
                    request.setAttribute("ALERTA", "ERROR");
                    request.getRequestDispatcher("Lista_Incidentes.jsp").forward(request, response);
                }
                
            break;
            
            // ELIMINAR
            case 'E':
            
                try {
                
                    mod= new Modelo_Incidente();

                    //mod.eliminarProblema(Integer.parseInt(request.getParameter("txtId")));
                    
                    if(mod.eliminarIncidente(Integer.parseInt(request.getParameter("txtId")))==1){
                        request.setAttribute("ALERTA", "ELIMINADO");
                    } else {
                        request.setAttribute("ALERTA", "NO_ELIMINADO");
                    }
                    
                    request.getRequestDispatcher("Lista_Incidentes.jsp").forward(request, response);

                    //response.sendRedirect("Lista_Problemas.jsp");
                
                } catch (IOException | NumberFormatException e) {
                    request.setAttribute("ALERTA", "ERROR");
                    request.getRequestDispatcher("Lista_Incidentes.jsp").forward(request, response);
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
