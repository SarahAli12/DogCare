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
    public static Console c = new Console (32, 100);
    public static BufferedImage image = new BufferedImage (c.getWidth (), c.getHeight (), BufferedImage.TYPE_INT_ARGB);
    public static Graphics2D g = image.createGraphics ();
    static Random r = new Random ();
    static Color pink = new Color (249, 199, 198);
    static Actions dog;
    public static String [] illnesses = {"rabies", "fleas", "pneumonia", "cough", "fever", "depression", "anxiety", "poisoning"};
    public static int [] healthFail = {25, 35, 10, 40, 30, 20, 20, 10};

    public static Image loadImage (String name) throws Exception
    {
        Image img = ImageIO.read(new File(name));
        return img;

        /* Different Ways to Load Files Directly Inside ./src/Folder */
//        InputStream file1 = DogCare.class.getClassLoader().getResourceAsStream(name);

//        InputStream inputStream = null;
//        try {
//            File file = new File(DogCare.class.getResource(name).getFile());
//            inputStream = new FileInputStream(file);
//        }
//        finally {
//            if (inputStream != null) {
//                try {
//                    inputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

//        File file = new File (DogCare.class.getResource(name).getFile());
//        try {
//            Image image = ImageIO.read(file);
//            return image;
//        }
//        catch(Exception e) {
//            System.err.println("Couldn't find file: " + name);
//            return null;
//        }
    }

