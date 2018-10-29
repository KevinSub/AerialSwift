// The "GameModePikachu" class.
//By Deep
import java.awt.*;
import javax.swing.*;
import java.text.*;
import java.awt.event.*;

public class GameModePikachu extends JFrame implements KeyListener
{
    // declaring varibales for word, Translate ,input/output,pictures,authors
    ImageIcon lblPic, lblPic2, lblPic3, lblPic4, lblPic5, lblPic6, lblPic7, lblPic8, lblPic9, lblPic10, groundPic;
    ImageIcon lblPic11, lblPic12, lblPic13, lblPic14, lblPic15, lblPic16, lblPic17, lblPic18, lblPic19, lblPic20, lblPic21, lblPic22;  //pictures to be drawn
    boolean leftKey;            // booleans to tell which key is pressed
    boolean rightKey;
    boolean upKey;
    boolean downKey;
    boolean fireKey;
    int yPos;           // the position variables
    int xPos;
    int xSpeed = 0;         // variable for x speed
    double k = 0;
    int y;           // the position variables
    int x;
    int z = 70;
    int a;
    int xSpeed2 = 1;         // variable for x speed
    double k2 = 0;
    Container frame;
    JButton btnRestart;

    public GameModePikachu ()
    {
	super ("GameModePikachu");     // Set the frame's name

	setResizable (false);
	frame = getContentPane ();
	getRootPane ().setWindowDecorationStyle (JRootPane.FRAME);
	setDefaultCloseOperation (EXIT_ON_CLOSE);

	lblPic = new ImageIcon (getClass ().getResource ("backgroundUpdated.png")); // load the pictures
	lblPic2 = new ImageIcon (getClass ().getResource ("pikachuFly.gif"));
	lblPic3 = new ImageIcon (getClass ().getResource ("pipe.png"));
	lblPic4 = new ImageIcon (getClass ().getResource ("pipe2.png"));
	lblPic5 = new ImageIcon (getClass ().getResource ("pipe.png"));
	lblPic6 = new ImageIcon (getClass ().getResource ("pipe2.png"));
	lblPic7 = new ImageIcon (getClass ().getResource ("pipe.png"));
	lblPic8 = new ImageIcon (getClass ().getResource ("pipe2.png"));
	lblPic9 = new ImageIcon (getClass ().getResource ("pipe.png"));
	lblPic10 = new ImageIcon (getClass ().getResource ("pipe2.png"));
	lblPic9 = new ImageIcon (getClass ().getResource ("pipe.png"));
	lblPic10 = new ImageIcon (getClass ().getResource ("pipe2.png"));
	groundPic = new ImageIcon (getClass ().getResource ("ground.png"));
	lblPic11 = new ImageIcon (getClass ().getResource ("pipe.png"));
	lblPic12 = new ImageIcon (getClass ().getResource ("pipe2.png"));
	lblPic13 = new ImageIcon (getClass ().getResource ("pipe.png"));
	lblPic14 = new ImageIcon (getClass ().getResource ("pipe2.png"));
	lblPic15 = new ImageIcon (getClass ().getResource ("pipe.png"));
	lblPic16 = new ImageIcon (getClass ().getResource ("pipe2.png"));
	lblPic17 = new ImageIcon (getClass ().getResource ("pipe.png"));
	lblPic18 = new ImageIcon (getClass ().getResource ("pipe2.png"));
	lblPic19 = new ImageIcon (getClass ().getResource ("pipe.png"));
	lblPic20 = new ImageIcon (getClass ().getResource ("pipe2.png"));
	lblPic21 = new ImageIcon (getClass ().getResource ("pipe.png"));
	lblPic22 = new ImageIcon (getClass ().getResource ("pipe2.png"));

	btnRestart = new JButton ("Restart");

	leftKey = false;    // set keys to false and original positions
	rightKey = false;
	upKey = false;
	downKey = false;
	fireKey = false;
	xPos = 0;
	yPos = 350;


	this.setBounds (270, 150, 0, 0);
	frame.setLayout (null);
	//frame.add (btnRestart);

	setSize (800, 430);     // Set the frame's size

	addKeyListener (this);  // add the frame as a listener to your keys
	//btnRestart.addKeyListener (this);

	btnRestart.setBounds (15, 95, 150, 25);

	//frame.add (btnRestart);

	btnRestart.setBounds (15, 95, 150, 25);

	setVisible (true);                // Show the frame
    } // Constructor


    public void actionPerformed (ActionEvent e)
    {
	if (e.getSource () == btnRestart)
	{
	    new GameModePikachu ();
	}
    }


    public void keyTyped (KeyEvent e)       //needs to be here because the class implements KeyListener
    {
	//System.out.println (e.getKeyCode ());
    }


    public void keyPressed (KeyEvent e)  //needs to be here because the class implements KeyListener
    {
	//System.out.println (e.getKeyCode ());
	if (e.getKeyCode () == KeyEvent.VK_LEFT)
	{
	    leftKey = true;
	}
	else if (e.getKeyCode () == KeyEvent.VK_RIGHT)
	{
	    rightKey = true;
	}
	else if (e.getKeyCode () == KeyEvent.VK_UP)
	{
	    upKey = true;
	}
	else if (e.getKeyCode () == KeyEvent.VK_DOWN)
	{
	    downKey = true;
	}
	repaint ();  //repaint the window everytime you press a key

    }


    public void keyReleased (KeyEvent e)  //needs to be here because the class implements KeyListener
    {
	//System.out.println (e.getKeyCode ());
    }


    public void paint (Graphics g)  //paints the pictures
    {

	for (int i = 0 ; i < 1000 ; i++)
	{

	    x = x - xSpeed2;
	    //pipe size
	    lblPic.paintIcon (this, g, x, y);
	    lblPic3.paintIcon (this, g, x + 150, y + 250);

	    lblPic4.paintIcon (this, g, x + 150, y + - 50);
	    lblPic5.paintIcon (this, g, x + 350, y + 210);
	    lblPic6.paintIcon (this, g, x + 350, y + - 80); //picture based on x and y co-ordinates
	    lblPic7.paintIcon (this, g, x + 500, y + 280);
	    lblPic8.paintIcon (this, g, x + 500, y + 0);
	    lblPic9.paintIcon (this, g, x + 650, y + 230);
	    lblPic10.paintIcon (this, g, x + 650, y + - 30);
	    groundPic.paintIcon (this, g, x + 0, y + 375);

	    for (int j = 0 ; j < 10 ; j++)
	    {
		k2 = Math.pow (k2, 2);
	    }
	    if (yPos - 170 >= y + 250)
	    {
		super.dispose ();
		new TestMan ();
	    }
	    else if (yPos - 170 <= y - 1000)
	    {
		super.dispose ();
		new TestMan ();
	    }
	    if (xPos < 1600)
	    {
		break;
	    }

	    System.out.println (x < 500);
	}

	for (int i = 0 ; i < 1000 ; i++)
	{
	    z = z + xSpeed;

	    lblPic2.paintIcon (this, g, z, yPos - 170);
	    for (int j = 0 ; j < 10 ; j++)
	    {
		k = Math.pow (k, 2);
	    }

	    if (xPos < 10000)
	    {
		break;
	    }
	    System.out.println ("Loop 2");



	}
	{


	    if (upKey == true)
	    {
		yPos = yPos - 20;
		upKey = false;
	    }
	    else if (downKey == true)
	    {
		yPos = yPos + 5;
		upKey = false;
	    }
	}
    }





    public static void main (String[] args)  // main method starts it all
    {
	new GameModePikachu (); // Call constructor to create a a frame
    }



} // GameModePikachu class


