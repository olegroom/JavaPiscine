package renderer;

import preproc.PreProcessor;

public class RendererStandardImpl implements Renderer {
    PreProcessor preProcessor;

    public RendererStandardImpl(PreProcessor preProcessor, int x) {
        this.preProcessor = preProcessor;
        System.out.println(x);
    }

    @Override
    public void print(String textToPrint) {
        textToPrint = preProcessor.process(textToPrint);
        System.out.println(textToPrint);
    }
}
