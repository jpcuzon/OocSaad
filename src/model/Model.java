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
    
    int countResult;
    
    //----------------------------------------------------------All Movies----------------------------------------------------------\\
    //counts all the movies on the database
    public int allMoviesCount(){
        
        countResult = 0;
        
        try
        {
            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
            String dbUser = "Jon_2019395";
            String dbPassword = "2019395";
            String countQuery = "Select count(*) from movie_list";
            
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
    
    //feth all the movies on the database
    public String[][] allMovies() 
    {
        int allMoviesCount = countResult;
        String[][] allMovieResult = new String[allMoviesCount][6];

        try
        {
            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
            String dbUser = "Jon_2019395";
            String dbPassword = "2019395";
            String searchQuery = "Select * from movie_list order by movie_title";
            

            Connection conn = DriverManager.getConnection(dbServer,dbUser,dbPassword);
            
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery(searchQuery);
            int row = 0;
            
            while (rs.next()) {                     
                
                allMovieResult[row][0] = rs.getString("movie_title");
                allMovieResult[row][1] = rs.getString("movie_genre");
                allMovieResult[row][2] = rs.getString("release_year");
                allMovieResult[row][3] = rs.getString("num_avail");
                allMovieResult[row][4] = rs.getString("num_rented");
                allMovieResult[row][5] = rs.getString("movie_code");
                
                row++;
                
            }

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
        
        return allMovieResult;
    }
    
    //----------------------------------------------------------Search----------------------------------------------------------\\
    //counts the search through name results
    public int countSearchTitle(String search){
        
        int countResult = 0;
        
        try
        {
            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
            String dbUser = "Jon_2019395";
            String dbPassword = "2019395";
            String countQuery = "Select count(*) from movie_list where movie_title like '%" + search + "%'";
            
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
    public String[][] searchTitle(String search)
    {
        
        int countMovie = countSearchTitle(search);
        String[][] searchMovieResult = new String[countMovie][6];

        try
        {
            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
            String dbUser = "Jon_2019395";
            String dbPassword = "2019395";
            String searchQuery = "Select * from movie_list where movie_title like '%" + search + "%'";
            

            Connection conn = DriverManager.getConnection(dbServer,dbUser,dbPassword);
            
            Statement stmt = conn.createStatement();
            
            //takes the name and locaion information
            String[][] searchMovie = new String[countMovie][6];

            ResultSet rs = stmt.executeQuery(searchQuery);
            int row = 0;
            
            int num_avail;
            while (rs.next()) {                     
                
                searchMovie[row][0] = rs.getString("movie_title");
                searchMovie[row][1] = rs.getString("movie_genre");
                searchMovie[row][2] = rs.getString("release_year");
                searchMovie[row][3] = rs.getString("num_avail");
                searchMovie[row][4] = rs.getString("num_rented");
                searchMovie[row][5] = rs.getString("movie_code");
//                num_avail = rs.getInt("num_avail");
//                if(num_avail>0){
//                    
//                    searchMovie[row][6] = rs.getString("num_avail");
//                    
//                }else{System.out.println("Not Avaialble");}
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
    
    //----------------------------------------------------------Categories----------------------------------------------------------\\
    //cout the results for the categories function first
    public int categoriesMoviesCount(String categories) 
    {
        
        countResult=0;
        
        String cateTypes = categories;
        String searchQuery=null;
        System.out.println("count result"+ cateTypes);
        switch(cateTypes){
            case "action": searchQuery = "SELECT count(*) FROM movie_list WHERE movie_genre='action' or movie_genre='adventure'"; break;
            case "comedy": searchQuery = "SELECT count(*) FROM movie_list WHERE movie_genre ='comedy'";break;
            case "drama": searchQuery = "SELECT count(*) FROM movie_list WHERE movie_genre='drama'";break;
            case "fantasy": searchQuery = "SELECT count(*) FROM movie_list WHERE movie_genre='fantasy'";break;
            case "horror": searchQuery = "SELECT count(*) FROM movie_list WHERE movie_genre='horror'";break;
            case "mystery": searchQuery = "SELECT count(*) FROM movie_list WHERE movie_genre='mystery'";break;
            case "romance": searchQuery = "SELECT count(*) FROM movie_list WHERE movie_genre='romance'";break;
            case "scifi": searchQuery = "SELECT count(*) FROM movie_list WHERE movie_genre='sci-fi'";break;
            case "thriller": searchQuery = "SELECT count(*) FROM movie_list WHERE movie_genre='thriller'";break;
            case "western": searchQuery = "SELECT count(*) FROM movie_list WHERE movie_genre='western'";break;
        }
        try
        {
            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
            String dbUser = "Jon_2019395";
            String dbPassword = "2019395";

            System.out.println("Sort Type: "+cateTypes+" Query: "+searchQuery);
            Connection conn = DriverManager.getConnection(dbServer,dbUser,dbPassword);
            
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery(searchQuery);

            rs.next();
            countResult=rs.getInt(1);

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
    
    //fetch all the movies that matches the chosen category
    public String[][] categoriesMovies(String categories) 
    {
        
        int allMoviesCount = countResult;
        String[][] cateResult = new String[allMoviesCount][6];
        String cateTypes = categories;
        String searchQuery=null;
        switch(cateTypes){
            case "action": searchQuery = "SELECT * FROM movie_list WHERE movie_genre='action' or movie_genre='adventure'"; break;
            case "comedy": searchQuery = "SELECT * FROM movie_list WHERE movie_genre ='comedy'";break;
            case "drama": searchQuery = "SELECT * FROM movie_list WHERE movie_genre='drama'";break;
            case "fantasy": searchQuery = "SELECT * FROM movie_list WHERE movie_genre='fantasy'";break;
            case "horror": searchQuery = "SELECT * FROM movie_list WHERE movie_genre='horror'";break;
            case "mystery": searchQuery = "SELECT * FROM movie_list WHERE movie_genre='mystery'";break;
            case "romance": searchQuery = "SELECT * FROM movie_list WHERE movie_genre='romance'";break;
            case "scifi": searchQuery = "SELECT * FROM movie_list WHERE movie_genre='sci-fi'";break;
            case "thriller": searchQuery = "SELECT * FROM movie_list WHERE movie_genre='thriller'";break;
            case "western": searchQuery = "SELECT * FROM movie_list WHERE movie_genre='western'";break;
        }
        try
        {
            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
            String dbUser = "Jon_2019395";
            String dbPassword = "2019395";

            System.out.println("Sort Type: "+cateTypes+" Query: "+searchQuery);
            Connection conn = DriverManager.getConnection(dbServer,dbUser,dbPassword);
            
            Statement stmt = conn.createStatement();
            
//            //takes the name and locaion information
//            String[][] cateList = new String[allMoviesCount][7];

            ResultSet rs = stmt.executeQuery(searchQuery);
            int row = 0;
            
            int num_avail;
            while (rs.next()) {                     
                
                cateResult[row][0] = rs.getString("movie_title");
                cateResult[row][1] = rs.getString("movie_genre");
                cateResult[row][2] = rs.getString("release_year");
                cateResult[row][3] = rs.getString("num_avail");
                cateResult[row][4] = rs.getString("num_rented");
                cateResult[row][5] = rs.getString("movie_code");
                
                row++;
                
            }
//            
//            cateResult = cateList;

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
        
        return cateResult;
    }
    
    //----------------------------------------------------------Sort----------------------------------------------------------\\
    //Sorts all the movies to the selected order
    public String[][] allMoviesSort(String sort) 
    {
        
        int allMoviesCount = countResult;
        String[][] sortMoviesResult = new String[allMoviesCount][6];
        String sortType = sort;
        String searchQuery=null;
        switch(sortType){
            case "Name": searchQuery = "Select * from movie_list order by movie_title";break;
            case "Popularity": searchQuery = "Select * from movie_list order by num_rented";break;
            case "Genre": searchQuery = "Select * from movie_list order by movie_genre";break;
            case "Release Date": searchQuery = "Select * from movie_list order by release_year";break;
        }
        try
        {
            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
            String dbUser = "Jon_2019395";
            String dbPassword = "2019395";
            System.out.println("Sort Type: "+sortType+" Query: "+searchQuery);
            Connection conn = DriverManager.getConnection(dbServer,dbUser,dbPassword);
            
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery(searchQuery);
            int row = 0;
            
            int num_avail;
            while (rs.next()) {                     
                
                sortMoviesResult[row][0] = rs.getString("movie_title");
                sortMoviesResult[row][1] = rs.getString("movie_genre");
                sortMoviesResult[row][2] = rs.getString("release_year");
                sortMoviesResult[row][3] = rs.getString("num_avail");
                sortMoviesResult[row][4] = rs.getString("num_rented");
                sortMoviesResult[row][5] = rs.getString("movie_code");
                
                row++;
                
            }
            
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
        
        return sortMoviesResult;
    }
    
    //sorts the search results
    public String[][] searchTitleSort(String search, String sort)
    {
        
        int countMovie = countSearchTitle(search);
        String[][] searchMovieResult = new String[countMovie][6];
        String sortType = sort;
        String searchQuery=null;
        switch(sortType){
            case "Name": searchQuery = "Select * from movie_list where movie_title like '%" + search + "%'" + " order by movie_title";break;
            case "Popularity": searchQuery = "Select * from movie_list where movie_title like '%" + search + "%'" + " order by num_rented";break;
            case "Genre": searchQuery = "Select * from movie_list where movie_title like '%" + search + "%'" + " order by movie_genre";break;
            case "Release Date": searchQuery = "Select * from movie_list where movie_title like '%" + search + "%'" + " order by release_year";break;
        }
            
        try
        {
            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
            String dbUser = "Jon_2019395";
            String dbPassword = "2019395";

            Connection conn = DriverManager.getConnection(dbServer,dbUser,dbPassword);
            
            Statement stmt = conn.createStatement();
            
            //takes the name and locaion information
            
            ResultSet rs = stmt.executeQuery(searchQuery);
            int row = 0;
            
            int num_avail;
            while (rs.next()) {                     
                
                searchMovieResult[row][0] = rs.getString("movie_title");
                searchMovieResult[row][1] = rs.getString("movie_genre");
                searchMovieResult[row][2] = rs.getString("release_year");
                searchMovieResult[row][3] = rs.getString("num_avail");
                searchMovieResult[row][4] = rs.getString("num_rented");
                searchMovieResult[row][5] = rs.getString("movie_code");
//                num_avail = rs.getInt("num_avail");
//                if(num_avail>0){
//                    
//                    searchMovie[row][6] = rs.getString("num_avail");
//                    
//                }else{System.out.println("Not Avaialble");}
                row++;
                
            }
            
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
    
    //Model for the info panel ===================== change description later
    public String[][] infoMovies(int movieCode) 
    {
//        int allMoviesCount = countResult;
        String[][] allMovieResult = new String[1][7];

        try
        {
            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
            String dbUser = "Jon_2019395";
            String dbPassword = "2019395";
            String searchQuery = "Select * from movie_list where movie_code = "+movieCode;
            

            Connection conn = DriverManager.getConnection(dbServer,dbUser,dbPassword);
            
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery(searchQuery);
            int row = 0;
            
            while (rs.next()) {                     
                
                allMovieResult[0][0] = rs.getString("movie_title");
                allMovieResult[0][1] = rs.getString("movie_genre");
                allMovieResult[0][2] = rs.getString("release_year");
                allMovieResult[0][3] = rs.getString("num_avail");
                allMovieResult[0][4] = rs.getString("num_rented");
                allMovieResult[0][5] = rs.getString("movie_code");
                allMovieResult[0][6] = rs.getString("movie_info");
                row++;
                
            }

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
        
        return allMovieResult;
    }
    
    public int movieID(int movieCode) //getting the movie ID
    {
        int movieID=0;
        
        try {

            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
            String dbUser = "Jon_2019395";
            String dbPassword = "2019395";
            String query = "Select * from movie_list where movie_code = "+movieCode;

            // Get a connection to the database
            Connection conn = DriverManager.getConnection(dbServer, dbUser, dbPassword);

            // Get a statement from the connection
            Statement stmt = conn.createStatement();

            // Execute the query
            ResultSet rs = stmt.executeQuery(query);

            // Loop through the result set
            rs.next();
            movieID = rs.getInt("id_movie");
            

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
        
        return movieID;
        
    }
    
    //test for date
    public boolean setRent(Rent rent)
    {
        boolean result = false;
        
        try
        {
            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
            String dbUser = "Jon_2019395";
            String dbPassword = "2019395";
            String update = "INSERT INTO rent (id_customer,id_movie,date_rent)" +
                    "VALUES ("+rent.getCustomerID()+","+rent.getMovieID()+",'"+rent.getRentDate()+"');";

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
    //=================================TEST====================================================
    
    public boolean userCardInput(User user)
    {
        
        boolean result = false;
        
        try {

            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
            String dbUser = "Jon_2019395";
            String dbPassword = "2019395";
            String query = "select * from movie_customers where card_num like '%"+user.getCardNumber()+"' and card_pin like '"+user.getPin()+"'";

            // Get a connection to the database
            Connection conn = DriverManager.getConnection(dbServer, dbUser, dbPassword);

            // Get a statement from the connection
            Statement stmt = conn.createStatement();

            // Execute the query
            ResultSet rs = stmt.executeQuery(query);

            // Loop through the result set
            if (rs.next()) {
                result = true;
            }

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
        
        return result;
        
    }
    
    public int[] userID(User user)
    {
        int[] userNumber= new int[2]; //stores the userNumber in index 0 and the balance on index 1
        
        try {

            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
            String dbUser = "Jon_2019395";
            String dbPassword = "2019395";
            String query = "Select * from movie_customers where card_num like '%"+user.getCardNumber()+"' and card_pin like '"+user.getPin()+"'";

            // Get a connection to the database
            Connection conn = DriverManager.getConnection(dbServer, dbUser, dbPassword);

            // Get a statement from the connection
            Statement stmt = conn.createStatement();

            // Execute the query
            ResultSet rs = stmt.executeQuery(query);

            // Loop through the result set
            rs.next();
            userNumber[0] = rs.getInt("id_customer");
            userNumber[1] = rs.getInt("balance");
            
            

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
        
        return userNumber;
        
    }
    
    public void updateNumAvailRent(int movieID) //update the number of available disk in the kiosk and also adds 1 to the number of time the movie is rented
    {
        
        try {

            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
            String dbUser = "Jon_2019395";
            String dbPassword = "2019395";
            String query = "Update movie_list "
                    + "Set num_avail = num_avail-1, num_rented = num_rented + 1 "
                    + "where id_movie = "+movieID;

            // Get a connection to the database
            Connection conn = DriverManager.getConnection(dbServer, dbUser, dbPassword);

            // Get a statement from the connection
            Statement stmt = conn.createStatement();

            // Execute the query
            stmt.executeUpdate(query);

            // Loop through the result set
            
            // Close the statement and the connection
            
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            System.out.println("SQL Exception (num Avail):");

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
        
        
    }
    
    public void deductBalance(int customerID) //charges the customer 2.99 euros for their rent and add 1 to the "times_used" column (the number of times they rented)
    {
        
        try {

            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
            String dbUser = "Jon_2019395";
            String dbPassword = "2019395";
            String query = "Update movie_customers "
                    + "Set balance = balance - 2.99, times_used = times_used + 1 "
                    + "where id_customer = "+customerID;

            // Get a connection to the database
            Connection conn = DriverManager.getConnection(dbServer, dbUser, dbPassword);

            // Get a statement from the connection
            Statement stmt = conn.createStatement();

            // Execute the query
            stmt.executeUpdate(query);

            // Loop through the result set
            
            // Close the statement and the connection
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            System.out.println("SQL Exception(deduct)");

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
        
        
    }
    
        //assigns a card number to a customer
    public boolean newCard(Card cardDetails)
    {
        boolean result = false;
        
        try
        {
            String dbServer = "jdbc:mysql://52.50.23.197:3306/Jon_2019395?useSSL=false";
            String dbUser = "Jon_2019395";
            String dbPassword = "2019395";
            String update = "INSERT INTO movie_customers (card_num,card_pin, balance,times_used)" +
                    "VALUES ('"+cardDetails.getCardNumber()+"','"+cardDetails.getPin()+"','"+cardDetails.getBalance()+"',0);";

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
    
    
}
