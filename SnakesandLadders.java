//Image and Audio Sources:


// 1-64.jpg: http://www.wildzebraoutdoorplay.co.uk/products-playground-markings-board-games.html
// Dice1-Dice6.jpeg: http://www.clipartkid.com/dice-showing-6-cliparts/
// p1.jpg: http://www.iconarchive.com/show/people-icons-by-martin-berube/astronaut-icon.html
// p2.jpg: http://findicons.com/icon/44295/alien
// seb-james-snakes-ladders.gif: https://www.artstation.com/artwork/rOqbm
// song.wav: http://www.wavsource.com/






//Name: Aashan Meiyappan









//Applet libraries
import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;


//For Border Layout
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


//Random Variable Function (more efficient)
import java.util.Random;


//Audio Files
import java.io.FileInputStream;
import sun.audio.*;
import java.io.*;






//Main Class
public class SnakesandLadders extends Applet implements ActionListener
{


//Global Variables (change)
//Used throughout various sections of game
    Panel p_card;
    Panel card1, card2, card3;
    CardLayout cdLayout = new CardLayout ();
    Border thickBorder = new LineBorder (Color.BLACK, 12);


    JButton ins;
    JButton play;
    JButton menu;


    int row = 8;
    
    //Main grid array
    JLabel a[] = new JLabel [(row * row) + 1];
    Panel g = new Panel (new GridLayout (row, row));
    JLabel grid;
    JLabel dice;
    JButton roll;
    JLabel turn;
    int playerNum = 1;
    JLabel numOfTurns;
    int turnNum = 00;
    int p1space = 0;
    int p2space = 0;


    JButton hardmode;


    Random rand = new Random ();
    int n = rand.nextInt (6) + 1;


    int p1score = 0;
    int p2score = 0;
    JLabel scoreNum1;
    JLabel scoreNum2;
    








    public void init ()
    {
        resize (450, 575);
        //ensures all screens are same size
        
        //Multi-screening
        p_card = new Panel ();
        p_card.setLayout (cdLayout);


        //Main 3 screens in game
        start ();
        instruction ();
        game ();


        setLayout (new BorderLayout ());
        add ("Center", p_card);
    }


    //Home screen (main menu)
    public void start ()
    {
        
        //Gray colour code (my own custom color)
        setBackground (new Color (96, 96, 96));
        
        card1 = new Panel ();


        JLabel subheading = new JLabel ("                  Space Edition");
        subheading.setFont (new Font ("Arial", Font.BOLD, 24));
        subheading.setForeground (Color.red);


        JLabel title = new JLabel ("SNAKES AND LADDERS");
        title.setFont (new Font ("Copperplate Gothic Bold", Font.BOLD, 30));
        title.setForeground (Color.cyan);


        ins = new JButton ("INSTRUCTIONS");
        ins.setForeground (Color.white);
        ins.setBackground (Color.black);
        ins.setFont (new Font ("Arial", Font.BOLD, 24));
        ins.addActionListener (this);
        ins.setActionCommand ("ins");
        ins.setBorder (thickBorder);


        play = new JButton ("PLAY");
        play.setForeground (Color.white);
        play.setBackground (Color.black);
        play.setFont (new Font ("Arial", Font.BOLD, 24));
        play.addActionListener (this);
        play.setActionCommand ("play");
        play.setBorder (thickBorder);


        JLabel mainPic = new JLabel (createImageIcon ("seb-james-snakes-ladders.gif"));
        //GIF makes game visually attractive esp. to target audience
        
        playMusic ("song");
        //Song to attract target audience
       
        //GridLayout array  
        Panel x = new Panel (new GridLayout (2, 0));
        x.add (title);
        x.add (subheading);


        add (ins);
        add (play);


        card1.add (x);
        card1.add (play);
        card1.add (ins);
        card1.add (mainPic);


        p_card.add ("1", card1);
        
        //Screen leads to instructions page and game page


    }




