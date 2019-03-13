<%-- 
    Document   : index
    Created on : 13-Oct-2018, 4:00:19 PM
    Author     : Mariel Martinez (marmarie)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"
        import="ca.sheridancollege.marmarie.bus.Course"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GPA Calculator | Course Form</title>
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <link rel="stylesheet" type="text/css" href="css/forms.css">
    </head>
    <body>
        <header>
            <h1>GPA Calculator</h1>
        </header>
        <main class="container">
            <h2>Enter Course Information</h2>
            <form action="CalcGpa" method="GET">
                <c:forEach var="counter" begin="1" end="6">
                    <p>
                        <label for="codes">
                            Course #${counter}: <input type="text" name="codes">
                        </label>
                        <label for="credits">
                            Credits: <input type="text" name="credits">
                        </label>
                        <label for="grades">
                            Grade: <input type="text" name="grades">
                        </label>
                    </p>
                </c:forEach>
                <input type="submit" value="Submit">
                <input type="reset" value="Clear">
            </form>
        </main>
        <footer>
            2018 &copy; Mariel Martinez
        </footer>
    </body>
</html>
