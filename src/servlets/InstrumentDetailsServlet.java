package servlets;

import MyContainer.BucketContainer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;

@WebServlet(name = "InstrumentDetailsServlet")
public class InstrumentDetailsServlet extends HttpServlet {

    protected void langRequest(HttpServletResponse response, HttpServletRequest request)
            throws ServletException,IOException{

        String l = request.getParameter("lang");
        Cookie cookieLang;
        Locale locale = null;
        if (l == null){
            Cookie[] cookies = request.getCookies();
            l = "ru";
            if (cookies != null) {
                for (Cookie c : cookies) {
                    if (c.getName().equals("lang")) {
                        l = c.getValue();
                        break;
                    }
                }
            }
            locale = (new Locale(l.toString()));
        }
        else{
            locale = new Locale(l.toString());
        }
        request.getSession().setAttribute("lang",l);
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        StringBuilder sb = new StringBuilder("");
        ResourceBundle bundle = ResourceBundle.getBundle("prop", locale) ;
        String id = request.getParameter("id");
        sb.append("<!DOCTYPE html>\n" +
                "<html id = \"html1\" lang = \"");
        sb.append(locale.toString());
        sb.append("\">\n" +
                "<head>\n" +
                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "    <title>Musse</title>\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" hr" +
                "ef=\"/resources/CSS/style.css\" />\n" +
                "        <script type=\"text/javascript\" src = \"/resources/JS/JavaScriptic.js\"></script>\n" +
                "    <div class = \"languages\">\n"+
                "        <input type=\"button\" class = \"lang\" id = 'butEn' onclick=setAttr('lang','en') value=\"\"/>" +
                "        <input type=\"button\" class = \"lang\" id = 'butRu' onclick=setAttr('lang','ru') value=\"\"/>" +
                "        <input type=\"button\" class = \"lang\" id = 'butFr' onclick=setAttr('lang','fr') value=\"\"/>");
        if (request.getParameter("lang") != null) {
            cookieLang = new Cookie("lang", request.getParameter("lang"));
            response.addCookie(cookieLang);
            cookieLang.setMaxAge(900);
        }
        sb.append(
                "    </div>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "\n" +
                "<div id=\"container\">\n" +
                        "        <div id=\"header\">\n" +
                        "            <div id = \"allshopname\">\n" +
                        "                <h1>Musse</h1>\n" +
                        "                <h2>");
        sb.append(bundle.getString("shopName"));
        sb.append("</h2></div>\n" +
                        "\n" +
                        "            <input type=\"button\" class = \"butbucket\" id=\"bucket\" value=\"\" onclick=\"goToBucket('");
                        sb.append(l);
                        sb.append("')\" title=\"");
        sb.append(bundle.getString("goToBucket"));
        sb.append("\" />\n" +
                        "           <button class = \"login\" onclick=\"goToAuth('<%=l%>')\" title=\"");

        if (request.getSession().getAttribute("user") == null){
         sb.append(bundle.getString("logInSystem"));
            sb.append("\"></button>");
        }
        else {
            sb.append(bundle.getString("logOutSystem"));
            sb.append("\"></button>" +
                    "<p class=\"userInfo\">");
            sb.append(bundle.getString("youEnterAs"));
            sb.append("</p>" +
                    "<a class=\"userInfo1\" href=\"myAccount.jsp?lang=");
                    sb.append(l);
                    sb.append("\" title=\"");
            sb.append(bundle.getString("goToAccount"));
            sb.append("\">");
            sb.append(request.getSession().getAttribute("user"));
            sb.append("</a>");
            BucketContainer bc = (BucketContainer) request.getSession().getAttribute("container");
            if (!bc.isEmpty()){
                sb.append("<button class=\"goToOrder\" onclick=\"goToOrder('");
                sb.append(l);
                sb.append("')\">");
                sb.append(bundle.getString("checkOut"));
                sb.append("</button>");
            }
        }
         sb.append("</div>");
                /*"<input type=\"button\" class = \"historyOfBuying\" value = \"");
        sb.append(bundle.getString("history"));
        sb.append("\"/>"+
                "    </div>*/
        sb.append("<div id=\"menu\">\n" +
                "\n" +
                "        <div id = \"catalogue\" >\n" +
                "            <input type=\"button\" class=\"catal\" onclick=setAttr1('filter','all') value=\"");
        sb.append(bundle.getString("catalog"));
        sb.append("\"/>" +
                "        </div>\n" +
                "\n" +
                "        <div id = \"instruments\">"+
                "<ul class=\"dropdown\">"+
                    "<li class=\"dropdown-top\">"+
                        "<input type=\"button\" class=\"menuType\" onclick=setAttr1('filter','string') value=\"");
        sb.append(bundle.getString("string"));
        sb.append("\"/>");
        sb.append("<ul class=\"dropdown-inside\">"+
                            "<li><input type=\"button\" class=\"menuSubtype\" onclick=setAttr1('filter','guitar') value=\"");
        sb.append(bundle.getString("guitars"));
        sb.append("\"/>"+
                "</li><li><input type=\"button\" class=\"menuSubtype\" onclick=setAttr1('filter','violin') value=\"");
        sb.append(bundle.getString("violins"));
        sb.append("\"/>"+
                "</li> <li><input type=\"button\" class=\"menuSubtype\" onclick=setAttr1('filter','cello') value=\"");
        sb.append(bundle.getString("cellos"));
        sb.append("\"/>"+
                "</li><li><input type=\"button\" class=\"menuSubtype\" onclick=setAttr1('filter','piano') value=\"");
        sb.append(bundle.getString("pianos"));
        sb.append("\"/>"+
                "</li></ul></li><li class=\"dropdown-top\">"+
                        "<input type=\"button\" class=\"menuType\" onclick=setAttr1('filter','wind') value=\"");
        sb.append(bundle.getString("wind"));
        sb.append("\"/>"+

                "<ul class=\"dropdown-inside\">"+

                            "<li><input type=\"button\" class=\"menuSubtype\" onclick=setAttr1('filter','sax') value=\"");
        sb.append(bundle.getString("sax"));
        sb.append("\"/>"+
                "</li><li><input type=\"button\" class=\"menuSubtype\" onclick=setAttr1('filter','flute') value=\"");
        sb.append(bundle.getString("flutes"));
        sb.append("\"/>"+
                "</li><li><input type=\"button\" class=\"menuSubtype\" onclick=setAttr1('filter','pipe') value=\"");
        sb.append(bundle.getString("pipes"));
        sb.append("\"/>"+
                "</li><li><input type=\"button\" class=\"menuSubtype\" onclick=setAttr1('filter','clarinet') value=\"");
        sb.append(bundle.getString("clarinets"));
        sb.append("\"/>"+
                "</li></ul> </li><li class=\"dropdown-top\">"+
                        "<input type=\"button\" class=\"menuType\" onclick=setAttr1('filter', 'keyboard') value=\"");
        sb.append(bundle.getString("keyboards"));
        sb.append("\"/>"+

                "<ul class=\"dropdown-inside\">"+

                            "<li><input type=\"button\" class=\"menuSubtype\" onclick=setAttr1('filter','synthesizer') value=\"");
        sb.append(bundle.getString("synthesizers"));
        sb.append("\"/>"+
                "</li><li><input type=\"button\" class=\"menuSubtype\" onclick=setAttr1('filter','accordion') value=\"");
        sb.append(bundle.getString("accordions"));
        sb.append("\"/>"+
                "</li><li><input type=\"button\" class=\"menuSubtype\" onclick=setAttr1('filter','bayan') value=\"");
        sb.append(bundle.getString("bayans"));
        sb.append("\"/>"+
                "</li></ul></li></ul></div>"+
                "    </div>\n" +
                "\n" +
                "    <div class=\"content\">\n" +
                "        <p id = \"instrumentname\">");
        sb.append(bundle.getString(id+"name"));
        sb.append("</p>\n" +
                "\n" +
                "        <div id = \"left\">\n" +
                "            <div id = \"image\"><img src = \"resources/images/"+id+"MainBigImage.jpg\"></div>\n");
                /*            <div style = \"margin-left: 200px\" id = \"photoes\">\n" +
                "                <a href=\"#\">\n" +
                "                    <div class=\"overlay\"><img style = \"width: 495px\" src = \"resources/images/"+id+"subImageMini1.jpg\"></div><img src = \"resources/images/"+id+"subImage1.jpg\">\n" +
                "                </a>\n" +
                "                <a href=\"#\">\n" +
                "                    <div class=\"overlay\"><img style = \"width: 495px\" src = \"resources/images/"+id+"subImageMini2.jpg\"></div><img src = \"resources/images/"+id+"subImage2.jpg\">\n" +
                "                </a>\n" +
                "            </div>\n" */
         sb.append(      "        </div>\n" +
                "\n" +
                "        <p class = \"price\">");
        sb.append(bundle.getString(id+"price"));
        sb.append("</p>\n" +
                "        <form type=\"submit\" action=\"BucketServlet1\" method=\"post\" value=\"\" >"+
                "<button name = \"id1\" class = \"buy-button\" value=\"");
                sb.append(id);
                sb.append("&");
                sb.append(bundle.getString(id+"price"));
        sb.append("\" title=\"");
        sb.append(bundle.getString("goToBucket"));
        sb.append("\" >");
        sb.append(bundle.getString("buy"));
        sb.append("</button></form><div class = \"right\">");
        sb.append("<script type=\"text/javascript\" src = \"resources/CSS/JavaScriptic.js\"></script>\n");
        sb.append("<input type='button' id='sh1' class = 'but1' onclick='show1()' value='");
        sb.append(bundle.getString("description"));
        sb.append("' ");
        if (getInitParameter("paramDesc").equals("block")){
            sb.append("style = 'border-color: #ffe6a9;'");
        }
        else{
            sb.append("style = 'border-color: gray;'");
        }
        sb.append("/>\n");
        sb.append("<input type='button' id='sh2' class = 'but1' onclick='show2()' value='");
        sb.append(bundle.getString("details"));
        sb.append("' ");
        if (getInitParameter("paramDet").equals("block")){
            sb.append("style = 'border-color: #ffe6a9;'");
        }
        else{
            sb.append("style = 'border-color: gray;'");
        }
        sb.append("/>");
        sb.append("<input type='button' id='sh3' class = 'but1' onclick='show3()' value='");
        sb.append(bundle.getString("reviews"));
        sb.append("' ");
        if (getInitParameter("paramRev").equals("block")){
            sb.append("style = 'border-color: #ffe6a9; margin-left: 3px;'");
        }
        else{
            sb.append("style = 'border-color: gray; margin-left: 3px;'");
        }
        sb.append("/><div id = 'desc' style=\"display: ");

        sb.append(getInitParameter("paramDesc"));
        sb.append("\"><p class = \"descr\">\n");
        sb.append(bundle.getString(id+"description"));
        sb.append("</p></div>");
        sb.append("<div id = 'descfull' style=\"display: ");

        sb.append(getInitParameter("paramDet"));

        sb.append("\"><p class = \"descr\" >\n");
        sb.append(bundle.getString(id+"details"));
        sb.append("</p></div><div id=\"reviews\" style=\"display: ");
        sb.append(getInitParameter("paramRev"));
        sb.append("\"><p class = \"descr\" >");
        sb.append(bundle.getString(id+"reviews"));
        sb.append("</p></div>\n" +
                        "        </div>\n" +
                        "\n" +
                        "    </div><!--content close-->\n" +
                        "\n" +
                        "    <div id=\"footer\" >\n" +
                        "\n" +
                        "    </div><!--footer close-->\n" +
                        "</div> <!--container close-->\n" +
                        "\n" +
                        "</body>\n" +
                        "</html>");
        out.println(sb.toString());
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doPost(request, response);
        response.setContentType("text/html; charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        langRequest(response,request);
    }
}
