package hello.servlet1.web.frontcontroller.v2;

import hello.servlet1.web.frontcontroller.MyView;
import hello.servlet1.web.frontcontroller.v1.ControllerV1;
import hello.servlet1.web.frontcontroller.v2.controller.MemberFormControllerV2;
import hello.servlet1.web.frontcontroller.v2.controller.MemberListControllerV2;
import hello.servlet1.web.frontcontroller.v2.controller.MemberSaveControllerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {

    private Map<String, ControllerV2> controllerV2Map = new HashMap<>();

    public FrontControllerServletV2() {
        controllerV2Map.put("/front-controller/v2/members/save", new MemberSaveControllerV2());
        controllerV2Map.put("/front-controller/v2/members", new MemberListControllerV2());
        controllerV2Map.put("/front-controller/v2/members/new-form", new MemberFormControllerV2());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("FrontControllerServletV2.service");

        String requestURI = req.getRequestURI();
        System.out.println("requestURI = " + requestURI);

        ControllerV2 controller = controllerV2Map.get(requestURI);
        if(controller == null){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MyView view = controller.process(req, resp);
        view.render(req, resp);
    }
}
