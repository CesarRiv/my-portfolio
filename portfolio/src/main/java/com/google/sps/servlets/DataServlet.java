
package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import java.io.IOException;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.SortDirection;
/** Servlet that returns some example content. TODO: modify this file to handle comments data */
@WebServlet("/data")
public class DataServlet extends HttpServlet {



   
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    ArrayList<String> cars = new ArrayList<String>();
    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
 

    String json = convertToJson(cars);

    // Send the JSON as the response
    response.setContentType("application/json;");
    response.getWriter().println(json);

  }


    private String convertToJson(ArrayList<String> cars) {
    String json = "{";
    json += "\"firstCar\": ";
    json += "\"" + cars.get(0) + "\"";
    json += ", ";
    json += "\"middleCar\": ";
    json += "\"" + cars.get(1) + "\"";
    json += ", ";
    json += "\"lastCar\": ";
    json += "\"" + cars.get(2) + "\"";
    json += "}";
    return json;
    }

}
   
    