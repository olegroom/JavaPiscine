package edu.school21.printer.app;

import edu.school21.printer.logic.Logic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

class Program {

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("Wrong number of args");
            System.exit(-1);
        }
        char w = args[0].charAt(0);
        char b = args[1].charAt(0);


        int[][] ar2d = Logic.seeBMPImage("/resources/image.bmp", b, w);

        for (int x = 0; x < ar2d.length; x++)
        {
            for (int y = 0; y < ar2d[x].length; y++)
            {
                System.out.print((char)ar2d[y][x]);
            }
            System.out.println();
        }
    }
}