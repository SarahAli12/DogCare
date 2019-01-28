/*Sarah Ali, James Chen, Clare Loong, Jessica Xiong
Jan 26 2019
ICS203
Fight
This class contains the fighting scene between your dog and an enemy one.
You will gain happiness and intelligence if you win but lose health if you lose.*/

package Classes;

import java.awt.*;
import hsa.Console;
import java.awt.image.BufferedImage;
import sun.audio.*;
import javax.imageio.*;
import java.io.*;
import java.util.Random;

public class Fight {

  static Console c = DogCare.c;
  static BufferedImage image = DogCare.image;
  static Graphics2D g = DogCare.g;
  static Random r = DogCare.r;
  static Color pink = new Color (249, 199, 198);

  public static Image loadImage (String name) throws Exception
  {
    Image img = ImageIO.read (new File (name));
    return img;
  }

  public static void playAudio (String file) throws Exception
  {
    InputStream in = new FileInputStream (file);
    AudioStream as = new AudioStream (in);
    AudioPlayer.player.start (as);
  }

  public static void Tutorial() throws Exception
  {
    g.setColor (Color.black);
    g.fillRect (0, 0, 800, 640);

    g.setColor (Color.white);
    g.setFont (new Font ("Arial", Font.BOLD, 30));
    g.drawString ("1. Select the next move using the following keys", 40, 50);

    Image keymap = loadImage ("./src/Images/Fight/keymap.png");
    g.fillRect (40, 70, 720, 200);
    g.drawImage(keymap, 50, 20, null);

    g.drawString ("2. Before each round, you will choose the next move", 40, 310);
    g.drawString ("3. Special can be used after 3 successful attacks", 40, 350);
    g.drawString ("4. Make the right move, or die", 40, 390);
    g.drawString ("Press x to exit", 40, 510);
    c.drawImage (image, 0, 0, null);
  }

  public static void main (String[] args) throws Exception
  {

    Sound bgmusic = new Sound ("./src/Audio/bgmusicfightintro.wav");
    bgmusic.play();

    Actions dog = DogCare.dog;

    //************************************************** Tutorial **************************************************//

    /*
    // Welcome Screen
    g.setColor (pink);
    g.fillRect (0, 0, 800, 640);
    g.setColor (Color.white);
    g.setFont (new Font ("Arial", Font.BOLD, 50));
    g.drawString ("Welcome to the Arena.", 125, 170);
    g.setFont (new Font ("Arial", Font.BOLD, 30));
    g.drawString ("Press any key to continue.", 205, 240);
    c.drawImage (image, 0, 0, null);
    c.getChar ();

    // Transition to Tutorial Screen
    int red = 249;
    int green = 199;
    int blue = 198;

    for (int k = 0 ; k <= 249 ; k++)
    {
      Color gradient = new Color (red, green, blue);
      g.setColor (gradient);
      g.fillRect(0,0,800,640);

      g.setColor (Color.white);
      g.setFont (new Font ("Arial", Font.BOLD, 50));
      g.drawString ("Welcome to the Arena.", 125, 170-k);
      c.drawImage (image, 0, 0, null);

      if (red > 0)
      {
        red--;
      }
      if (green > 0)
      {
        green--;
      }
      if (blue > 0)
      {
        blue--;
      }

      try
      {
        Thread.sleep (10);
      }
      catch (InterruptedException ie)
      {
        ie.printStackTrace ();
      }
    }
    */

    Tutorial ();
    c.getChar();

    // Initial Fight Scene
    Sound bgmusic2 = new Sound ("./src/Audio/bgmusicfight.wav");
    bgmusic2.loop();


    // Default variables
    int health = 100;
    int enemyhealth = 100;

    // Choose Next Move
    char choice;
    choice = c.getChar();

    // Bring Up Tutorial
    if (choice == 'h' || choice == 'H')
    {
      Tutorial();
    }

    /*
    Legend (More on README.md)
    P - Attack
    O - Shield
    S - Special
     */

    // Randomly Generated Enemy's Move (1-4 is attack (40%), 5-8 is shield (40%) and 9-10 is special (20%))
    int enemynum = r.nextInt (10);
    char enemychoice = 'a'; // Temporary variable
    if (1 <= enemynum && enemynum <= 4)
    {
      enemychoice = 'p';
    }

    if (5 <= enemynum && enemynum <= 8)
    {
      enemychoice = 'o';
    }

    if (9 <= enemynum && enemynum <= 10)
    {
      enemychoice = 'i';
    }

    // Fight Results
    if ((choice == 'p' || choice == 'P') && enemychoice == 'p')
    {
      health-=10;
      enemyhealth-=10;
    }

    if ((choice == 'p' || choice == 'P') && enemychoice == 'o')
    {
      health-=50;
      enemyhealth-=10;
    }

    if ((choice == 'o' || choice == 'O') && enemychoice == 'p')
    {
      health-=10;
      enemyhealth-=50;
    }

    if ((choice == 'o' || choice == 'O') && enemychoice == 'i')
    {
      enemyhealth-=25;
    }

    if ((choice == 'i' || choice == 'I') && enemychoice == 'o')
    {
      health-=25;
    }

    // Animations
    if (choice == 'p' || choice == 'P')
    {

    }

    if (choice == 'o' || choice == 'O')
    {

    }

    if (choice == 'i' || choice == 'I')
    {
      Image fireball = loadImage ("./src/Images/Fight/fireball.png");
      g.drawImage(fireball, 0, 0, null);
    }

    if (enemychoice == 'p')
    {

    }

    if (enemychoice == 'o')
    {

    }

    if (enemychoice == 'i')
    {

    }

  }
}
