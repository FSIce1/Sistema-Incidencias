
package controladores;

import beans.Solucion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Modelo_Solucion;

@WebServlet(name = "Controlador_Solucion", urlPatterns = {"/Controlador_Solucion"})
public class Controlador_Solución extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
        //request.setCharacterEncoding("UTF-8");

        try (PrintWriter out = response.getWriter()) {
            
            Modelo_Solucion mod;
            //HttpSession session = request.getSession();
            
            switch(request.getParameter("opcion").charAt(0)){
                
            // MANDAR A LA LISTA DE SOLUCIONES    
            case 'L': 
                
                request.getRequestDispatcher("Lista_Soluciones.jsp").forward(request, response);

                break;
                
            // INSERTAR SOLUCION
            case 'I': 
                
                mod= new Modelo_Solucion();

                Solucion solucion;
                
                try {
                
                // LLENO CON LOS DATOS ENVIADOS POR EL FORMULARIO
                solucion= new Solucion();
                
                solucion.setCodigo_solucion(request.getParameter("txtCodigo"));
                
                solucion.setDescripcion_solucion(request.getParameter("txtDescripcion"));
                //problema.setDescripcion_problema(URLDecoder.decode(request.getParameter("txtDescripcion"), "UTF-8"));
                
                int existe=mod.existe(request.getParameter("txtCodigo"));
                
                if(existe==1){ // EXISTE EL PROBLEMA
                    request.setAttribute("ALERTA", "EXISTE_PROBLEMA");
                } else {

                    if(mod.insertarSolucion(solucion)==1){
                        request.setAttribute("ALERTA", "INGRESADO");
                    } else {
                        request.setAttribute("ALERTA", "NO_INGRESADO");
                    }

                }    
                
                request.getRequestDispatcher("Lista_Soluciones.jsp").forward(request, response);

                } catch (IOException | ServletException e) {
                    request.setAttribute("ALERTA", "ERROR");
                    request.getRequestDispatcher("Lista_Soluciones.jsp").forward(request, response);
                }
                
            break;
                
            // MODIFICAR SOLUCION
            case 'D': 
                
                mod= new Modelo_Solucion();

                //Problema problema;
                
                try {
                
                // LLENO CON LOS DATOS ENVIADOS POR EL FORMULARIO
                solucion= new Solucion();
                
                solucion.setId_solucion(Integer.parseInt(request.getParameter("txtId")));
                solucion.setCodigo_solucion(request.getParameter("txtCodigo"));
                
                solucion.setDescripcion_solucion(request.getParameter("txtDescripcion"));
                //problema.setDescripcion_problema(URLDecoder.decode(request.getParameter("txtDescripcion"), "UTF-8"));
                    
                int existe=0;
                
                if(request.getParameter("txtCodigoAntiguo").equals(solucion.getCodigo_solucion())){
                    existe = 0;
                } else {
                    existe=mod.existe(request.getParameter("txtCodigo"));
                }
                
                if(existe==1){ // EXISTE EL PROBLEMA
                    request.setAttribute("ALERTA", "EXISTE_PROBLEMA");
                } else {

                    if(mod.modificarSolucion(solucion)==1){
                        request.setAttribute("ALERTA", "MODIFICADO");
                    } else {
                        request.setAttribute("ALERTA", "NO_MODIFICADO");
                    }

                }    
                
                request.getRequestDispatcher("Lista_Soluciones.jsp").forward(request, response);

                } catch (IOException | ServletException e) {
                    request.setAttribute("ALERTA", "ERROR");
                    request.getRequestDispatcher("Lista_Soluciones.jsp").forward(request, response);
                }
                
            break;
                
            // ELIMINAR SOLUCION
            case 'E':
            
                try {
                
                    mod= new Modelo_Solucion();

                    //mod.eliminarProblema(Integer.parseInt(request.getParameter("txtId")));
                    
                    if(mod.eliminarSolucion(Integer.parseInt(request.getParameter("txtId")))==1){
                        request.setAttribute("ALERTA", "ELIMINADO");
                    } else {
                        request.setAttribute("ALERTA", "NO_ELIMINADO");
                    }
                    
                    request.getRequestDispatcher("Lista_Soluciones.jsp").forward(request, response);

                    //response.sendRedirect("Lista_Problemas.jsp");
                
                } catch (IOException | NumberFormatException e) {
                    request.setAttribute("ALERTA", "ERROR");
                    request.getRequestDispatcher("Lista_Soluciones.jsp").forward(request, response);
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
