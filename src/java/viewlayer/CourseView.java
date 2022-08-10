/* File: AuthorsSummaryView2.java
 * AuthorDTO: Stanley Pieda
 * Date: 2015
 * Description: Demonstration of DAO Design Pattern with Servlet website
 */
package viewlayer;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businesslayer.CoursesBusinessLogic;
import transferobjects.Course;
import java.util.List;
import transferobjects.CredentialsDTO;

/**
 *
 * @author Stanley Pieda
 */
public class CourseView extends HttpServlet {
    private CredentialsDTO creds=new CredentialsDTO();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Authors Summary View</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Authors Summary View at " + request.getContextPath() + "</h1>");
          
            creds.setUsername(request.getParameter("username"));
            creds.setPassword(request.getParameter("password"));
            
            CoursesBusinessLogic logic = new CoursesBusinessLogic(creds);
            List<Course> courses = logic.getAllCourses();
            out.println("<table border=\"1\">");
            out.println("<tr>");
            out.println("<td>CourseCode</td>");
            out.println("<td>CourseName</td>");
            out.println("<td>CourseDescription</td>");
            out.println("</tr>");
            for(Course course : courses){
                out.printf("<tr><td>%d</td><td>%s</td><td>%s</td></tr>",
                    course.getCourseCode(), course.getCourseName(), course.getCourseDescription());
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
