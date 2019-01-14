package Classes;

import java.awt.*;
import hsa.Console;
import java.awt.image.BufferedImage;
import sun.audio.*;
import javax.imageio.*;
import java.io.*;
import java.util.Random;

public class DogCare extends Intro
{

  static BufferedImage image = new BufferedImage (c.getWidth (), c.getHeight (), BufferedImage.TYPE_INT_ARGB);
  static Graphics2D g = image.createGraphics ();
  static Random r = new Random ();
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

  public static void clear ()
  {
    g.setColor (Color.white);
    g.fillRect (0, 0, 800, 600);
  }

  public static void Music () throws Exception
  {
    while (true)
    {
      try
      {
        playAudio ("bgmusic.wav");
        Thread.sleep (73000);
      }
      catch (java.lang.Exception ex)
      {
        c.println (ex.getMessage ());
      }
    }
  }

  public static void Layout (String name, int age) throws Exception
  {
    Image plate = loadImage ("plate.jpg");
    g.drawImage (plate, 0, 0, null);
    g.setColor (new Color (147, 119, 32));
    g.setFont (new Font ("Arial", Font.BOLD, 30));
    g.drawString (name, (500 - name.length () * 22) / 2, 35);

    g.setColor (Color.darkGray);
    g.fillRect (500, 0, 300, 600);
    g.fillRect (0, 525, 500, 75);

    g.setColor (new Color (185, 252, 103));
    g.setFont (new Font ("Arial", Font.BOLD, 15));
    g.drawString ("Choose from the following actions:", 525, 305);
    for (int i = 325 ; i <= 465 ; i += 70)
    {
      g.fillRect (525, i, 115, 50);
      g.fillRect (660, i, 115, 50);
    }
    g.setColor(Color.white);
    g.setFont (new Font ("Arial", Font.BOLD, 18));
    g.drawString ("Nutrition (1)", 530, 358);
    g.drawString ("Play (2)", 687, 358);
    g.drawString ("Groom (3)", 540, 428);
    g.drawString ("Bond (4)", 687, 428);
    g.drawString ("Train (5)", 546, 498);
    g.drawString ("Vet (6)", 689, 498);
    c.drawImage (image, 0, 0, null);
  }

  public static void Bars (int food, int water, int health, int happiness, int hygiene, int relationship, int intelligence)
  {
    g.setFont (new Font ("Arial", Font.BOLD, 30));
    g.setColor (new Color (206, 150, 107));
    g.fillRect (525, 30, (int) (food * 0.04 * 62), 30);
    g.setColor (new Color (83, 207, 209));
    g.fillRect (587, 30, (int) (water * 0.04 * 63), 30);
    g.setColor (Color.green);
    g.fillRect (650, 30, (int) (health * 0.02 * 125), 30);
    g.fillRect (525, 80, (int) (happiness * 0.01 * 250), 30);
    g.fillRect (525, 130, (int) (hygiene * 0.01 * 250), 30);
    g.fillRect (525, 180, (int) (relationship * 0.01 * 250), 30);
    g.fillRect (525, 230, (int) (intelligence * 0.01 * 250), 30);
    g.setColor (Color.white);
    g.setStroke (new BasicStroke (3));
    for (int i = 30 ; i <= 230 ; i += 50)
    {
      g.drawRect (525, i, 250, 30);
    }
    g.setFont (new Font ("Arial", Font.BOLD, 20));
    g.drawString ("Health", 610, 53);
    g.drawString ("Happiness", 600, 103);
    g.drawString ("Hygiene", 610, 153);
    g.drawString ("Relationship", 590, 203);
    g.drawString ("Intelligence", 593, 253);
    c.drawImage (image, 0, 0, null);
  }

  public static int getStat (int stat, int max, int increase)
  {
    stat += increase;
    if (stat > max)
    {
      stat = max;
    }
    return stat;
  }

  public static char PlayAgain ()
  {
    clear ();
    g.setColor (pink);
    g.fillRect (0, 0, 640, 500);
    g.setFont (new Font ("Arial", Font.BOLD, 30));
    g.setColor (Color.white);
    g.drawString ("Would you like to play again? (y/n)", 80, 210);
    c.drawImage (image, 0, 0, null);
    char choice = c.getChar ();

    while (choice != 'y' && choice != 'n' && choice != 'Y' && choice != 'N')
    {
      g.drawString ("Sorry, that is not a valid choice", 100, 260);
      g.drawString ("Please try again", 200, 310);
      c.drawImage (image, 0, 0, null);
      choice = c.getChar ();
    }

    return choice;
  }

