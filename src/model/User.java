/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Random;

/**
 *
 * @author jonpaulcarlo
 */
public class User {
    
    
    CardGenerator cg = new CardGenerator();
    protected String email;
    protected String cardNumber;
    protected String cardPin;

    public void generateCard() {
        this.cardNumber = cg.newCard;
        this.cardPin = cg.newPin;
    }

    public void setCardPin(String cardPin) {
        this.cardPin = cardPin;
    }
    
    
    // getters
    public String getCardNumber(){
        return this.cardNumber;
        
    }
    
    public String getCardPin(){
        return this.cardPin;
    }
    
    
    public class CardGenerator{ //inner class for the card generator
        
        Random cardGen = new Random();
       
        String newCard = cardNum();
        String newPin = cardPin();
        
        
        
        public String cardNum(){
            
            String numGen = "4"; //Visa cards always starts with "4"
                        
            for(int i = 0; i<15;i++){
            numGen = numGen + cardGen.nextInt(10);
            }
            
//            System.out.println(numGen);
            
            return numGen;
            
        }
        
        public String cardPin(){
            
            String pinGen = "";
        
            for(int i = 0; i<3;i++){
            pinGen = pinGen + cardGen.nextInt(10);
            }
            
//            System.out.println(pinGen);
            
            return pinGen;
            
        }
        
            
            
        
        
        
        
        
    }
    
}
