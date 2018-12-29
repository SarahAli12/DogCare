import java.awt.*;
import hsa.Console;
import java.awt.image.BufferedImage;
import sun.audio.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.util.Random;

public class DogCare
{
    static Console c = new Console ();
    static BufferedImage image = new BufferedImage (c.getWidth (), c.getHeight (), BufferedImage.TYPE_INT_ARGB);
    static Graphics2D g = image.createGraphics ();
    static Random r = new Random ();

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


    public static void main (String[] args) throws Exception
    {


    }
}
