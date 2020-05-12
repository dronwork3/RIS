<%@page import="java.util.ArrayList"%>
<%@page import="javax.ejb.EJB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>
<jsp:useBean id="subjects" class="subject.ejb.Subject" scope="session"/>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Лабораторная работа 2</title>
        <link href="style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <%
            if (request.getParameter("add") != null) {
                subjects.add(new String(request.getParameter("a-departure").getBytes("ISO-8859-1"), "UTF-8"),
                        new String(request.getParameter("a-arrival").getBytes("ISO-8859-1"), "UTF-8"),
                        new String(request.getParameter("a-price").getBytes("ISO-8859-1"), "UTF-8"),
                        request.getParameter("a-classe"));
            }
            if (request.getParameter("delete") != null) {
                if (request.getParameter("d-index") != null)
                    subjects.remove(Integer.parseInt(request.getParameter("d-index")) - 1);
                else {%>
        <script>
            alert("Список пуст");
        </script>
        <%}
            }%>
        <table border="1" class="info">
            <legend>Заказанные билеты</legend>
            <thead>
                <tr>
                    <th>Номер</th>
                    <th>Место отправления</th>
                    <th>Место прибытия</th>
                    <th>Цена</th>
                    <th>Класс</th>
                </tr>
            </thead>
            <tbody>
                <%
                    ArrayList arr = subjects.getList();
                    for (int i = 0; i < arr.size(); i++) {
                %>
                <tr>
                    <td><%=i + 1%></td>
                    <td><%=((String[]) arr.get(i))[0]%></td>
                    <td><%=((String[]) arr.get(i))[1]%></td>
                    <td><%=((String[]) arr.get(i))[2]%></td>
                    <td><%=((String[]) arr.get(i))[3]%></td>
                </tr>
                <%}%>
            </tbody>
        </table>
        <table border="1" class="info">
            <legend>Самые дорогие билеты</legend>
            <thead>
                <tr>
                    <th>Место отправления</th>
                    <th>Место прибытия</th>
                    <th>Цена</th>
                    <th>Класс</th>
                </tr>
            </thead>
            <tbody>
                <%
                    ArrayList duoarr = subjects.getMostExpensive(2);
                    for (int i = 0; i < duoarr.size(); i++) {
                %>
                <tr>
                    <td><%=((String[]) duoarr.get(i))[0]%></td>
                    <td><%=((String[]) duoarr.get(i))[1]%></td>
                    <td><%=((String[]) duoarr.get(i))[2]%></td>
                    <td><%=((String[]) duoarr.get(i))[3]%></td>
                </tr>
                <%}%>
            </tbody>
        </table>
        <form action="index.jsp" method="POST">
            <table border="0">
                <legend>Заказ билета</legend>
                <tbody>
                    <tr>
                        <td>Место отправления</td>
                        <td><input name="a-departure" type="text" required/></td>
                    </tr>
                    <tr>
                        <td>Место прибытия</td>
                        <td><input name="a-arrival" type="text" required/></td>
                    </tr>
                    <tr>
                        <td>Цена</td>
                        <td><input name="a-price" type="text" required/></td>
                    </tr>
                    <tr>
                        <td>Класс</td>
                        <td><input name="a-classe" type="number" min="1" step="1" max="3" required/></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" name="add" value="Добавить" />
        </form>
        <form action="" method="POST">
            <table border="0">
                <legend>Удаление билета</legend>
                <tbody>
                    <tr>
                        <td>Номер билета</td>
                        <td><select name="d-index">
                                <%for (int i = 0; i < arr.size(); i++) {%>
                                <option><%=i + 1%>
                                </option> 
                                <%}%>
                            </select></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" name="delete" value="Удалить" />
        </form>
    </body>
</html>