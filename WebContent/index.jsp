<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<title>ABM de Personas</title>



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
        $('#PersonTableContainer').jtable({
            title: 'Tabla de Personas',
                actions: {
                listAction:   'PersonController?action=list',
                createAction: 'PersonController?action=create',
                updateAction: 'PersonController?action=update',
                deleteAction: 'PersonController?action=delete'
            },
            fields: {
                userid: {
                	title:'S.NO',
                    key: true,
                    list: false,
                    create:false
                },
                firstName: {
                    title: 'Nombre',
                    width: '30%',
                    edit:true,
                },
                lastName: {
                    title: 'Apellido',
                    width: '30%',
                    edit:true
                },
                email: {
                    title: 'Email',
                    width: '20%',
                    edit: true
                },
                tipoDoc: {
                    title: 'Tipo Doc',
                    list: true,
                    options: {'1': 'DNI', '2': 'Pasaporte', '99': 'Otros' }
                },
                nroDoc: {
                    title: 'Numero',
                    width: '20%',
                    edit: true
                },
                telefono: {
                    title: 'Telefono',
                    width: '20%',
                    edit: true
                },
             
            }
        });
        $('#PersonTableContainer').jtable('load');
    });
</script>
</head>
<body>
<div style="width:60%;margin-right:20%;margin-left:20%;text-align:center;">
<h1>ABM de personas</h1>
<div id="PersonTableContainer"></div>
</div>
</body>
</html>