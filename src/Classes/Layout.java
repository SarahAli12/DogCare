package Classes;

import java.awt.*;
import hsa.Console;
import java.awt.image.BufferedImage;
import sun.audio.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.util.Random;

public interface Layout
{
    static Console c = DogCare.c;
    static BufferedImage image = new BufferedImage (c.getWidth (), c.getHeight (), BufferedImage.TYPE_INT_ARGB);
    static Graphics2D g1 = image.createGraphics ();
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

    public static void Background (Graphics2D g, String name, int age) throws Exception
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
    
    public static void Options (Graphics2D g, char choice)
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
        }
        c.drawImage (image, 0, 0, null);
    }

    public static void Bars (Graphics2D g, int food, int water, int health, int happiness, int hygiene, int relationship, int intelligence)
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

    public static void main (String[] args) throws Exception
    {

        Background (g1, "ObamaObama", 1);
        Bars (g1, 25, 25, 50, 100, 100, 100, 100);

    }
}
