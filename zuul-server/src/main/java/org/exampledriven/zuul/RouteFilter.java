package org.exampledriven.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import java.net.MalformedURLException;
import java.net.URL;

public class RouteFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "route";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        System.out.println("Inside Route Filter");
        RequestContext context = RequestContext.getCurrentContext();
        System.out.println("==============" + context.getRequest().getHeaderNames());
        System.out.println("==============" + context.getRequest().getRequestURL());
        System.out.println("==============" + context.getRequest().getRequestURI());
        if (context.getRequest().getRequestURI().contains("controller")) {
            try {
                //                context.setRouteHost(new URL("http://192.168.99" +
                //                        ".100:9090/api/echo-service/echo"));
                //                String url = UriComponentsBuilder.fromHttpUrl("http://localhost:9090").path("/api")
                //                        .path("/echo-service"
                //                                "/echo")
                //                                                 .build()
                //                                                 .toUriString();
                //                context.set("requestURI", "/api/echo-service/echo");
                String host = context.getRequest().getParameter("url");
                context.setRouteHost(new URL(host));
//                context.setRouteHost(new URL("http://192.168.99.100:9099"));
//                context.setRouteHost(new URL("http://0.0.0.0:8080"));
                String path = context.getRequest().getParameter("path");
//                String path = "/echo";
//                String path = "/controller";
                if( path != null) {
                    context.set("requestURI", path);
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
