/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author jonpaulcarlo
 */
public class Rent {
    
    private int movieID;
    private int customerID;
    String rentDate;

    public Rent(int movieID, int customerID) {
        this.movieID = movieID;
        this.customerID = customerID;
    }

    public String getRentDate() {
        return rentDate;
    }

    public void setRentDate(String rentDate) {
        this.rentDate = rentDate;
    }

    public int getMovieID() {
        return movieID;
    }

    public int getCustomerID() {
        return customerID;
    }

    String getReturnDate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
