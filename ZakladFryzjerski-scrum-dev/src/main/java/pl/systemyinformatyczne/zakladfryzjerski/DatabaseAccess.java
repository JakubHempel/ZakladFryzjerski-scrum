package pl.systemyinformatyczne.zakladfryzjerski;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class DatabaseAccess extends HttpServlet{

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // JDBC driver name and database URL
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
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
                "<h1 align = \"center\">" + title + "</h1>\n");

        try {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Open a connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Execute SQL query
            PreparedStatement st = conn
                    .prepareStatement("insert into clients values(?, ?, ?)");

            // For the first parameter,
            // get the data using request object
            // sets the data to st pointer
            st.setInt(1, Integer.valueOf(request.getParameter("id")));

            // Same for second parameter
            st.setString(2, request.getParameter("name"));
            st.setString(3, request.getParameter("surname"));

            // Execute the insert command using executeUpdate()
            // to make changes in database
            st.executeUpdate();

            // Close all the connections
            st.close();
            conn.close();

            // Get a writer pointer
            // to display the successful result
            out.println("<html><body><center><b>Successfully Inserted"
                    + "</b><br><br><form action=./><input type=submit value=Powrot></form></center></body></html>");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}