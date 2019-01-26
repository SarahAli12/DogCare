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

  public static void main (String[] args) throws Exception {



  }
}