    public void instruction ()
    {
        card2 = new Panel ();
        JLabel insTitle = new JLabel ("        ---- INSTRUCTIONS ----        ");
        insTitle.setForeground (Color.lightGray);
        insTitle.setFont (new Font ("Arial", Font.BOLD, 28));
        
        //Clear Instructions that specifically tell how to play
        JLabel instructions = new JLabel ("Oh no! Your rocket-ship has crashed on the planet ");
        JLabel instructions2 = new JLabel ("Stavania. Their alien leader has infiltrated your ship ");
        JLabel instructions3 = new JLabel (" and has brought all his vicious snakes with him in your ");
        JLabel instructions4 = new JLabel ("rocketship in order to  do so. You roll the dice and ");
        JLabel instructions5 = new JLabel ("take turns trying to reach the top of the order to take");
        JLabel instructions6 = new JLabel ("control of it and leave the planet. Ladders will ");
        JLabel instructions7 = new JLabel ("help both of you rise to the top, while snakes do the ");
        JLabel instructions8 = new JLabel ("opposite and will make you you fall! The first to land on");
        JLabel instructions9 = new JLabel ("the final square will win the game and escape the planet of");
        JLabel instructions10 = new JLabel ("                             EVIL ! ! ! ! !                               ");
        //includes a small background adventure story
        
        instructions.setFont (new Font ("Arial", Font.BOLD, 16));
        instructions2.setFont (new Font ("Arial", Font.BOLD, 16));
        instructions3.setFont (new Font ("Arial", Font.BOLD, 16));
        instructions4.setFont (new Font ("Arial", Font.BOLD, 16));
        instructions5.setFont (new Font ("Arial", Font.BOLD, 16));
        instructions6.setFont (new Font ("Arial", Font.BOLD, 16));
        instructions7.setFont (new Font ("Arial", Font.BOLD, 16));
        instructions8.setFont (new Font ("Arial", Font.BOLD, 16));
        instructions9.setFont (new Font ("Arial", Font.BOLD, 16));
        instructions10.setFont (new Font ("Arial", Font.BOLD, 16));
        //ensures all instruction JLabel widgets are same size
        
        instructions.setForeground (Color.white);
        instructions2.setForeground (Color.white);
        instructions3.setForeground (Color.white);
        instructions4.setForeground (Color.white);
        instructions5.setForeground (Color.white);
        instructions6.setForeground (Color.white);
        instructions7.setForeground (Color.white);
        instructions8.setForeground (Color.white);
        instructions9.setForeground (Color.white);
        instructions10.setForeground (Color.white);
        
        
        JLabel p1display = new JLabel (createImageIcon ("p1display.jpg"));
        JLabel p2display = new JLabel (createImageIcon ("p2display.jpg"));


        menu = new JButton ("Back to Main Menu");
        menu.setPreferredSize (new Dimension (200, 20));
        menu.setForeground (Color.white);
        menu.setBackground (Color.black);
        menu.addActionListener (this);
        menu.setActionCommand ("menu");


        JLabel note = new JLabel ("Note: HARD Mode makes dice roll up to only 3");
        note.setForeground (Color.red);
        note.setFont (new Font ("Arial", Font.BOLD, 16));
        
        String text = "HAVE FUN!!!";
        JTextArea textarea = new JTextArea (text, 2, 5);
        textarea.setPreferredSize (new Dimension (70, 15));
       


        card2.add (insTitle);
        card2.add (instructions);
        card2.add (instructions2);
        card2.add (instructions3);
        card2.add (instructions4);
        card2.add (instructions5);
        card2.add (instructions6);
        card2.add (instructions7);
        card2.add (instructions8);
        card2.add (instructions9);
        card2.add (instructions10);
        card2.add (menu);
        card2.add (note);
        card2.add (textarea);
        card2.add (p1display);
        card2.add (p2display);


        p_card.add ("2", card2);
        //Includes button that will lead back to home screen
    }




