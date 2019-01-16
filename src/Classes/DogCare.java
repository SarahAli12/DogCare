package Classes;

import java.awt.*;
import hsa.Console;
import java.awt.image.BufferedImage;
import sun.audio.*;
import javax.imageio.*;
import java.io.*;
import java.util.Random;

public class DogCare
{
    public static Console c = new Console (30, 100);
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

    public static int getStat (int stat, int max, int increase)
    {
        stat += increase;
        if (stat > max)
        {
            stat = max;
        }
        return stat;
    }

    public static char getChoice (int options)
    {
        char choice = c.getChar ();
        if (options == 2)
        {
            while (choice != 'a' && choice != 'b' && choice != 'x')
            {
                g.setColor (Color.red);
                g.setFont (new Font ("Arial", Font.BOLD, 18));
                g.drawString ("That is not a valid choice,", 540, 560);
                c.drawImage (image, 0, 0, null);
                choice = c.getChar();
            }
        }
        else
        {
            while (choice != 'a' && choice != 'b' && choice != 'c' && choice != 'x')
            {
                g.setColor (Color.red);
                g.setFont (new Font ("Arial", Font.BOLD, 18));
                g.drawString ("That is not a valid choice,", 540, 560);
                c.drawImage (image, 0, 0, null);
                choice = c.getChar();
            }
        }
        return choice;
    }

    public static char getChoice (char min, char max)
    {
        char choice = c.getChar();
        while (choice < min || choice > max)
        {
            g.setColor (Color.red);
            g.setFont (new Font ("Arial", Font.BOLD, 18));
            g.drawString ("That is not a valid choice,", 540, 560);
            c.drawImage (image, 0, 0, null);
            choice = c.getChar();
        }
        return choice;
    }

    public static void main (String[] args) throws Exception
    {
        Sound bgmusic = new Sound ("bgmusic.wav");
        bgmusic.loop();

        int playAgain;

        do
        {
            clear ();
            Intro.intro ();
            Image[] dog = Intro.Adopt ();
            String name = Intro.Name ();

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
                    Layout.Background (g, name, age);
                    Layout.Bars (g, food, health, health, happiness, hygiene, relationship, intelligence);

                    Image bed = loadImage ("bed.jpg");
                    g.drawImage (bed, 0, 50, null);
                    g.drawImage (dog [age - 1], 200, 150, null);
                    c.drawImage (image, 0, 0, null);

                    char choice = getChoice('1', '6');
                    switch (choice)
                    {
                        case '1':
                            Layout.Options (g, choice);
                            choice = getChoice (2);
                            break;
                        case '2':
                            Layout.Options (g, choice);
                            choice = getChoice (3);
                            break;
                        case '3':
                            Layout.Options (g, choice);
                            choice = getChoice (2);
                            break;
                        case '4':
                            Layout.Options (g, choice);
                            choice = getChoice (3);
                            break;
                        case '5':
                            Layout.Options (g, choice);
                            choice = getChoice (3);
                            break;
                        case '6':
                            //random chance of success
                            health = 50;
                            break;
                    }
                    /*if (choice == '1') //nutrition
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
                    }*/
                }
                age++;
            }

            playAgain = Intro.PlayAgain ();
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
