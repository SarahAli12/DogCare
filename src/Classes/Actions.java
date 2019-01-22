package Classes;

import java.awt.*;
import hsa.Console;
import java.awt.image.BufferedImage;
import sun.audio.*;
import javax.imageio.*;
import java.io.*;
import java.util.Random;

public class Actions extends java.lang.Exception
{
    static Console c = DogCare.c;
    static BufferedImage image = DogCare.image;
    static Graphics2D g = DogCare.g;
    static Random r = DogCare.r;

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

    private Image [] dog;
    private Image bed, outdoors, vet, bathroom;
    public Actions (Image [] images) throws Exception
    {
        dog = images;
        bed = loadImage ("bed.jpg");
        outdoors = loadImage ("outdoors.jpg");
        vet = loadImage ("vet.jpg");
        bathroom = loadImage ("bathroom.png");
    }

    //image order: puppy [0], teen [1], adult [2], old [3], eating [4], standing [5], belly [6], chewing [7], fetch [8], bath [9]

    public void Standard (int age)
    {
        g.drawImage (bed, 0, 50, null);
        g.drawImage (dog [age - 1], (500 - dog [age - 1].getWidth (null)) / 2, (475 - dog [age - 1].getHeight (null)) / 2, null);
        c.drawImage (image, 0, 0, null);
    }

    public static void action (Image pic, Image bg, String audio) throws Exception
    {
        g.drawImage (bg, 0, 50, null);
        g.drawImage (pic, (500 - pic.getWidth (null)) / 2, (475 - pic.getHeight (null)) / 2, null);
        c.drawImage (image, 0, 0, null);
        if (audio != null)
        {
            playAudio (audio);
        }
    }

    public void Eat () throws Exception
    {
        action (dog[4], bed, "eating.wav");
        Thread.sleep (3000);
    }

    public void Drink () throws Exception
    {
        action (dog[4], bed, "drinking.wav");
        Thread.sleep (3000);
    }

    public void Fetch () throws Exception
    {
        action (dog[8], outdoors, null);
        Thread.sleep (3000);
    }

    public void Chew () throws Exception
    {
        action (dog[7], bed, "chew.wav");
        Thread.sleep (3000);
    }

    public void Treat (int age) throws Exception
    {
        Image treat = loadImage ("treat.png");
        action (dog[age - 1], bed, "eating.wav");
        g.drawImage (treat, (500 - dog[age - 1].getWidth (null)) / 2, (475 - dog[age - 1].getHeight (null)) / 2, null);
        c.drawImage (image, 0, 0, null);
        Thread.sleep (3000);
    }

    public void Brush () throws Exception
    {
        Image brush = loadImage ("brush.png");
        playAudio ("brushing.wav");
        for (int i = (500 - dog[5].getWidth (null)) / 2; i <= (500 - dog[5].getWidth (null)) / 2 + 150; i += 10)
        {
            action (dog[5], bed, null);
            g.drawImage (brush, i, (500 - dog[5].getHeight (null)) / 2 - 50, null);
            c.drawImage (image, 0, 0, null);
            Thread.sleep (100);
        }
        for (int i = (500 - dog[5].getWidth (null)) / 2 + 150; i >= (500 - dog[5].getWidth (null)) / 2; i -= 10)
        {
            action (dog[5], bed, null);
            g.drawImage (brush, i, (500 - dog[5].getHeight (null)) / 2 - 50, null);
            c.drawImage (image, 0, 0, null);
            Thread.sleep (100);
        }
    }

    public void Bathe () throws Exception
    {
        g.drawImage (bathroom, 0, 50, null);
        g.drawImage (dog[9], (500 - dog[9].getWidth (null)) / 2, (475 - dog[9].getHeight (null)) / 2 + 100, null);
        c.drawImage (image, 0, 0, null);
        playAudio ("bath.wav");
        Thread.sleep (3000);
    }

    public void Belly () throws Exception
    {
        Image hand = loadImage ("hand.png");
        playAudio ("brushing.wav");
        for (int i = (500 - dog[6].getWidth (null)) / 2; i <= (500 - dog[6].getWidth (null)) / 2 + 150; i += 10)
        {
            action (dog[6], bed, null);
            g.drawImage (hand, i, (500 - dog[6].getHeight (null)) / 2 - 25, null);
            c.drawImage (image, 0, 0, null);
            Thread.sleep (100);
        }
        for (int i = (500 - dog[6].getWidth (null)) / 2 + 150; i >= (500 - dog[6].getWidth (null)) / 2; i -= 10)
        {
            action (dog[6], bed, null);
            g.drawImage (hand, i, (500 - dog[6].getHeight (null)) / 2 - 25, null);
            c.drawImage (image, 0, 0, null);
            Thread.sleep (100);
        }
    }

    public void Scratch (int age) throws Exception
    {
        Image hand = loadImage ("hand.png");
        action (dog[age - 1], bed, "brushing.wav");
        g.drawImage (hand, (500 - dog[age - 1].getWidth (null)) / 2, (475 - dog[age - 1].getHeight (null)) / 2 - 25, null);
        c.drawImage (image, 0, 0, null);
        Thread.sleep (3000);
    }

    public void Cuddle (int age) throws Exception
    {
        action (dog[age - 1], bed, "heart.wav");
        Thread.sleep (3000);
    }

    public void Sit (int age) throws Exception
    {
        action (dog[5], bed, null);
        g.setColor (Color.black);
        g.setFont (new Font ("Arial", Font.BOLD, 50));
        g.drawString ("SIT", 200, 475);
        c.drawImage (image, 0, 0, null);
        Thread.sleep (1500);
        action (dog[age - 1], bed, null);
        Thread.sleep (2000);
    }

    public void Roll (int age) throws Exception
    {
        action (dog[age - 1], bed, null);
        g.setColor (Color.black);
        g.setFont (new Font ("Arial", Font.BOLD, 50));
        g.drawString ("ROLL OVER", 125, 475);
        c.drawImage (image, 0, 0, null);
        Thread.sleep (1500);
        action (dog[6], bed, null);
        Thread.sleep (2000);
    }

    public void Dead (int age) throws Exception
    {
        Image skull = loadImage ("skull.png");
        action (dog[age - 1], bed, null);
        g.setColor (Color.black);
        g.setFont (new Font ("Arial", Font.BOLD, 50));
        g.drawString ("PLAY DEAD", 125, 475);
        c.drawImage (image, 0, 0, null);
        Thread.sleep (1500);
        action (dog[6], bed, null);
        g.drawImage (skull, (500 - dog[6].getWidth (null)) / 2, (475 - dog[6].getHeight (null)) / 2 - 50, null);
        c.drawImage (image, 0, 0, null);
        Thread.sleep (2000);
    }

    public int Vet (int age, int health) throws Exception
    {
        g.drawImage (vet, 0, 50, null);
        g.drawImage (dog[age - 1], 300, 150, null);
        c.drawImage (image, 0, 0, null);
        if (health == 50)
        {
            Layout.Error ("healthy");
            return 50;
        }
        else
        {
            int cure = r.nextInt (51);
            if (cure <= health)
            {
                Layout.Error("cured");
                return 50;
            }
            else
            {
                Layout.Error ("fail");
                return health;
            }
        }
    }
}