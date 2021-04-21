/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ViewController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author leojk
 */
public class View extends JFrame {
//    ViewController ViewController;
//    public view(ViewController ViewController){
//        this.ViewController = ViewController;
//        welcome();
//    }
    
    ViewController viewController;
    
    JFrame main;
    JFrame welcome;
    JFrame returnn;
    JFrame faq;
    JPanel p1;
    JTextField searchBar;
    
    Font txt;
    
    ScrollPane sp;
    
    int countResult;
    int countIndex;
    

    public View(ViewController viewController){  //I honestly don't know why this is needed, I just copied it on Amilcar's code on GUI with the comment below and it removed the error
        this.viewController = viewController;
        // We encapsulated the building process of the window
        welcome();  //calls the home page
        
    }
    
    public void welcome(){
        //welcome page
        welcome = new JFrame();
            welcome.setVisible(true);
            welcome.setSize(1600, 900);
            welcome.setTitle("Xtra Vision");
            BorderLayout welcomeLayout = new BorderLayout();
            welcome.setLayout(welcomeLayout);
        //header     
        Font tFont = new Font("Arial Black",Font.BOLD,50);
        Font tFont1 = new Font("Arial Black",Font.BOLD,20);
        
        JPanel header = new JPanel();
        JLabel xtra = new JLabel("Welcome to");
            xtra.setFont(tFont);
            xtra.setForeground(new Color(255, 228, 0));
            
            welcome.add(header, BorderLayout.PAGE_START);
            
        ImageIcon logoxtra = new ImageIcon(getClass().getResource("images/logoxtravision.png"));
            JLabel logo = new JLabel(logoxtra);
            GridLayout head = new GridLayout(2,1);
                header.setLayout(head);
                header.setBackground(new Color(160,0,0));//personalized colors
            header.add(xtra);
            header.add(logo);
            
        //center    
        JButton rent = new JButton("Rent a movie");
            rent.addActionListener(viewController);
            rent.setActionCommand("rent");
        JButton retur = new JButton("Return a movie");
            retur.addActionListener(viewController);
            retur.setActionCommand("retur");
            
            JPanel rr = new JPanel();
                welcome.add(rr, BorderLayout.CENTER);
                rr.setBackground(new Color(160,0,0));
            GridLayout rentreturn = new GridLayout(1,2);
                rr.setLayout(rentreturn);
            rr.add(rent);
            rr.add(retur);
            
        //footer
        JPanel footer = new JPanel();
            welcome.add(footer, BorderLayout.PAGE_END);
            footer.setBackground(new Color(160,0,0));
        JLabel txtfooter = new JLabel("Xtra easy and Xtra fast way to rent a movie!");
            txtfooter.setFont(tFont1);
        footer.add(txtfooter);
            txtfooter.setForeground(new Color(255, 228, 0));   
            
        welcome.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        welcome.validate();
        welcome.repaint();  
    }
    
