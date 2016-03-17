<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Task Manager</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%--<link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">--%>
    <link rel="stylesheet" href="/" type="text/css">
    <script type="text/javascript" src="js/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="../../../js/angular/angular.min.js"></script>
    <script type="text/javascript" src="../../../js/angular/angular-resource.js"></script>
    <script type="text/javascript" src="../../../js/application.js"></script>

    <script type="text/javascript" src="../../../js/Task/todo-controller.js"></script>
    <script type="text/javascript" src="../../../js/Task/todo-service.js"></script>

    <link rel="stylesheet" href="../../../css/bootstrap.min.css" type="text/css">
</head>

<body ng-app="taksApp" ng-controller="taskController">
<header class="page-header">Todo Manager List</header>

<div class="container">
    <div id="content" class="jumbotron">
        <div class="row">
            <div>ToDo List</div>{{model.todos}}
            <div ng-repeat="item as todos"> {{item.name}}</div>
        </div>
        <div>
            ${todos.size()}
        </div>
    </div>
    <div class="has">

    </div>
</div>

<footer class="panel-footer">Todo Manager</footer>
</body>
</html>
