// The "Leaderboards" class.
// Author: Kevin Subhash
// Date: June 15, 2016
// Description: This program is the gui for the Leaderboard. This program has file reading for the leaderboard information.
//              The information is displayed in a chart and are organized in 2 arrays (timesPlayed and characters). Along with that,
//              the information can be sorted in ascending or descending order and it gives the user an ability to seach for a name
//              to find how much that character was played.  
import java.awt.*;
import java.awt.event.*;    // Import java libraries
import javax.swing.*;
import java.text.*;
import java.io.*;
import java.util.*;
import java.applet.*;
import java.net.*;

public class Leaderboards extends JFrame implements ActionListener
{
    JLabel lblName, lblName2, lblText, bg, backPic, title; // Declaring variables for JLabels, JButtons, Container,
    JTextField txtName, result;                            // JTextField, JTextArea, AudioClip, double, and String
    JTextArea leaderboardChart;
    JButton search, back, ascending, descending;
    Container frame;
    AudioClip ad;
    double timesPlayed[];
    String characters[];


    public Leaderboards ()
    {

	super ("Leaderboard");
	NumberFormat f = NumberFormat.getInstance (); // set up formatting for zero decimal place
	f.setMaximumFractionDigits (0);
	try
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

	String chart = "  Team \t Times Played \n"; // declared that chart is a string and equal to a chart format
	chart = chart + "  ===== \t =========== \n"; // to organize the arrays

	for (int i = 0 ; i < characters.length ; i++) // loops to add information to new output file to display

	    {
		chart = chart + "  " + characters [i] + " \t        " + f.format (timesPlayed [i]) + " \n"; // Displays characters and its scores
	    }


	URL path2 = getClass ().getResource ("coin.wav"); //open the audio file
	ad = Applet.newAudioClip (path2); //create audio clip

	frame = getContentPane ();  // get the container frame
	setBounds (800, 300, 500, 500); // Setting bounds where the program will open on the screen
	setUndecorated (true);  // get rid of the border
	show ();

	frame = getContentPane (); //get the container's frame
	setResizable (false); // Can't make the window resizeable
	getRootPane ().setWindowDecorationStyle (JRootPane.FRAME); // Adds decoration to window border
	setDefaultCloseOperation (EXIT_ON_CLOSE); // When 'x' is clicked on the window, program ends

	lblText = new JLabel ("Names with a -1 \nrequire a DLC to be played!"); // Creating a label for lblText
	lblName = new JLabel ("Search Name:"); // Creating a label for lblName
	lblName2 = new JLabel ("Times Played:"); // Creating a label for lblName2
	bg = new JLabel (new ImageIcon ("bg.jpg")); // Creating a label for bg

	txtName = new JTextField (); // Creating a text field for txtName
	result = new JTextField (); // Creating a text field for result


	 leaderboardChart = new JTextArea (); // Creates Text Area for leaderboardChart
	leaderboardChart.setTabSize (12); // Setting tab size to organize arrays
	leaderboardChart.setText (chart); // Displays chart with arrays organized

	search = new JButton ("Search"); // Created a label on button
	ascending = new JButton ("Ascend"); // Created a label on button
	descending = new JButton ("Descend"); // Created a label on button
	backPic = new JLabel (new ImageIcon ("back.png")); // Adding a picture
	back = new JButton (new ImageIcon ("back.png"));  // Adding a picture on button
	title = new JLabel (new ImageIcon ("leaderboard.png")); // Adding a picture

	setSize (400, 400);     // Set the frame's size

	frame.add (title); // Adding frame for title
	frame.add (lblText); // Adding frame for lblText
	frame.add (result); // Adding frame for result
	frame.add (lblName); // Adding frame for lblName
	frame.add (lblName2); // Adding frame for lblName2
	frame.add (leaderboardChart); // Adding frame for leaderboardChart
	frame.add (txtName); // Adding frame for txtName
	frame.add (search); // Adding frame for search
	frame.add (ascending); // Adding frame for ascending
	frame.add (descending); // Adding frame for descending
	frame.add (back); // Adding frame for back
	frame.add (bg); // Adding frame for bg

	back.addActionListener (this); // Adding action listener for back
	search.addActionListener (this); // Adding action listener for search
	ascending.addActionListener (this); // Adding action listener for ascending
	descending.addActionListener (this); // Adding action listener for descending

	title.setBounds (-2, -175, 400, 400); // Displaying positions for all frames added
	bg.setBounds (0, 0, 400, 400);
	lblText.setBounds (5, 285, 400, 45);
	lblName.setBounds (297, 80, 100, 15);
	txtName.setBounds (295, 100, 85, 20);
	lblName2.setBounds (295, 130, 100, 15);
	result.setBounds (295, 150, 85, 20);
	search.setBounds (295, 175, 85, 25);
	ascending.setBounds (295, 225, 85, 25);
	descending.setBounds (295, 260, 85, 25);
	back.setBounds (5, 320, 65, 40);
	leaderboardChart.setBounds (40, 65, 220, 220);

	leaderboardChart.setEditable (false); // makes leaderboardChart non-editable
	result.setEditable (false); // makes result non-editable

	setVisible (true); // Show the frame

    } // Constructor


