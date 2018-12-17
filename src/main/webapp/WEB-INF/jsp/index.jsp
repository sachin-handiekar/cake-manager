<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %><html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="cake manager">
    <meta name="author" content="Sachin Handiekar">

    <title>Cake Manager</title>

    <!-- Bootstrap core CSS -->
    <link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="css/custom.css" rel="stylesheet">
</head>

<body>

<header>
    <!-- Fixed navbar -->
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <a class="navbar-brand" href="/">Cake Manager</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/insertCake">Insert Cake</a>
                </li>

            </ul>

        </div>
    </nav>
</header>

<!-- Begin page content -->
<main role="main" class="container">
    <h1 class="mt-5">Cakes</h1>


    <table class="table table-striped">
        <thead>
        <tr>
            <th>Title</th>
            <th>Description</th>
            <th>Image</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${empty cakes}">
            <tr>
                <td colspan="8">No Cakes' to display</td>
            </tr>
        </c:if>
        <c:if test="${not empty cakes}">

            <c:forEach items="${cakes}" var="cake">
                <tr class="">
                    <td>${cake.title}</td>
                    <td>${cake.description}</td>
                    <td><img src="${cake.image}" height="150" width="150"></td>


                </tr>
            </c:forEach>
        </c:if>
        </tbody>
    </table>


</main>

<footer class="footer">
    <div class="container">
        <span class="text-muted">Developed by Sachin Handiekar</span>
    </div>
</footer>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
<script src="https://getbootstrap.com/docs/4.1/assets/js/vendor/popper.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>
