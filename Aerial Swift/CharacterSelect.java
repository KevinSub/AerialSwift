// The "CharacterSelect" class.
// Author: Deep Patel & Kevin Subhash
// Date: June 15, 2016
// Description: This program is the GUI for character selecting. This program allows the user to pick any character they want to play the game.
//              It contains FILEWRITER. It counts how many times a certain character button has been pressed because if you press a character, you
//              instantly play as that character.
import java.awt.*;
import javax.swing.*;
import java.text.*;
import java.awt.event.*;
import java.applet.*;
import java.net.*;
import java.io.*;

public class CharacterSelect extends JFrame implements ActionListener
{
    JLabel lblPic, lblPic2, lblPic3, lblPic4, lblPic5, lblPic6, lblPic7, bg, backPic, title,  // declaring varibales for word, Translate ,input/output,pictures,authors
	lblName, lblName2, lblName3, lblName4, lblName5, lblName6, lblName7;
    JButton button, button2, button3, button4, button5, button6, back;
    Container frame;
    AudioClip ad;
    double timesPlayed[];
    String characters[];


    public CharacterSelect ()
    {
	super ("Character Select");
//-------------KEVIN SUBHASH----------------------
	URL path2 = getClass ().getResource ("coin.wav"); //open the file
	ad = Applet.newAudioClip (path2); //create audio clip

	try // Try catch for file reader
	{
	    characters = new String [11]; // Creating array amount for characters and timesPlayed
	    timesPlayed = new double [11];

	    FileReader file = new FileReader ("Leaderboard.txt"); // Reads information from leaderboard.txt
	    BufferedReader input = new BufferedReader (file);

	    for (int i = 0 ; i < characters.length ; i++) // Loops to organize content in each array
	    {
		characters [i] = input.readLine ();
		timesPlayed [i] = Double.parseDouble (input.readLine ());
	    }
	    file.close (); // closes file
	}
	catch (Exception e)
	{

	}

	frame = getContentPane ();  // get the container frame
	setBounds (800, 300, 500, 500); // Setting bounds where the program will open on the screen
	setUndecorated (true);  // get rid of the border
	show ();
	
//-------------DEEP PATEL----------------------
	frame = getContentPane (); //get the container's frame
	setResizable (false); // Can't make the window resizeable
	getRootPane ().setWindowDecorationStyle (JRootPane.FRAME); // Adds decoration to window border
	setDefaultCloseOperation (EXIT_ON_CLOSE); // When 'x' is clicked on the window, program ends

	lblName = new JLabel ("Mario"); // Adding a label named Mario
	lblName2 = new JLabel ("Spyro"); // Adding a label named Spyro
	lblName3 = new JLabel ("Bird"); // Adding a label named Bird
	lblName4 = new JLabel ("Sonic"); // Adding a label named Sonic
	lblName5 = new JLabel ("Campos"); // Adding a label named Campos
	lblName6 = new JLabel ("Pikachu"); // Adding a label named Pikachu
	title = new JLabel (new ImageIcon ("characterselect.png")); // Adding a picture
	bg = new JLabel (new ImageIcon ("bg.jpg")); // Adding a picture

	button = new JButton (new ImageIcon ("Mariostand.gif")); // Adding a picture to a button
	button2 = new JButton (new ImageIcon ("spyro.gif")); // Adding a picture to a button
	button3 = new JButton (new ImageIcon ("bluebird.gif")); // Adding a picture to a button
	button4 = new JButton (new ImageIcon ("sonic.gif")); // Adding a picture to a button
	button5 = new JButton (new ImageIcon ("rsz_campos.png")); // Adding a picture to a button
	button6 = new JButton (new ImageIcon ("pika.gif")); // Adding a picture to a button
	back = new JButton (new ImageIcon ("back.png")); // Adding a picture to a button

	frame.add (title); // Adding frame for title
	frame.add (button); // Adding frame for button
	frame.add (button2); // Adding frame for button2
	frame.add (button3); // Adding frame for button3
	frame.add (button4); // Adding frame for button4
	frame.add (button5); // Adding frame for button5
	frame.add (button6); // Adding frame for button6
	frame.add (back); // Adding frame for back
	frame.add (lblName); // Adding frame for lblName
	frame.add (lblName2); // Adding frame for lblName2
	frame.add (lblName3); // Adding frame for lblName3
	frame.add (lblName4); // Adding frame for lblName4
	frame.add (lblName5); // Adding frame for lblName5
	frame.add (lblName6); // Adding frame for lblName6
	frame.add (bg); // Adding frame for bg

	button.addActionListener (this); // Adding action listener for button
	button2.addActionListener (this); // Adding action listener for button2
	button3.addActionListener (this); // Adding action listener for button3
	button4.addActionListener (this); // Adding action listener for button4
	button5.addActionListener (this); // Adding action listener for button5
	button6.addActionListener (this); // Adding action listener for button6
	back.addActionListener (this); // Adding action listener for back

	setSize (400, 400);     // Set the frame's size
//-------------KEVIN SUBHASH----------------------
	title.setBounds (-2, -165, 400, 400); // Displaying positions for all frames added
	bg.setBounds (0, 0, 400, 400);
	button.setBounds (30, 100, 75, 56);
	button2.setBounds (158, 100, 75, 56);
	button3.setBounds (285, 100, 75, 56);
	button4.setBounds (30, 195, 75, 56);
	button5.setBounds (158, 195, 75, 56);
	button6.setBounds (285, 195, 75, 56);
	back.setBounds (5, 320, 65, 40);
	lblName.setBounds (53, 75, 100, 15);
	lblName2.setBounds (180, 75, 100, 15);
	lblName3.setBounds (312, 75, 100, 15);
	lblName4.setBounds (50, 170, 100, 15);
	lblName5.setBounds (173, 170, 100, 15);
	lblName6.setBounds (301, 170, 100, 15);

	setVisible (true);                // Show the frame
    } // Constructor

//-------------KEVIN SUBHASH----------------------
    public void actionPerformed (ActionEvent e)
    {

	if (e.getSource () == button) // If user presses button
	{
	    ad.play (); // Plays coin sound
	    try // Try catch for file writer
	    {
		FileWriter file2 = new FileWriter ("Leaderboard.txt"); // Writes information to leaderboard.txt
		PrintWriter output = new PrintWriter (file2);

		timesPlayed [0] = timesPlayed [0] + 1; // Adds 1 to the value stored
		reWrite (timesPlayed, characters, output); // Calls reWrite Method
		file2.close (); // Closes file2
	    }
	    catch (Exception a)
	    {
	    }

	    super.dispose ();
	    new GameMode ();
	}

	else if (e.getSource () == button2) // If user presses button2
	{
	    ad.play (); // Plays coin sound
	    try // Try catch for file writer
	    {
		FileWriter file2 = new FileWriter ("Leaderboard.txt");
		PrintWriter output = new PrintWriter (file2);

		timesPlayed [2] = timesPlayed [2] + 1; // Adds 1 to the value stored
		reWrite (timesPlayed, characters, output); // Calls reWrite Method
		file2.close (); // Closes file2
	    }
	    catch (Exception a)
	    {
	    }
	    super.dispose ();
	    new GameModeSpyro ();
	}

	else if (e.getSource () == button3) // If user presses button3
	{
	    ad.play (); // Plays coin sound
	    try // Try catch for file writer
	    {
		FileWriter file2 = new FileWriter ("Leaderboard.txt");
		PrintWriter output = new PrintWriter (file2);

		timesPlayed [3] = timesPlayed [3] + 1; // Adds 1 to the value stored
		reWrite (timesPlayed, characters, output); // Calls reWrite Method
		file2.close (); // Closes file2
	    }
	    catch (Exception a)
	    {
	    }
	    super.dispose ();
	    new GameModeBird ();
	}

	else if (e.getSource () == button4) // If user presses button4
	{
	    ad.play (); // Plays coin sound
	    try // Try catch for file writer
	    {
		FileWriter file2 = new FileWriter ("Leaderboard.txt");
		PrintWriter output = new PrintWriter (file2);

		timesPlayed [4] = timesPlayed [4] + 1; // Adds 1 to the value stored
		reWrite (timesPlayed, characters, output); // Calls reWrite Method
		file2.close (); // Closes file2
	    }
	    catch (Exception a)
	    {
	    }
	    super.dispose ();
	    new GameModeSonic ();
	}

	else if (e.getSource () == button5) // If user presses button5
	{
	    ad.play (); // Plays coin sound
	    try // Try catch for file writer
	    {
		FileWriter file2 = new FileWriter ("Leaderboard.txt");
		PrintWriter output = new PrintWriter (file2);

		timesPlayed [1] = timesPlayed [1] + 1; // Adds 1 to the value stored
		reWrite (timesPlayed, characters, output); // Calls reWrite Method
		file2.close (); // Closes file2
	    }
	    catch (Exception a)
	    {
	    }
	    super.dispose ();
	    new GameModecampos ();
	}

	else if (e.getSource () == button6) // If user presses button6
	{
	    ad.play (); // Plays coin sound
	    try // Try catch for file writer
	    {
		FileWriter file2 = new FileWriter ("Leaderboard.txt");
		PrintWriter output = new PrintWriter (file2);

		timesPlayed [5] = timesPlayed [5] + 1; // Adds 1 to the value stored
		reWrite (timesPlayed, characters, output); // Calls reWrite Method
		file2.close (); // Closes file2
	    }
	    catch (Exception a)
	    {
	    }
	    super.dispose ();
	    new GameModePikachu ();
	}
	else if (e.getSource () == back) // If user presses back
	{
	    ad.play ();
	    super.dispose ();
	    new MainMenu2 ();
	}
    } // paint method

//-------------KEVIN SUBHASH----------------------
    //---------------------------------METHODS------------------------------

    public static void reWrite (double timesPlayed[], String characters[], PrintWriter output)  // Method for reWriting the text file
    {
	for (int i = 0 ; i < characters.length ; i++) // Loops to organize content in the array
	{
	    output.println (characters [i]);
	    output.println (timesPlayed [i]);
	}

    }


    public static void main (String[] args)
    {
	new CharacterSelect ();    // Create a CharacterSelect frame
    } // main method
} // CharacterSelect class


