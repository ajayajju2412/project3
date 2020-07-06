//*******************DONE***********************
package com.upgrad.blog.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

public class UserServlet {

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
