// The "MainMenu2" class.
// Author: Kevin Subhash
// Date: June 15, 2016
// Description: This program is the gui for the second main menu of the game. The difference is, this program does not have music
//              and it will access every mode without losing the background music.
import java.awt.*;
import javax.swing.*;
import java.text.*;
import java.awt.event.*;
import java.applet.*;
import java.net.*;

public class MainMenu2 extends JFrame implements ActionListener
{
    JLabel lblPic, lblPic2, lblPic3, lblPic4,                        // Declaring variables for JLabels, JButtons, Container
	lblName, lblName2, lblName3, lblName4, bg, logo;             // and Audio Clips
    JButton button, button2, button3, button4, button5, button6;
    Container frame;
    AudioClip ad;



    public MainMenu2 ()
    {
	super ("Main Menu"); // Displays "Main Menu" on top of window

	URL path2 = getClass ().getResource ("coin.wav"); //open the file
	ad = Applet.newAudioClip (path2); //create a second audio clip

	frame = getContentPane ();  // get the container frame
	setBounds (800, 300, 500, 500); // Setting bounds where the program will open on the screen
	setUndecorated (true);  // get rid of the border
	show ();

	setResizable (false); // Can't make the window resizeable
	getRootPane ().setWindowDecorationStyle (JRootPane.FRAME); // Adds decoration to window border
	setDefaultCloseOperation (EXIT_ON_CLOSE); // When 'x' is clicked on the window, program ends

	lblName = new JLabel ("Play");          // labeling it as play
	lblName2 = new JLabel ("Leaderboard");  // labeling it as leaderboard
	lblName3 = new JLabel ("How to Play");  // labeling it as how to play
	lblName4 = new JLabel ("Credits");      // labeling it as credits

	lblPic = new JLabel (new ImageIcon ("logo.png")); // giving JLabel a picture to hold
	button = new JButton ("");                        // Setting up JButton
	bg = new JLabel (new ImageIcon ("bg.jpg"));       // giving JLabel a picture to hold
	button2 = new JButton ("");                       // Setting up JButton
	logo = new JLabel (new ImageIcon ("logo2.png"));  // giving JLabel a picture to hold
	button3 = new JButton ("");                       // Setting up JButton
	button4 = new JButton ("");                       // Setting up JButton
	button5 = new JButton (new ImageIcon ("nomusic.png")); // giving JButton a picture to hold
	button6 = new JButton (new ImageIcon ("sound.gif"));   // giving JButton a picture to hold


	frame.add (lblName); // adding a frame for lblName
	frame.add (lblName2);// adding a frame for lblName2
	frame.add (lblName3);// adding a frame for lblName3
	frame.add (lblName4);// adding a frame for lblName4
	frame.add (button);// adding a frame for button
	frame.add (button2);// adding a frame for button2
	frame.add (button3);// adding a frame for button3
	frame.add (button4);// adding a frame for button4
	frame.add (button5);// adding a frame for button5
	frame.add (button6);// adding a frame for button6
	frame.add (lblPic);// adding a frame for lblPic
	frame.add (logo);// adding a frame for logo
	frame.add (bg);// adding a frame for bg

	button.addActionListener (this); //adding action listener for button
	button2.addActionListener (this); //adding action listener for button2
	button3.addActionListener (this); //adding action listener for button3
	button4.addActionListener (this); //adding action listener for button4
	button5.addActionListener (this); //adding action listener for button5
	button6.addActionListener (this); //adding action listener for button6


	setSize (400, 400);     // Set the frame's size

	bg.setBounds (0, 0, 400, 400);          // displaying positions for all frames added
	logo.setBounds (-77, -10, 550, 100);
	lblPic.setBounds (150, 100, 200, 211);
	button.setBounds (15, 100, 100, 50);
	button2.setBounds (15, 220, 100, 50);
	button3.setBounds (15, 280, 100, 50);
	button4.setBounds (15, 160, 100, 50);
	button5.setBounds (343, 320, 40, 40);
	button6.setBounds (300, 320, 40, 40);

	lblName.setBounds (50, 117, 100, 15);
	lblName2.setBounds (28, 177, 100, 15);
	lblName3.setBounds (30, 237, 100, 15);
	lblName4.setBounds (45, 297, 100, 15);

	setVisible (true);                // Show the frame
    } // Constructor


    public void actionPerformed (ActionEvent e)
    {

	if (e.getSource () == button) // If button is clicked, coin sound will play and will open CharacterSelect.java
	{
	    ad.play (); 
	    super.dispose();
	    new CharacterSelect ();
	}

	else if (e.getSource () == button2) // If button2 is clicked, coin sound will play and will open Help.java
	{
	    ad.play ();
	    super.dispose();
	    new Help ();
	}

	else if (e.getSource () == button3) // If button3 is clicked, coin sound will play and will open Credits.java
	{
	    ad.play ();
	    super.dispose();
	    new Credits ();
	}

	else if (e.getSource () == button4) // If button4 is clicked, coin sound will play and will open Leaderboards.java
	{
	    ad.play ();
	    super.dispose();
	    new Leaderboards ();
	}

    } // paint method


    public static void main (String[] args)
    {
	new MainMenu2 ();    // Create a CharacterSelect frame
    } // main method
} // CharacterSelect class


