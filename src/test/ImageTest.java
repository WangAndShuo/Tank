package test;

import org.junit.Test;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class ImageTest {

    @Test
    public void test(){

        try {
            BufferedImage image = ImageIO.read(new File("C:\\Users\\10155\\Pictures\\Camera Roll\\31c3fdc63511cabedd6415d121fa2d58.jpg"));
            assertNotNull(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("dadsad");
        assertNotNull(new Object());
    }
}
