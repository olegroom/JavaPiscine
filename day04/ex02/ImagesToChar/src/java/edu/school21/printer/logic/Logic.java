package edu.school21.printer.logic;

import com.diogonunes.jcdp.color.ColoredPrinter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Logic {
    public static int[][] seeBMPImage(String BMPFileName, ColoredPrinter cp1, ColoredPrinter cp2) throws IOException {
        BufferedImage image = ImageIO.read(Logic.class.getResource("/resources/image.bmp"));

        int array2D[][] = new int[image.getWidth()][image.getHeight()];

        for (int xPixel = 0; xPixel < image.getWidth(); xPixel++)
        {
            for (int yPixel = 0; yPixel < image.getHeight(); yPixel++)
            {
                int color = image.getRGB(yPixel, xPixel);
                if (color == Color.BLACK.getRGB()) {
                    cp1.print("   ");
                } else {
                    cp2.print("   ");
                }
            }
            System.out.println();
        }
        return array2D;
    }
}