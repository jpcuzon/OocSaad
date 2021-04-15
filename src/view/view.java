/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

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
    JFrame welcome;
    
    public void welcome(){
        //welcome page
        welcome = new JFrame();
            welcome.setVisible(true);
            welcome.setSize(600, 600);
            welcome.setTitle("Xtra Vision");
            BorderLayout welcomeLayout = new BorderLayout();
            welcome.setLayout(welcomeLayout);
        //header   
        JPanel header = new JPanel();
        JLabel xtra = new JLabel("Welcome to");
            welcome.add(header, BorderLayout.PAGE_START);
            
            GridLayout head = new GridLayout(1,2);
                header.setLayout(head);
            header.add(xtra);
            
        //center    
        JButton rent = new JButton("Rent a movie");
        JButton retur = new JButton("Return a movie");
            
            JPanel rr = new JPanel();
                welcome.add(rr, BorderLayout.CENTER);
            GridLayout rentreturn = new GridLayout(1,2);
                rr.setLayout(rentreturn);
            rr.add(rent);
            rr.add(retur);
            
        //footer
        JLabel txtfooter = new JLabel("A Xtra easy and Xtra fast way to rent a movie!");
            welcome.add(txtfooter, BorderLayout.PAGE_END);
            
    }
    
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
            main.add(categories, BorderLayout.LINE_START);
            
            GridLayout menuGrid = new GridLayout(13,1);
                categories.setLayout(menuGrid);
                
            JLabel cate = new JLabel("Categories");
                categories.add(cate);
                
            JButton action = new JButton("Action and Adventure");
            JButton comedy = new JButton("Comedy");
            JButton drama = new JButton("Drama");
            JButton fantasy = new JButton("Fantasy");
            JButton horror = new JButton("Horror");
            JButton mystery = new JButton("Mystery");
            JButton romance = new JButton("Romance");
            JButton scifi = new JButton("Sci-Fi");
            JButton thriller = new JButton("Trhiller");
            JButton western = new JButton("Western");
            
                categories.add(action);
                categories.add(comedy);
                categories.add(drama);
                categories.add(fantasy);
                categories.add(horror);
                categories.add(mystery);
                categories.add(romance);
                categories.add(scifi);
                categories.add(thriller);
                categories.add(western);
            
            JLabel hiw = new JLabel("How it Works?");
                categories.add(hiw);
                
            JButton faq = new JButton("FAQ");
                categories.add(faq);
                
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