  public static void main (String[] args) throws Exception
  {
    Runnable muse = new Runnable ()
    {
      public void run ()
      {
        try
        {
          Music ();
        }
        catch (java.lang.Exception ex)
        {
          c.println (ex.getMessage ());
        }
      }
    }
            ;
    new Thread (muse).start ();

    int playAgain;

    do
    {
      clear ();
      intro ();
      Image[] dog = Adopt ();
      String name = Name ();

      int intelligence = r.nextInt (25);
      int hygiene;
      int health = 50;
      int happiness;
      int relationship;
      int food;
      int water;
      int age = 1;

      while (age <= 4)
      {
        hygiene = r.nextInt (100);
        happiness = r.nextInt (100);
        relationship = r.nextInt (100);
        food = r.nextInt (25);
        water = r.nextInt (25);
        while (happiness < 100 || relationship < 100 || hygiene < 100 || health < 50 || food < 25 || water < 25)
        {
          Layout (name, age);
          Bars (food, health, health, happiness, hygiene, relationship, intelligence);

          Image bed = loadImage ("bed.jpg");
          g.drawImage (bed, 0, 50, null);
          g.drawImage (dog [age - 1], 200, 150, null);
          c.drawImage (image, 0, 0, null);

          char choice = c.getChar ();
          while (choice < '1' || choice > '6')
          {
            choice = c.getChar ();
          }
          if (choice == '1') //nutrition
          {
            choice = c.getChar ();
            while (choice != 'a' && choice != 'b' && choice != 'x')
            {
              choice = c.getChar ();
            }
            if (choice == 'a') //feed
            {
              food = getStat (food, 25, 10);
            }
            else //water
            {
              water = getStat (water, 25, 10);
            }
          }
          else if (choice == '2') //play
          {
            choice = c.getChar ();
            while (choice != 'a' && choice != 'b' && choice != 'c' && choice != 'x')
            {
              choice = c.getChar ();
            }
            if (choice == 'a') //fetch
            {
              happiness = getStat (happiness, 100, 20);
            }
            if (choice == 'b') //chew
            {
              happiness = getStat (happiness, 100, 15);
            }
            else //treat
            {
              happiness = getStat (happiness, 100, 15);
            }
          }
          else if (choice == '3') //groom
          {
            choice = c.getChar ();
            while (choice != 'a' && choice != 'b' && choice != 'x')
            {
              choice = c.getChar ();
            }
            if (choice == 'a') //brush
            {
              hygiene = getStat (hygiene, 100, 40);
            }
            else //bath
            {
              hygiene = getStat (hygiene, 100, 50);
            }
          }
          else if (choice == '4') //show affection
          {
            choice = c.getChar ();
            while (choice != 'a' && choice != 'b' && choice != 'c' && choice != 'x')
            {
              choice = c.getChar ();
            }
            if (choice == 'a') //belly rub
            {
              relationship = getStat (relationship, 100, 30);
            }
            if (choice == 'b') //ear scratch
            {
              relationship = getStat (relationship, 100, 20);
            }
            else //cuddle
            {
              relationship = getStat (relationship, 100, 40);
            }
          }
          else if (choice == '5') //train
          {
            choice = c.getChar ();
            while (choice != 'a' && choice != 'b' && choice != 'c' && choice != 'x')
            {
              choice = c.getChar ();
            }
            if (choice == 'a') //sit
            {
            }
            if (choice == 'b') //roll over
            {
            }
            else //play dead
            {
            }
          }
          else //take to vet
          {
            //random chance of success
            health = 50;
          }
        }
        age++;
      }

      playAgain = PlayAgain ();
    }
    while (playAgain != 'n');

    //thanks for playing
    Image sparkle = loadImage ("sparkle.png");
    playAudio ("special.wav");
    g.setFont (new Font ("Freestyle Script", Font.PLAIN, 80));
    while (true)
    {
      g.setColor (new Color (175, 87, 86));
      g.fillRect (0, 0, 640, 500);
      g.setColor (Color.white);
      g.drawString ("Thanks for", 210, 240);
      g.drawString ("playing!", 240, 330);
      for (int i = 0 ; i <= 200 ; i++)
      {
        int x = r.nextInt (640);
        int y = r.nextInt (500);
        boolean frame = (x < 140 || x >= 500) || (y < 152 || y >= 348);
        if (frame)
        {
          g.drawImage (sparkle, x, y, null);
        }
        else
        {
          i--;
        }
      }
      c.drawImage (image, 0, 0, null);
      Thread.sleep (20);
    }
  }
}
