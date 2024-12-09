package hello.servlet1.web.frontcontroller.v2;

import hello.servlet1.web.frontcontroller.MyView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface ControllerV2 {

    MyView process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
