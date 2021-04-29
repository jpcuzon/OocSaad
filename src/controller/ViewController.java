/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import model.Model;
import model.Movies;
import view.View;

/**
 *
 * @author jonpaulcarlo
 */
public class ViewController implements ActionListener {
    View view;
    Model model;
    
    private int allMovieCount = 0;
    private String[][] allMovies;
    String search;
    int categoriesCount;
    String [][] categoriesResult;

    public ViewController (){
      this.view = new View(this);
      this.model = new Model();
    }

    @Override
    //rent movie
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("rent")){
            
            allMovieCount = model.allMoviesCount();
            allMovies = model.allMovies();
            for(int i=0;i<allMovies.length;i++)       //for the rows
                {
                    for(int j=0;j<6;j++)   //for the columns
                    {
                        System.out.println(allMovies[i][j]);         //initalizing the value of squares into 0;

                    }  
                    System.out.println("");
                }
            view.getWelcome().dispatchEvent(new WindowEvent(view.getWelcome(), WindowEvent.WINDOW_CLOSING));//disposes the other frame when this frame opens
//            view.welcome.remove();
            view.main();  
            
        }
        
        //image as a button, return to welcome screen
//        if(e.getActionCommand().equals("logo")){
//            System.out.println("welcome screen");
//            view.welcome();
//        }
        //return screen
        if(e.getActionCommand().equals("retur")){
            System.out.println("return a movie");
            view.getWelcome().dispatchEvent(new WindowEvent(view.getWelcome(), WindowEvent.WINDOW_CLOSING));
            view.returnn();
        }
        
        //FAQ
        if(e.getActionCommand().equals("faq")){
            System.out.println("FAQ frame for help");
            view.getMain().dispatchEvent(new WindowEvent(view.getMain(), WindowEvent.WINDOW_CLOSING));
            view.faq();
        }
        if(e.getActionCommand().equals("back")){
            System.out.println("back to home movies");
            view.getFaq().dispatchEvent(new WindowEvent(view.getFaq(), WindowEvent.WINDOW_CLOSING));
            view.main();
        }
        
                                                     
        //=======================================================Test=================================================================\\
        if(e.getActionCommand().equals("search")){
            int countSearch;
            String[][] searchMovieResult;
            
            model = new Model();

            search = view.getSearchBar().getText().trim();
            Movies searchMovie = new Movies(search);
            
            if(search.isEmpty())
            {
                model.allMoviesCount();
                searchMovieResult = model.allMovies(); 

                for(int i=0;i<searchMovieResult.length;i++)       //for the rows
                {
                    for(int j=0;j<6;j++)   //for the columns
                    {
                        System.out.println(searchMovieResult[i][j]);         //initalizing the value of squares into 0;

                    }  
                    System.out.println("");
                }

            }
            else{
//                model.countSearchTitle(searchMovie);

                countSearch = model.countSearchTitle(searchMovie); //count the results
                if(countSearch==0)
                {
                    System.out.println("No Results Found");
//                    view.p1.removeAll(); //removes the dashboard panel for bookings
//                    view.p1.add(view.noResults());
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
//                    view.p1.removeAll(); //removes the dashboard panel for bookings
//                    view.p1.add(view.moviePanels());

                }
                
            }
        }
        
      //============================= panels with card layout
        
        String categories = null;
        
        if(e.getActionCommand().equals("action")){
            System.out.println("action category");
            categories="action";
            categoriesCount=model.categoriesMoviesCount(categories);
            categoriesResult=model.categoriesMovies(categories);
            System.out.println("count="+ categoriesCount);
            for(int i=0;i<categoriesResult.length;i++)       //for the rows
                {
                    for(int j=0;j<6;j++)   //for the columns
                    {
                        System.out.println(categoriesResult[i][j]);         //initalizing the value of squares into 0;

                    }  
                    System.out.println("");
                }
            view.getMovieSection().add(view.movieCategories(), "movieCategories");
            view.getMovieSectionL().show(view.getMovieSection(), "movieCategories");
        }
        
        if(e.getActionCommand().equals("comedy")){
            System.out.println("comedy category");
            categories="comedy";
            categoriesCount=model.categoriesMoviesCount(categories);
            categoriesResult=model.categoriesMovies(categories);
            System.out.println("count="+ categoriesCount);
            for(int i=0;i<categoriesResult.length;i++)       //for the rows
                {
                    for(int j=0;j<6;j++)   //for the columns
                    {
                        System.out.println(categoriesResult[i][j]);         //initalizing the value of squares into 0;

                    }  
                    System.out.println("");
                }
            view.getMovieSection().add(view.movieCategories(), "movieCategories");
            view.getMovieSectionL().show(view.getMovieSection(), "movieCategories");
        }
        
        if(e.getActionCommand().equals("drama")){
            System.out.println("drama category");
            categories="drama"; //categories identifier
            categoriesCount=model.categoriesMoviesCount(categories);
            categoriesResult=model.categoriesMovies(categories);
            System.out.println("count="+ categoriesCount);
            for(int i=0;i<categoriesResult.length;i++)       //for the rows
                {
                    for(int j=0;j<6;j++)   //for the columns
                    {
                        System.out.println(categoriesResult[i][j]);         //initalizing the value of squares into 0;

                    }  
                    System.out.println("");
                }
            view.getMovieSection().add(view.movieCategories(), "movieCategories");
            view.getMovieSectionL().show(view.getMovieSection(), "movieCategories");
        }
        
        if(e.getActionCommand().equals("fantasy")){
            System.out.println("fantasy category");
            categories="fantasy";
            categoriesCount=model.categoriesMoviesCount(categories);
            categoriesResult=model.categoriesMovies(categories);
            System.out.println("count="+ categoriesCount);
            for(int i=0;i<categoriesResult.length;i++)       //for the rows
                {
                    for(int j=0;j<6;j++)   //for the columns
                    {
                        System.out.println(categoriesResult[i][j]);         //initalizing the value of squares into 0;

                    }  
                    System.out.println("");
                }
            view.getMovieSection().add(view.movieCategories(), "movieCategories");
            view.getMovieSectionL().show(view.getMovieSection(), "movieCategories");
        }
        
        if(e.getActionCommand().equals("horror")){
            System.out.println("horror category");
            categories="horror";
            categoriesCount=model.categoriesMoviesCount(categories);
            categoriesResult=model.categoriesMovies(categories);
            System.out.println("count="+ categoriesCount);
            for(int i=0;i<categoriesResult.length;i++)       //for the rows
                {
                    for(int j=0;j<6;j++)   //for the columns
                    {
                        System.out.println(categoriesResult[i][j]);         //initalizing the value of squares into 0;

                    }  
                    System.out.println("");
                }
            view.getMovieSection().add(view.movieCategories(), "movieCategories");
            view.getMovieSectionL().show(view.getMovieSection(), "movieCategories");
        }
        
        if(e.getActionCommand().equals("mystery")){
            System.out.println("mystery category");
            categories="mystery";
            categoriesCount=model.categoriesMoviesCount(categories);
            categoriesResult=model.categoriesMovies(categories);
            System.out.println("count="+ categoriesCount);
            for(int i=0;i<categoriesResult.length;i++)       //for the rows
                {
                    for(int j=0;j<6;j++)   //for the columns
                    {
                        System.out.println(categoriesResult[i][j]);         //initalizing the value of squares into 0;

                    }  
                    System.out.println("");
                }
            view.getMovieSection().add(view.movieCategories(), "movieCategories");
            view.getMovieSectionL().show(view.getMovieSection(), "movieCategories");
        }
        
        if(e.getActionCommand().equals("romance")){
            System.out.println("romance category");
            categories="romance";
            categoriesCount=model.categoriesMoviesCount(categories);
            categoriesResult=model.categoriesMovies(categories);
            System.out.println("count="+ categoriesCount);
            for(int i=0;i<categoriesResult.length;i++)       //for the rows
                {
                    for(int j=0;j<6;j++)   //for the columns
                    {
                        System.out.println(categoriesResult[i][j]);         //initalizing the value of squares into 0;

                    }  
                    System.out.println("");
                }
            view.getMovieSection().add(view.movieCategories(), "movieCategories");
            view.getMovieSectionL().show(view.getMovieSection(), "movieCategories");
        }
        
        if(e.getActionCommand().equals("scifi")){
            System.out.println("scifi category");
            categories="scifi";
            categoriesCount=model.categoriesMoviesCount(categories);
            categoriesResult=model.categoriesMovies(categories);
            System.out.println("count="+ categoriesCount);
            for(int i=0;i<categoriesResult.length;i++)       //for the rows
                {
                    for(int j=0;j<6;j++)   //for the columns
                    {
                        System.out.println(categoriesResult[i][j]);         //initalizing the value of squares into 0;

                    }  
                    System.out.println("");
                }
            view.getMovieSection().add(view.movieCategories(), "movieCategories");
            view.getMovieSectionL().show(view.getMovieSection(), "movieCategories");
        }
        
        if(e.getActionCommand().equals("thriller")){
            System.out.println("thriller category");
            categories="thriller";
            categoriesCount=model.categoriesMoviesCount(categories);
            categoriesResult=model.categoriesMovies(categories);
            System.out.println("count="+ categoriesCount);
            for(int i=0;i<categoriesResult.length;i++)       //for the rows
                {
                    for(int j=0;j<6;j++)   //for the columns
                    {
                        System.out.println(categoriesResult[i][j]);         //initalizing the value of squares into 0;

                    }  
                    System.out.println("");
                }
            view.getMovieSection().add(view.movieCategories(), "movieCategories");
            view.getMovieSectionL().show(view.getMovieSection(), "movieCategories");
        }
        
        if(e.getActionCommand().equals("western")){
            System.out.println("western category");
            categories="western";
            categoriesCount=model.categoriesMoviesCount(categories);
            categoriesResult=model.categoriesMovies(categories);
            System.out.println("count="+ categoriesCount);
            for(int i=0;i<categoriesResult.length;i++)       //for the rows
                {
                    for(int j=0;j<6;j++)   //for the columns
                    {
                        System.out.println(categoriesResult[i][j]);         //initalizing the value of squares into 0;

                    }  
                    System.out.println("");
                }
            view.getMovieSection().add(view.movieCategories(), "movieCategories");
            view.getMovieSectionL().show(view.getMovieSection(), "movieCategories");
        }
        
        
        
    }
    
    
    
    
    
    //getters===================================================================================================
    //I think we need getters if we call attributes from one package to another so we don't have to
    //make them public, or better we can make them private for encapsulation

    
    public int getAllMovieCount() {
        return allMovieCount;
    }

    public String[][] getAllMovies() {
        return allMovies;
    }

    public int getCategoriesCount() {
        return categoriesCount;
    }

    public String[][] getCategoriesResult() {
        return categoriesResult;
    }
    
    
    
    
    
}
