package Classes;

import java.awt.*;
import hsa.Console;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;

public class Intro
{
    static Console c = DogCare.c;
    static BufferedImage image = DogCare.image;
    static Graphics2D g = DogCare.g;
    static Color pink = new Color (249, 199, 198);
    
//    public Intro ()
//    {
//    }

    public static Image loadImage (String name) throws Exception
    {
        Image img = ImageIO.read (new File (name));
        return img;
    }

    public static void clear ()
    {
        g.setColor (Color.white);
        g.fillRect (0, 0, 800, 600);
    }

    public static void intro () throws Exception
    {
        //logo
        Image logo = loadImage ("logo.jpg");
        g.setFont (new Font ("Arial", Font.BOLD, 30));
        g.setColor (pink);
        g.drawImage (logo, 154, 55, null);
        g.drawString ("Press any key to start", 165, 450);
        c.drawImage (image, 0, 0, null);
        c.getChar ();

        //welcome
        g.setColor (pink);
        g.fillRect (0, 0, 640, 500);
        g.setColor (Color.white);
        g.drawString ("Welcome to Dog Care!", 160, 170);
        g.drawString ("Would you like a tutorial? (y/n)", 110, 220);
        c.drawImage (image, 0, 0, null);
        char choice = c.getChar ();
        while (choice != 'y' && choice != 'n' && choice != 'Y' && choice != 'N')
        {
            g.drawString ("Sorry, that is not a valid choice.", 110, 270);
            g.drawString ("Please try again.", 210, 320);
            c.drawImage (image, 0, 0, null);
            choice = c.getChar ();
        }

        //instructions
        while (choice == 'y')
        {
            g.setColor (pink);
            g.fillRect (0, 0, 640, 500);
            g.setColor (Color.white);
            g.setFont (new Font ("Arial", Font.BOLD, 25));
            g.drawString ("The goal of this game is to successfully raise a dog.", 10, 25);
            g.drawString ("Your progress will be measured using 5 stat bars:", 10, 70);
            g.drawString ("-  Health (which includes hunger and thirst)", 10, 105);
            g.drawString ("-  Happiness", 10, 140);
            g.drawString ("-  Hygiene", 10, 175);
            g.drawString ("-  Relationship (with you, the owner)", 10, 210);
            g.drawString ("-  Intelligence", 10, 245);
            g.drawString ("Your goal is to age your dog through 4 stages:", 10, 290);
            g.drawString ("-  Puppy", 10, 325);
            g.drawString ("-  Teenager", 10, 360);
            g.drawString ("-  Adult", 10, 395);
            g.drawString ("-  Elder", 10, 430);
            g.drawString ("Press any key to continue.", 10, 475);
            c.drawImage (image, 0, 0, null);
            c.getChar ();

            g.setColor (pink);
            g.fillRect (0, 0, 640, 500);
            g.setColor (Color.white);
            g.drawString ("You can take care of your dog by doing the following", 10, 25);
            g.drawString ("actions:", 10, 60);
            g.drawString ("-  Feed/Water", 10, 105);
            g.drawString ("-  Play", 10, 140);
            g.drawString ("-  Groom", 10, 175);
            g.drawString ("-  Show affection", 10, 210);
            g.drawString ("-  Train (the better your relationship, the more likely", 10, 245);
            g.drawString ("   you are to succeed)", 10, 280);
            g.drawString ("-  Take to vet", 10, 315);
            g.drawString ("And finally, when all 5 stat bars are full you will be", 10, 360);
            g.drawString ("able to age your dog!", 10, 395);
            g.drawString ("Press any key to continue.", 10, 440);
            c.drawImage (image, 0, 0, null);
            c.getChar ();

            g.setColor (pink);
            g.fillRect (0, 0, 640, 500);
            g.setColor (Color.white);
            g.drawString ("There are several occurances that can happen as a", 10, 25);
            g.drawString ("result of your neglect, such as dehydration,", 10, 60);
            g.drawString ("malnutrition, and depression.", 10, 95);
            g.drawString ("There are also several things that can occur", 10, 140);
            g.drawString ("randomly and are therefore out of your control,", 10, 175);
            g.drawString ("such as an attack from another dog, illness, and", 10, 210);
            g.drawString ("losing your dog.", 10, 245);
            g.drawString ("Some of these happenings are solvable. For", 10, 290);
            g.drawString ("example, you can simply take your dog to the vet in", 10, 325);
            g.drawString ("the case of illness. Others are simply up to chance,", 10, 360);
            g.drawString ("like hoping you eventually find your dog.", 10, 395);
            g.drawString ("Press any key to continue.", 10, 440);
            c.drawImage (image, 0, 0, null);
            c.getChar ();

            g.setColor (pink);
            g.fillRect (0, 0, 640, 500);
            g.setColor (Color.white);
            g.setFont (new Font ("Arial", Font.BOLD, 30));
            g.drawString ("Would you like to replay the tutorial? (y/n)", 30, 220);
            c.drawImage (image, 0, 0, null);
            choice = c.getChar ();
            while (choice != 'y' && choice != 'n' && choice != 'Y' && choice != 'N')
            {
                g.drawString ("Sorry, that is not a valid choice.", 110, 270);
                g.drawString ("Please try again.", 210, 320);
                c.drawImage (image, 0, 0, null);
                choice = c.getChar ();
            }
        }
    }

