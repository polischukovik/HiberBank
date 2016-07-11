<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>New Contact</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">

			<h3>Customers</h3>
			<select class="selectpicker form-control form-group" name="customer">
			<option value="-1">Default</option>
			<c:forEach items="${customers}" var="group">
				<option value="${customer.id}">${customer.name}</option>
			</c:forEach>
			</select>

        </div>

        <script>
            $('.selectpicker').selectpicker();
        </script>
    </body>
</html>