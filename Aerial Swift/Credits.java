// The "Credits" class.
// Author: Kevin Subhash
// Date: June 15, 2016
// Description: This program is the GUI for credits. It contains a file reader to obtain the credits information
//              and it organizes the information in an array so it is able to display the credits.
import java.awt.*;
import java.awt.event.*;    // Import java libraries
import javax.swing.*;
import java.text.*;
import java.io.*;
import java.util.*;
import java.applet.*;
import java.net.*;

public class Credits extends JFrame implements ActionListener
{
    JLabel bg, image1, image2, title, photo1, photo2; // Declaring variables for JLabels, JButtons, Container,
    JButton back;                                     // JTextArea, AudioClip, and String
    JTextArea display;
    Container frame;
    AudioClip ad;
    String credit[];
    String info = "";

    public Credits ()
    {
	super ("Credits");

	try // Try catch for file reader
	{
	    credit = new String [11]; // Creating array amount for credit

	    FileReader file = new FileReader ("credits.txt"); // Reads information from credits.txt
	    BufferedReader input = new BufferedReader (file);
	    for (int i = 0 ; i < credit.length ; i++) // Loops to organize content in the array
	    {
		credit [i] = input.readLine ();
	    }

	    file.close (); // closes file
	}
	catch (Exception e)
	{

	}
	for (int i = 0 ; i < credit.length ; i++) // loops to add information to new output file

	    {
		info = info + credit [i] + " \n"; // Displays each line of the credits message
	    }

	URL path2 = getClass ().getResource ("coin.wav"); //open the file
	ad = Applet.newAudioClip (path2); //create audio clip

	frame = getContentPane ();  // get the container frame
	setBounds (800, 300, 500, 500);
	setUndecorated (true);  // get rid of the border
	show ();

	frame = getContentPane (); //get the container's frame
	setResizable (false); // Can't make the window resizeable
	getRootPane ().setWindowDecorationStyle (JRootPane.FRAME); // Adds decoration to window border
	setDefaultCloseOperation (EXIT_ON_CLOSE); // When 'x' is clicked on the window, program ends

	display = new JTextArea (); // Creates Text Area for display
	display.setText (info); // Displays info with the array organized

	bg = new JLabel (new ImageIcon ("bg.jpg")); // Adding a picture
	photo1 = new JLabel (new ImageIcon ("ks.png")); // Adding a picture
	photo2 = new JLabel (new ImageIcon ("dp.jpg")); // Adding a picture
	back = new JButton (new ImageIcon ("back.png")); // Adding a picture on button
	title = new JLabel (new ImageIcon ("credits.png")); // Adding a picture

	frame.add (title); // Adding frame for title
	frame.add (display); // Adding frame for display
	frame.add (back); // Adding frame for back
	frame.add (photo1); // Adding frame for photo1
	frame.add (photo2); // Adding frame for photo2
	frame.add (bg); // Adding frame for bg

	back.addActionListener (this); // Adding action listener for back

	setSize (400, 400);     // Set the frame's size

	title.setBounds (-2, -175, 400, 400); // Displaying positions for all frames added
	display.setBounds (20, 80, 140, 180);
	back.setBounds (5, 320, 65, 40);
	bg.setBounds (0, 0, 400, 400);
	photo1.setBounds (175, 185, 200, 200);
	photo2.setBounds (175, 30, 200, 200);

	display.setEditable (false); // makes display non-editable
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
	new Credits ();    // Create a Leaderboards frame
    } // main method
} // Leaderboards class


