/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oocsaad;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author leojk
 */
public class view extends JFrame {
    
    JFrame main;
    
    
    public void main() {
        //main frame (dosen't change)
        main = new JFrame();
            main.setVisible(true);
            main.setSize(600, 600);
            main.setTitle("Xtra Vision");
            BorderLayout mainLayout = new BorderLayout();
            main.setLayout(mainLayout);
    
        //top panel (search bar)
        JPanel search = new JPanel();
            search.setBackground(Color.red);
            main.add(search, BorderLayout.PAGE_START);
            
            GridLayout searchGrid = new GridLayout(1,2);
                search.setLayout(searchGrid);
            
            JTextField searchBar = new JTextField();
                search.add(searchBar);
                
            JButton searchButton = new JButton("Search");
                search.add(searchButton);
                
                
                
        //left panel (movies categories)
        JPanel categories = new JPanel();
            categories.setBackground(Color.blue);
            main.add(categories, BorderLayout.LINE_START);
            
            GridLayout menuGrid = new GridLayout(10,1);
                categories.setLayout(menuGrid);
                
            JLabel cate = new JLabel("Categories");
                categories.add(cate);
                
            JButton action = new JButton("Action");
            JButton adventure = new JButton("Adventure");
            JButton family = new JButton("Family");
            JButton thriller = new JButton("Trhiller");
            JButton scifi = new JButton("Sci-Fi");
                categories.add(action);
                categories.add(adventure);
                categories.add(family);
                categories.add(thriller);
                categories.add(scifi);
                
                
                
        //first screen 
        JPanel arrival = new JPanel();
            arrival.setBackground(Color.yellow);
            main.add(arrival, BorderLayout.CENTER);
            
            GridLayout arrGrid = new GridLayout(4,1);
                arrival.setLayout(arrGrid);
                
            JLabel newArrival = new JLabel("New Arrival");
                arrival.add(newArrival);
                
            JLabel soon = new JLabel("Coming Soon");
                arrival.add(soon);
            
            
            
        
             
                    
            
            
            
            
            
            
            
}
    
    
}
