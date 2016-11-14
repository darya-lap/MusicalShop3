package workWithServletes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class returnCookieFilter {

    public static String returnCookieFilter(HttpSession session, HttpServletRequest request){
        String l="all";
        if (request.getParameter("filter") != null){
            l = request.getParameter("filter");

        }
        else {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("filter")) {
                        l = cookie.getValue();
                        break;
                    }
                }
            }
        }
        return l;
    }
}
