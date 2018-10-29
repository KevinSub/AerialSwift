// The "TestMan" class.
import java.awt.*;
import javax.swing.*;
import java.text.*;
import java.awt.event.*;

public class TestMan extends JFrame implements ActionListener
{
    Container frame;
    JButton btnRestart;
    public TestMan ()
    {
	super ("test");    // Set the frame's name

	setResizable (false);
	frame = getContentPane ();
	getRootPane ().setWindowDecorationStyle (JRootPane.FRAME);
	setDefaultCloseOperation (EXIT_ON_CLOSE);

	btnRestart = new JButton ("Restart");


	frame.setLayout (null);
	frame.add (btnRestart);
	setSize (200, 120);     // Set the frame's size

	btnRestart.addActionListener (this);

	btnRestart.setBounds (15, 15, 150, 25);

	setVisible (true);                // Show the frame
    } // Constructor


    public void actionPerformed (ActionEvent e)
    {
	String question;
	if (e.getSource () == btnRestart)
	{
	    super.dispose ();
	    new CharacterSelect ();
	}



    }


    public static void main (String[] args)
    {
	new TestMan ();       // Create a A frame
    } // main method
} // TestMan class
