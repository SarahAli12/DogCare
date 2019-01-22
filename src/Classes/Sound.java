import javax.sound.sampled.*;
import java.io.*;
import java.net.*;

public class Sound
{
    private Clip clip;
    private FloatControl volume;

    public Sound (String filename)
    {       
        File file = new File(filename);
        try
        {
            if(file.exists())
            {
                AudioInputStream sound = AudioSystem.getAudioInputStream(file);
                clip = AudioSystem.getClip();
                clip.open(sound);
                volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            }
        }
        catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void play()
    {
        clip.setFramePosition(0);
        clip.start();
    }

    public void loop()
    {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop()
    {
        clip.stop();
    }
    
    public void louder()
    {
        volume.setValue(6.0206f);
    }
    
    public void lower ()
    {
        volume.setValue(-6.0206f);
    }
}