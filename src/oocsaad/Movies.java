/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oocsaad;

/**
 *
 * @author jonpaulcarlo
 */
public class Movies {
    
    protected String title;
    protected String genre;
    protected int release_year;
    protected int num_avail;
    protected int num_rented;
    protected int image_id;
    
    protected String searchTitle;
    
    
    
    
//    String[] movieList = {"Matrix", "The Lion King", "Harry Potter", "The Avengers", "Pirates of the Caribbean", "Silence of the Lambs", "Spider-Man: Far From Home", "Iron Man", "Tenet", "John Wick"};

//    public String[] getMovieList() {
//        return movieList;
//    }
//
//    @Override
//    public String toString() {
//        return "Movies{" + "avb=" + avb + ", movieList=" + movieList + '}';
//    }
    
    public Movies (String searchTitle){
        this.searchTitle = searchTitle;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getRelease_year() {
        return release_year;
    }

    public int getNum_avail() {
        return num_avail;
    }

    public int getNum_rented() {
        return num_rented;
    }

    public int getImage_id() {
        return image_id;
    }

    public String getSearchTitle() {
        return searchTitle;
    }

    
    
    
     
}
