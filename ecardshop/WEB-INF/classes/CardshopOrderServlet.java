// To save as "ebookshop\WEB-INF\classes\QueryServlet.java".
import java.io.*;
import java.sql.*;
import jakarta.servlet.*;            // Tomcat 10
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
//import javax.servlet.*;            // Tomcat 9
//import javax.servlet.http.*;
//import javax.servlet.annotation.*;

@WebServlet("/cardshoporder")   // Configure the request URL for this servlet (Tomcat 7/Servlet 3.0 upwards)
public class CardshopOrderServlet extends HttpServlet {

   // The doGet() runs once per HTTP GET request to this servlet.
   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException {
      // Set the MIME type for the response message
      response.setContentType("text/html");
      // Get a output writer to write the response message into the network socket
      PrintWriter out = response.getWriter();
      // Print an HTML page as the output of the query
      out.println("<html>");
      out.println("<head><title>Query Response</title></head>");
      out.println("<body>");

      try (
         // Step 1: Allocate a database 'Connection' object
         Connection conn = DriverManager.getConnection(
               "jdbc:mysql://localhost:3306/ecardshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
               "myuser", "xxxx");   // For MySQL
               // The format is: "jdbc:mysql://hostname:port/databaseName", "username", "password"

         // Step 2: Allocate a 'Statement' object in the Connection
         Statement stmt = conn.createStatement();
      ) {
    // Step 3 & 4: Execute a SQL SELECT query and Process the query result
         // Retrieve the cards' id. Can order more than one card.
         String[] ids = request.getParameterValues("id");
         String name = request.getParameter("cust_name");
         String email = request.getParameter("cust_email");
         String phone = request.getParameter("cust_phone");
         String quantity = request.getParameter("quantity");

         out.println("<audio controls>"
            + "<source src=\"Music/jazz_driftveilcity.mp3\" width=\"150\" height=\"90\" loop=\"true\" hidden=\"false\" autostart=\"true\">"
            + "</audio>");

         if (ids != null) {
            String sqlStr;
            int count;
 
            // Process each of the cards
            for (int i = 1; i < ids.length; ++i) {
               // Get the quantity parameter from the request

               // Update the qty of the table cards101
               sqlStr = "UPDATE cards101 SET qty = qty - " + quantity + " WHERE id = " + ids[i];
               out.println("<p>" + sqlStr + "</p>");  // for debugging
               count = stmt.executeUpdate(sqlStr);
               out.println("<p>" + count + " record updated.</p>");
               out.println("Your purchase is successful!");
 
               // Create a transaction record
               sqlStr = "INSERT INTO order_records (id, qty_ordered, cust_name, cust_email, cust_phone) VALUES ("
                     + ids[i] + ", " + quantity + ", " + "\'" + name + "\'" + ", " + "\'" + email + "\'" + ", " + "\'" + phone + "\'" + ")";
               out.println("<p>" + sqlStr + "</p>");  // for debugging
               count = stmt.executeUpdate(sqlStr);
               out.println("<p>" + count + " record inserted.</p>");
               out.println("<h3>Your order for card id=" + ids[i]
                     + " has been confirmed.</h3>");
            }
            out.println("<h3>Thank you. Please visit our shop again!<h3>");
         } else { // No card selected
            out.println("<h3>No card selected! Please go back and select items to checkout.</h3>");
         }
 
         // Print the submit button and </form> end-tag
         out.println("<a href=\"HomePage.html\">"
            + "<button>Continue shopping!</button>"
            + "</a>");
         out.println("</form>");
      } catch(SQLException ex) {
         out.println("<p>Error: " + ex.getMessage() + "</p>");
         out.println("<p>Check Tomcat console for details.</p>");
         ex.printStackTrace();
      }  // Step 5: Close conn and stmt - Done automatically by try-with-resources (JDK 7)
 
      out.println("</body></html>");
      out.close();
   }
}