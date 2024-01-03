package com.example.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//새로운 회원을 등록하는 서블릿

@WebServlet(name = "SaveServlet", urlPatterns = "/servlet/save")
public class SaveServlet extends HttpServlet {

	@Autowired
	MemberRepo repo;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//요청 메세지에서 사용자가 전달한 파라미터 꺼내기
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		Member member = Member.builder().userId(username).password(password).build();
		
		Member newMember = repo.save(member);
		
		//응답 메세지 만들기
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		
		// html 내용 작성
        PrintWriter w = resp.getWriter();
        
        w.write("<html>\n" +
                "<body>\n" +
                newMember.getNo() + "번 회원을 등록 했습니다!\n" +
                "</body>\n" +
                "</html>");
		
	}
	
	
	
}
