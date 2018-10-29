// The "Help" class.
// Author: Kevin Subhash
// Date: June 15, 2016
// Description: This program is the GUI for help. It contains a file reader to obtain the help information
//              and it organizes the information in an array so it is able to display how to play the game.
import java.awt.*;
import java.awt.event.*;    // Import java libraries
import javax.swing.*;
import java.text.*;
import java.io.*;
import java.util.*;
import java.applet.*;
import java.net.*;

public class Help extends JFrame implements ActionListener
{
    JLabel bg, image1, image2, title, keys; // Declaring variables for JLabels, JButtons, Container,
    JButton back;                           // JTextArea, AudioClip, and String
    JTextArea helpInfo;
    Container frame;
    AudioClip ad;
    String help[];
    String info = "";

    public Help ()
    {
	super ("How To Play");

	try // Try catch for file reader
	{
	    help = new String [8]; // Creating array amount for help

	    FileReader file = new FileReader ("help.txt"); // Reads information from help.txt
	    BufferedReader input = new BufferedReader (file);
	    for (int i = 0 ; i < help.length ; i++) // Loops to organize content in the array
	    {
		help [i] = input.readLine ();
	    }

	    file.close (); // closes file
	}
	catch (Exception e)
	{

	}
	for (int i = 0 ; i < help.length ; i++) // loops to add information to new output file

	    {
		info = info + help [i] + " \n"; // Displays each line of the help message
	    }

	URL path2 = getClass ().getResource ("coin.wav"); //open the file
	ad = Applet.newAudioClip (path2); //create audio clip

	frame = getContentPane ();  // get the container frame
	setBounds (800, 300, 500, 500); // Setting bounds where the program will open on the screen
	setUndecorated (true);  // get rid of the border
	show ();

	frame = getContentPane (); //get the container's frame
	setResizable (false); // Can't make the window resizeable
	getRootPane ().setWindowDecorationStyle (JRootPane.FRAME); // Adds decoration to window border
	setDefaultCloseOperation (EXIT_ON_CLOSE); // When 'x' is clicked on the window, program ends

	helpInfo = new JTextArea (); // Creates Text Area for helpInfo
	helpInfo.setText (info); // Displays info with the array organized

	bg = new JLabel (new ImageIcon ("bg.jpg")); // Adding a picture
	keys = new JLabel (new ImageIcon ("keys.png")); // Adding a picture
	back = new JButton (new ImageIcon ("back.png")); // Adding a picture on button
	title = new JLabel (new ImageIcon ("howtoplay.png")); // Adding a picture

	frame.add (title); // Adding frame for title
	frame.add (helpInfo); // Adding frame for helpInfo
	frame.add (back); // Adding frame for back
	frame.add (keys); // Adding frame for keys
	frame.add (bg); // Adding frame for bg

	back.addActionListener (this); // Adding action listener for back

	setSize (400, 400);     // Set the frame's size

	keys.setBounds (40, 262, 550, 100); // Displaying positions for all frames added
	title.setBounds (-2, -175, 400, 400);
	helpInfo.setBounds (50, 60, 280, 150);
	back.setBounds (5, 320, 65, 40);
	bg.setBounds (0, 0, 400, 400);


	helpInfo.setEditable (false); // makes helpInfo non-editable

	setVisible (true); // Shows Frame

    } // Constructor


    public void actionPerformed (ActionEvent e)
    {
	if (e.getSource () == back) // If back button is pressed
	{
	    ad.play (); // Coin sound plays
	    super.dispose (); // closes help program/class
	    new MainMenu2 (); // Opens MainMenu2. java or MainMenu2 class
	}
    }


    public static void main (String[] args)
    {
	new Help ();    // Create a Leaderboards frame
    } // main method
} // Leaderboards class


