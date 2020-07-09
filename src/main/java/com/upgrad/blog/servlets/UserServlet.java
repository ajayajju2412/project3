//*******************DONE***********************

package com.upgrad.blog.servlets;
import com.upgrad.blog.dao.DAOFactory;
import com.upgrad.blog.dto.UserDTO;
import com.upgrad.blog.exceptions.EmailNotValidException;
import com.upgrad.blog.util.EmailValidator;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * TODO: 4.4. Modify the class definition to make it a Servlet class.
 * TODO: 4.5. Override doPost() method from the base Class.
 * TODO: 4.6. Retrieve the values of form attributes defined in the index.jsp file
 * TODO: 4.7. Check if password is empty or null. If empty or null, then redirect to
 * the index.jsp file with an error message "Password is a required field".
 * (Hint: Store the error message as an attribute inside request object before redirecting
 * to the index.jsp. This error message will be displayed in the index.jsp page when this
 * error arises.)
 * TODO: 4.8. If Sign In button is clicked, print "User Signed In" with the user
 * details on the console. Also, store the email id in the session object.
 * TODO: 4.9. If Sign Up button is clicked, then print "User Signed Up"
 * with the user details on the console. Also, store the email id in the session object.
 * TODO: 4.10. Check if the user is logged in or not. If yes, then redirect them
 * to the Home.jsp file. (Hint: Make use of the email id stored in the session object)
 */

/**
 * TODO: 5.4. Validate the email id that is retrieved from the request object using the
 * EmailValidator class. If the email is not valid, then redirect the user to the Sign In/
 * Sign Up page with the error message that is stored in the EmailNotValidException. This error
 * message should be displayed on the index.jsp page.
 * TODO: 5.5. Map this Servlet to "/blog/user" url using the @WebServlet annotation.
 * TODO: 5.6: Remove the same mapping from the Deployment Descriptor.
 */

/**
 * TODO: 6.10. When the user click on the Sign In button on the Sign In/ Sign Up page, handle the
 * following scenarios. (Hint: Use DAOFactory to get UserDAO)
 * 1. If the user's email is not found in the database, display "No user registered with the given email address!"
 * message on the Sign In/ Sign Up page.
 * 2. If the user's email is registered but the password is incorrect, display "Please enter valid credentials"
 * message on the Sign In/ Sign Up page.
 * 3. If the user's credentials are correct, then redirect the user to the Home.jsp page.
 * 
 * TODO: 6.11. When the user click on the Sign Up button on the Sign In/ Sign Up page, handle the
 * following scenarios (Hint: Use DAOFactory to get UserDAO)
 * 1. If the user's email is already registered on the database, display
 * "A user with this email address already exists!" message on the Sign In/ Sign Up page.
 * 2. If the user's email is unregistered, then store the user's details in the database and
 * redirect the user to the Home.jsp page.
 */
@WebServlet("/blog/user")
public class UserServlet extends HttpServlet {

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> messages = new HashMap<String, String>();
        Map<String, String> after = new HashMap<String, String>();

        req.setAttribute("messages", messages);
        req.setAttribute("after", after);

        String emailId = req.getParameter("emailId");//get value
        after.put("emailId",emailId);//if no error,previous entered data will be reflected
        String password = req.getParameter("password");//get value
        after.put("password",password);

        //error display for email using email validator
        EmailValidator e = new EmailValidator();
        try {
            if(!e.isValidEmail(emailId)){
                messages.put("password","Password is a required field");
                //req.getRequestDispatcher("index.jsp").forward(req, resp);
            }
        } catch (EmailNotValidException emailNotValidException) {
            messages.put("emailId","Email is Invalid");
        }


        //error display for password
        if(password == null || password.trim().isEmpty()){
            messages.put("password","Password is a required field");
            //req.getRequestDispatcher("index.jsp").forward(req, resp);
        }

        //working whole block
        //Start
        if(messages.isEmpty()){
            String action = req.getParameter("actionType");
            //actions for two submit buttons
            if ("Sign In".equals(action)) {
                System.out.println("User Signed In");
                System.out.println("User Details:-");
                System.out.println("EmailId: "+emailId);
                HttpSession session = req.getSession();
                session.setAttribute("sEmailId", emailId);
                //String sEmailId2 = (String) session.getAttribute("sEmailId");
                /*if (null != sEmailId2) {
                    resp.sendRedirect(req.getContextPath() + "/Home.jsp");
                }*/
                resp.sendRedirect(req.getContextPath() + "../Home.jsp");
            }
            else if("Sign Up".equals(action)) {
                System.out.println("User Signed Up");
                System.out.println("User Details:-");
                System.out.println("EmailId: "+emailId);
                HttpSession session = req.getSession();
                session.setAttribute("sEmailId", emailId);
                //String sEmailId2 = (String) session.getAttribute("sEmailId");
                /*if (null != sEmailId2) {
                    resp.sendRedirect(req.getContextPath() + "/Home.jsp");
                }*/
                resp.sendRedirect(req.getContextPath() + "../Home.jsp");
            }
        }
        //End
        else {
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }



    }
}
