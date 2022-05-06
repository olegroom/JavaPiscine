package edu.school21.printer.app;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi;
import edu.school21.printer.logic.Logic;

import java.io.IOException;

@Parameters(separators = "=")
public class Args {
    @Parameter(names = "--white")
    String firstColor;

    @Parameter(names = "--black")
    String secondColor;

    public void run() throws IOException {
        Ansi.BColor color1 = Ansi.BColor.valueOf(firstColor);
        Ansi.BColor color2 = Ansi.BColor.valueOf(secondColor);

        ColoredPrinter cpWh = new ColoredPrinter.Builder(1, false)
                .background(color1)
                .build();

        ColoredPrinter cpBl = new ColoredPrinter.Builder(1, false)
                .background(color2)
                .build();

        Logic.seeBMPImage("/resources/image.bmp", cpBl, cpWh);
    }

}
