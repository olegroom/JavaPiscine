package printer;

import renderer.Renderer;

public class PrinterWithPrefixImpl implements Printer {
    private String prefix;
    private Renderer renderer;



    public void setRenderer(Renderer renderer) {
        this.renderer = renderer;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void print(String text) {
        renderer.print(this.prefix + " " + text);
    }
}
