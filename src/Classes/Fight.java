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
//  static Actions dog = DogCare.dog;
  static Graphics2D g = DogCare.g;
  static Random r = DogCare.r;
  static Color pink = new Color (249, 199, 198);
  static Color brown = new Color (124, 99, 99);

  public static Image loadImage (String name) throws Exception
  {
    Image img = ImageIO.read (new File (name));
    return img;
  }

  public static void clear ()
  {
    g.setColor (Color.white);
    g.fillRect (0, 0, 800, 600);
    c.drawImage (image, 0, 0, null);
  }

  public static void Tutorial () throws Exception
  {
    char close;
    do {
      g.setColor(Color.black);
      g.fillRect(0, 0, 800, 640);

      g.setColor(Color.white);
      g.setFont(new Font("Arial", Font.BOLD, 30));
      g.drawString("1. Select the next move using the following keys", 40, 50);

      Image keymap = loadImage("keymap.png");
      g.fillRect(40, 70, 720, 200);
      g.drawImage(keymap, 50, 20, null);

      g.drawString("2. Before each round, you will choose the next move", 40, 310);
      g.drawString("3. Special can be used after 3 successful attacks", 40, 350);
      g.drawString("4. Make the right move, or die", 40, 390);
      g.drawString("Press x to exit", 40, 510);
      c.drawImage(image, 0, 0, null);

      close = c.getChar();
    }
    while (close != 'x');
  }

  public static void Health (int health, int enemyhealth) throws Exception
  {
    g.setColor (Color.green);
    g.fillRect (370 - (health * 3), 50, (int) (health * 3), 15);
    g.fillRect (430, 50, (enemyhealth * 3), 15);

    g.setColor (Color.white);
    Stroke oldStroke = g.getStroke();
    g.setStroke(new BasicStroke(2));
    g.drawRect(70, 50, 300, 15);
    g.drawRect(430, 50, 300, 15);
    g.setStroke(oldStroke);
    c.drawImage (image, 0, 0, null);
  }

  public static void Critical (int attack, int enemyattack) throws Exception
  {
    g.setColor (Color.white);
    g.fillRect (220 - (attack * 50), 500, (int) (attack * 50), 20);
    g.fillRect (580, 500, (enemyattack * 50), 20);

    g.setColor (Color.blue);
    Stroke oldStroke = g.getStroke();
    g.setStroke(new BasicStroke(2));
    g.drawRect(70, 500, 150, 20);
    g.drawRect(580, 500, 150, 20);
    g.setStroke(oldStroke);
    c.drawImage (image, 0, 0, null);
  }

  public static void Fight (String name, Image[] images) throws Exception
  {

    //************************************************** Introduction **************************************************//

    // Background Music for Welcome and Tutorial
    Sound bgmusic = new Sound ("bgmusicfightintro.wav");
    bgmusic.play();

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


    // Tutorial Screen
    Tutorial();

    //************************************************** Initial Scene **************************************************//

    // Initial Variables
    int health = 100;
    int enemyhealth = 100;
    char choice;
    int enemynum;
    char enemychoice = 'a'; // Temporary variable
    int attack = 0;
    int enemyattack = 0;
    int round = 0;
    boolean runagain;
    Image park = loadImage("park.jpg");

    // You Dog Fighter's Location (for all actions) - (x1, y1) - positionthis
    int x1 = 100;
    int y1 = 350;

    // Enemy Fighter's Location (for all actions) - (x2, y1) - positionthis
    int x2 = 500;

    // Background Music
    Sound bgmusic2 = new Sound ("bgmusicfight.wav");
    bgmusic2.loop();

    // User Selection
    do {
      // Update Round Count
      round++;

      do {
        // Background Image
        g.drawImage(park, 0, 0, null);
        c.drawImage (image, 0, 0, null);

        // Display Name
        g.setColor (Color.white);
        g.setFont (new Font ("Arial", Font.BOLD, 30));
        g.drawString(name, 20, 100);
        c.drawImage(image, 0, 0, null);

//        // Head of Dog Breed - ignore
//        g.drawImage(images[11], 0, 0, null);
//        g.drawImage(images[16], 700, 0, null);
//        c.drawImage (image, 0, 0, null);
        
        // Fighters
        g.drawImage(images[14], x1, y1, null);
        g.drawImage(images[19], x2, y1, null);
        c.drawImage (image, 0, 0, null);

        // Health Bars
        Health (health, enemyhealth);

        // Critical Bars
        Critical (attack, enemyattack);

        // Round Display
        g.setColor (Color.white);
        g.setFont (new Font ("Arial", Font.BOLD, 15));
        g.drawString ("ROUND", 370, 30);

        String roundstring = Integer.toString(round);
        g.setFont (new Font ("Arial", Font.BOLD, 50));
        g.drawString (roundstring, 385, 75);
        c.drawImage (image, 0, 0, null);

        // Help Display
        g.setFont (new Font ("Arial", Font.BOLD, 15));
        g.drawString ("Press h for help", 660, 535);
        c.drawImage (image, 0, 0, null);

        // User Choice
        choice = c.getChar();

        /*
        Legend (More on README.md)
        P - Attack
        O - Special
        I - Shield
        */

        // Show Tutorial
        if (choice == 'h' || choice == 'H') {
          Tutorial();
        }

        // Special Error Message
        if ((choice == 'o' || choice == 'O') && attack < 3) {
          g.setFont(new Font("Arial", Font.BOLD, 15));
          g.drawString("You can only use special if the critical bar is full", 50, 535);
          c.drawImage(image, 0, 0, null);
          Thread.sleep(3000);
        }
        if (choice == 'p' || choice == 'P' || choice == 'i' || choice == 'I' || (choice == 'o' || choice == 'O') && attack == 3) {
          runagain = false;
        }
        else {
          runagain = true;
        }
      }
      while (runagain);

      // Update Attack Count
      if (choice == 'o' || choice == 'O') {
        attack -= 3;
      }

      // Randomly Generated Enemy's Move
      /*
      If attack is 3, special - 50%, attack - 25%, shield - 25%
      If attack is less than 3, special - 0%, attack - 50%, shield - 50%
      */
      enemynum = r.nextInt(2) + 1;
//      enemynum = (int)(Math.random() * 2 + 1);
      if (enemyattack == 3) {
        if (enemynum == 1) {
          enemychoice = 'o';
          enemyattack -= 3;
        }
      }
      else {
        if (enemynum == 1) {
          enemychoice = 'p';
        }
        if (enemynum == 2) {
          enemychoice = 'i';
        }
      }

      // Redraw Background
      g.drawImage(park, 0, 0, null);
      c.drawImage (image, 0, 0, null);

      //************************************************** Animations **************************************************//

      if (choice == 'p' || choice == 'P') {
        g.drawImage(images[15], x1, y1, null);
        c.drawImage (image, 0, 0, null);
      }

      if (choice == 'o' || choice == 'O') {
        g.drawImage(images[13], x1, y1, null);

        Image fireball = loadImage("fireball.png");
        g.drawImage(fireball, x2, y1, null);
        c.drawImage(image, 0, 0, null);
      }

      if (choice == 'i' || choice == 'I') {
        g.drawImage(images[12], x1, y1, null);

        Image shield = loadImage("shield.png");
        g.drawImage(shield, x1, y1, null);
        c.drawImage (image, 0, 0, null);
      }

      if (enemychoice == 'p') {
        g.drawImage(images[20], x2, y1, null);
        c.drawImage (image, 0, 0, null);
      }

      if (enemychoice == 'o') {
        g.drawImage(images[18], x2, y1, null);

        Image fireballpurple = loadImage("fireballpurple.png");
        g.drawImage(fireballpurple, x1, y1, null);
        c.drawImage(image, 0, 0, null);
      }

      if (enemychoice == 'i') {
        g.drawImage(images[17], x2, y1, null);

        Image shield = loadImage("shield.png");
        g.drawImage(shield, x2, y1, null);
        c.drawImage (image, 0, 0, null);
      }

      //************************************************** Fight Results **************************************************//

      if ((choice == 'p' || choice == 'P') && enemychoice == 'p') {
        health -= 10;
        enemyhealth -= 10;
        if (attack < 3) {
          attack++;
        }
        if (enemyattack < 3) {
          enemyattack++;
        }
      }

      if ((choice == 'p' || choice == 'P') && enemychoice == 'i') {
        enemyhealth -= 1;
      }

      if ((choice == 'i' || choice == 'I') && enemychoice == 'p') {
        health -= 1;
      }

      if ((choice == 'p' || choice == 'P') && enemychoice == 'o') {
        health -= 50;
        enemyhealth -= 10;
        if (attack < 3) {
          attack++;
        }
      }

      if ((choice == 'o' || choice == 'O') && enemychoice == 'p') {
        health -= 10;
        enemyhealth -= 50;
        if (enemyattack < 3) {
          enemyattack++;
        }
      }

      if ((choice == 'o' || choice == 'O') && enemychoice == 'i') {
        enemyhealth -= 25;
      }

      if ((choice == 'i' || choice == 'I') && enemychoice == 'o') {
        health -= 25;
      }

    }
    while (health > 0 && enemyhealth > 0);

    //************************************************** Ending Scene **************************************************//

    clear();

    if (health > enemyhealth) {
      g.setColor (pink);
      g.fillRect (0, 0, 800, 640);
      g.setColor (Color.white);
      g.setFont (new Font ("Arial", Font.BOLD, 50));
      g.drawString ("Your dog won!", 210, 170);
      g.setFont (new Font ("Arial", Font.BOLD, 30));
      g.drawString ("Press any key to continue.", 205, 240);
      c.drawImage (image, 0, 0, null);
      c.getChar ();
    }
    if (health < enemyhealth) {
      g.setColor (Color.black);
      g.fillRect (0, 0, 800, 640);
      g.setColor (Color.white);
      g.setFont (new Font ("Arial", Font.BOLD, 50));
      g.drawString ("Your dog lost.", 220, 170);
      g.setFont (new Font ("Arial", Font.BOLD, 30));
      g.drawString ("Press any key to continue.", 205, 240);
      c.drawImage (image, 0, 0, null);
      c.getChar ();
    }
    if (health == enemyhealth) {
      g.setColor (brown);
      g.fillRect (0, 0, 800, 640);
      g.setColor (Color.white);
      g.setFont (new Font ("Arial", Font.BOLD, 50));
      g.drawString ("Your dog tied!", 220, 170);
      g.setFont (new Font ("Arial", Font.BOLD, 30));
      g.drawString ("Press any key to continue.", 205, 240);
      c.drawImage (image, 0, 0, null);
      c.getChar ();
    }

  }

  public static void main (String[] args) throws Exception
  {

  }
}
