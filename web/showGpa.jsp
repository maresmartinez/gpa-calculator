<%-- 
    Document   : showGpa
    Created on : 13-Oct-2018, 4:18:07 PM
    Author     : Mariel Martinez (marmarie)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"
        import="ca.sheridancollege.marmarie.bus.Course" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GPA Calculator | Output</title>
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <link rel="stylesheet" type="text/css" href="css/tables.css">
    </head>
    <body>
        <header>
            <h1>GPA Calculator</h1>
        </header>
        <main class="container">
            <h2>Your GPA Information</h2>
            <table>
                <tr>
                    <th>Course</th>
                    <th>Grade Points</th>
                    <th>Credit Value</th>
                    <th>Weighted Credit Value</th>
                </tr>
                <c:forEach var="course" items="${courses}">
                    <tr>
                        <td>${course.code}</td>
                        <td>${course.gradePoints}</td>
                        <td>${course.credits}</td>
                        <td><fmt:formatNumber 
                                value="${course.weight}" pattern=".0"/></td>
                    </tr>
                </c:forEach>
                <tr>
                    <th colspan="2">Totals</th>
                    
                    <%-- Calculate and display total credit values --%>
                    <c:set var="totalCreditValues" value="0" />
                    <c:set var="totalWeight" value="0" />
                    <c:forEach var="course" items="${courses}">
                        <c:set var="totalCreditValues" 
                               value="${totalCreditValues + course.credits}"/>
                        <c:set var="totalWeight" 
                               value="${totalWeight + course.weight}"/>
                    </c:forEach>
                    
                    <td>${totalCreditValues}</td>
                    <td>${totalWeight}</td>
                </tr>
            </table>
            
            <%-- Calculate average GPA and display value --%>
            <c:set var="averageGpa" value="${totalWeight / totalCreditValues}"/>
            <p>
                Your GPA this term is 
                <strong>
                    <fmt:formatNumber value="${averageGpa}" pattern=".00"/>
                </strong>
            </p>
        </main>
        <footer>
            2018 &copy; Mariel Martinez
        </footer>
    </body>
</html>
