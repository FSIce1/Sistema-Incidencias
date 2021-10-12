package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Login_005fRegistro_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      java.lang.String USUARIO = null;
      synchronized (request) {
        USUARIO = (java.lang.String) _jspx_page_context.getAttribute("USUARIO", PageContext.REQUEST_SCOPE);
        if (USUARIO == null){
          USUARIO = new java.lang.String();
          _jspx_page_context.setAttribute("USUARIO", USUARIO, PageContext.REQUEST_SCOPE);
        }
      }
      out.write('\n');
      java.lang.String ALERTA = null;
      synchronized (request) {
        ALERTA = (java.lang.String) _jspx_page_context.getAttribute("ALERTA", PageContext.REQUEST_SCOPE);
        if (ALERTA == null){
          ALERTA = new java.lang.String();
          _jspx_page_context.setAttribute("ALERTA", ALERTA, PageContext.REQUEST_SCOPE);
        }
      }
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    \n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        \n");
      out.write("        <title>\n");
      out.write("            Login - InciApp v1\n");
      out.write("        </title>\n");
      out.write("        \n");
      out.write("        <!--\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        -->\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <!--\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n");
      out.write("        -->\n");
      out.write("        \n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no, user-scalable=no, minimal-ui\">\n");
      out.write("        <!-- Call App Mode on ios devices -->\n");
      out.write("        <meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />\n");
      out.write("        <!-- Remove Tap Highlight on Windows Phone IE -->\n");
      out.write("        <meta name=\"msapplication-tap-highlight\" content=\"no\">\n");
      out.write("        <!-- base css -->\n");
      out.write("        <link rel=\"stylesheet\" media=\"screen, print\" href=\"css/vendors.bundle.css\">\n");
      out.write("        <link rel=\"stylesheet\" media=\"screen, print\" href=\"css/app.bundle.css\">\n");
      out.write("        <!-- Place favicon.ico in the root directory -->\n");
      out.write("        <link rel=\"apple-touch-icon\" sizes=\"180x180\" href=\"img/favicon/apple-touch-icon.png\">\n");
      out.write("        <link rel=\"icon\" type=\"image/png\" sizes=\"32x32\" href=\"img/favicon/favicon-32x32.png\">\n");
      out.write("        <link rel=\"mask-icon\" href=\"img/favicon/safari-pinned-tab.svg\" color=\"#5bbad5\">\n");
      out.write("        <!-- Optional: page related CSS-->\n");
      out.write("        <link rel=\"stylesheet\" media=\"screen, print\" href=\"css/fa-brands.css\">\n");
      out.write("        \n");
      out.write("        <!-- NOTIFICACIONES -->\n");
      out.write("        <link rel=\"stylesheet\" media=\"screen, print\" href=\"css/notifications/toastr/toastr.css\">\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"page-wrapper\">\n");
      out.write("            <div class=\"page-inner bg-brand-gradient\">\n");
      out.write("                <div class=\"page-content-wrapper bg-transparent m-0\">\n");
      out.write("                    <div class=\"height-10 w-100 shadow-lg px-4 bg-brand-gradient\">\n");
      out.write("                        <div class=\"d-flex align-items-center container p-0\">\n");
      out.write("                            <div class=\"page-logo width-mobile-auto m-0 align-items-center justify-content-center p-0 bg-transparent bg-img-none shadow-0 height-9\">\n");
      out.write("                                <a href=\"javascript:void(0)\" class=\"page-logo-link press-scale-down d-flex align-items-center\">\n");
      out.write("                                    <img style=\"border-radius: 50%\" src=\"img/logo.jpg\" alt=\"InciApp\" aria-roledescription=\"logo\">\n");
      out.write("                                    <span class=\"page-logo-text mr-1\">InciApp</span>\n");
      out.write("                                </a>\n");
      out.write("                            </div>\n");
      out.write("                            <span class=\"text-white opacity-50 ml-auto mr-2 hidden-sm-down\">\n");
      out.write("                                ¿Ya eres usuario?\n");
      out.write("                            </span>\n");
      out.write("                            <a href=\"Login_Inicio.jsp\" class=\"btn-link text-white ml-auto ml-sm-0\">\n");
      out.write("                                Inicio de sesión\n");
      out.write("                            </a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"flex-1\" style=\"background: url(img/svg/pattern-1.svg) no-repeat center bottom fixed; background-size: cover;\">\n");
      out.write("                        <div class=\"container py-4 py-lg-5 my-lg-5 px-4 px-sm-0\">\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-xl-12\">\n");
      out.write("                                    <h2 class=\"fs-xxl fw-500 mt-4 text-white text-center\">\n");
      out.write("                                            Regístrese ahora, ¡es gratis!\n");
      out.write("                                        <small class=\"h3 fw-300 mt-3 mb-5 text-white opacity-60 hidden-sm-down\">\n");
      out.write("                                            El regsitro de nuestro sistema de inicidencias es gratis\n");
      out.write("                                        </small>\n");
      out.write("                                    </h2>\n");
      out.write("                                </div>\n");
      out.write("                                \n");
      out.write("                                <div class=\"col-xl-6 ml-auto mr-auto\">\n");
      out.write("                                    <div class=\"card p-4 rounded-plus bg-faded\">\n");
      out.write("                                        <!--\n");
      out.write("                                        <div class=\"alert alert-primary text-dark\" role=\"alert\">\n");
      out.write("                                            <strong>Heads Up!</strong> Due to server maintenance from 9:30GTA to 12GTA, the verification emails could be delayed by up to 10 minutes.\n");
      out.write("                                        </div>\n");
      out.write("                                        -->\n");
      out.write("                                        \n");
      out.write("                                        <form class=\"form\" method=\"post\" autocomplete=\"off\" action=\"Controlador_Usuario\">\n");
      out.write("                                            \n");
      out.write("                                            <input type=\"hidden\" name=\"opcion\" value=\"I\">\n");
      out.write("                                            \n");
      out.write("                                            <div class=\"form-group row\">\n");
      out.write("                                                <label class=\"col-xl-12 form-label\" for=\"fname\">Nombres Completos</label>\n");
      out.write("                                                \n");
      out.write("                                                <div class=\"col-6 pr-1\">\n");
      out.write("                                                    <input type=\"text\" id=\"txtNombres\" name=\"txtNombres\" maxlength=\"20\" class=\"form-control\" placeholder=\"Nombres\" required>\n");
      out.write("                                                    <div class=\"invalid-feedback\">No, you missed this one.</div>\n");
      out.write("                                                </div>\n");
      out.write("                                                \n");
      out.write("                                                <div class=\"col-6 pl-1\">\n");
      out.write("                                                    <input type=\"text\" id=\"txtApellidos\" name=\"txtApellidos\" maxlength=\"20\" class=\"form-control\" placeholder=\"Apellidos\" required>\n");
      out.write("                                                    <div class=\"invalid-feedback\">No, you missed this one.</div>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                            \n");
      out.write("                                            <div class=\"form-group row\">\n");
      out.write("                                                \n");
      out.write("                                                <div class=\"col-6 pr-1\">\n");
      out.write("                                                    <label class=\"form-label\" for=\"txtCorreo\">Email</label>\n");
      out.write("                                                    <input type=\"email\" id=\"txtCorreo\" name=\"txtCorreo\" maxlength=\"50\" class=\"form-control\" placeholder=\"Ejemplo: rodolfo12@gmail.com\" required>\n");
      out.write("                                                    <div class=\"invalid-feedback\">No, you missed this one.</div>\n");
      out.write("                                                </div>\n");
      out.write("                                                \n");
      out.write("                                                <div class=\"col-6 pr-1\">\n");
      out.write("                                                    <label class=\"form-label\" for=\"txtTelefono\">Teléfono</label>\n");
      out.write("                                                    <input type=\"text\" onkeyup=\"limpiarNumero(this)\" onchange=\"limpiarNumero(this)\" id=\"txtTelefono\" name=\"txtTelefono\" maxlength=\"9\" class=\"form-control\" placeholder=\"Ejemplo: 965423112\" required>\n");
      out.write("                                                    <div class=\"invalid-feedback\">No, you missed this one.</div>\n");
      out.write("                                                </div>\n");
      out.write("                                                \n");
      out.write("                                            </div>\n");
      out.write("                                            \n");
      out.write("                                            <div class=\"form-group row\">\n");
      out.write("                                                \n");
      out.write("                                                <div class=\"col-12 pr-1\">\n");
      out.write("                                                    <label class=\"form-label\" for=\"txtCodigo\">Usuario</label>\n");
      out.write("                                                    <input type=\"text\" id=\"txtCodigo\" name=\"txtCodigo\" maxlength=\"30\" class=\"form-control\" placeholder=\"Ejemplo: Juanito12\" required>\n");
      out.write("                                                    <div class=\"invalid-feedback\">No, you missed this one.</div>\n");
      out.write("                                                </div>\n");
      out.write("                                                \n");
      out.write("                                            </div>\n");
      out.write("                                            \n");
      out.write("                                            <div class=\"form-group row\">\n");
      out.write("                                                \n");
      out.write("                                                <div class=\"col-12 pr-1\">\n");
      out.write("                                                    <label class=\"form-label\" for=\"txtContra\">Contraseña</label>\n");
      out.write("                                                    <input type=\"password\" id=\"txtContra\" name=\"txtContra\" maxlength=\"30\" class=\"form-control\" placeholder=\"Ejemplo: cuchara123\" required>\n");
      out.write("                                                    <div class=\"invalid-feedback\">No, you missed this one.</div>\n");
      out.write("                                                </div>\n");
      out.write("                                                \n");
      out.write("                                            </div>\n");
      out.write("                                            \n");
      out.write("                                            <!--\n");
      out.write("                                            <div class=\"form-group demo\">\n");
      out.write("                                                <div class=\"custom-control custom-checkbox\">\n");
      out.write("                                                    <input type=\"checkbox\" class=\"custom-control-input\" id=\"terms\" required>\n");
      out.write("                                                    <label class=\"custom-control-label\" for=\"terms\"> I agree to terms & conditions</label>\n");
      out.write("                                                    <div class=\"invalid-feedback\">You must agree before proceeding</div>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                            -->\n");
      out.write("                                            \n");
      out.write("                                            <div class=\"row no-gutters\">\n");
      out.write("                                                <div class=\"col-md-4 ml-auto text-right\">\n");
      out.write("                                                    <button id=\"js-login-btn\" type=\"submit\" class=\"btn btn-block btn-dark btn-lg mt-3\">Registrar</button>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                            \n");
      out.write("                                        </form>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"position-absolute pos-bottom pos-left pos-right p-3 text-center text-white\">\n");
      out.write("                            2021 © InciApp &nbsp; Todos los derechos reservados.\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <script src=\"js/vendors.bundle.js\"></script>\n");
      out.write("        <script src=\"js/app.bundle.js\"></script>\n");
      out.write("        \n");
      out.write("        <!-- SCRIPTS DE NOTIFICACION -->\n");
      out.write("        <script src=\"js/notifications/toastr/toastr.js\"></script>\n");
      out.write("        \n");
      out.write("        <script>\n");
      out.write("            toastr.options = {\n");
      out.write("                \"closeButton\": false,\n");
      out.write("                \"debug\": false,\n");
      out.write("                \"newestOnTop\": false,\n");
      out.write("                \"progressBar\": true,\n");
      out.write("                \"preventDuplicates\": true,\n");
      out.write("                \"onclick\": null,\n");
      out.write("                \"showDuration\": \"100\",\n");
      out.write("                \"hideDuration\": \"1000\",\n");
      out.write("                \"timeOut\": \"5000\",\n");
      out.write("                \"extendedTimeOut\": \"1000\",\n");
      out.write("                \"showEasing\": \"swing\",\n");
      out.write("                \"hideEasing\": \"linear\",\n");
      out.write("                \"showMethod\": \"show\",\n");
      out.write("                \"hideMethod\": \"hide\"\n");
      out.write("            };\n");
      out.write("        </script>\n");
      out.write("        \n");
      out.write("        ");

            if(ALERTA!=null){
                if(ALERTA.equals("EXISTE_EMAIL")){
                    
      out.write("\n");
      out.write("                    <script>\n");
      out.write("                        toastr.info('Este email ya existe');\n");
      out.write("                    </script>\n");
      out.write("                    ");

                } else if(ALERTA.equals("EXISTE_USUARIO")){
                    
      out.write("\n");
      out.write("                    <script>\n");
      out.write("                        toastr.info('Este usuario ya existe');\n");
      out.write("                    </script>\n");
      out.write("                    ");

                } else if(ALERTA.equals("INGRESADO")){
                    
      out.write("\n");
      out.write("                    <script>\n");
      out.write("                        toastr.success('Usuario ingresado correctamente');\n");
      out.write("                    </script>\n");
      out.write("                    ");

                } else if(ALERTA.equals("NO_INGRESADO")){
                    
      out.write("\n");
      out.write("                    <script>                        \n");
      out.write("                        toastr.info('Usuario no ingresado');\n");
      out.write("                    </script>\n");
      out.write("                    ");

                } else if(ALERTA.equals("ERROR")){
                    
      out.write("\n");
      out.write("                    <script>\n");
      out.write("                        toastr.error('Ups! Error Interno, intente nuevamente');\n");
      out.write("                    </script>\n");
      out.write("                    ");

                }
            }
        
      out.write("\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            function limpiarNumero(obj) {\n");
      out.write("                /* El evento \"change\" sólo saltará si son diferentes */\n");
      out.write("                obj.value = obj.value.replace(/\\D/g, '');\n");
      out.write("              }\n");
      out.write("        </script>\n");
      out.write("        \n");
      out.write("        <script>\n");
      out.write("            $(\"#js-login-btn\").click(function(event)\n");
      out.write("            {\n");
      out.write("\n");
      out.write("                // Fetch form to apply custom Bootstrap validation\n");
      out.write("                var form = $(\"#js-login\")\n");
      out.write("\n");
      out.write("                if (form[0].checkValidity() === false)\n");
      out.write("                {\n");
      out.write("                    event.preventDefault()\n");
      out.write("                    event.stopPropagation()\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                form.addClass('was-validated');\n");
      out.write("                // Perform ajax submit here...\n");
      out.write("            });\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
