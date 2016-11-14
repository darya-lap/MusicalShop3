<%@ page import="ConnectToDB.Comment" %>
<%@ page import="DAO.Factory1" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
    </head>

    <body>
    <%
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.YYYY kk:mm:ss");
        String date = sdf.format(new Date());
        Comment comment = new Comment();
        comment.setUser(session.getAttribute("user").toString());
        comment.setContent(request.getParameter("commentText"));
        comment.setDate(date);
        try {
            Factory1.getInstance().getCommentDAO().setComment(comment);
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        try{
            List list = Factory1.getInstance().getCommentDAO().getAllComments();
            String date1;
            String user;
            String text;
            for (Iterator iterator = list.iterator(); iterator.hasNext();) {
                Comment cur = (Comment) iterator.next();
                user = cur.getUser();
                date1 = cur.getDate();
                text = cur.getContent();
    %>
    <p class="comment1">user: <%=user%></p>
    <p class="comment2">date: <%=date1%></p>
    <p class="comment3"><%=text%></p><hr>
    <%}
    }
    catch(SQLException e){ e.printStackTrace();}%>

    </body>

</html>