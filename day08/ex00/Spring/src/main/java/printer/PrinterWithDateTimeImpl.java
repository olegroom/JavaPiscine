package printer;

import renderer.Renderer;

import java.time.LocalDateTime;

public class PrinterWithDateTimeImpl implements Printer {

    public PrinterWithDateTimeImpl(Renderer renderer) {
    }

    public void print(LocalDateTime time) {
        System.out.println(time);
    }
}
