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
    
    
    
    
    
}