    //Main Game Screen
    public void game ()
    {
        card3 = new Panel ();


        //Title formatted for visual appeal
        JLabel title = new JLabel ("SNAKES AND LADDERS");
        title.setFont (new Font ("Copperplate Gothic Bold", Font.BOLD, 34));
        title.setForeground (Color.red);
        card3.add (title);




        dice = new JLabel (createImageIcon ("Dice-6-b.svg.jpeg"));
        //Changing dice picture is visually attractive rather than just number appearing on screen


        roll = new JButton ("ROLL");
        roll.setFont (new Font ("Arial", Font.BOLD, 16));
        roll.addActionListener (this);
        roll.setActionCommand ("roll");
        roll.setBackground (Color.yellow);
        roll.setForeground (Color.red);




        turn = new JLabel ("Click ROLL to play the game!");
        turn.setFont (new Font ("Arial", Font.BOLD, 18));


        //displays number of turns
        numOfTurns = new JLabel ("        Number of Turns: 0" + turnNum + "  ");
        numOfTurns.setFont (new Font ("Arial", Font.BOLD, 18));


        //Nested for loop to efficiently show board of 64 images
        for (int rownum = 7 ; rownum >= 0 ; rownum--)
        {
            int number = rownum * 8;
            if (rownum % 2 != 0)
            {
                for (int i = 7 ; i >= 0 ; i--)
                {
                    a [i + number] = new JLabel (createImageIcon ((i + number) + ".jpg"));
                    g.add (a [i + number]);
                }
            }
            else
            {
                for (int i = 0 ; i < 8 ; i++)
                {
                    a [i + number] = new JLabel (createImageIcon ((i + number) + ".jpg"));
                    g.add (a [i + number]);
                }
            }


        }
        a [0].setIcon (createImageIcon ("p1.jpg")); //icons are space-theme related
        //sets player one icon as first picture
        
        hardmode = new JButton ("HARD MODE");
        hardmode.setForeground (Color.white);
        hardmode.setBackground (Color.red);
        hardmode.addActionListener (this);
        hardmode.setActionCommand ("hard");
        hardmode.setPreferredSize (new Dimension (150, 30));
        //alternate difficulty level (makes dice roll only up to 3 in actionPerformed)
        //included in same screen
        
        scoreNum1 = new JLabel ("P1 Score: " + p1score+ "   ");
        scoreNum1.setFont (new Font ("Arial", Font.BOLD, 18));


        scoreNum2 = new JLabel ("P2 Score: " + p2score);
        scoreNum2.setFont (new Font ("Arial", Font.BOLD, 18));
        //scoring


        card3.add (g);
        card3.add (roll);
        card3.add (dice);
        card3.add (turn);
        card3.add (numOfTurns);
        card3.add (hardmode);
        card3.add (scoreNum1);
        card3.add (scoreNum2);
        //roll and hardmode are only 2 ways of user input
        //limited input restricts movement/choices and ensures no errors


        p_card.add ("3", card3);
        //all difficulty levels in same method
    }


    
    //actionPerformed to make jButtons work
    public void actionPerformed (ActionEvent e)
    {
        //sets screens
        if (e.getActionCommand ().equals ("play"))
        {
            cdLayout.show (p_card, "3");
        }


        else if (e.getActionCommand ().equals ("ins"))
        {
            cdLayout.show (p_card, "2");
        }


        else if (e.getActionCommand ().equals ("menu"))
        {
            cdLayout.show (p_card, "1");
            hardmode.setEnabled (true);
        }
  
        //updates difficulty level
        else if (e.getActionCommand ().equals ("hard"))
        {
            n = rand.nextInt (3) + 1;
            showStatus ("Hard Mode has been activated!");
            hardmode.setEnabled (false); //makes sure you can't click again
        }






        if (e.getActionCommand ().equals ("roll"))
        {   
            //updates turn number
            turnNum++;
            if (turnNum < 10)
            {
                numOfTurns.setText ("        Number of Turns: 0" + turnNum + "  ");
            }
            numOfTurns.setText ("        Number of Turns: " + turnNum + "  ");


            //confirms hard mode is not enabled
            if (!hardmode.isEnabled ())
            {
                n = (int) (Math.random () * 3 + 1);
            }


            else
            {
                n = (int) ((Math.random () * 6) + 1);
            }


            showStatus ("You rolled a " + n + ".");
            playerNum++;
            //showStatus to show number rolled






            if (playerNum % 2 == 0)
            {
                turn.setText ("        It is Player 2's Turn");
                p1space = p1space + n;


                //updates board and sets clear
                for (int rownum = 7 ; rownum >= 0 ; rownum--)
                {
                    int number = rownum * 8;
                    if (rownum % 2 != 0)
                    {
                        for (int i = 7 ; i >= 0 ; i--)
                        {
                            a [i + number].setIcon (createImageIcon ((i + number) + ".jpg"));


                        }
                    }
                    else
                    {
                        for (int i = 0 ; i < 8 ; i++)
                        {
                            a [i + number].setIcon (createImageIcon ((i + number) + ".jpg"));
                        }
                    }
                }
                
                //includes space facts on every 8th space to add to theme
                if (p1space == 7)
                {
                    JOptionPane.showMessageDialog (null, "There are thousands of planets in our universe!", "Did you know that...?", JOptionPane.ERROR_MESSAGE);
                }


                else if (p1space == 15)
                {
                    JOptionPane.showMessageDialog (null, "In space, the skin on your feet peels off!", "Did you know that...?", JOptionPane.ERROR_MESSAGE);
                }


                else if (p1space == 23)
                {
                    JOptionPane.showMessageDialog (null, "On Venus, a day is longer than a year in Earth!", "Did you know that...?", JOptionPane.ERROR_MESSAGE);
                }


                else if (p1space == 31)
                {
                    JOptionPane.showMessageDialog (null, "One million Earths can fit inside the Sun!", "Did you know that...?", JOptionPane.ERROR_MESSAGE);
                }


                else if (p1space == 39)
                {
                    JOptionPane.showMessageDialog (null, "You become taller in space!", "Did you know that...?", JOptionPane.ERROR_MESSAGE);
                }


                else if (p1space == 47)
                {
                    JOptionPane.showMessageDialog (null, "The hottest planet is not the closest to the Sun!", "Did you know that...?", JOptionPane.ERROR_MESSAGE);
                }


                else if (p1space == 55)
                {
                    JOptionPane.showMessageDialog (null, "You can cry in space but your tears won't fall!", "Did you know that...?", JOptionPane.ERROR_MESSAGE);
                }


                else if (p1space == 10)
                {
                    showStatus ("You rolled a " + n + ". Nice! You climbed up a LADDER!");
                    p1space = 35;
                }


                else if (p1space == 17)
                {
                    showStatus ("You rolled a " + n + ". Nice! You climbed up a LADDER!");
                    p1space = 51;
                }


                else if (p1space == 42)
                {
                    showStatus ("You rolled a " + n + ". Nice! You climbed up a LADDER!");
                    p1space = 57;
                }


                else if (p1space == 15)
                {
                    showStatus ("You rolled a " + n + ". Oh no! You were eaten by a SNAKE!");
                    p1space = 5;
                }


                else if (p1space == 36)
                {
                    showStatus ("You rolled a " + n + ". Oh no! You were eaten by a SNAKE!");
                    p1space = 24;
                }


                else if (p1space == 60)
                {
                    showStatus ("You rolled a " + n + ". Oh no! You were eaten by a SNAKE!");
                    p1space = 32;
                }


                //winning condition serves as a reset button and lets user play again
                else if (p1space >= 63)
                {
                    p1space = 0;
                    p2space = 0;
                    p1score++;


                    scoreNum1.setText ("P1 Score: " + p1score+ "   ");




                    for (int rownum = 7 ; rownum >= 0 ; rownum--)
                    {
                        int number = rownum * 8;
                        if (rownum % 2 != 0)
                        {
                            for (int i = 7 ; i >= 0 ; i--)
                            {
                                a [i + number].setIcon (createImageIcon ((i + number) + ".jpg"));
                            }
                        }
                        else
                        {
                            for (int i = 0 ; i < 8 ; i++)
                            {
                                a [i + number].setIcon (createImageIcon ((i + number) + ".jpg"));
                            }
                        }
                    }


                    a [0].setIcon (createImageIcon ("p1.jpg"));
                    a [0].setIcon (createImageIcon ("p2.jpg"));


                    dice.setIcon (createImageIcon ("Dice-6-b.svg.jpeg"));


                    turn.setText ("Click ROLL to play the game!");


                    turnNum = 00;
                    numOfTurns.setText ("        Number of Turns: 0" + turnNum + "  ");


                    JOptionPane.showMessageDialog (null, "Congratulations! Player 1 wins!");
                    showStatus ("Player 1 has won the game!");
                    //Dialog Box to show victory


                    cdLayout.show (p_card, "1");
                    //Back to Screen 1 to play again
                }


                a [p1space].setIcon (createImageIcon ("p1.jpg"));
                a [p2space].setIcon (createImageIcon ("p2.jpg"));
                
                hardmode.setEnabled (true);


            }
            
            //same thing as player one except for player two
            else
            {
                turn.setText ("        It is Player 1's Turn");
                p2space = p2space + n;


                for (int rownum = 7 ; rownum >= 0 ; rownum--)
                {
                    int number = rownum * 8;
                    if (rownum % 2 != 0)
                    {
                        for (int i = 7 ; i >= 0 ; i--)
                        {
                            a [i + number].setIcon (createImageIcon ((i + number) + ".jpg"));
                        }
                    }
                    else
                    {
                        for (int i = 0 ; i < 8 ; i++)
                        {
                            a [i + number].setIcon (createImageIcon ((i + number) + ".jpg"));
                        }
                    }
                }
                if (p2space == 7)
                {
                    JOptionPane.showMessageDialog (null, "The moon looks bigger on the horizon!", "Did you know that...?", JOptionPane.ERROR_MESSAGE);
                }


                else if (p2space == 15)
                {
                    JOptionPane.showMessageDialog (null, "Dirty underwear and toilet paper grew plants on the ISS!", "Did you know that...?", JOptionPane.ERROR_MESSAGE);
                }


                else if (p2space == 23)
                {
                    JOptionPane.showMessageDialog (null, "There is a dwarf planet called Easter Island Legend!", "Did you know that...?", JOptionPane.ERROR_MESSAGE);
                }


                else if (p2space == 31)
                {
                    JOptionPane.showMessageDialog (null, "Nebulae can come in any shape or size!", "Did you know that...?", JOptionPane.ERROR_MESSAGE);
                }


                else if (p2space == 39)
                {
                    JOptionPane.showMessageDialog (null, "The North Star will change... one day!", "Did you know that...?", JOptionPane.ERROR_MESSAGE);
                }


                else if (p2space == 47)
                {
                    JOptionPane.showMessageDialog (null, "In space, metal sticks together!", "Did you know that...?", JOptionPane.ERROR_MESSAGE);
                }


                else if (p2space == 55)
                {
                    JOptionPane.showMessageDialog (null, "The Apollo crews did not have life insurance!", "Did you know that...?", JOptionPane.ERROR_MESSAGE);
                }




                else if (p2space == 10)
                {
                    showStatus ("You rolled a " + n + ". Nice! You climbed up a LADDER!");
                    p2space = 35;
                }


                else if (p2space == 17)
                {
                    showStatus ("You rolled a " + n + ". Nice! You climbed up a LADDER!");
                    p2space = 51;
                }


                else if (p2space == 42)
                {
                    showStatus ("You rolled a " + n + ". Nice! You climbed up a LADDER!");
                    p2space = 57;
                }


                else if (p2space == 15)
                {
                    showStatus ("You rolled a " + n + ". Oh no! You were eaten by a SNAKE!");
                    p2space = 5;
                }


                else if (p2space == 36)
                {
                    showStatus ("You rolled a " + n + ". Oh no! You were eaten by a SNAKE!");
                    p2space = 24;
                }


                else if (p2space == 60)
                {
                    showStatus ("You rolled a " + n + ". Oh no! You were eaten by a SNAKE!");
                    p2space = 32;
                }


                else if (p2space >= 63)
                {
                    p1space = 0;
                    p2space = 0;


                    p2score++;


                    scoreNum2.setText ("P2 Score: " + p2score);


                    JOptionPane.showMessageDialog (null, "Congratulations! Player 2 wins!");
                    showStatus ("Player 2 has won the game!");


                    for (int rownum = 7 ; rownum >= 0 ; rownum--)
                    {
                        int number = rownum * 8;
                        if (rownum % 2 != 0)
                        {
                            for (int i = 7 ; i >= 0 ; i--)
                            {
                                a [i + number].setIcon (createImageIcon ((i + number) + ".jpg"));
                            }
                        }
                        else
                        {
                            for (int i = 0 ; i < 8 ; i++)
                            {
                                a [i + number].setIcon (createImageIcon ((i + number) + ".jpg"));
                            }
                        }
                    }


                    a [0].setIcon (createImageIcon ("p2.jpg"));
                    a [0].setIcon (createImageIcon ("p1.jpg"));


                    dice.setIcon (createImageIcon ("Dice-6-b.svg.jpeg"));


                    turn.setText ("Click ROLL to play the game!");


                    turnNum = 00;
                    numOfTurns.setText ("        Number of Turns: 0" + turnNum + "  ");
                    hardmode.setEnabled (true);


                    cdLayout.show (p_card, "1");
                }


                a [p1space].setIcon (createImageIcon ("p1.jpg"));
                a [p2space].setIcon (createImageIcon ("p2.jpg"));
            }
            {
                if (n == 1)
                    dice.setIcon (createImageIcon ("Dice1.jpeg"));
                else if (n == 2)
                    dice.setIcon (createImageIcon ("120px-Dice-2-b.svg.jpeg"));
                else if (n == 3)
                    dice.setIcon (createImageIcon ("Dice-3-b.jpeg"));
                else if (n == 4)
                    dice.setIcon (createImageIcon ("dice4.gif"));
                else if (n == 5)
                    dice.setIcon (createImageIcon ("Dice-5-b.svg.jpeg"));
                else
                    dice.setIcon (createImageIcon ("Dice-6-b.svg.jpeg"));
            }
        }
    }


    
    //method for updating pictures
    protected static ImageIcon createImageIcon (String path)
    {
        java.net.URL imgURL = SnakesandLadders.class.getResource (path);
        if (imgURL != null)
        {
            return new ImageIcon (imgURL);
        }
        else
        {
            System.err.println ("Couldn't find file: " + path);
            return null;
        }
    }
    
    
    //method for playing music
    public static void playMusic (String filepath)  // Method to allow music of 1MB size or smaller
    {
        AudioPlayer MGP = AudioPlayer.player;
        AudioStream BGM;
        AudioData MD;
        ContinuousAudioDataStream loop = null;
        try
        {
            BGM = new AudioStream (new FileInputStream (filepath + ".wav")); //set song
            MD = BGM.getData (); //get data fom song
            loop = new ContinuousAudioDataStream (MD); //set as loop
        }
        catch (IOException error)  //error
        {
            System.out.println ("Audio - File not found.");
        }
        MGP.start (loop); //start running loop
    }
   


}
