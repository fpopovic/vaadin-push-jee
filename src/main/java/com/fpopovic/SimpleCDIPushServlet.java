package com.fpopovic;

import com.vaadin.server.VaadinServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by fp on 18.9.2014.
 */
/*@WebServlet(value = "*//*", asyncSupported = true, initParams = {@WebInitParam(name = "session-timeout",value = "60"),@WebInitParam(name = "UIProvider",value = "com.fpopovic.ui.SimpleCDIPushUIProvider")})
@VaadinServletConfiguration(ui = SimpleCDIPushUI.class,productionMode = false,closeIdleSessions = true)*/
public class SimpleCDIPushServlet extends VaadinServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.service(request, response);
    }
}
