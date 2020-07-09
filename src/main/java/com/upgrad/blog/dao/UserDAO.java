package com.upgrad.blog.dao;

import com.upgrad.blog.db.DatabaseConnection;
import com.upgrad.blog.dto.UserDTO;

import com.upgrad.blog.interfaces.UserCRUD;

import java.sql.*;

/**
 * TODO: 6.5. Implement the UserCRUD interface.
 * TODO: 6.6. findByEmail() method should take email id as an input parameter and
 * return the user details corresponding to the email id from the USERS table defined
 * in the database.
 * TODO: 6.7. create() method should take user details as input and insert these details
 * into the USERS table. Return the same UserDAO object which was passed as an input argument.
 */
public class UserDAO implements UserCRUD {

    public static void main(String[] args) {
        try {
            UserDAO userDAO = new UserDAO();
            UserDTO temp = new UserDTO();
            temp.setUserId(1);
            temp.setEmailId("temp@temp.temp");
            temp.setPassword("temp");
            userDAO.create(temp);
            System.out.println(userDAO.findByEmail("temp@temp.temp"));
        } catch (Exception e) {
            System.out.println("FAILED");
        }

        /**
         * Following should be the desired output of the main method.
         * UserDTO{userId=11, emailId='temp@temp.temp', password='temp'}
         */
    }

    @Override
    public UserDTO findByEmail(String emailId) throws SQLException {
        Connection connection = (Connection) DatabaseConnection.getConnection();

        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE emailId=" + emailId);
        if (rs.next()) {
            UserDTO userDTO = new UserDTO();
            userDTO.setEmailId(rs.getString("emailId"));
            userDTO.setUserId(rs.getInt("Id"));
            userDTO.setPassword(rs.getString("password"));
            return userDTO;
        }
        return null;
    }

    @Override
    public UserDTO create(UserDTO userDTO) throws SQLException {

        Connection connection = (Connection) DatabaseConnection.getConnection();

        PreparedStatement ps = connection.prepareStatement("INSERT INTO users VALUES ( ?, ?, ?)");
        userDTO.setUserId(1);
        ps.setInt(1, userDTO.getUserId());
        ps.setString(2, userDTO.getEmailId());
        ps.setString(3, userDTO.getPassword());
        ps.executeUpdate();
        return userDTO;
    }






}
