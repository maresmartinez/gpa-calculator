/*
 * Course: PROG 32758
 * Instructor: Wendi Jollymore
 * Date Created: 13-Oct-2018
 * Author: Mariel Martinez
 */

package ca.sheridancollege.marmarie.servlets;

import ca.sheridancollege.marmarie.bus.Course;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mariel Martinez (marmarie)
 */
public class CalcGpa extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        

        // Retrieve all values
        String[] courseCodes = request.getParameterValues("codes");
        for (String courseCode : courseCodes) {
            if (courseCode == null || courseCode.trim().isEmpty()) {
                throw new ServletException(
                        "All courses must have a code value.");
            }
        }
        
        String[] txtCredits = request.getParameterValues("credits");
        Double[] credits = new Double[txtCredits.length];
        for (int i = 0; i < credits.length; i++) {
            if (txtCredits[i] == null || txtCredits[i].trim().isEmpty()) {
                throw new ServletException(
                        "All courses must have a credit value.");
            }
            credits[i] = Double.parseDouble(txtCredits[i]);
        }
        
        String[] txtGrades = request.getParameterValues("grades");
        Double[] grades = new Double[txtCredits.length];
        for (int i = 0; i < grades.length; i++) {
            if (txtGrades[i] == null || txtGrades[i].trim().isEmpty()) {
                throw new ServletException(
                        "All courses must have a grade value.");
            }
            grades[i] = Double.parseDouble(txtGrades[i]);
        }
        
        // Construct ArrayList of Course Objects
        ArrayList<Course> courses = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            courses.add(new Course(courseCodes[i], credits[i], grades[i]));
        }
        
        // Forward to showGpa.jsp
        request.setAttribute("courses", courses);
        request.getRequestDispatcher("showGpa.jsp").forward(request, response);
    } 

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

    /** 
     * Handles the HTTP <code>GET</code> method.
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

}
