/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Scanner;
import model.Model;
import model.Movies;

/**
 *
 * @author jonpaulcarlo
 */
public class MovieController {
    
    public void searchMovie(){
        
        int countSearch;
        String searchMovieResult[][];
        
        Model model = new Model();
        Scanner kb = new Scanner(System.in);
        
        System.out.print("Welcome! \nSearch: ");
        String search = kb.nextLine();
        
        Movies searchMovie = new Movies(search);
        
        model.countSearchTitle(searchMovie);
        
        countSearch = model.countSearchTitle(searchMovie);
        if(countSearch==0)
        {
            System.out.println("No Results Found");
        }
        else
        {
            searchMovieResult = model.searchTitle(searchMovie); 
           
            for(int i=0;i<searchMovieResult.length;i++)       //for the rows
            {
                for(int j=0;j<4;j++)   //for the columns
                {
                    System.out.println(searchMovieResult[i][j]);         //initalizing the value of squares into 0;
                    
                }  
                System.out.println("");
            }

        }


    }
    
}
