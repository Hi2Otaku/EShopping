<%-- 
    Document   : ForgetPassword
    Created on : May 11, 2024, 3:42:54 PM
    Author     : hi2ot
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="ForgetPassword" method="post">
            <c:if test='${mailcheck == null}'>
                <table>
                    <c:if test='${err}'>
                        <tr>
                            <td>Information not match!</td>
                        </tr>
                    </c:if>
                    <tr>
                        <td>Enter Mail: </td>
                        <td><input type="email" name="mail" required></td>
                    </tr>
                    <tr>
                        <td>Security Question: </td>
                        <td><select name="sq">
                                <c:forEach items="${ql}" var='x'>
                                    <option value='${x.getSecurityQuestionID()}'>${x.getQuestion()}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Answer: </td>
                        <td><input type="text" name="sqa" placeholder="Answer" required></td>
                    </tr>
                </table>
                <input type="submit" name="submit">
            </c:if>
            <c:if test='${mailcheck != null}'>
                <table>
                    <tr>
                        <td>New Password: </td>
                        <td><input type="password" name="pass"></td>
                    </tr>
                    <tr>
                        <td>Confirm Password: </td>
                        <td><input type="password" name="cfpass"></td>
                    </tr>
                </table>
                <input type="submit" name="submit">
            </c:if>
        </form>
    </body>
</html>
