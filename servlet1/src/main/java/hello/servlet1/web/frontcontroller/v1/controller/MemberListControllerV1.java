package hello.servlet1.web.frontcontroller.v1.controller;

import hello.servlet1.domain.member.Member;
import hello.servlet1.domain.member.MemberRepository;
import hello.servlet1.web.frontcontroller.v1.ControllerV1;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class MemberListControllerV1 implements ControllerV1 {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Member> members = memberRepository.findAll();

        request.setAttribute("members", members);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/members.jsp");
        dispatcher.forward(request, response);
    }
}
