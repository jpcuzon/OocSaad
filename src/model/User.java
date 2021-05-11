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
public class User extends Card{
    
    private String email;
//    private String cardNumber;
//    private String pin;

    public User(){
        
    }
    
    public User(String cardNumber, String pin) {
        setCardNumber(cardNumber);
        setPin(pin);
    }
    
}
