package pl.systemyinformatyczne.zakladfryzjerski;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ViewClient extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // JDBC driver name and database URL
        final  String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL="jdbc:mysql://localhost:3306/demoprj";

        //  Database credentials
        final String USER = "root";
        final String PASS = "admin";

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Database Result";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor = \"#f0f0f0\">\n" +
                "<h1 align = \"center\"> Lista klientow </h1>\n");

        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Execute SQL query
            String sql;
            sql = "SELECT * FROM clients";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            //rs.getInt(Integer.valueOf(request.getParameter("id")));
            // Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("id");
                String first = rs.getString("name");
                String last = rs.getString("surname");

                //Display values
                out.println("<center>ID: " + id );
                out.println(", Imie: " + first);
                out.println(", Nazwisko: " + last + "</center><br>");
            }
            out.println("</body></html>");
            // For the first parameter,
            // get the data using request object
            // sets the data to st pointer


            // Execute the insert command using executeUpdate()
            // to make changes in database

            // Close all the connections
            stmt.close();
            conn.close();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}