    public void actionPerformed (ActionEvent e)
    {
	if (e.getSource () == search) // If search button is pressed
	{
	    ad.play (); // Coin sound will play

	    String foundName = txtName.getText (); // Moves the inputted text by the user to String foundName

	    int location; // Declaring that location is an integer
	    location = findName (foundName, characters); // calls findName method

	    if (location >= 0) // If location is greater or equal to 0
	    {
		String score = Double.toString (timesPlayed [location]); // Converts double timesPlayed to a string
		result.setText (score); // Displays string in result
	    }
	    else // Otherwise, it will notify the user that the character inputted is not in the game
	    {
		JOptionPane.showMessageDialog (null, foundName + " is not in the game or any DLC.\n\nHowever, submit your character at\n'AerialSwift.com/CharacterSubmission'\nand it may appear in the next DLC!");
	    }

	}
	else if (e.getSource () == ascending) // If user presses ascending button
	{
	    ad.play (); // Coin sound plays
	    ascendingScore (timesPlayed, characters); // Calls ascendingScore Method
	    chartDisplay (timesPlayed, characters, leaderboardChart); // Calls chartDisplay Method
	}
	else if (e.getSource () == descending) // If user presses descending button
	{
	    ad.play (); // Coin sound plays
	    descendingScore (timesPlayed, characters); // Calls descendingScore Method
	    chartDisplay (timesPlayed, characters, leaderboardChart); // Calss chartDisplay Method
	}
	else if (e.getSource () == back) // If user presses back button
	{
	    ad.play (); // Coin sound plays
	    super.dispose (); // Closes leaderboard window/program
	    new MainMenu2 (); // Opens MainMenu2.java or MainMenu2 class
	}
    }


    //------------------------------------------METHODS----------------------------------------------METHODS----------------------------------------------METHODS----------------------------------------------METHODS----------------------------------------------//
    
    public static int findName (String name, String array[])  // Method for Finding name
    {

	for (int i = 0 ; i < array.length ; i++)
	{

	    if (name.equalsIgnoreCase (array [i]) == true)
	    {
		return i; //found at i
	    }
	}
	return -1; //  not found
    }


    public static void ascendingScore (double timesPlayed[], String characters[]) // Method for ascending the times played
    {
	for (int i = 0 ; i < characters.length ; i++) // Loops for organzing arrays in ascending order
	{
	    for (int j = 0 ; j < characters.length - 1 ; j++)
	    {
		if (timesPlayed [j] > timesPlayed [j + 1])
		{
		    double tempWins = timesPlayed [j];
		    timesPlayed [j] = timesPlayed [j + 1];
		    timesPlayed [j + 1] = tempWins;

		    String tempNames = characters [j];
		    characters [j] = characters [j + 1];
		    characters [j + 1] = tempNames;
		}

	    }
	}
    }


    public static void descendingScore (double timesPlayed[], String characters[]) // Method for descending the times played
    {
	for (int i = 0 ; i < characters.length ; i++) // Loops for organzing arrays in descending order
	{
	    for (int j = 0 ; j < characters.length - 1 ; j++)
	    {
		if (timesPlayed [j] < timesPlayed [j + 1])
		{
		    double tempWins = timesPlayed [j];
		    timesPlayed [j] = timesPlayed [j + 1];
		    timesPlayed [j + 1] = tempWins;

		    String tempNames = characters [j];
		    characters [j] = characters [j + 1];
		    characters [j + 1] = tempNames;
		}

	    }
	}
    }


    public static void chartDisplay (double timesPlayed[], String characters[], JTextArea leaderboardChart) // Method for creating and displaying the chart with the arrays organized
    {
	NumberFormat f = NumberFormat.getInstance (); // set up formatting for two decimal place
	f.setMaximumFractionDigits (0);

	String chart = "  Team \t Times Played \n"; // declared that chart is a string and equal to a chart format
	chart = chart + "  ===== \t =========== \n"; // to organize the arrays

	for (int i = 0 ; i < characters.length ; i++) // loops to add information to new output file to display

	    {
		chart = chart + "  " + characters [i] + " \t        " + f.format (timesPlayed [i]) + " \n"; // Displays characters and its times played
	    }

	chart = chart;  // Displays total average of timesPlayed

	leaderboardChart.setText (chart); // leaderboardChart sets chart as its text to display
	leaderboardChart.setEditable (false); // Makes leaderboardChart non-editable
    }




    public static void main (String[] args)
    {
	new Leaderboards ();    // Create a Leaderboards frame
    } // main method
} // Leaderboards class