    public static Image[] Adopt () throws Exception
    {
        char breed;
        g.setColor (pink);
        g.fillRect (0, 0, 640, 500);
        g.setColor (Color.white);
        g.drawString ("Which breed would you like to adopt?", 50, 40);
        g.drawString ("Beagle (b)", 30, 400);
        g.drawString ("Golden", 260, 400);
        g.drawString ("Retriever (g)", 230, 440);
        g.drawString ("Corgi (c)", 450, 400);
        g.drawImage (loadImage ("beagle_puppy.png"), 40, 210, null);
        g.drawImage (loadImage ("golden_puppy.png"), 270, 210, null);
        g.drawImage (loadImage ("corgi_puppy.png"), 460, 230, null);
        c.drawImage (image, 0, 0, null);
        breed = c.getChar ();
        while (breed != 'b' && breed != 'g' && breed != 'c')
        {
            g.drawString ("Sorry, that is not a valid choice.", 100, 90);
            g.drawString ("Please try again.", 200, 140);
            c.drawImage (image, 0, 0, null);
            breed = c.getChar ();
        }

        Image[] beagle = {loadImage ("beagle_puppy.png"), loadImage ("beagle_teen.png"), loadImage ("beagle_adult.png"), loadImage ("beagle_old.png"), loadImage ("beagle_eating.png"), loadImage ("beagle_standing.png"), loadImage ("beagle_belly.png"), loadImage ("beagle_chew.png"), loadImage ("beagle_fetch.png"), loadImage ("beagle_bath.png"), loadImage ("beagle_head.png"), loadImage ("beagle_back.png"), loadImage ("beagle_kick.png"), loadImage ("beagle_prepare.png"), loadImage ("beagle_punch.png"), loadImage ("beagle_headreflect.png"), loadImage ("beagle_backreflect.png"), loadImage ("beagle_kickreflect.png"), loadImage ("beagle_preparereflect.png"), loadImage ("beagle_punchreflect.png") };
        Image[] golden = {loadImage ("golden_puppy.png"), loadImage ("golden_teen.png"), loadImage ("golden_adult.png"), loadImage ("golden_old.png"), loadImage ("golden_eating.png"), loadImage ("golden_standing.png"), loadImage ("golden_belly.png"), loadImage ("golden_chew.png"), loadImage ("golden_fetch.png"), loadImage ("golden_bath.png"), loadImage ("golden_head.png"), loadImage ("golden_back.png"), loadImage ("golden_kick.png"), loadImage ("golden_prepare.png"), loadImage ("golden_punch.png"), loadImage ("golden_headreflect.png"), loadImage ("golden_backreflect.png"), loadImage ("golden_kickreflect.png"), loadImage ("golden_preparereflect.png"), loadImage ("golden_punchreflect.png") };
        Image[] corgi = {loadImage ("corgi_puppy.png"), loadImage ("corgi_teen.png"), loadImage ("corgi_adult.png"), loadImage ("corgi_old.png"), loadImage ("corgi_eating.png"), loadImage ("corgi_standing.png"), loadImage ("corgi_belly.png"), loadImage ("corgi_chew.png"), loadImage ("corgi_fetch.png"), loadImage ("corgi_bath.png"), loadImage ("corgi_head.png"), loadImage ("corgi_back.png"), loadImage ("corgi_kick.png"), loadImage ("corgi_prepare.png"), loadImage ("corgi_punch.png"), loadImage ("corgi_headreflect.png"), loadImage ("corgi_backreflect.png"), loadImage ("corgi_kickreflect.png"), loadImage ("corgi_preparereflect.png"), loadImage ("corgi_punchreflect.png") };
        //image order: puppy [1], teen [2], adult [3], old [4], eating [5], standing [6], belly [7], chewing [8], fetch [9], bath [10], head [11], back [12], kick [13], prepare [14], punch [15], headreflect [16], backreflect [17], kickreflect [18], preparereflect [19], punchreflect [20]

        if (breed == 'b')
        {
            return beagle;
        }
        else if (breed == 'g')
        {
            return golden;
        }
        else
        {
            return corgi;
        }
    }

    public static String Name ()
    {
        String name = "";
        char ch;
        char confirm = 'n';
        while (confirm == 'n')
        {
            boolean cont = true;
            name = "";
            while (cont && name.length () < 10)
            {
                g.setColor (pink);
                g.fillRect (0, 0, 640, 500);
                g.setColor (Color.white);
                g.setFont (new Font ("Arial", Font.BOLD, 30));
                g.drawString ("Name your dog (10 characters max):", 60, 200);
                g.fillRect (190, 240, 260, 60);
                g.setColor (Color.gray);
                g.drawString (name, 210, 280);
                c.drawImage (image, 0, 0, null);
                ch = c.getChar ();
                if (ch == 10)
                {
                    cont = false;
                }
                else if (ch == 8)
                {
                    if (name.length () > 0)
                    {
                        name = name.substring (0, name.length () - 1);
                    }
                }
                else
                {
                    name += ch;
                }
            }
            g.setColor (pink);
            g.fillRect (0, 0, 640, 500);
            g.setColor (Color.white);
            g.drawString ("Are you sure you want to name your dog", 30, 200);
            g.drawString ("'" + name + "'? (y/n)", (640 - (name.length () + 9) * 15) / 2, 250);
            c.drawImage (image, 0, 0, null);
            confirm = c.getChar ();
            while (confirm != 'y' && confirm != 'n')
            {
                g.drawString ("Sorry, that is not a valid choice.", 100, 300);
                g.drawString ("Please try again.", 200, 350);
                c.drawImage (image, 0, 0, null);
                confirm = c.getChar ();
            }
        }
        return name;
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

    }
}