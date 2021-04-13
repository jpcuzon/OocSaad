/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jonpaulcarlo
 */
public class Model {
    
    //counts the search through name results
    public int countSearchTitle(Movies search){
        
        int countResult = 0;
        
        try
        {
            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
            String dbUser = "Jon_2019395";
            String dbPassword = "2019395";
//            String countQuery = "select count(*) from barbers where full_name like '%" + search.getSearchBarber() + "%';"; 
            String countQuery = "Select count(*) from movie_list where movie_title like '%" + search.getSearchTitle() + "%'";
            
            Connection conn = DriverManager.getConnection(dbServer,dbUser,dbPassword);
            
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery(countQuery);
            rs.next();
            countResult = rs.getInt(1);
            
            // Close the result set, statement and the connection
            rs.close();
            stmt.close();
            conn.close();
   
        } catch (SQLException se) {
            System.out.println("SQL Exception:");

            // Loop through the SQL Exceptions
            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return countResult;
    }
    
    //search for a match on movie title
    public String[][] searchTitle(Movies search)
    {
        
        int countMovie = countSearchTitle(search);
        String[][] searchMovieResult = new String[countMovie][4];

        try
        {
            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
            String dbUser = "Jon_2019395";
            String dbPassword = "2019395";
            String searchQuery = "Select * from movie_list where movie_title like '%" + search.getSearchTitle() + "%'";
            

            Connection conn = DriverManager.getConnection(dbServer,dbUser,dbPassword);
            
            Statement stmt = conn.createStatement();
            
            //takes the name and locaion information
            String[][] searchMovie = new String[countMovie][4];

            ResultSet rs = stmt.executeQuery(searchQuery);
            int row = 0;
            
            int num_avail;
            while (rs.next()) {                     
                
                searchMovie[row][0] = rs.getString("movie_title");
                searchMovie[row][1] = rs.getString("movie_genre");
                searchMovie[row][2] = rs.getString("release_year");
                num_avail = rs.getInt("num_avail");
                if(num_avail>0){
                    
                    searchMovie[row][3] = rs.getString("num_avail");
                    
                }else{System.out.println("Not Avaialble");}
                row++;
                
            }
            
            searchMovieResult = searchMovie;

            // Close the result set, statement and the connection
            rs.close();
            stmt.close();
            conn.close();
            
        } catch (SQLException se) {
            System.out.println("SQL Exception:");

            // Loop through the SQL Exceptions
            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return searchMovieResult;
    }
    
    
    
    //assigns a card number to a customer
    public boolean UserCard(User cardDetails)
    {
        boolean result = false;
        
        try
        {
            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
            String dbUser = "Jon_2019395";
            String dbPassword = "2019395";
            String update = "INSERT INTO movie_customers (card_num,card_pin)" +
                    "VALUES ('"+cardDetails.cardNumber+"','"+cardDetails.cardPin+"');";

            //Get a connection to the database
            Connection conn = DriverManager.getConnection(dbServer, dbUser, dbPassword);

            //get a statement from the connection
            Statement stmt = conn.createStatement();
            
            //execute the query
            stmt.executeUpdate(update);
            
            stmt.close();
            conn.close();
        
        }catch (SQLException se) 
        {
            System.out.println("SQL Exception: ");
            
            //Loop through the Exceptions
            while(se != null) 
            {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());
                
                se = se.getNextException();
            } 
        }catch (Exception e)
        {
            System.out.println(e);
        }
        
        
        return result;
    }
    
    //check if there's a much of the pin
    public int countPin(User pin){
        
        int countResult = 0;
        
        try
        {
            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
            String dbUser = "Jon_2019395";
            String dbPassword = "2019395";
//            String countQuery = "select count(*) from barbers where full_name like '%" + search.getSearchBarber() + "%';"; 
            String countQuery = "Select count(*) from movie_customers where card_pin like '" + pin.cardPin + "'";
            
            Connection conn = DriverManager.getConnection(dbServer,dbUser,dbPassword);
            
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery(countQuery);
            rs.next();
            countResult = rs.getInt(1);
            
            // Close the result set, statement and the connection
            rs.close();
            stmt.close();
            conn.close();
   
        } catch (SQLException se) {
            System.out.println("SQL Exception:");

            // Loop through the SQL Exceptions
            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return countResult;
    }
    
    
    
    //checks for a match of pin
    public String[] checkPin(User pin)
    {
        
//        int countMovie = countSearchTitle(search);
        String checkPin[] = new String[2];

        try
        {
            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
            String dbUser = "Jon_2019395";
            String dbPassword = "2019395";
            String searchQuery = "Select * from movie_customers where card_pin like '%" + pin.cardPin + "%'";
            

            Connection conn = DriverManager.getConnection(dbServer,dbUser,dbPassword);
            
            Statement stmt = conn.createStatement();
            
            //takes the name and locaion information
            String[] pinTemp = new String[2];

            ResultSet rs = stmt.executeQuery(searchQuery);
            int row = 0;
            
            while (rs.next()) {                     
                
                pinTemp[0] = rs.getString("card_num");
                pinTemp[1] = rs.getString("card_pin");                
            }
            
            checkPin = pinTemp;

            // Close the result set, statement and the connection
            rs.close();
            stmt.close();
            conn.close();
            
        } catch (SQLException se) {
            System.out.println("SQL Exception:");

            // Loop through the SQL Exceptions
            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return checkPin;
    }
    
}
