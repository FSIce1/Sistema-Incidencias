
<jsp:useBean id="USUARIO" scope="request" class="java.lang.String"></jsp:useBean>
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
                                    <img style="border-radius: 50%" src="img/logo.jpg" alt="InciApp" aria-roledescription="logo">
                                    <span class="page-logo-text mr-1">InciApp</span>
                                </a>
                            </div>
                            <span class="text-white opacity-50 ml-auto mr-2 hidden-sm-down">
                                ¿Ya eres usuario?
                            </span>
                            <a href="Login_Inicio.jsp" class="btn-link text-white ml-auto ml-sm-0">
                                Inicio de sesión
                            </a>
                        </div>
                    </div>
                    <div class="flex-1" style="background: url(img/svg/pattern-1.svg) no-repeat center bottom fixed; background-size: cover;">
                        <div class="container py-4 py-lg-5 my-lg-5 px-4 px-sm-0">
                            <div class="row">
                                <div class="col-xl-12">
                                    <h2 class="fs-xxl fw-500 mt-4 text-white text-center">
                                            Regístrese ahora, ¡es gratis!
                                        <small class="h3 fw-300 mt-3 mb-5 text-white opacity-60 hidden-sm-down">
                                            El regsitro de nuestro sistema de inicidencias es gratis
                                        </small>
                                    </h2>
                                </div>
                                
                                <div class="col-xl-6 ml-auto mr-auto">
                                    <div class="card p-4 rounded-plus bg-faded">
                                        <!--
                                        <div class="alert alert-primary text-dark" role="alert">
                                            <strong>Heads Up!</strong> Due to server maintenance from 9:30GTA to 12GTA, the verification emails could be delayed by up to 10 minutes.
                                        </div>
                                        -->
                                        
                                        <form class="form" method="post" autocomplete="off" action="Controlador_Usuario">
                                            
                                            <input type="hidden" name="opcion" value="I">
                                            
                                            <div class="form-group row">
                                                <label class="col-xl-12 form-label" for="fname">Nombres Completos</label>
                                                
                                                <div class="col-6 pr-1">
                                                    <input type="text" id="txtNombres" name="txtNombres" maxlength="20" class="form-control" placeholder="Nombres" required>
                                                    <div class="invalid-feedback">No, you missed this one.</div>
                                                </div>
                                                
                                                <div class="col-6 pl-1">
                                                    <input type="text" id="txtApellidos" name="txtApellidos" maxlength="20" class="form-control" placeholder="Apellidos" required>
                                                    <div class="invalid-feedback">No, you missed this one.</div>
                                                </div>
                                            </div>
                                            
                                            <div class="form-group row">
                                                
                                                <div class="col-6 pr-1">
                                                    <label class="form-label" for="txtCorreo">Email</label>
                                                    <input type="email" id="txtCorreo" name="txtCorreo" maxlength="50" class="form-control" placeholder="Ejemplo: rodolfo12@gmail.com" required>
                                                    <div class="invalid-feedback">No, you missed this one.</div>
                                                </div>
                                                
                                                <div class="col-6 pr-1">
                                                    <label class="form-label" for="txtTelefono">Teléfono</label>
                                                    <input type="text" onkeyup="limpiarNumero(this)" onchange="limpiarNumero(this)" id="txtTelefono" name="txtTelefono" maxlength="9" class="form-control" placeholder="Ejemplo: 965423112" required>
                                                    <div class="invalid-feedback">No, you missed this one.</div>
                                                </div>
                                                
                                            </div>
                                            
                                            <div class="form-group row">
                                                
                                                <div class="col-12 pr-1">
                                                    <label class="form-label" for="txtCodigo">Usuario</label>
                                                    <input type="text" id="txtCodigo" name="txtCodigo" maxlength="30" class="form-control" placeholder="Ejemplo: Juanito12" required>
                                                    <div class="invalid-feedback">No, you missed this one.</div>
                                                </div>
                                                
                                            </div>
                                            
                                            <div class="form-group row">
                                                
                                                <div class="col-12 pr-1">
                                                    <label class="form-label" for="txtContra">Contraseña</label>
                                                    <input type="password" id="txtContra" name="txtContra" maxlength="30" class="form-control" placeholder="Ejemplo: cuchara123" required>
                                                    <div class="invalid-feedback">No, you missed this one.</div>
                                                </div>
                                                
                                            </div>
                                            
                                            <!--
                                            <div class="form-group demo">
                                                <div class="custom-control custom-checkbox">
                                                    <input type="checkbox" class="custom-control-input" id="terms" required>
                                                    <label class="custom-control-label" for="terms"> I agree to terms & conditions</label>
                                                    <div class="invalid-feedback">You must agree before proceeding</div>
                                                </div>
                                            </div>
                                            -->
                                            
                                            <div class="row no-gutters">
                                                <div class="col-md-4 ml-auto text-right">
                                                    <button id="js-login-btn" type="submit" class="btn btn-block btn-dark btn-lg mt-3">Registrar</button>
                                                </div>
                                            </div>
                                            
                                        </form>
                                    </div>
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
                if(ALERTA.equals("EXISTE_EMAIL")){
                    %>
                    <script>
                        toastr.info('Este email ya existe');
                    </script>
                    <%
                } else if(ALERTA.equals("EXISTE_USUARIO")){
                    %>
                    <script>
                        toastr.info('Este usuario ya existe');
                    </script>
                    <%
                } else if(ALERTA.equals("INGRESADO")){
                    %>
                    <script>
                        toastr.success('Usuario ingresado correctamente');
                    </script>
                    <%
                } else if(ALERTA.equals("NO_INGRESADO")){
                    %>
                    <script>                        
                        toastr.info('Usuario no ingresado');
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
            function limpiarNumero(obj) {
                /* El evento "change" sólo saltará si son diferentes */
                obj.value = obj.value.replace(/\D/g, '');
              }
        </script>
        
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
