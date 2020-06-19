
package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import com.google.gson.Gson;

/** Servlet that returns some example content. TODO: modify this file to handle comments data */
@WebServlet("/data")
public class DataServlet extends HttpServlet {

    ArrayList<String> comments = new ArrayList<String>();
    

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    // Get the input from the form.
    
    String comment = getParameter(request, "comment", "");

    
    comments.add(comment);
    System.out.println("comment was added");
    
     System.out.println(comments.get(0));
    
    response.getWriter().println(comments.get(0));
   
   response.sendRedirect("/index.html");
  }

    private String getParameter(HttpServletRequest request, String name, String defaultValue) {
    String value = request.getParameter(name);
    if (value == null) {
      return defaultValue;
    }
    return value;
  }
}
   
    