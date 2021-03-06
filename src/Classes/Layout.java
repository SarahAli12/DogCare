package Classes;

import java.awt.*;
import hsa.Console;
import java.awt.image.BufferedImage;
import sun.audio.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.util.Random;

public class Layout
{
    static Console c = DogCare.c;
    static BufferedImage image = DogCare.image;
    static Graphics2D g = DogCare.g;

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

    public static void Background (String name, int age, int food, int water, int health, int happiness, int hygiene, int relationship, int intelligence) throws Exception
    {
        Image plate = loadImage ("plate.jpg");
        g.drawImage (plate, 0, 0, null);
        g.setColor (new Color (147, 119, 32));
        g.setFont (new Font ("Arial", Font.BOLD, 30));
        g.drawString (name, (500 - name.length () * 22) / 2, 35);

        g.setColor (Color.darkGray);
        g.fillRect (500, 0, 300, 625);
        g.fillRect (0, 525, 500, 100);

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

        c.drawImage (image, 0, 0, null);
    }

    public static void Options (char choice)
    {
        Color button = new Color (185, 252, 103);
        g.setFont (new Font ("Arial", Font.BOLD, 18));
        switch (choice)
        {
            case '1':
            g.setColor (button);
            g.fillRect (20, 550, 140, 50);
            g.fillRect (190, 550, 140, 50);
            g.fillRect (360, 550, 140, 50);
            g.setColor(Color.white);
            g.drawString ("Food (a)", 55, 580);
            g.drawString ("Water (b)", 220, 580);
            g.drawString ("Exit (x)", 400, 580);
            c.drawImage (image, 0, 0, null);
            break;
            case '2':
            g.setColor (button);
            g.fillRect (25, 550, 100, 50);
            g.fillRect (150, 550, 100, 50);
            g.fillRect (275, 550, 100, 50);
            g.fillRect (400, 550, 100, 50);
            g.setColor(Color.white);
            g.drawString ("Fetch (a)", 36, 580);
            g.drawString ("Chew Toy", 157, 570);
            g.drawString ("(b)", 190, 590);
            g.drawString ("Treat (c)", 288, 580);
            g.drawString ("Exit (x)", 419, 580);
            c.drawImage (image, 0, 0, null);
            break;
            case '3':
            g.setColor (button);
            g.fillRect (20, 550, 140, 50);
            g.fillRect (190, 550, 140, 50);
            g.fillRect (360, 550, 140, 50);
            g.setColor(Color.white);
            g.drawString ("Brush (a)", 50, 580);
            g.drawString ("Bathe (b)", 220, 580);
            g.drawString ("Exit (x)", 400, 580);
            c.drawImage (image, 0, 0, null);
            break;
            case '4':
            g.setColor (button);
            g.fillRect (25, 550, 100, 50);
            g.fillRect (150, 550, 100, 50);
            g.fillRect (275, 550, 100, 50);
            g.fillRect (400, 550, 100, 50);
            g.setColor(Color.white);
            g.drawString ("Belly Rub", 32, 570);
            g.drawString ("(a)", 65, 590);
            g.drawString ("Ear Scratch", 150, 570);
            g.drawString ("(b)", 190, 590);
            g.drawString ("Cuddle (c)", 280, 580);
            g.drawString ("Exit (x)", 419, 580);
            c.drawImage (image, 0, 0, null);
            break;
            case '5':
            g.setColor (new Color (185, 252, 103));
            g.fillRect (25, 550, 100, 50);
            g.fillRect (150, 550, 100, 50);
            g.fillRect (275, 550, 100, 50);
            g.fillRect (400, 550, 100, 50);
            g.setColor(Color.white);
            g.drawString ("Play Dead", 32, 570);
            g.drawString ("(a)", 65, 590);
            g.drawString ("Roll Over", 157, 570);
            g.drawString ("(b)", 190, 590);
            g.drawString ("Sit (c)", 298, 580);
            g.drawString ("Exit (x)", 419, 580);
            c.drawImage (image, 0, 0, null);
            break;
        }
    }

    public static void Error (String msg)
    {
        g.setColor (new Color (185, 252, 103));
        g.fillRect (125, 150, 250, 175);
        g.setColor(Color.white);
        g.fillRect (130, 155, 240, 165);
        g.setColor(Color.black);
        g.setFont (new Font ("Arial", Font.BOLD, 25));
        if (msg.equals("train"))
        {
            g.drawString ("You failed to", 170, 220);
            g.drawString ("train your dog!", 165, 250);
        }
        else if (msg.equals("repeat"))
        {
            g.drawString ("Your dog already", 150, 220);
            g.drawString ("knows that trick!", 150, 250);
        }
        else if (msg.equals("healthy"))
        {
            g.drawString ("Your dog is in", 160, 220);
            g.drawString ("good health", 170, 250);
        }
        else if (msg.equals("fail"))
        {
            g.drawString ("The vet was", 175, 200);
            g.drawString ("unable to cure", 165, 230);
            g.drawString ("your dog", 195, 260);
        }
        else if (msg.equals("cured"))
        {
            g.drawString ("The doctor cured", 150, 220);
            g.drawString ("your dog!", 190, 250);
        }
        g.setFont (new Font ("Arial", Font.PLAIN, 15));
        g.drawString ("Press any key to continue", 165, 300);
        c.drawImage (image, 0, 0, null);
        c.getChar();
    }
    
    public static void Ill (String illness)
    {
        g.setColor (new Color (185, 252, 103));
        g.fillRect (125, 150, 250, 175);
        g.setColor(Color.white);
        g.fillRect (130, 155, 240, 165);
        g.setColor(Color.black);
        g.setFont (new Font ("Arial", Font.BOLD, 25));
        g.drawString ("Your dog has been", 140, 200);
        g.drawString ("diagnosed with", 150, 230);
        g.drawString (illness, 180, 260);
        g.setFont (new Font ("Arial", Font.PLAIN, 15));
        g.drawString ("Press any key to continue", 165, 300);
        c.drawImage (image, 0, 0, null);
        c.getChar();
    }

    public static void Age (int age)
    {
        if (age > 1)
        {
            g.setColor (new Color (185, 252, 103));
            g.fillRect (125, 150, 250, 175);
            g.setColor(Color.white);
            g.fillRect (130, 155, 240, 165);
            g.setColor(Color.black);
            g.setFont (new Font ("Arial", Font.BOLD, 25));
            g.drawString ("Your dog has aged!", 133, 230);
            g.setFont (new Font ("Arial", Font.PLAIN, 15));
            g.drawString ("Press any key to continue", 165, 300);
            c.drawImage (image, 0, 0, null);
            c.getChar();
        }
    }

    public static void main (String[] args) throws Exception
    {

    }
}