    public void main() {
        //main frame (will change only the panels
        main = new JFrame();
            main.setVisible(true);
            main.setSize(1600, 900);
            main.setTitle("Xtra Vision");
            BorderLayout mainLayout = new BorderLayout();
            main.setLayout(mainLayout);
            
        txt = new Font("Arial Black", Font.PLAIN,15);
        main.add(searchBar(), BorderLayout.PAGE_START);   
        main.add(categories(), BorderLayout.LINE_START);  
    
//        //top panel (search bar, never change)
//        JPanel search = new JPanel();
//            main.add(search, BorderLayout.PAGE_START);
//            search.setBackground(new Color(160,0,0));
//            GridLayout searchGrid = new GridLayout(1,4);
//                search.setLayout(searchGrid);
//                
//            //image    
//            ImageIcon logoxtra = new ImageIcon(getClass().getResource("logoxtravision.png"));        
//                logoxtra.setImage(logoxtra.getImage().getScaledInstance(150, 45, 100));    
//                JButton logo = new JButton();
//            logo.setIcon(logoxtra); //button with image needs design fix
//                logo.addActionListener(viewController);
//                logo.setActionCommand("logo");
//                search.add(logo);
//                
//            JTextField searchBar = new JTextField();
//                search.add(searchBar);   
//            JButton searchButton = new JButton("Search");
//                search.add(searchButton);
//            JButton cart = new JButton("My Cart");
//                search.add(cart);
//     
//            //left panel (movies categories, also never change)
//            JPanel categories = new JPanel();
//                categories.setBackground(new Color(160,0,0));
//            main.add(categories, BorderLayout.LINE_START);
//            
//            GridLayout menuGrid = new GridLayout(13,1);
//                categories.setLayout(menuGrid);
//                
//            JLabel cate = new JLabel("Categories");
//                cate.setFont(txt);
//                cate.setForeground(new Color(255, 228, 0)); 
//                categories.add(cate);
//                
//            JButton action = new JButton("Action and Adventure");
//            JButton comedy = new JButton("Comedy");
//            JButton drama = new JButton("Drama");
//            JButton fantasy = new JButton("Fantasy");
//            JButton horror = new JButton("Horror");
//            JButton mystery = new JButton("Mystery");
//            JButton romance = new JButton("Romance");
//            JButton scifi = new JButton("Sci-Fi");
//            JButton thriller = new JButton("Trhiller");
//            JButton western = new JButton("Western");
//            
//                categories.add(action);
//                categories.add(comedy);
//                categories.add(drama);
//                categories.add(fantasy);
//                categories.add(horror);
//                categories.add(mystery);
//                categories.add(romance);
//                categories.add(scifi);
//                categories.add(thriller);
//                categories.add(western);
//            
//            JLabel hiw = new JLabel("How it Works?");
//                hiw.setFont(txt);
//                hiw.setForeground(new Color(255, 228, 0)); 
//                categories.add(hiw);
//                
//            JButton faq = new JButton("FAQ");
//            faq.addActionListener(viewController);
//            faq.setActionCommand("faq");
//                categories.add(faq);
//                
//                
//        //first panel (this will be the one that change) 
//        JPanel p1 = new JPanel();
//            main.add(p1, BorderLayout.CENTER);
//        GridLayout gridP1 = new GridLayout(2,1);
//            p1.setLayout(gridP1);
//       
//        //panel for the movies
//        Font titletxt = new Font("Arial Black", Font.PLAIN,25);
//        JPanel arrival = new JPanel();
//            p1.add(arrival);
//            BorderLayout arrB = new BorderLayout();
//                arrival.setLayout(arrB);
//        JLabel arr = new JLabel("New Arrival");
//            arr.setFont(titletxt);
//            arrival.add(arr, BorderLayout.PAGE_START);
//        
//        JPanel arrMovies = new JPanel();
//            GridLayout moviesArr = new GridLayout(2,3);
//            arrMovies.setLayout(moviesArr);
//            arrival.add(arrMovies);
//        //images
//        ImageIcon it = new ImageIcon(getClass().getResource("it.jpg"));
//            it.setImage(it.getImage().getScaledInstance(110, 200, 100));
//            JLabel itt = new JLabel(it);
//        
//        ImageIcon pokemon = new ImageIcon(getClass().getResource("pokemon.jpg"));
//            pokemon.setImage(pokemon.getImage().getScaledInstance(110, 200, 100));
//            JLabel poke = new JLabel(pokemon);
//            
//        ImageIcon ww = new ImageIcon(getClass().getResource("ww.jpg"));
//            ww.setImage(ww.getImage().getScaledInstance(110, 200, 100));
//            JLabel wow = new JLabel(ww);
//            
//        //Adding the images on the panel    
//            arrMovies.add(itt);
//            arrMovies.add(poke);
//            arrMovies.add(wow);
//          
//        //Adding the titles
//        JLabel itTitle = new JLabel("IT: Chapter II");
//            arrMovies.add(itTitle);
//        JLabel pokeTitle = new JLabel("Detective Pikachu");
//            arrMovies.add(pokeTitle);
//        JLabel wwTitle = new JLabel("Wonder Woman 1984");
//            arrMovies.add(wwTitle);
//            
//        //coming soon panel
//        JPanel soon = new JPanel();
//            p1.add(soon);
//        
//        BorderLayout soonB = new BorderLayout();
//            soon.setLayout(arrB);
//        JLabel coming = new JLabel("Coming Soon");
//            coming.setFont(titletxt);     
//        soon.add(coming, BorderLayout.PAGE_START);
//        
//        JPanel soonM = new JPanel();
//        GridLayout soongrid = new GridLayout(2,3);
//        soonM.setLayout(soongrid);
//            soon.add(soonM);
//            
//        //images
//        ImageIcon rct = new ImageIcon(getClass().getResource("rocktman.jpg"));
//            rct.setImage(rct.getImage().getScaledInstance(110, 200, 100));
//            JLabel rockt = new JLabel(rct);
//            
//        ImageIcon aladdin = new ImageIcon(getClass().getResource("aladdin.png"));
//            aladdin.setImage(aladdin.getImage().getScaledInstance(110, 200, 100));
//            JLabel ala = new JLabel(aladdin);
//            
//        ImageIcon godzilla = new ImageIcon(getClass().getResource("godzilla.png"));
//            godzilla.setImage(godzilla.getImage().getScaledInstance(110, 200, 100));
//            JLabel godz = new JLabel(aladdin);
//            
//        //adding the images
//        soonM.add(rockt);
//        soonM.add(ala);
//        soonM.add(godz);
//        
//        //titles
//        JLabel rctTitle = new JLabel("Rocktman");
//            soonM.add(rctTitle);
//        JLabel alaTitle = new JLabel("Aladdin");
//            soonM.add(alaTitle);
//        JLabel godzTitle = new JLabel("Godzilla: King of the Monsters");
//            soonM.add(godzTitle);   

        JPanel movieSection = new JPanel();
        movieSection.setLayout(new BoxLayout(movieSection, BoxLayout.Y_AXIS)); ///////////////////////////
        main.add(movieSection,BorderLayout.CENTER);
        
        BorderLayout movieL = new BorderLayout();
        JPanel moviePanel = new JPanel();
            moviePanel.setLayout(movieL);
            movieSection.add(moviePanel);
        
        JPanel moviePanelHeader = new JPanel();  //contains the "New Arrivals, etc" as well as the sort buttons
        moviePanel.add(moviePanelHeader,BorderLayout.NORTH);
            String[] sortOption = {"Name","Popularity","Genre","Release Date"};
            JComboBox sort = new JComboBox(sortOption);
            JButton sortConfirm = new JButton("Sort");
            moviePanelHeader.add(sort);
            moviePanelHeader.add(sortConfirm);
        
        sp = new ScrollPane();
        GridLayout movieListL = new GridLayout(0,5); //makes the grid to have 5 rows and dynamic number of columns
        JPanel movieListP = new JPanel();  //panel for the movie list (images and title tiles
            movieListP.setLayout(movieListL);
            moviePanel.add(sp, BorderLayout.CENTER);
            sp.add(movieListP);
            
//        JPanel movieLoop = new JPanel();
//        movieListP.add(movieLoop);
        
        countResult = viewController.getAllMovieCount();
        countIndex = 0; //initialized the count index
        
        JPanel[] movieArray = new JPanel[countResult];
        
        if(countResult == 0){
            System.out.println("No movies found"); //will change later
        }
        else{
            for(int i=0;i<countResult;i++){
                
                movieArray[i] = new JPanel();
                JPanel movieTile = new JPanel();
//                movieTile.setBorder(new EmptyBorder(10,10,10,10));
                    JPanel movieDetails = new JPanel();
                    movieDetails.setLayout(new BoxLayout(movieDetails, BoxLayout.Y_AXIS));
                    movieTile.add(movieDetails);
                        ImageIcon movieImage = new ImageIcon(getClass().getResource("images/"+viewController.getAllMovies()[i][5]+".jpg"));
                        movieImage.setImage(movieImage.getImage().getScaledInstance(110, 200, 100));
                        JLabel itt = new JLabel(movieImage);
                        movieDetails.add(itt);
                        JLabel movieTitle = new JLabel(viewController.getAllMovies()[i][0] + " ("+viewController.getAllMovies()[i][2]+")");
                        movieDetails.add(movieTitle);
                        JLabel movieGenre = new JLabel(viewController.getAllMovies()[i][1]);
                        movieDetails.add(movieGenre);
                        JButton rentB = new JButton("RENT");
                        movieDetails.add(rentB);
                
                
                        
                        
              movieArray[i].add(movieTile);
              movieListP.add(movieArray[i]);
            }
        }
        

        
        main.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        main.validate();
        main.repaint();      
        
        
            
}
    //return frame
    public void returnn(){
        returnn = new JFrame();
            returnn.setVisible(true);
            returnn.setSize(1600, 900);
            returnn.setTitle("Xtra Vision");
            BorderLayout welcomeLayout = new BorderLayout();
            returnn.setLayout(welcomeLayout);
            
                    JPanel search = new JPanel();
            returnn.add(search, BorderLayout.PAGE_START);
            search.setBackground(new Color(160,0,0));
            GridLayout searchGrid = new GridLayout(1,4);
                search.setLayout(searchGrid);
        //image    
        ImageIcon logoxtra = new ImageIcon(getClass().getResource("images/logoxtravision.png"));        
            logoxtra.setImage(logoxtra.getImage().getScaledInstance(150, 45, 100));    
            JButton logo = new JButton();
            logo.setIcon(logoxtra); //button with image needs design fix
                logo.addActionListener(viewController);
                logo.setActionCommand("logo");
                search.add(logo);
                
            JTextField searchBar = new JTextField();
                search.add(searchBar);   
            JButton searchButton = new JButton("Search");
                search.add(searchButton);
            JButton cart = new JButton("My Cart");
                search.add(cart);
    }  
    
