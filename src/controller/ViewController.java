/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.View;

/**
 *
 * @author jonpaulcarlo
 */
public class ViewController implements ActionListener {
    View view;
//    OocSaad OocSaad;   can be removed

    public ViewController (){
      this.view = new View(this);
//      this.OocSaad = new OocSaad(); can be removed
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}