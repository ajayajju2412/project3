package com.upgrad.blog.dao;

/**
 * TODO: 6.12. Implement the PostsCRUD interface.
 * TODO: 6.13. Define the following methods and return null for each of them. You will provide
 * a proper implementation for each of these methods, later in this project.
 * a. findByEmail
 * b. findByTag
 * c. findAllTags
 * d. deleteById
 * TODO: 6.14. create() method should take post details as input and insert these details
 * into the POSTS table. Return the same PostDTO object which was passed as an input argument.
 */

/**
 * TODO: 7.1. Implement findByEmail() method which takes email id as an input
 * parameter and returns all the posts corresponding to the email id from the POSTS
 * table defined in the database.
 */

/**
 * TODO: 7.6. Implement deleteById() method which takes post id and email id
 * as an input parameters and delete the corresponding post from the database. If
 * the post was deleted successfully, then return true, otherwise return false.
 */

import com.upgrad.blog.db.DatabaseConnection;
import com.upgrad.blog.dto.PostDTO;

import com.upgrad.blog.interfaces.PostsCRUD;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * TODO: 7.10. Implement findAllTags() method which returns a set of all unique tags
 * in the POSTS table.
 * TODO: 7.11. Implement findByTag() method which takes "tag" as an input parameter and
 * returns all the posts corresponding to the input "tag" from the POSTS table defined
 * in the database.
 */
public class PostDAO implements PostsCRUD {

    @Override
    public List<PostDTO> findByEmail(String emailId) throws SQLException {
        List<PostDTO> postDTO=new ArrayList<>();
        Connection connection = (Connection) DatabaseConnection.getConnection();

        Statement stmt = connection.createStatement();
        stmt.executeQuery("SELECT * FROM posts WHERE emailId=" + emailId);
        return postDTO;
    }

    @Override
    public PostDTO create(PostDTO postDTO) throws SQLException {
        Connection connection = (Connection) DatabaseConnection.getConnection();

        PreparedStatement ps = connection.prepareStatement("INSERT INTO posts VALUES (?,?,?, ?, ?, ?)");
        ps.setInt(1, postDTO.getPostId());
        ps.setString(2, postDTO.getEmailId());
        ps.setString(3, postDTO.getTag());
        ps.setString(4, postDTO.getTitle());
        ps.setString(5, postDTO.getDescription());
        ps.setTimestamp(6, Timestamp.valueOf(postDTO.getTimestamp()));
        ps.executeUpdate();
        return postDTO;
    }

    @Override
    public boolean deleteById(int id, String emailId) throws SQLException {
        Connection connection = (Connection) DatabaseConnection.getConnection();

        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("DELETE FROM posts WHERE emailId=" + emailId);
        if( rs==null) {
            return true;
        }
        return false;
    }

    @Override
    public List<PostDTO> findByTag(String tag) throws SQLException {
        List<PostDTO> postDTO=new ArrayList<>();
        Connection connection = (Connection) DatabaseConnection.getConnection();

        Statement stmt = connection.createStatement();
        stmt.executeQuery("SELECT * FROM posts WHERE tag=" + tag);
        return postDTO;

    }

    @Override
    public HashSet<String> findAllTags() throws SQLException {
        HashSet<String> allTags= new HashSet<>();
        return allTags;
    }
}
