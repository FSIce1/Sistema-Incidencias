
package controladores;

import beans.Informe_Final;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Modelo_Informe;

@WebServlet(name = "Controlador_Informe", urlPatterns = {"/Controlador_Informe"})
public class Controlador_Informe extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
        //request.setCharacterEncoding("UTF-8");

        try (PrintWriter out = response.getWriter()) {
            
            Modelo_Informe mod;
            //HttpSession session = request.getSession();
            
            switch(request.getParameter("opcion").charAt(0)){
                
            // MANDAR A LA LISTA DE INFORME    
            case 'L': 
                
                request.getRequestDispatcher("Lista_Informes.jsp").forward(request, response);

                break;
                
            // INSERTAR INFORME
            case 'I': 
                
                mod= new Modelo_Informe();

                Informe_Final informe;
                
                try {
                
                // LLENO CON LOS DATOS ENVIADOS POR EL FORMULARIO
                informe= new Informe_Final();
                
                informe.setDescripcion(request.getParameter("txtDescripcion"));
                informe.setId_incidente_fk(Integer.parseInt(request.getParameter("txtIncidenteFK")));
                informe.setId_problema_fk(Integer.parseInt(request.getParameter("txtProblemaFK")));
                informe.setId_solucion_fk(Integer.parseInt(request.getParameter("txtSolucionFK")));
                
                if(mod.insertarInforme(informe)==1){
                    request.setAttribute("ALERTA", "INGRESADO");
                } else {
                    request.setAttribute("ALERTA", "NO_INGRESADO");
                }

                request.getRequestDispatcher("Lista_Informes.jsp").forward(request, response);

                } catch (IOException | ServletException e) {
                    request.setAttribute("ALERTA", "ERROR");
                    request.getRequestDispatcher("Lista_Informes.jsp").forward(request, response);
                }
                
            break;
            
            // INSERTAR INFORME
            case 'W': 
                
                mod= new Modelo_Informe();

                Informe_Final informe1;
                
                try {
                
                // LLENO CON LOS DATOS ENVIADOS POR EL FORMULARIO
                informe1= new Informe_Final();
                
                informe1.setDescripcion(request.getParameter("txtDescripcion"));
                informe1.setId_incidente_fk(Integer.parseInt(request.getParameter("txtIncidenteFK")));
                informe1.setId_problema_fk(Integer.parseInt(request.getParameter("txtProblemaFK")));
                informe1.setId_solucion_fk(Integer.parseInt(request.getParameter("txtSolucionFK")));
                
                if(mod.insertarInforme(informe1)==1){
                    request.setAttribute("ALERTA", "INGRESADO");
                } else {
                    request.setAttribute("ALERTA", "NO_INGRESADO");
                }

                request.getRequestDispatcher("Lista_Informes_Propia.jsp").forward(request, response);

                } catch (IOException | ServletException e) {
                    request.setAttribute("ALERTA", "ERROR");
                    request.getRequestDispatcher("Lista_Informes_Propia.jsp").forward(request, response);
                }
                
            break;
                
            // MODIFICAR INCIDENTE
            case 'D': 
                
                mod= new Modelo_Informe();
                
                try {
                
                // LLENO CON LOS DATOS ENVIADOS POR EL FORMULARIO
                informe1= new Informe_Final();
                
                informe1.setDescripcion(request.getParameter("txtDescripcion"));
                informe1.setId_incidente_fk(Integer.parseInt(request.getParameter("txtIncidenteFK")));
                informe1.setId_problema_fk(Integer.parseInt(request.getParameter("txtProblemaFK")));
                informe1.setId_solucion_fk(Integer.parseInt(request.getParameter("txtSolucionFK")));
                
                    System.out.println("TEXT0 = "+informe1.getDescripcion());
                
                if(mod.modificarInforme(informe1)==1){
                    request.setAttribute("ALERTA", "MODIFICADO");
                } else {
                    request.setAttribute("ALERTA", "NO_MODIFICADO");
                }

                
                request.getRequestDispatcher("Lista_Informes.jsp").forward(request, response);

                } catch (IOException | ServletException e) {
                    request.setAttribute("ALERTA", "ERROR");
                    request.getRequestDispatcher("Lista_Informes.jsp").forward(request, response);
                }
                
            break;
            
            // ELIMINAR
            case 'E':
            
                try {
                
                    mod= new Modelo_Informe();

                    //mod.eliminarProblema(Integer.parseInt(request.getParameter("txtId")));
                    
                    if(mod.eliminarInforme(Integer.parseInt(request.getParameter("txtId")))==1){
                        request.setAttribute("ALERTA", "ELIMINADO");
                    } else {
                        request.setAttribute("ALERTA", "NO_ELIMINADO");
                    }
                    
                    request.getRequestDispatcher("Lista_Informes.jsp").forward(request, response);

                    //response.sendRedirect("Lista_Problemas.jsp");
                
                } catch (IOException | NumberFormatException e) {
                    request.setAttribute("ALERTA", "ERROR");
                    request.getRequestDispatcher("Lista_Informes.jsp").forward(request, response);
                }
                
            break;
            
            // ELIMINAR
            case 'Y':
            
                try {
                
                    mod= new Modelo_Informe();

                    //mod.eliminarProblema(Integer.parseInt(request.getParameter("txtId")));
                    
                    if(mod.eliminarInforme(Integer.parseInt(request.getParameter("txtId")))==1){
                        request.setAttribute("ALERTA", "ELIMINADO");
                    } else {
                        request.setAttribute("ALERTA", "NO_ELIMINADO");
                    }
                    
                    request.getRequestDispatcher("Lista_Informes_Propia.jsp").forward(request, response);

                    //response.sendRedirect("Lista_Problemas.jsp");
                
                } catch (IOException | NumberFormatException e) {
                    request.setAttribute("ALERTA", "ERROR");
                    request.getRequestDispatcher("Lista_Informes_Propia.jsp").forward(request, response);
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