//    public static File loadFile (String name) throws Exception
//    {
//        File file = new File (DogCare.class.getResource(name).getFile());
//        return file;
//    }

    public static void playAudio (String name) throws Exception
    {
        InputStream in = new FileInputStream (name);
        AudioStream as = new AudioStream (in);
        AudioPlayer.player.start (as);

//        File file = new File (DogCare.class.getResource(name).getFile());
//        try {
//            InputStream in = new FileInputStream (file);
//            AudioStream as = new AudioStream (in);
//            AudioPlayer.player.start (as);
//        }
//        catch(Exception e) {
//            System.err.println("Couldn't find file: " + name);
//        }
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

    public static char getAction (char choice)
    {
        Layout.Options (choice);
        c.drawImage (image, 0, 0, null);
        char action = c.getChar ();
        if (choice == '1' || choice == '3')
        {
            while (action != 'a' && action != 'b' && action != 'x')
            {
                g.setColor (Color.red);
                g.setFont (new Font ("Arial", Font.BOLD, 18));
                g.drawString ("That is not a valid choice,", 540, 560);
                g.drawString ("try again.", 600, 590);
                c.drawImage (image, 0, 0, null);
                action = c.getChar();
            }
        }
        else
        {
            while (action != 'a' && action != 'b' && action != 'c' && action != 'x')
            {
                g.setColor (Color.red);
                g.setFont (new Font ("Arial", Font.BOLD, 18));
                g.drawString ("That is not a valid choice,", 540, 560);
                g.drawString ("try again.", 600, 590);
                c.drawImage (image, 0, 0, null);
                action = c.getChar();
            }
        }
        g.setColor(Color.darkGray);
        g.fillRect (540, 530, 260, 70);
        c.drawImage (image, 0, 0, null);
        return action;
    }

    public static char getChoice (char min, char max)
    {
        char choice = c.getChar();
        while (choice < min || choice > max)
        {
            g.setColor (Color.red);
            g.setFont (new Font ("Arial", Font.BOLD, 18));
            g.drawString ("That is not a valid choice,", 540, 560);
            g.drawString ("try again.", 610, 590);
            c.drawImage (image, 0, 0, null);
            choice = c.getChar();
        }
        g.setColor(Color.darkGray);
        g.fillRect (540, 530, 260, 70);
        c.drawImage (image, 0, 0, null);
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
            Image[] images = Intro.Adopt ();
            dog = new Actions (images);
            String name = Intro.Name ();

            int intelligence = r.nextInt (25);
            int health = 50;
            int happiness,hygiene, relationship, food, water;
            int age = 1;
            char sit = 'n';
            char roll = 'n';
            char dead = 'n';
            int train = intelligence * 4;
            String illness = "none";
            int happ = 0;

            while (age <= 4)
            {
                Layout.Age(age);
                hygiene = r.nextInt (100);
                happiness = r.nextInt (100);
                relationship = r.nextInt (100);
                food = r.nextInt (25);
                water = r.nextInt (25);
                while (happiness < 100 || relationship < 100 || hygiene < 100 || health < 50 || food < 25 || water < 25)
                {
                    if (happ % 4 == 0 && happ > 0)
                    {
                        int happrand = r.nextInt (101);
                        if (happrand <= 25)
                        {
                            int disease = r.nextInt (8);
                            illness = illnesses [disease];
                            Layout.Ill (illness);
                            health = healthFail [disease];
                        }
                        else if (happrand <= 50)
                        {
                            
                        }
                        else if (happrand <= 75)
                        {
                        }
                    }
                    Layout.Background (name, age, food, water, health, happiness, hygiene, relationship, intelligence);
                    dog.Standard (age);

                    char choice = getChoice ('1', '6');
                    char action = 'a';
                    if (choice != '6')
                    {
                        action = getAction (choice);
                    }
                    
                    if (choice == '1') //nutrition
                    {
                        if (action == 'a') //feed
                        {
                            bgmusic.lower();
                            dog.Eat();
                            bgmusic.louder();
                            food = getStat (food, 25, 10);
                            happ++;
                        }
                        else if (action == 'b') //water
                        {
                            bgmusic.lower();
                            dog.Drink();
                            bgmusic.louder();
                            water = getStat (water, 25, 10);
                            happ++;
                        }
                    }
                    else if (choice == '2') //play
                    {
                        if (action == 'a') //fetch
                        {
                            bgmusic.lower();
                            dog.Fetch();
                            bgmusic.louder();
                            happiness = getStat (happiness, 100, 20);
                            happ++;
                        }
                        if (action == 'b') //chew
                        {
                            bgmusic.lower();
                            dog.Chew();
                            bgmusic.louder();
                            happiness = getStat (happiness, 100, 15);
                            happ++;
                        }
                        else if (action == 'c') //treat
                        {
                            bgmusic.lower();
                            dog.Treat(age);
                            bgmusic.louder();
                            happiness = getStat (happiness, 100, 15);
                            happ++;
                        }
                    }
                    else if (choice == '3') //groom
                    {
                        if (action == 'a') //brush
                        {
                            bgmusic.lower();
                            dog.Brush();
                            bgmusic.louder();
                            hygiene = getStat (hygiene, 100, 40);
                            happ++;
                        }
                        else if (action == 'b') //bath
                        {
                            bgmusic.lower();
                            dog.Bathe();
                            bgmusic.louder();
                            hygiene = getStat (hygiene, 100, 50);
                            happ++;
                        }
                    }
                    else if (choice == '4') //show affection
                    {
                        if (action == 'a') //belly rub
                        {
                            bgmusic.lower();
                            dog.Belly();
                            bgmusic.louder();
                            relationship = getStat (relationship, 100, 30);
                            happ++;
                        }
                        if (action == 'b') //ear scratch
                        {
                            bgmusic.lower();
                            dog.Scratch (age);
                            bgmusic.louder();
                            relationship = getStat (relationship, 100, 20);
                            happ++;
                        }
                        else if (action == 'c') //cuddle
                        {
                            bgmusic.lower();
                            dog.Cuddle(age);
                            bgmusic.louder();
                            relationship = getStat (relationship, 100, 40);
                            happ++;
                        }
                    }
                    else if (choice == '5') //train
                    {
                        if (action == 'a') //roll over
                        {
                            if (dead == 'n')
                            {
                                if (r.nextInt (101) <= train)
                                {
                                    dog.Dead(age);
                                    intelligence += 25;
                                    dead = 'y';
                                    happ++;
                                }
                                else
                                {
                                    Layout.Error ("train");
                                    happ++;
                                }
                            }
                            else
                            {
                                Layout.Error ("repeat");
                            }
                        }
                        if (action == 'b') //roll over
                        {
                            if (roll == 'n')
                            {
                                if (r.nextInt (101) <= train)
                                {
                                    dog.Roll(age);
                                    intelligence += 25;
                                    roll = 'y';
                                    happ++;
                                }
                                else
                                {
                                    Layout.Error ("train");
                                    happ++;
                                }
                            }
                            else
                            {
                                Layout.Error ("repeat");
                            }
                        }
                        else if (action == 'c') //sit
                        {
                            if (sit == 'n')
                            {
                                if (r.nextInt (101) <= train)
                                {
                                    dog.Sit(age);
                                    intelligence += 25;
                                    sit = 'y';
                                    happ++;
                                }
                                else
                                {
                                    Layout.Error ("train");
                                    happ++;
                                }
                            }
                            else
                            {
                                Layout.Error ("repeat");
                            }
                        }
                    }
                    else if (choice == '6')//take to vet
                    {
                        health = dog.Vet (age, health);
                        happ++;
                    }
                }
                age++;
            }

            playAgain = Intro.PlayAgain ();
        }
        while (playAgain != 'n');

        //thanks for playing
        clear ();
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