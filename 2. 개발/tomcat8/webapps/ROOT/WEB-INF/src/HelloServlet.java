package cuh.sv;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class HelloServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		res.setContentType("text/html;charset=utf-8");
		PrintWriter pw = res.getWriter();
		pw.println("<meta charset='utf-8'>");
		pw.println("<center>");
		//pw.println("<h2 style='color:blue'>Hello 운학</h2>");
		pw.println("<h2 style='color:#3a3d27;font-family:궁서체,sans-serif'>HTML 공부중...</h2>");
		pw.println("<img src='https://www.sports-g.com/wp-content/uploads/2019/02/%EB%88%88%EC%9D%B4-%EB%B6%80%EC%8B%9C%EA%B2%8C%ED%8F%AC%EC%8A%A4%ED%84%B0.jpg'");
		//pw.println("<img src='C:/CUH/오목/img/kakao1.png'");
		pw.println("<br>");
		//pw.println("<video width='320' height='240' controls>");
            //pw.println("<source src='video/video.mp4' type='video/mp4'>");
        //pw.println("</video>");
		pw.println("<iframe width='956' height='538' src='https://www.youtube.com/embed/13qaU1kUIdE' frameborder='0' allow='accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture' allowfullscreen></iframe>");
		//pw.println("<iframe width='600' height='500' src='https://www.youtube.com/watch?v=KQiqzFmKti0'");
		//pw.println("</iframe>");
		pw.println("</center>");
		//https://youtu.be/YCR5lVMmX-c
	}
}