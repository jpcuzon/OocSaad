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
    int countSearch; //counts the search result
    int categoriesCount;
    private String[][] allMovies;
    String[][] searchMovieResult;
    String[][] moviesActive; // for sorting
    String [][] categoriesResult;
    String search;
    String active;
    
    String[][] infoMovie;

    public ViewController (){
      this.view = new View(this);
      this.model = new Model();
    }

    @Override
    //rent movie
    public void actionPerformed(ActionEvent e) {
        
        //----------------------------------------------------going to main panel----------------------------------------------------\\
        if(e.getActionCommand().equals("goMain")){
            
            view.setHeaderLabel("All Movies");
            allMovieCount = model.allMoviesCount();
            allMovies = model.allMovies();
            searchMovieResult = null;
            for(int i=0;i<allMovies.length;i++)       //for the rows
                {
                    for(int j=0;j<6;j++)   //for the columns
                    {
                        System.out.println(allMovies[i][j]);         //initalizing the value of squares into 0;

                    }  
                    System.out.println("");
                }
            view.getWelcome().dispatchEvent(new WindowEvent(view.getWelcome(), WindowEvent.WINDOW_CLOSING));//disposes the other frame when this frame opens
            view.main();  
            
        }
        
        //return screen
        //----------------------------------------------------return----------------------------------------------------\\
        if(e.getActionCommand().equals("retur")){
            System.out.println("return a movie");
            view.getWelcome().dispatchEvent(new WindowEvent(view.getWelcome(), WindowEvent.WINDOW_CLOSING));
            view.returnn();
        }
        
        //----------------------------------------------------search----------------------------------------------------\\
        if(e.getActionCommand().equals("search")){
            
            model = new Model();

            search = view.getSearchBar().getText();
            countSearch = model.countSearchTitle(search); //count the results
            System.out.println("CS1 "+countSearch);////////////////
            
            if(search.isEmpty())
            {
                model.allMoviesCount();
                allMovies = model.allMovies(); 
                searchMovieResult = null;

                for(int i=0;i<allMovies.length;i++)       //for the rows
                {
                    for(int j=0;j<6;j++)   //for the columns
                    {
                        System.out.println(allMovies[i][j]);         //initalizing the value of squares into 0;

                    }  
                    System.out.println("");
                }
                
                view.getMovieSectionL().show(view.getMovieSection(), "moviesHome");

            }
            else{
                
                System.out.println("CS2 "+countSearch);////////////////
                if(countSearch==0)
                {
//                    System.out.println("No Results Found ");

//                    view.movieSectionL.show(view.movieSection, "searchResult");
                }
                else
                {
                    view.setHeaderLabel("Search Results for \""+search+"\""); //assign the input into the label
                    searchMovieResult = model.searchTitle(search); 
                    allMovies = null;

                    for(int i=0;i<searchMovieResult.length;i++)       //for the rows
                    {
                        for(int j=0;j<6;j++)   //for the columns
                        {
                            System.out.println(searchMovieResult[i][j]);         //initalizing the value of squares into 0;

                        }  
                        System.out.println("");
                    }
                    view.getMovieSection().add(view.movieSearchPanel(),"searchResult");
                    view.getMovieSectionL().show(view.getMovieSection(), "searchResult");
                }
                
            }
        }
        
        //----------------------------------------------------sort----------------------------------------------------\\
        if(e.getActionCommand().equalsIgnoreCase("sort")){
            
            moviesActive = null; //container for the sorting function
            active=null;
            String sortType = view.getSort().getSelectedItem().toString();
            
            
            if(allMovies == null){  //switches the data inside of the container on what data is active.
                moviesActive = searchMovieResult;
                active = "search";

                System.out.println("Search active");
            }else if(searchMovieResult == null){
                moviesActive = allMovies;
                active = "all";
                System.out.println("All active");

            }
            if(active.equalsIgnoreCase("all")){  //Sorts the "All movies" result if the active identifier is "all"
                moviesActive = model.allMoviesSort(sortType);
                for(int i=0;i<allMovies.length;i++)       //for the rows
                    {
                        for(int j=0;j<6;j++)   //for the columns
                        {
                            System.out.println(moviesActive[i][j]);         //initalizing the value of squares into 0;

                        }  
                        System.out.println("");
                    }
                view.getMovieSection().add(view.moviePanelSort(),"allMoviesSort");
                view.getMovieSectionL().show(view.getMovieSection(), "allMoviesSort");
            }
            else if(active.equalsIgnoreCase("search")){  //Sorts the search result if the active identifier is "search"
                moviesActive = model.searchTitleSort(search , sortType);
                for(int i=0;i<moviesActive.length;i++)       //for the rows
                    {
                        for(int j=0;j<6;j++)   //for the columns
                        {
                            System.out.println(moviesActive[i][j]);         //initalizing the value of squares into 0;

                        }  
                        System.out.println("");
                    }
                
                view.getMovieSection().add(view.moviePanelSort(),"allMoviesSort");
                view.getMovieSectionL().show(view.getMovieSection(), "allMoviesSort");
//                view.getMovieSection().add(view.movieSearchPanelSort(),"searchResult");
//                view.getMovieSectionL().show(view.getMovieSection(), "searchResult");
            }
            
        }

        //----------------------------------------------------FAQ----------------------------------------------------\\
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
        
                                  
        //----------------------------------------------------Categories----------------------------------------------------\\
      //============================= panels with card layout
        
        String categories = null;
        
        if(e.getActionCommand().equals("action")){
            view.setHeaderLabel("Category: Action");
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
            view.setHeaderLabel("Category: Comedy");
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
            view.setHeaderLabel("Category: Drama");
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
            view.setHeaderLabel("Category: Fantasy");
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
            view.setHeaderLabel("Category: Horror");
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
            view.setHeaderLabel("Category: Mystery");
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
            view.setHeaderLabel("Category: Romance");
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
            view.setHeaderLabel("Category: Science Fiction");
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
            view.setHeaderLabel("Category: Thriller");
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
            view.setHeaderLabel("Category: Western");
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
        
        //goes back to the home page
        if(e.getActionCommand().equals("home")){
            
            model.allMoviesCount();
                allMovies = model.allMovies(); 
                searchMovieResult = null;
                view.setHeaderLabel("All Movies");

                for(int i=0;i<allMovies.length;i++)       //for the rows
                {
                    for(int j=0;j<6;j++)   //for the columns
                    {
                        System.out.println(allMovies[i][j]);         //initalizing the value of squares into 0;

                    }  
                    System.out.println("");
                }
                
                view.getMovieSection().add(view.moviePanel(),"moviesHome");
                view.getMovieSectionL().show(view.getMovieSection(), "moviesHome");
        }
        
        //goes back to the home page
        if(e.getActionCommand().equals("home")){
            
            model.allMoviesCount();
                allMovies = model.allMovies(); 
                searchMovieResult = null;
                view.setHeaderLabel("All Movies");

                for(int i=0;i<allMovies.length;i++)       //for the rows
                {
                    for(int j=0;j<6;j++)   //for the columns
                    {
                        System.out.println(allMovies[i][j]);         //initalizing the value of squares into 0;

                    }  
                    System.out.println("");
                }
                
                view.getMovieSection().add(view.moviePanel(),"moviesHome");
                view.getMovieSectionL().show(view.getMovieSection(), "moviesHome");
        }
        
        //===========================TEST RENT=============================
        int countResult = view.getCountResult();
        for(int i=0;i<countResult;i++){
            
            if(e.getActionCommand().equals("rent"+view.getMovieID()[i])){
                
                if(view.getPanelActive().equalsIgnoreCase("movieAll")){
                    
                    int movieCode = Integer.parseInt(allMovies[i][5]);
                    infoMovie = model.infoMovies(movieCode);
                    
                }else if(view.getPanelActive().equalsIgnoreCase("movieSearch")){
                    
                    int movieCode = Integer.parseInt(searchMovieResult[i][5]);
                    infoMovie = model.infoMovies(movieCode);
                    
                }else if(view.getPanelActive().equalsIgnoreCase("movieSort")){
                    
                    int movieCode = Integer.parseInt(moviesActive[i][5]);
                    infoMovie = model.infoMovies(movieCode);
                    
                }else if(view.getPanelActive().equalsIgnoreCase("movieCategory")){
                    
                    int movieCode = Integer.parseInt(categoriesResult[i][5]);
                    infoMovie = model.infoMovies(movieCode);
                    
                }
                
                
                
            view.info();
            
            }
            
        }
        if(e.getActionCommand().equals("back1")){
            view.getInfo().dispatchEvent(new WindowEvent(view.getInfo(), WindowEvent.WINDOW_CLOSING));
        }
    
    }
    
    
    
    
    
    //----------------------------------------------------getters----------------------------------------------------\\
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

    public int getCountSearch() {
        return countSearch;
    }

    public String[][] getSearchMovieResult() {
        return searchMovieResult;
    }

    public String[][] getMoviesActive() {
        return moviesActive;
    }

    public String[][] getInfoMovie() {
        return infoMovie;
    }

    public String getActive() {
        return active;
    }
    
    
    
    
    
}
