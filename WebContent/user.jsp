<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<title>ABM de Usuarios</title>

<!-- Include one of jTable styles. -->
<link href="css/metro/crimson/jtable.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />
<!-- Include jTable script file. -->
<script src="js/jquery-1.8.2.js" type="text/javascript"></script>
<script src="js/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
<script src="js/jquery.jtable.js" type="text/javascript"></script>
<script src="js/jquery.jtable.es.js" type="text/javascript"></script>
<script type="text/javascript">

    $(document).ready(function () {
        $('#UserTableContainer').jtable({
            title: 'Usuarios',
                actions: {
                listAction:   'UserController?action=list',
                createAction: 'UserController?action=create',
                updateAction: 'UserController?action=update',
                deleteAction: 'UserController?action=delete'
            },
            fields: {
                userid: {
                	title:'S.NO',
                    key: true,
                    list: false,
                    create:false
                },
                username: {
                    title: 'Usuario',
                    width: '30%',
                    edit:true,
                },
                password: {
                    title: 'Password',
                    type: 'password',
                    width: '30%',
                    list: true,
                    edit:true
                },
                rol: {
                    title: 'Rol',
                    width: '30%',
                    list: true,
                    options: {'1': 'Administrador', '2': 'Usuario' }
                },
                estado: {
                    title: 'Estado',
                    width: '30%',
                    list: true,
                    type: 'checkbox',
                    values: { 0: 'Inactivo', 1: 'Activo' },
                    defaultValue: 1
                }
            }
        });
        $('#UserTableContainer').jtable('load');
    });
</script>
</head>
<body>
<div style=";text-align:left;">Usted accedio con el usuario: <b>${requestScope['user'].username}</b> Rol Administrador</div>
<div style="width:60%;margin-right:20%;margin-left:20%;text-align:center;">
<h1>ABM de Usuarios</h1>
<div id="UserTableContainer"></div>
</div>
<div>
<p>Alta de personas
<input type=image src="css/images/agregar.png" value="alta Personas" onclick = "location='/TpMvc_final/index.jsp'"/> </p> 
</div>
</body>
</html>