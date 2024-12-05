package hello.servlet1.basic.request;

import hello.servlet1.basic.HelloServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HelloServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        String[] usernames = req.getParameterValues("username");
//        for (String username : usernames) {
//            System.out.println("username = " + username);
//
//        }

        String username = req.getParameter("username");
        String age = req.getParameter("age");

        System.out.println("username = " + username);
        System.out.println("age = " + age);
    }
}
