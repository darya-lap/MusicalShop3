package workWithServletes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class returnCookieLang {

    public static String returnCookieLang(HttpSession session, HttpServletRequest request){
        String l="ru";
        if (session.getAttribute("lang") == null) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null){
                for(Cookie cookie:cookies) {
                    if (cookie.getName().equals("lang")) {
                        l = cookie.getValue();
                        break;
                    }
                }
            }
        }
        else{
            l = session.getAttribute("lang").toString();
        }
        return l;
    }

}
