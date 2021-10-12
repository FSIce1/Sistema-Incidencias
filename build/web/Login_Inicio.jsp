
<jsp:useBean id="ALERTA" scope="request" class="java.lang.String"></jsp:useBean>
    
<%@ page contentType="text/html; charset=UTF-8" %>
    
<!DOCTYPE html>

<html lang="en">
    <head>
        
        <title>
            Login - InciApp v1
        </title>
        
        <!--
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        -->
        
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no, user-scalable=no, minimal-ui">
        <!-- Call App Mode on ios devices -->
        <meta name="apple-mobile-web-app-capable" content="yes" />
        <!-- Remove Tap Highlight on Windows Phone IE -->
        <meta name="msapplication-tap-highlight" content="no">
        <!-- base css -->
        <link rel="stylesheet" media="screen, print" href="css/vendors.bundle.css">
        <link rel="stylesheet" media="screen, print" href="css/app.bundle.css">
        <!-- Place favicon.ico in the root directory -->
        <link rel="apple-touch-icon" sizes="180x180" href="img/favicon/apple-touch-icon.png">
        <link rel="icon" type="image/png" sizes="32x32" href="img/favicon/favicon-32x32.png">
        <link rel="mask-icon" href="img/favicon/safari-pinned-tab.svg" color="#5bbad5">
        <!-- Optional: page related CSS-->
        <link rel="stylesheet" media="screen, print" href="css/fa-brands.css">
        
        <!-- NOTIFICACIONES -->
        <link rel="stylesheet" media="screen, print" href="css/notifications/toastr/toastr.css">
        
    </head>
    <body>
        <div class="page-wrapper">
            <div class="page-inner bg-brand-gradient">
                
                <div class="page-content-wrapper bg-transparent m-0">
                    <div class="height-10 w-100 shadow-lg px-4 bg-brand-gradient">
                        <div class="d-flex align-items-center container p-0">
                            <div class="page-logo width-mobile-auto m-0 align-items-center justify-content-center p-0 bg-transparent bg-img-none shadow-0 height-9">
                                <a href="javascript:void(0)" class="page-logo-link press-scale-down d-flex align-items-center">
                                    <img src="img/logo.jpg" style="border-radius: 50%" alt="InciApp" aria-roledescription="logo">
                                    <span class="page-logo-text mr-1">InciApp</span>
                                </a>
                            </div>
                            <a href="Login_Registro.jsp" class="btn-link text-white ml-auto">
                                Crear nueva cuenta
                            </a>
                        </div>
                    </div>
                    
                    <div class="flex-1" style="background: url(img/svg/pattern-1.svg) no-repeat center bottom fixed; background-size: cover;">
                        <div class="container py-4 py-lg-5 my-lg-5 px-4 px-sm-0">
                            <div class="row">
                                <div class="col col-md-6 col-lg-7 hidden-sm-down">
                                    <h2 class="fs-xxl fw-500 mt-4 text-white">
                                        Sistema de incidencias
                                        <small class="h3 fw-300 mt-3 mb-5 text-white opacity-60">
                                            Este sistema de seguimiento de incidentes es un paquete de software que administra y mantiene listas de incidentes
                                        </small>
                                    </h2>
                                    <a href="#" class="fs-lg fw-500 text-white opacity-70">Ver demo &gt;&gt;</a>
                                    
                                    <!-- REDES SOCIALES 
                                    <div class="d-sm-flex flex-column align-items-center justify-content-center d-md-block">
                                        <div class="px-0 py-1 mt-5 text-white fs-nano opacity-50">
                                            Find us on social media
                                        </div>
                                        <div class="d-flex flex-row opacity-70">
                                            <a href="#" class="mr-2 fs-xxl text-white">
                                                <i class="fab fa-facebook-square"></i>
                                            </a>
                                            <a href="#" class="mr-2 fs-xxl text-white">
                                                <i class="fab fa-twitter-square"></i>
                                            </a>
                                            <a href="#" class="mr-2 fs-xxl text-white">
                                                <i class="fab fa-google-plus-square"></i>
                                            </a>
                                            <a href="#" class="mr-2 fs-xxl text-white">
                                                <i class="fab fa-linkedin"></i>
                                            </a>
                                        </div>
                                    </div>
                                    -->
                                    
                                </div>
                                <div class="col-sm-12 col-md-6 col-lg-5 col-xl-4 ml-auto">
                                    
                                    <div class="card p-4 rounded-plus bg-faded">
                                        
                                        <form class="form" method="post" autocomplete="on" action="Controlador_Logueo">
                                            
                                            <input type="hidden" name="opcion" value="I">
                                            
                                            <div class="form-group">
                                                <label class="form-label" for="usuario123">Usuario</label>
                                                <input type="text" id="usuario123" name="usuario123" maxlength="30" class="form-control form-control-lg" placeholder="Ingrese su nombre de usuario" value="" required>
                                                <div class="help-block">Ingrese un usuario único</div>
                                            </div>
                                            
                                            <div class="form-group">
                                                <label class="form-label" for="contra123">Contraseña</label>
                                                <input type="password" id="contra123" name="contra123" maxlength="30" class="form-control form-control-lg" placeholder="Ingrese su contraseña" value="" required>
                                            </div>
                                            
                                            <div class="row no-gutters">
                                                <div class="col-lg-12 pr-lg-1 my-2">
                                                    <button type="submit" class="btn btn-info btn-block btn-lg">Entrar</button>
                                                </div>
                                            </div>
                                            
                                        </form>
                                        
                                    </div>
                                </div>
                            </div>
                            <div class="position-absolute pos-bottom pos-left pos-right p-3 text-center text-white">
                                2021 © InciApp &nbsp; Todos los derechos reservados.
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <script src="js/vendors.bundle.js"></script>
        <script src="js/app.bundle.js"></script>
        
        <!-- SCRIPTS DE NOTIFICACION -->
        <script src="js/notifications/toastr/toastr.js"></script>
        
        <script>
            toastr.options = {
                "closeButton": false,
                "debug": false,
                "newestOnTop": false,
                "progressBar": true,
                "preventDuplicates": true,
                "onclick": null,
                "showDuration": "100",
                "hideDuration": "1000",
                "timeOut": "5000",
                "extendedTimeOut": "1000",
                "showEasing": "swing",
                "hideEasing": "linear",
                "showMethod": "show",
                "hideMethod": "hide"
            };
        </script>
        
        <%
            if(ALERTA!=null){
                if(ALERTA.equals("NO_EXISTE_USUARIO")){
                    %>
                    <script>
                        toastr.info('No existe este usuario');
                    </script>
                    <%
                } else if(ALERTA.equals("CONTRA_INCORRECTA")){
                    %>
                    <script>
                        toastr.warning('Contraseña incorrecta');
                    </script>
                    <%
                } else if(ALERTA.equals("ERROR")){
                    %>
                    <script>
                        toastr.error('Ups! Error Interno, intente nuevamente');
                    </script>
                    <%
                }
            }
        %>
        
        <script>
            $("#js-login-btn").click(function(event)
            {

                // Fetch form to apply custom Bootstrap validation
                var form = $("#js-login")

                if (form[0].checkValidity() === false)
                {
                    event.preventDefault()
                    event.stopPropagation()
                }

                form.addClass('was-validated');
                // Perform ajax submit here...
            });

        </script>
        
        
    </body>
</html>

