// To save as "ebookshop\WEB-INF\classes\QueryServlet.java".
import java.io.*;
import java.sql.*;
import jakarta.servlet.*;            // Tomcat 10
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
//import javax.servlet.*;            // Tomcat 9
//import javax.servlet.http.*;
//import javax.servlet.annotation.*;

@WebServlet("/cardshopquery")   // Configure the request URL for this servlet (Tomcat 7/Servlet 3.0 upwards)
public class CardshopQueryServlet extends HttpServlet {

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
         // Step 3: Execute a SQL SELECT query
         String[] cardname = request.getParameterValues("cardname");  // Returns an array of Strings
         String sqlStr = "SELECT * FROM cards101 WHERE cardname IN (";
         for (int i = 0; i < cardname.length; ++i) {
            if (i < cardname.length - 1) {
               sqlStr += "'" + cardname[i] + "', ";  // need a commas
            } else {
               sqlStr += "'" + cardname[i] + "'";    // no commas
            }
         }
         sqlStr += ") AND qty > 0 ORDER BY cardname ASC, price ASC";
         out.println("<h3>Thank you for adding to your cart!</h3>");
         out.println("<p>Your cart is:</p>"); // Echo for debugging
         ResultSet rset = stmt.executeQuery(sqlStr);  // Send the query to the server

         // Step 4: Process the query result
         // Print the <form> start tag
         out.println("<form method='get' action='cardshoporder'>");

         out.println("<audio controls>"
            + "<source src=\"Music/jazz_driftveilcity.mp3\" width=\"150\" height=\"90\" loop=\"true\" hidden=\"false\" autostart=\"true\">"
            + "</audio>");
         
         out.println(
            "<table border=\"1\">" +
            "<tr>" +
               "<th>Select</th>" +
               "<th>Card Name</th>" +
               "<th>Card Set</th>" +
               "<th>Price</th>" +
               "<th>Quantity</th>" +
               "</tr>");
               // For each row in ResultSet, print one checkbox inside the <form>
               while (rset.next()) {
                  out.println("<tr>" +
                          "<td><p><input type='checkbox' name='id' value='" + rset.getString("id") + "' /></td>"
                          + "<td>" + rset.getString("cardname") + "</td>"
                          + "<td>" + rset.getString("cardset") + "</td>"
                          + "<td>" + "$" + rset.getString("price") + "</td>"
                          + "<td><form method='post' action='updateQuantity.jsp'>" + // Form for updating quantity
                          "<input type='hidden' name='id' value='" + rset.getString("id") + "' />" + // Hidden input for card ID
                          "<select name='quantity' size='1'>" + // Select dropdown for quantity
                          "<option value='1'>1</option>" +
                          "<option value='2'>2</option>" +
                          "<option value='3'>3</option>" +
                          "<option value='4'>4</option>" +
                          "</form></td>" +
                          "</tr>");
              }
         out.println("</table>");

         out.println(
                  "<p>Enter your Name: <input type='text' name='cust_name' /></p>" +
                  "<p>Enter your Email: <input type='text' name='cust_email' /></p>" +
                  "<p>Enter your Phone Number: <input type='text' name='cust_phone' /></p>");
 
         // Print the submit button and </form> end-tag
         out.println("<p><input type='submit' value='Checkout!' />");
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