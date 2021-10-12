
<%@page import="modelos.Modelo_Problema"%>
<%@page import="beans.Problema"%>
<%@page import="java.util.List"%>

<jsp:useBean id="ALERTA" scope="request" class="java.lang.String"></jsp:useBean>
    
<%@ page contentType="text/html; charset=UTF-8" %>
    
<!DOCTYPE html>

<html lang="en">
    <head>
        <title>
            Lista_Problemas - InciApp v1
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
        <link rel="stylesheet" media="screen, print" href="css/datagrid/datatables/datatables.bundle.css">
        <link rel="stylesheet" media="screen, print" href="css/fa-solid.css">
        
        
        <!-- NOTIFICACIONES -->
        <link rel="stylesheet" media="screen, print" href="css/notifications/toastr/toastr.css">
        
    </head>
    <body class="mod-bg-1 ">
        <!-- DOC: script to save and load page settings -->
        <script>
            /**
             *	This script should be placed right after the body tag for fast execution 
             *	Note: the script is written in pure javascript and does not depend on thirdparty library
             **/
            'use strict';

            var classHolder = document.getElementsByTagName("BODY")[0],
                /** 
                 * Load from localstorage
                 **/
                themeSettings = (localStorage.getItem('themeSettings')) ? JSON.parse(localStorage.getItem('themeSettings')) :
                {},
                themeURL = themeSettings.themeURL || '',
                themeOptions = themeSettings.themeOptions || '';
            /** 
             * Load theme options
             **/
            if (themeSettings.themeOptions)
            {
                classHolder.className = themeSettings.themeOptions;
                console.log("%c✔ Theme settings loaded", "color: #148f32");
            }
            else
            {
                console.log("Heads up! Theme settings is empty or does not exist, loading default settings...");
            }
            if (themeSettings.themeURL && !document.getElementById('mytheme'))
            {
                var cssfile = document.createElement('link');
                cssfile.id = 'mytheme';
                cssfile.rel = 'stylesheet';
                cssfile.href = themeURL;
                document.getElementsByTagName('head')[0].appendChild(cssfile);
            }
            /** 
             * Save to localstorage 
             **/
            var saveSettings = function()
            {
                themeSettings.themeOptions = String(classHolder.className).split(/[^\w-]+/).filter(function(item)
                {
                    return /^(nav|header|mod|display)-/i.test(item);
                }).join(' ');
                if (document.getElementById('mytheme'))
                {
                    themeSettings.themeURL = document.getElementById('mytheme').getAttribute("href");
                };
                localStorage.setItem('themeSettings', JSON.stringify(themeSettings));
            }
            /** 
             * Reset settings
             **/
            var resetSettings = function()
            {
                localStorage.setItem("themeSettings", "");
            }

        </script>
        
        <%
            if(session.getAttribute("idCUENTA")==null){
                %>
                    <jsp:include page="Controlador_Logueo?opcion=Y"/>
                <%
            }
        %>
        
        <!-- BEGIN Page Wrapper -->
        <div class="page-wrapper">
            <div class="page-inner">
                <!-- BEGIN Left Aside -->
                <aside class="page-sidebar">
                    <div class="page-logo">
                        <a href="#" class="page-logo-link press-scale-down d-flex align-items-center position-relative" data-toggle="modal" data-target="#modal-shortcut">
                             <img src="img/logo.jpg" style="border-radius: 50%" alt="InciApp" aria-roledescription="logo">
                            <span class="page-logo-text mr-1">InciApp</span>
                            <span class="position-absolute text-white opacity-50 small pos-top pos-right mr-2 mt-n2"></span>
                            <i class="fal fa-angle-down d-inline-block ml-1 fs-lg color-primary-300"></i>
                        </a>
                    </div>
                    
                    <!-- Iniciia NAVEGACION -->
                    <nav id="js-primary-nav" class="primary-nav" role="navigation">
                        <div class="nav-filter">
                            <div class="position-relative">
                                <input type="text" id="nav_filter_input" placeholder="Filtro de menú" class="form-control" tabindex="0">
                                <a href="#" onclick="return false;" class="btn-primary btn-search-close js-waves-off" data-action="toggle" data-class="list-filter-active" data-target=".page-sidebar">
                                    <i class="fal fa-chevron-up"></i>
                                </a>
                            </div>
                        </div>
                        
                        <!-- DATOS DEL USUARIO -->
                        <div class="info-card">
                            <img src="img/profile-user.png" class="profile-image rounded-circle" alt="<%=session.getAttribute("nombresCUENTA")%> - <%=session.getAttribute("apellidosCUENTA")%>">
                            <div class="info-card-text">
                                <a href="#" class="d-flex align-items-center text-white">
                                    <span class="text-truncate text-truncate-sm d-inline-block">
                                        <%=session.getAttribute("nombresCUENTA")%> - <%=session.getAttribute("apellidosCUENTA")%> 
                                    </span>
                                </a>
                                <span class="d-inline-block text-truncate text-truncate-sm"><%=session.getAttribute("correoCUENTA")%></span>
                            </div>
                            <img src="img/card-backgrounds/cover-2-lg.png" class="cover" alt="cover">
                            <a href="#" onclick="return false;" class="pull-trigger-btn" data-action="toggle" data-class="list-filter-active" data-target=".page-sidebar" data-focus="nav_filter_input">
                                <i class="fal fa-angle-down"></i>
                            </a>
                        </div>
                        
                        <!-- MENU -->
                        <ul id="js-nav-menu" class="nav-menu">
                            
                            <li>
                                <a href="#" title="Principal" data-filter-tags="Principal">
                                    <i class="fal fa-tag"></i>
                                    <span class="nav-link-text" data-i18n="nav.package_info">Principal</span>
                                </a>
                                <ul>
                                    <li>
                                        <a href="Perfil.jsp" title="Perfil" data-filter-tags="Perfil">
                                            <span class="nav-link-text" data-i18n="nav.package_info_documentation">Tu Perfil</span>
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            
                            <li class="nav-title">Administrador</li>
                            <li>
                                <a href="#" title="Usuarios" data-filter-tags="Usuarios">
                                    <i class="fal fa-window"></i>
                                    <span class="nav-link-text" data-i18n="nav.ui_components">Usuarios</span>
                                </a>
                                <ul>
                                    <li>
                                        <a href="Lista_Usuarios.jsp" title="Lista de Usuarios" data-filter-tags="Lista de Usuarios">
                                            <span class="nav-link-text" data-i18n="nav.ui_components_alerts">Lista de Usuarios</span>
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            
                            <li class="nav-title">Otros Usuarios</li>
                            <li>
                                
                                <a href="#" title="Incidentes" data-filter-tags="Incidentes">
                                    <i class="fal fa-shield-alt"></i>
                                    <span class="nav-link-text" data-i18n="nav.plugins">Incidentes</span>
                                </a>
                                
                                <ul>
                                    
                                    <li>
                                        <a href="Lista_Incidentes.jsp" title="Lista de Incidentes" data-filter-tags="Lista de Incidentes">
                                            <span class="nav-link-text" data-i18n="nav.plugins_plugins_faq">Lista de Incidentes</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="Lista_Informes.jsp" title="Lista de Informes" data-filter-tags="Lista de Informes">
                                            <span class="nav-link-text" data-i18n="nav.plugins_waves">Lista de Informes</span>
                                        </a>
                                    </li>
                                    
                                </ul>
                            </li>
                            
                            <!-- EL TECNICO NO PUEDE VER A LOS USUARIOS -->
                            <%
                                if(Integer.parseInt(String.valueOf(session.getAttribute("tipoCUENTA")))==1){
                            %> <!-- ADMIN -->
                                
                            <li class="active open">
                                <a href="#" title="Problemas & Soluciones" data-filter-tags="Problemas & Soluciones">
                                    <i class="fal fa-credit-card-front"></i>
                                    <span class="nav-link-text" data-i18n="nav.form_plugins">Problemas & Soluciones</span>
                                </a>
                                <ul>
                                    
                                    <li class="active">
                                        <a href="Lista_Problemas.jsp" title="Lista de Problemas" data-filter-tags="Lista de Problemas">
                                            <span class="nav-link-text" data-i18n="nav.form_plugins_color_picker">Lista de Problemas</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="Lista_Soluciones.jsp" title="Lista de Soluciones" data-filter-tags="Lista de Soluciones">
                                            <span class="nav-link-text" data-i18n="nav.form_plugins_date_picker">Lista de Soluciones</span>
                                        </a>
                                    </li>
                                    
                                </ul>
                            </li>
                            
                            <!--
                            <li>
                                <a href="#" title="Estadísticas" data-filter-tags="Estadísticas">
                                    <i class="fal fa-chart-pie"></i>
                                    <span class="nav-link-text" data-i18n="nav.statistics">Estadísticas</span>
                                </a>
                                <ul>
                                    
                                    <li>
                                        <a href="E_Incidentes_Solucionados.jsp" title="Incidentes solucionados" data-filter-tags="Incidentes solucionados">
                                            <span class="nav-link-text" data-i18n="nav.statistics_flot">Incidentes solucionados</span>
                                        </a>
                                    </li>
                                   
                                </ul>
                            </li>
                            -->
                                
                            <%
                                } else {
                            %> <!-- TECNICO -->
                                
                            <%
                                }
                            %>
                            
                            
                        </ul>
                        <div class="filter-message js-filter-message bg-success-600"></div>
                    </nav>
                    <!-- Termina Navegación -->
                    
                </aside>
                <!-- END Left Aside -->
                <div class="page-content-wrapper">
                    
                    <!-- Inicia HEADER -->
                    <header class="page-header" role="banner">
                        <!-- we need this logo when user switches to nav-function-top -->
                        <div class="page-logo">
                            <a href="#" class="page-logo-link press-scale-down d-flex align-items-center position-relative" data-toggle="modal" data-target="#modal-shortcut">
                                <img src="img/logo.jpg" style="border-radius: 50%" alt="InciApp" aria-roledescription="logo">
                                <span class="page-logo-text mr-1">InciApp</span>
                                <span class="position-absolute text-white opacity-50 small pos-top pos-right mr-2 mt-n2"></span>
                                <i class="fal fa-angle-down d-inline-block ml-1 fs-lg color-primary-300"></i>
                            </a>
                        </div>
                        <!-- DOC: nav menu layout change shortcut -->
                        <div class="hidden-md-down dropdown-icon-menu position-relative">
                            <a href="#" class="header-btn btn js-waves-off" data-action="toggle" data-class="nav-function-hidden" title="Ocultar Navegación">
                                <i class="ni ni-menu"></i>
                            </a>
                            <ul>
                                <li>
                                    <a href="#" class="btn js-waves-off" data-action="toggle" data-class="nav-function-minify" title="Minificar la navegación">
                                        <i class="ni ni-minify-nav"></i>
                                    </a>
                                </li>
                                <li>
                                    <a href="#" class="btn js-waves-off" data-action="toggle" data-class="nav-function-fixed" title="Bloquear navegación">
                                        <i class="ni ni-lock-nav"></i>
                                    </a>
                                </li>
                            </ul>
                        </div>
                        <!-- DOC: mobile button appears during mobile width -->
                        <div class="hidden-lg-up">
                            <a href="#" class="header-btn btn press-scale-down" data-action="toggle" data-class="mobile-nav-on">
                                <i class="ni ni-menu"></i>
                            </a>
                        </div>
                        
                        <div class="ml-auto d-flex">
                            
                            
                            <!-- CONFIGURACION -->
                            <div class="hidden-md-down">
                                <a href="#" class="header-icon" data-toggle="modal" data-target=".js-modal-settings">
                                    <i class="fal fa-cog"></i>
                                </a>
                            </div>
                            
                            <!-- BOTON DE SALIDA -->
                            <div>
                                
                                <a href="#" data-toggle="dropdown" title="<%=session.getAttribute("codigoCUENTA")%>" class="header-icon d-flex align-items-center justify-content-center ml-2">
                                    <img src="img/profile-user.png" class="profile-image rounded-circle" alt="<%=session.getAttribute("nombresCUENTA")%> <%=session.getAttribute("apellidosCUENTA")%>">
                                </a>
                                
                                <div class="dropdown-menu dropdown-menu-animated dropdown-lg">
                                    
                                    <div class="dropdown-header bg-trans-gradient d-flex flex-row py-4 rounded-top">
                                        <div class="d-flex flex-row align-items-center mt-1 mb-1 color-white">
                                            <span class="mr-2">
                                                <img src="img/profile-user.png" class="rounded-circle profile-image" alt="<%=session.getAttribute("nombresCUENTA")%> <%=session.getAttribute("apellidosCUENTA")%>">
                                            </span>
                                            <div class="info-card-text">
                                                <div class="fs-lg text-truncate text-truncate-lg"><%=session.getAttribute("nombresCUENTA")%> <%=session.getAttribute("apellidosCUENTA")%></div>
                                                <span class="text-truncate text-truncate-md opacity-80"><%=session.getAttribute("correoCUENTA")%></span>
                                            </div>
                                        </div>
                                    </div>
                                    
                                    <div class="dropdown-divider m-0"></div>
                                    <a href="#" class="dropdown-item" data-action="app-fullscreen">
                                        <span data-i18n="drpdwn.fullscreen">Maximizar</span>
                                        <i class="float-right text-muted fw-n">F11</i>
                                    </a>

                                    <div class="dropdown-divider m-0"></div>
                                    <a class="dropdown-item fw-500 pt-3 pb-3" href="Controlador_Logueo?opcion=C">
                                        <span data-i18n="drpdwn.page-logout">Cerrar Sesión</span>
                                        <span class="float-right fw-n">&commat;<%=session.getAttribute("codigoCUENTA")%></span>
                                    </a>
                                    
                                </div>
                            </div>
                            
                        </div>
                    </header>
                    <!-- Termina HEADER -->
                    
                    
                    <!-- BEGIN Page Content -->
                    <main id="js-page-content" role="main" class="page-content">
                        
                        <ol class="breadcrumb page-breadcrumb">
                            <li class="breadcrumb-item"><a href="javascript:void(0);">InciApp</a></li>
                            <li class="breadcrumb-item">Problema & Soluciones</li>
                            <li class="breadcrumb-item active">Lista de Problemas</li>
                            <li class="position-absolute pos-top pos-right d-none d-sm-block"><span class="js-get-date"></span></li>
                        </ol>
                        
                        <div class="subheader">
                            <h1 class="subheader-title">
                                <i class='subheader-icon fal fa-table'></i> Lista de: <span class='fw-300'>Problemas</span>
                                <small>
                                    Listado de todos los problemas que se han presentado o se puedan presentar
                                </small>
                            </h1>
                        </div>
                        
                        <div class="row">
                            <div class="col-xl-12">
                                <div id="panel-1" class="panel">
                                    <div class="panel-hdr">
                                        <h2>
                                            Problemas
                                        </h2>
                                        <div class="panel-toolbar">
                                            <button class="btn btn-panel" data-action="panel-collapse" data-toggle="tooltip" data-offset="0,10" data-original-title="Minimizar"></button>
                                            <button class="btn btn-panel" data-action="panel-fullscreen" data-toggle="tooltip" data-offset="0,10" data-original-title="Pantalla Completa"></button>
                                            <!--
                                            <button class="btn btn-panel" data-action="panel-close" data-toggle="tooltip" data-offset="0,10" data-original-title="Close"></button>
                                            -->
                                        </div>
                                    </div>
                                    
                                    <div class="panel-container show">
                                        <div class="panel-content">
                                            
                                            <!-- PANEL 
                                            <div class="panel-tag">
                                                <p>Exporting data from a table can often be a key part of a complex application. The Buttons extension for DataTables provides three plug-ins that provide overlapping functionality for data export:</p>
                                                <ul>
                                                    <li>
                                                        HTML5 export buttons - makes use of HTML5 APIs to create files client-side
                                                    </li>
                                                    <li class="font-italic">
                                                        <del>Flash export buttons - uses Adobe Flash for legacy browsers</del>
                                                    </li>
                                                    <li>
                                                        Print button
                                                    </li>
                                                </ul>
                                                <p>
                                                    Since SmartAdmin WebApp is built for the "next generation" browsers, we removed the flash (.swf) alternative plugin due to security reasons and ActionScript's memory leakage
                                                </p>
                                            </div>
                                            -->
                                            
                                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#default-example-modal" onclick="Mostrar('','','','','I')" >Agregar</button>
                                            <br><br> 
                                            
                                            <!-- Modal PROBLEMA -->
                                            <div class="modal fade" id="default-example-modal" tabindex="-1" role="dialog" aria-hidden="true">
                                                <div class="modal-dialog" role="document">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <h4 id="tituloModal" class="modal-title">
                                                                Agregar Problema
                                                            </h4>
                                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                                <span aria-hidden="true"><i class="fal fa-times"></i></span>
                                                            </button>
                                                        </div>
                                                        <div class="modal-body">
                                                            
                                                            <form id="formulario" class="form" method="post" autocomplete="off" action="Controlador_Problema">
                                                                                                                                
                                                                <div class="form-group">
                                                                    <label class="form-label" for="txtCodigo">Código</label>
                                                                    <input type="text" id="txtCodigo" name="txtCodigo" maxlength="10" required="required" class="form-control">
                                                                </div>
                                                                
                                                                <div class="form-group">
                                                                    <label class="form-label" for="txtPrioridad">Prioridad</label>
                                                                    <select class="form-control" id="txtPrioridad" name="txtPrioridad" required="required">
                                                                        <option value="0" >Muy Baja</option>
                                                                        <option value="1">Baja</option>
                                                                        <option value="2">Media</option>
                                                                        <option value="3">Alta</option>
                                                                        <option value="4">Muy Alta</option>
                                                                    </select>
                                                                </div>
                                                                
                                                                <div class="form-group">
                                                                    <label class="form-label" for="txtDescripcion">Descripción</label>
                                                                    <input type="text" id="txtDescripcion" required="required" name="txtDescripcion" class="form-control">
                                                                </div>
                                                              
                                                                
                                                                <input type="hidden" id="txtCodigoAntiguo" name="txtCodigoAntiguo" value="">

                                                                <input type="hidden" id="txtId" name="txtId" value="">
                                                                
                                                                <input type="hidden" id="opcion" name="opcion" value="I">

                                                                
                                                                <div class="modal-footer">
                                                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                                                                    <button id="btnGuardar" type="submit" class="btn btn-primary">Guardar</button>
                                                                </div>
                                                                
                                                            </form>
                                                                
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            
                                            
                                            <!-- Inicia TABLA -->
                                            <table id="dt-basic-example" class="table table-bordered table-hover table-striped w-100">
                                                
                                                <thead class="bg-primary-600">
                                                    <tr>
                                                        <th>Id</th>
                                                        <th>Código</th>
                                                        <th>Prioridad</th>
                                                        <th>Descripción</th>
                                                        <th class="disabled-sorting">Modificar</th>
                                                        <th class="disabled-sorting">Eliminar</th>
                                                    </tr>
                                                </thead>
                                                
                                                <tbody>
                                                    
                                                    <%
                                                    
                                                        List<Problema> listaProblemas = Modelo_Problema.listaProblemas(-1);
                                
                                                        for (Problema u : listaProblemas) {
                                                            
                                                    %>
                                                    
                                                    <tr>
                                                        <td><%= u.getId_problema() %></td>
                                                        <td><%= u.getCodigo_problema() %></td>
                                                        
                                                        <td>
                                                            
                                                            <%

                                                                int incidente = u.getPrioridad_problema();
                                                             
                                                                if(incidente==0){
                                                                    %>
                                                                        <a href="#" class="badge badge-success">Muy baja</a>
                                                                    <%
                                                                } else if(incidente==1){
                                                                    %>
                                                                        <a href="#" class="badge badge-primary">Baja</a>
                                                                    <%
                                                                } else if(incidente==2){
                                                                    %>
                                                                        <a href="#" class="badge badge-info">Media</a>
                                                                    <%
                                                                } else if(incidente==3){
                                                                    %>
                                                                        <a href="#" class="badge badge-warning">Alta</a>
                                                                    <%
                                                                } else if(incidente==4){
                                                                    %>
                                                                        <a href="#" class="badge badge-danger">Muy ALta</a>
                                                                    <%
                                                                } 

                                                            %>
                                                            
                                                        </td>
                                                        
                                                        <td><%= u.getDescripcion_problema() %></td>
                                                        <td>
                                                            <input type="image" src="img/editar.png" data-toggle="modal" data-target="#default-example-modal" onclick="Mostrar(<%=u.getId_problema()%>,'<%=u.getCodigo_problema()%>','<%=u.getPrioridad_problema()%>','<%=u.getDescripcion_problema()%>','M')">
                                                        </td>
                                                        <td>
                                                            
                                                            <form action="Controlador_Problema" method="post">

                                                                <input type="hidden" name="txtId" value="<%=u.getId_problema()%>"> 

                                                                <input type="hidden" name="opcion" value="E">

                                                                <input type="image" src="img/eliminar.png" onclick="return confirm('¿Desea Eliminar?')">
                                                                
                                                            </form>
                                                                       
                                                        </td>
                                                    </tr>
                                                    
                                                    <%
                                                        }
                                                    %>
                                                    
                                                </tbody>
                                                <tfoot>
                                                    <tr>
                                                        <th>Id</th>
                                                        <th>Código</th>
                                                        <th>Prioridad</th>
                                                        <th>Descripción</th>
                                                        <th class="disabled-sorting">Modificar</th>
                                                        <th class="disabled-sorting">Eliminar</th>
                                                    </tr>
                                                </tfoot>
                                            </table>
                                            <!-- Termina TABLA -->
                                        </div>
                                    </div>
                                
                                </div>
                            </div>
                        </div>
                    </main>
                    <!-- this overlay is activated only when mobile menu is triggered -->
                    <div class="page-content-overlay" data-action="toggle" data-class="mobile-nav-on"></div> <!-- END Page Content -->
                    
                    <!-- Footer -->
                    <footer class="page-footer" role="contentinfo">
                        <div class="d-flex align-items-center flex-1 text-muted">
                            <span class="hidden-md-down fw-700">2021 © InciApp &nbsp; Todos los derechos reservados.</span>
                        </div>
                    </footer>
                    <!-- Footer -->
                    
                </div>
            </div>
        </div>
        <!-- END Page Wrapper -->
        
        <!-- Inicia QUICK MENU -->
        <nav class="shortcut-menu d-none d-sm-block">
            <input type="checkbox" class="menu-open" name="menu-open" id="menu_open" />
            <label for="menu_open" class="menu-open-button ">
                <span class="app-shortcut-icon d-block"></span>
            </label>
            <a href="#" class="menu-item btn" data-toggle="tooltip" data-placement="left" title="Ir al inicio">
                <i class="fal fa-arrow-up"></i>
            </a>
            <a href="#" class="menu-item btn" data-action="app-fullscreen" data-toggle="tooltip" data-placement="left" title="Pantalla Completa">
                <i class="fal fa-expand"></i>
            </a>
            <a href="#" class="menu-item btn" data-action="app-print" data-toggle="tooltip" data-placement="left" title="Imprime página">
                <i class="fal fa-print"></i>
            </a>
        </nav>
        <!-- Termina QUICK MENU -->
        
        <!-- Inicio CONFIGURACIÓN -->
        <div class="modal fade js-modal-settings modal-backdrop-transparent" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog modal-dialog-right modal-md">
                <div class="modal-content">
                    <div class="dropdown-header bg-trans-gradient d-flex justify-content-center align-items-center w-100">
                        <h4 class="m-0 text-center color-white">
                            Configuraciones
                            <small class="mb-0 opacity-80">Configuración de la interfaz de usuario</small>
                        </h4>
                        <button type="button" class="close text-white position-absolute pos-top pos-right p-2 m-1 mr-2" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true"><i class="fal fa-times"></i></span>
                        </button>
                    </div>
                    <div class="modal-body p-0">
                        <div class="settings-panel">
                            <!--
                            <div class="mt-4 d-table w-100 px-5">
                                <div class="d-table-cell align-middle">
                                    <h5 class="p-0">
                                        App Layout
                                    </h5>
                                </div>
                            </div>
                            
                            <div class="list" id="fh">
                                <a href="#" onclick="return false;" class="btn btn-switch" data-action="toggle" data-class="header-function-fixed"></a>
                                <span class="onoffswitch-title">Fixed Header</span>
                                <span class="onoffswitch-title-desc">header is in a fixed at all times</span>
                            </div>
                            <div class="list" id="nff">
                                <a href="#" onclick="return false;" class="btn btn-switch" data-action="toggle" data-class="nav-function-fixed"></a>
                                <span class="onoffswitch-title">Fixed Navigation</span>
                                <span class="onoffswitch-title-desc">left panel is fixed</span>
                            </div>
                            <div class="list" id="nfm">
                                <a href="#" onclick="return false;" class="btn btn-switch" data-action="toggle" data-class="nav-function-minify"></a>
                                <span class="onoffswitch-title">Minify Navigation</span>
                                <span class="onoffswitch-title-desc">Skew nav to maximize space</span>
                            </div>
                            <div class="list" id="nfh">
                                <a href="#" onclick="return false;" class="btn btn-switch" data-action="toggle" data-class="nav-function-hidden"></a>
                                <span class="onoffswitch-title">Hide Navigation</span>
                                <span class="onoffswitch-title-desc">roll mouse on edge to reveal</span>
                            </div>
                            <div class="list" id="nft">
                                <a href="#" onclick="return false;" class="btn btn-switch" data-action="toggle" data-class="nav-function-top"></a>
                                <span class="onoffswitch-title">Top Navigation</span>
                                <span class="onoffswitch-title-desc">Relocate left pane to top</span>
                            </div>
                            <div class="list" id="mmb">
                                <a href="#" onclick="return false;" class="btn btn-switch" data-action="toggle" data-class="mod-main-boxed"></a>
                                <span class="onoffswitch-title">Boxed Layout</span>
                                <span class="onoffswitch-title-desc">Encapsulates to a container</span>
                            </div>
                            <div class="expanded">
                                <ul class="">
                                    <li>
                                        <div class="bg-fusion-50" data-action="toggle" data-class="mod-bg-1"></div>
                                    </li>
                                    <li>
                                        <div class="bg-warning-200" data-action="toggle" data-class="mod-bg-2"></div>
                                    </li>
                                    <li>
                                        <div class="bg-primary-200" data-action="toggle" data-class="mod-bg-3"></div>
                                    </li>
                                    <li>
                                        <div class="bg-success-300" data-action="toggle" data-class="mod-bg-4"></div>
                                    </li>
                                </ul>
                                <div class="list" id="mbgf">
                                    <a href="#" onclick="return false;" class="btn btn-switch" data-action="toggle" data-class="mod-fixed-bg"></a>
                                    <span class="onoffswitch-title">Fixed Background</span>
                                </div>
                            </div>
                            <div class="mt-4 d-table w-100 px-5">
                                <div class="d-table-cell align-middle">
                                    <h5 class="p-0">
                                        Mobile Menu
                                    </h5>
                                </div>
                            </div>
                            <div class="list" id="nmp">
                                <a href="#" onclick="return false;" class="btn btn-switch" data-action="toggle" data-class="nav-mobile-push"></a>
                                <span class="onoffswitch-title">Push Content</span>
                                <span class="onoffswitch-title-desc">Content pushed on menu reveal</span>
                            </div>
                            <div class="list" id="nmno">
                                <a href="#" onclick="return false;" class="btn btn-switch" data-action="toggle" data-class="nav-mobile-no-overlay"></a>
                                <span class="onoffswitch-title">No Overlay</span>
                                <span class="onoffswitch-title-desc">Removes mesh on menu reveal</span>
                            </div>
                            <div class="list" id="sldo">
                                <a href="#" onclick="return false;" class="btn btn-switch" data-action="toggle" data-class="nav-mobile-slide-out"></a>
                                <span class="onoffswitch-title">Off-Canvas <sup>(beta)</sup></span>
                                <span class="onoffswitch-title-desc">Content overlaps menu</span>
                            </div>
                            <div class="mt-4 d-table w-100 px-5">
                                <div class="d-table-cell align-middle">
                                    <h5 class="p-0">
                                        Accessibility
                                    </h5>
                                </div>
                            </div>
                            <div class="list" id="mbf">
                                <a href="#" onclick="return false;" class="btn btn-switch" data-action="toggle" data-class="mod-bigger-font"></a>
                                <span class="onoffswitch-title">Bigger Content Font</span>
                                <span class="onoffswitch-title-desc">content fonts are bigger for readability</span>
                            </div>
                            <div class="list" id="mhc">
                                <a href="#" onclick="return false;" class="btn btn-switch" data-action="toggle" data-class="mod-high-contrast"></a>
                                <span class="onoffswitch-title">High Contrast Text (WCAG 2 AA)</span>
                                <span class="onoffswitch-title-desc">4.5:1 text contrast ratio</span>
                            </div>
                            <div class="list" id="mcb">
                                <a href="#" onclick="return false;" class="btn btn-switch" data-action="toggle" data-class="mod-color-blind"></a>
                                <span class="onoffswitch-title">Daltonism <sup>(beta)</sup> </span>
                                <span class="onoffswitch-title-desc">color vision deficiency</span>
                            </div>
                            <div class="list" id="mpc">
                                <a href="#" onclick="return false;" class="btn btn-switch" data-action="toggle" data-class="mod-pace-custom"></a>
                                <span class="onoffswitch-title">Preloader Inside</span>
                                <span class="onoffswitch-title-desc">preloader will be inside content</span>
                            </div>
                            <div class="mt-4 d-table w-100 px-5">
                                <div class="d-table-cell align-middle">
                                    <h5 class="p-0">
                                        Global Modifications
                                    </h5>
                                </div>
                            </div>
                            <div class="list" id="mcbg">
                                <a href="#" onclick="return false;" class="btn btn-switch" data-action="toggle" data-class="mod-clean-page-bg"></a>
                                <span class="onoffswitch-title">Clean Page Background</span>
                                <span class="onoffswitch-title-desc">adds more whitespace</span>
                            </div>
                            <div class="list" id="mhni">
                                <a href="#" onclick="return false;" class="btn btn-switch" data-action="toggle" data-class="mod-hide-nav-icons"></a>
                                <span class="onoffswitch-title">Hide Navigation Icons</span>
                                <span class="onoffswitch-title-desc">invisible navigation icons</span>
                            </div>
                            <div class="list" id="dan">
                                <a href="#" onclick="return false;" class="btn btn-switch" data-action="toggle" data-class="mod-disable-animation"></a>
                                <span class="onoffswitch-title">Disable CSS Animation</span>
                                <span class="onoffswitch-title-desc">Disables CSS based animations</span>
                            </div>
                            <div class="list" id="mhic">
                                <a href="#" onclick="return false;" class="btn btn-switch" data-action="toggle" data-class="mod-hide-info-card"></a>
                                <span class="onoffswitch-title">Hide Info Card</span>
                                <span class="onoffswitch-title-desc">Hides info card from left panel</span>
                            </div>
                            <div class="list" id="mlph">
                                <a href="#" onclick="return false;" class="btn btn-switch" data-action="toggle" data-class="mod-lean-subheader"></a>
                                <span class="onoffswitch-title">Lean Subheader</span>
                                <span class="onoffswitch-title-desc">distinguished page header</span>
                            </div>
                            <div class="list" id="mnl">
                                <a href="#" onclick="return false;" class="btn btn-switch" data-action="toggle" data-class="mod-nav-link"></a>
                                <span class="onoffswitch-title">Hierarchical Navigation</span>
                                <span class="onoffswitch-title-desc">Clear breakdown of nav links</span>
                            </div>
                            <div class="list mt-1">
                                <span class="onoffswitch-title">Global Font Size <small>(RESETS ON REFRESH)</small> </span>
                                <div class="btn-group btn-group-sm btn-group-toggle my-2" data-toggle="buttons">
                                    <label class="btn btn-default btn-sm" data-action="toggle-swap" data-class="root-text-sm" data-target="html">
                                        <input type="radio" name="changeFrontSize"> SM
                                    </label>
                                    <label class="btn btn-default btn-sm" data-action="toggle-swap" data-class="root-text" data-target="html">
                                        <input type="radio" name="changeFrontSize" checked=""> MD
                                    </label>
                                    <label class="btn btn-default btn-sm" data-action="toggle-swap" data-class="root-text-lg" data-target="html">
                                        <input type="radio" name="changeFrontSize"> LG
                                    </label>
                                    <label class="btn btn-default btn-sm" data-action="toggle-swap" data-class="root-text-xl" data-target="html">
                                        <input type="radio" name="changeFrontSize"> XL
                                    </label>
                                </div>
                                <span class="onoffswitch-title-desc d-block mb-g">Change <strong>root</strong> font size to effect rem values</span>
                            </div>
                            -->
                            <br>
                            <div class="mt-2 d-table w-100 pl-5 pr-3">
                                <div class="d-table-cell align-middle">
                                    <h5 class="p-0">
                                        Temas
                                    </h5>
                                    <div class="fs-xs text-muted p-2 alert alert-warning mt-3 mb-0">
                                        <i class="fal fa-exclamation-triangle text-warning mr-2"></i>
                                        Debido a la latencia de la red y la utilización de la CPU, es posible que experimente un breve efecto de parpadeo en la carga de la página que puede mostrar el tema inicial aplicado durante una fracción de segundo. Establecer el estilo / tema preferido en el encabezado evitará que esto suceda.
                                    </div>
                                </div>
                            </div>
                            <div class="expanded theme-colors pl-5 pr-3">
                                <ul class="m-0">
                                    <li><a href="#" id="myapp-0" data-action="theme-update" data-themesave data-theme="" data-toggle="tooltip" data-placement="top" title="Wisteria (base css)" data-original-title="Wisteria (base css)"></a></li>
                                    <li><a href="#" id="myapp-1" data-action="theme-update" data-themesave data-theme="css/themes/cust-theme-1.css" data-toggle="tooltip" data-placement="top" title="Tapestry" data-original-title="Tapestry"></a></li>
                                    <li><a href="#" id="myapp-2" data-action="theme-update" data-themesave data-theme="css/themes/cust-theme-2.css" data-toggle="tooltip" data-placement="top" title="Atlantis" data-original-title="Atlantis"></a></li>
                                    <li><a href="#" id="myapp-3" data-action="theme-update" data-themesave data-theme="css/themes/cust-theme-3.css" data-toggle="tooltip" data-placement="top" title="Indigo" data-original-title="Indigo"></a></li>
                                    <li><a href="#" id="myapp-4" data-action="theme-update" data-themesave data-theme="css/themes/cust-theme-4.css" data-toggle="tooltip" data-placement="top" title="Dodger Blue" data-original-title="Dodger Blue"></a></li>
                                    <li><a href="#" id="myapp-5" data-action="theme-update" data-themesave data-theme="css/themes/cust-theme-5.css" data-toggle="tooltip" data-placement="top" title="Tradewind" data-original-title="Tradewind"></a></li>
                                    <li><a href="#" id="myapp-6" data-action="theme-update" data-themesave data-theme="css/themes/cust-theme-6.css" data-toggle="tooltip" data-placement="top" title="Cranberry" data-original-title="Cranberry"></a></li>
                                    <li><a href="#" id="myapp-7" data-action="theme-update" data-themesave data-theme="css/themes/cust-theme-7.css" data-toggle="tooltip" data-placement="top" title="Oslo Gray" data-original-title="Oslo Gray"></a></li>
                                    <li><a href="#" id="myapp-8" data-action="theme-update" data-themesave data-theme="css/themes/cust-theme-8.css" data-toggle="tooltip" data-placement="top" title="Chetwode Blue" data-original-title="Chetwode Blue"></a></li>
                                    <li><a href="#" id="myapp-9" data-action="theme-update" data-themesave data-theme="css/themes/cust-theme-9.css" data-toggle="tooltip" data-placement="top" title="Apricot" data-original-title="Apricot"></a></li>
                                    <li><a href="#" id="myapp-10" data-action="theme-update" data-themesave data-theme="css/themes/cust-theme-10.css" data-toggle="tooltip" data-placement="top" title="Blue Smoke" data-original-title="Blue Smoke"></a></li>
                                    <li><a href="#" id="myapp-11" data-action="theme-update" data-themesave data-theme="css/themes/cust-theme-11.css" data-toggle="tooltip" data-placement="top" title="Green Smoke" data-original-title="Green Smoke"></a></li>
                                    <li><a href="#" id="myapp-12" data-action="theme-update" data-themesave data-theme="css/themes/cust-theme-12.css" data-toggle="tooltip" data-placement="top" title="Wild Blue Yonder" data-original-title="Wild Blue Yonder"></a></li>
                                    <li><a href="#" id="myapp-13" data-action="theme-update" data-themesave data-theme="css/themes/cust-theme-13.css" data-toggle="tooltip" data-placement="top" title="Emerald" data-original-title="Emerald"></a></li>
                                </ul>
                            </div>
                            <hr class="mb-0 mt-4">
                            
                            <div class="pl-5 pr-3 py-3 bg-faded">
                                <div class="row no-gutters">
                                    <div class="col-6 pr-1">
                                        <a href="#" class="btn btn-outline-danger fw-500 btn-block" data-action="app-reset">Reiniciar Configuración</a>
                                    </div>
                                    <div class="col-6 pl-1">
                                        <a href="#" class="btn btn-danger fw-500 btn-block" data-action="factory-reset">Reiniciar de Fábrica</a>
                                    </div>
                                </div>
                            </div>
                            
                        </div>
                        <span id="saving"></span>
                    </div>
                </div>
            </div>
        </div> 
        <!-- TERMINA CONFIGURACIÓN -->
        
        
        <script src="js/vendors.bundle.js"></script>
        <script src="js/app.bundle.js"></script>
        <!-- datatble responsive bundle contains: 
	+ jquery.dataTables.js
	+ dataTables.bootstrap4.js
	+ dataTables.autofill.js							
	+ dataTables.buttons.js
	+ buttons.bootstrap4.js
	+ buttons.html5.js
	+ buttons.print.js
	+ buttons.colVis.js
	+ dataTables.colreorder.js							
	+ dataTables.fixedcolumns.js							
	+ dataTables.fixedheader.js						
	+ dataTables.keytable.js						
	+ dataTables.responsive.js							
	+ dataTables.rowgroup.js							
	+ dataTables.rowreorder.js							
	+ dataTables.scroller.js							
	+ dataTables.select.js							
	+ datatables.styles.app.js
	+ datatables.styles.buttons.app.js -->
        <script src="js/datagrid/datatables/datatables.bundle.js"></script>
        <!-- datatbles buttons bundle contains: 
	+ "jszip.js",
	+ "pdfmake.js",
	+ "vfs_fonts.js"	
	NOTE: 	The file size is pretty big, but you can always use the
			build.json file to deselect any components you do not need under "export" -->
        <script src="js/datagrid/datatables/datatables.export.js"></script>
    
        <!-- SCRIPT DE NOTIFICACION -->
        <script src="js/notifications/toastr/toastr.js"></script>
        
        <script type="text/javascript">
                    
            var Mostrar = function(id,codigo,prioridad,descripcion,estado){
                
                document.getElementById("txtId").value = id;
                document.getElementById("txtCodigo").value = codigo;
                document.getElementById("txtCodigoAntiguo").value = codigo;
                document.getElementById("txtDescripcion").value = descripcion;
                
                if(estado=="I"){
                    document.getElementById("tituloModal").innerHTML = "Nuevo Problema";
                    document.getElementById("btnGuardar").innerHTML = "Guardar";
                    
                    document.getElementById("opcion").value = estado;
                    
                } else {
                    document.getElementById("tituloModal").innerHTML = "Modificar Problema";
                    document.getElementById("btnGuardar").innerHTML = "Modificar";
                
                    $("#txtPrioridad").val(prioridad);
            
                    document.getElementById("opcion").value = 'D';
                }
            
            }
            
            // CUANDO CIERRAS EL MODAL
            $("#default-example-modal").on("hidden.bs.modal", function(){
                $("#campo-alertas").fadeOut();
                limpiarDatos();
            });

            // LIMPIO FORMULARIO
            var limpiarDatos = function(){
                document.getElementById("formulario").reset();
            }
        </script>

        
        
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
                if(ALERTA.equals("EXISTE_PROBLEMA")){
                    %>
                    <script>
                        toastr.info('Ya existe este código, no pudo ser registrado');
                    </script>
                    <%
                } else if(ALERTA.equals("INGRESADO")){
                    %>
                    <script>
                        toastr.success('Ingresado correctamente');
                    </script>
                    <%
                } else if(ALERTA.equals("NO_INGRESADO")){
                    %>
                    <script>
                        toastr.warning('No pudo ser ingresado');
                    </script>
                    <%
                } else if(ALERTA.equals("MODIFICADO")){
                    %>
                    <script>
                        toastr.success('Modificado correctamente');
                    </script>
                    <%
                } else if(ALERTA.equals("NO_MODIFICADO")){
                    %>
                    <script>
                        toastr.warning('No pudo ser modificado');
                    </script>
                    <%
                } else if(ALERTA.equals("ELIMINADO")){
                    %>
                    <script>
                        toastr.warning('Eliminado correctamente');
                    </script>
                    <%
                } else if(ALERTA.equals("NO_ELIMINADO")){
                    %>
                    <script>
                        toastr.warning('No fue eliminado correctamente');
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
        
        <!-- LIBERÍA PARA REPORTES-->
        <script>
            $(document).ready(function()
            {

                // initialize datatable
                $('#dt-basic-example').dataTable(
                {
                    responsive: true,
                    lengthChange: false,
                    dom:
                        /*	--- Layout Structure 
                        	--- Options
                        	l	-	length changing input control
                        	f	-	filtering input
                        	t	-	The table!
                        	i	-	Table information summary
                        	p	-	pagination control
                        	r	-	processing display element
                        	B	-	buttons
                        	R	-	ColReorder
                        	S	-	Select

                        	--- Markup
                        	< and >				- div element
                        	<"class" and >		- div with a class
                        	<"#id" and >		- div with an ID
                        	<"#id.class" and >	- div with an ID and a class

                        	--- Further reading
                        	https://datatables.net/reference/option/dom
                        	--------------------------------------
                         */
                        "<'row mb-3'<'col-sm-12 col-md-6 d-flex align-items-center justify-content-start'f><'col-sm-12 col-md-6 d-flex align-items-center justify-content-end'lB>>" +
                        "<'row'<'col-sm-12'tr>>" +
                        "<'row'<'col-sm-12 col-md-5'i><'col-sm-12 col-md-7'p>>",
                    buttons: [
                        /*{
                        	extend:    'colvis',
                        	text:      'Column Visibility',
                        	titleAttr: 'Col visibility',
                        	className: 'mr-sm-3'
                        },*/
                        {
                            extend: 'pdfHtml5',
                            text: 'PDF',
                            titleAttr: 'Generar PDF',
                            className: 'btn-outline-danger btn-sm mr-1'
                        },
                        {
                            extend: 'excelHtml5',
                            text: 'Excel',
                            titleAttr: 'Generar Excel',
                            className: 'btn-outline-success btn-sm mr-1'
                        },
                        {
                            extend: 'csvHtml5',
                            text: 'CSV',
                            titleAttr: 'Generate CSV',
                            className: 'btn-outline-primary btn-sm mr-1'
                        },
                        {
                            extend: 'copyHtml5',
                            text: 'Copy',
                            titleAttr: 'Filas copiadas',
                            className: 'btn-outline-primary btn-sm mr-1'
                        },
                        {
                            extend: 'print',
                            text: 'Print',
                            titleAttr: 'Imprime tabla',
                            className: 'btn-outline-primary btn-sm'
                        }
                    ]
                });

            });

        </script>
    
    </body>
</html>
