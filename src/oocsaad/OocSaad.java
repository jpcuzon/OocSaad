/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oocsaad;

import java.util.Scanner;

public class OocSaad {

    
    
    
    public static void main(String[] args) 
    {
       new OocSaad();
        
    }
    
    public OocSaad(){
        
        view view1 = new view();
        view1.main();

        searchMovie();
        
        
    }
    
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