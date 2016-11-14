package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "LogFilter")
public class LogFilter implements Filter {

    private ServletContext conteхt;
    public LogFilter() {}
    public void destroy() {}
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) request;
        String ip = httpReq.getRemoteAddr();
        String uri = httpReq.getRequestURI();
        conteхt.log("ip: " + ip + ", uri: " + uri);
        chain.doFilter(request, response);
    }
    public void init(FilterConfig config) throws ServletException {
       conteхt = config.getServletContext();
    }
}