    //faq frame
    public void faq(){
        String[] questions={"Questions","Answers"};
        String[][] answers={{"How long can I keep the movie?","You can keep the movie for 3 days"},
                {"How much cost each movie?","Each movie costs £3,99"},
                {"Why do I need to pay a security deposit?","We change a security deposit in case any damage cause on the disk, scretches for example"},
                {"How much is the security deposit?","The security desposit is £7,99"},
                {"What happen if I do not return the disk?","We will automatically charge on your credit card the security deposit"}};
        
        faq = new JFrame();
            faq.setVisible(true);
            faq.setSize(600, 600);
            faq.setTitle("Xtra Vision");
            BorderLayout welcomeLayout = new BorderLayout();
            faq.setLayout(welcomeLayout);
            
                    JPanel search = new JPanel();
            faq.add(search, BorderLayout.PAGE_START);
            search.setBackground(new Color(160,0,0));
            GridLayout searchGrid = new GridLayout(1,4);
                search.setLayout(searchGrid);
        //image    
        ImageIcon logoxtra = new ImageIcon(getClass().getResource("logoxtravision.png"));        
            logoxtra.setImage(logoxtra.getImage().getScaledInstance(150, 45, 100));    
            JButton logo = new JButton();
            logo.setIcon(logoxtra); //button with image needs design fix
                logo.addActionListener(viewController);
                logo.setActionCommand("logo");
                search.add(logo);
                
            JTextField searchBar = new JTextField();
                search.add(searchBar);   
            JButton searchButton = new JButton("Search");
                search.add(searchButton);
            JButton cart = new JButton("My Cart");
                search.add(cart);
                
        //panel for the questions and answers
        JPanel p1 = new JPanel();
            faq.add(p1, BorderLayout.CENTER);
           
        JTable qaa = new JTable(answers,questions);
        JScrollPane qaaScroll = new JScrollPane(qaa);
            faq.add(qaa);
                
          
    }
    
    
    public JPanel searchBar(){
    
        JPanel search = new JPanel();

            search.setBackground(new Color(160,0,0));
            GridLayout searchGrid = new GridLayout(1,4);
            search.setLayout(searchGrid);
            //image    
            ImageIcon logoxtra = new ImageIcon(getClass().getResource("images/logoxtravision.png"));        
                logoxtra.setImage(logoxtra.getImage().getScaledInstance(150, 45, 100));    
                JLabel logo = new JLabel(logoxtra);
                    search.add(logo);

                searchBar = new JTextField();
                    search.add(searchBar);   
                JButton searchButton = new JButton("Search");
                    search.add(searchButton);
                    searchButton.addActionListener(viewController);
                    searchButton.setActionCommand("search");
                JButton cart = new JButton("My Cart");
                    search.add(cart);
                    cart.addActionListener(viewController);
                    cart.setActionCommand("cart");

                
        return search;        
    }
    
    
    public JPanel categories(){
        JPanel categories = new JPanel();
        categories.setBackground(new Color(160,0,0));
//        main.add(categories, BorderLayout.LINE_START);

        GridLayout menuGrid = new GridLayout(13,1);
            categories.setLayout(menuGrid);

        JLabel cate = new JLabel("Categories");
            cate.setFont(txt);
            cate.setForeground(new Color(255, 228, 0)); 
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
            hiw.setFont(txt);
            hiw.setForeground(new Color(255, 228, 0)); 
            categories.add(hiw);

        JButton faq = new JButton("FAQ");
            categories.add(faq);
                
        return categories;
    }
    
    
   
    
    //getters===================================================================================================
    //I think we need getters if we call attributes from one package to another so we don't have to
    //make them public, or better we can make them private for encapsulation
    public JFrame getWelcome() {
        return welcome;
    }

    public JTextField getSearchBar() {
        return searchBar;
    }
    
    
    
    
}
