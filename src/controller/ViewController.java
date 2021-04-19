/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import view.View;

/**
 *
 * @author jonpaulcarlo
 */
public class ViewController implements ActionListener {
    View view;

    public ViewController (){
      this.view = new View(this);
    }

    @Override
    //rent movie
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("rent")) {
            System.out.println("rent a movie");
//            view.welcome.dispatchEvent(new WindowEvent(view.welcome, WindowEvent.WINDOW_CLOSING)); for some reason this line has an error .-.
            view.main();
        }
        //image as a button, return to welcome screen
        if(e.getActionCommand().equals("logo")){
            System.out.println("welcome screen");
            view.welcome();
        }
        //return screen
        if(e.getActionCommand().equals("retur")){
            System.out.println("return a movie");
            view.returnn();
        }
        
        //FAQ
        if(e.getActionCommand().equals("faq")){
            System.out.println("FAQ frame for help");
            view.faq();
        }
        
        
        
        
        
        
        
        
        
    }
    
    
    
    
}