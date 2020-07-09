package com.upgrad.blog.db;

import java.sql.SQLException;

import java.sql.*;
import java.util.*;

/**
 * TODO 6.2: Implement the DatabaseConnection class using the Singleton Pattern (Hint. Should have the
 * private no-arg constructor).
 * TODO 6.3: The getInstance() method should create a connection object which is
 * connected with the local database and return this connection object.
 * TODO 6.4: You should handle the ClassNotFoundException and SQLException individually,
 * and not using the Exception class.
 */
public class DatabaseConnection {
    private static DatabaseConnection userDAO;
    private  DatabaseConnection(){

    }
    public static DatabaseConnection  getConnection(){
        if(userDAO==null)
            userDAO =new DatabaseConnection();
        return  userDAO;

    }
    public static void main(String[] args) {

        try {
            DatabaseConnection.getConnection( );
            System.out.println("Connected");
        } catch (Exception e) {
            System.out.println("Not Connected");
        }
    }

}