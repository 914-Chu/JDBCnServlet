import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.phctw.bean.Student;
import tw.com.phctw.service.StudentServiceImpl;

/**
 * Servlet implementation class Demo
 */
@WebServlet(
		urlPatterns = { 
				"/StudentServlet", 
				"/TestServlet"
		}, 
		initParams = { 
				@WebInitParam(name = "default", value = "default value")
		})
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
     * Default constructor. 
     */
    public StudentServlet() {
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException{
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		if(request.getParameter("page").equals("insert")) {
			int num = Integer.parseInt(request.getParameter("num"));
			
			StudentServiceImpl impl = new StudentServiceImpl();
			HashMap<String, Integer> result = impl.generate(num);			
//			printList(list);
//			System.out.println(result.get("success"));
//			System.out.println(result.get("failed"));
			
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8"); 
			
			request.getSession().setAttribute("success", result.get("success"));
			request.getSession().setAttribute("failed", result.get("failed"));
			
			//response.sendRedirect("insertStudent.jsp");
			//response.sendRedirect("showStudent.jsp");
			
			request.getRequestDispatcher("/insertStudent.jsp").forward(request, response);
			return;
		}else if(request.getParameter("page").equals("show")) {
			StudentServiceImpl impl = new StudentServiceImpl();
			ArrayList<Student> list = impl.selectStudent();
			printList(list);
			request.getSession().setAttribute("list", list);
			request.getRequestDispatcher("showStudent.jsp").forward(request, response);
			return;
		}
	}
	
	public void destroy() {
		
	}
	
	private static void printList(ArrayList<Student> list) {
		System.out.println("Size: " + list.size());
		for(Student s : list) {
			System.out.println(s);
		}
		System.out.println();
	}
}
