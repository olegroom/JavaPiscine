package renderer;

import preproc.PreProcessor;

public class RendererErrImpl implements Renderer {


    PreProcessor preProcessor;

    public RendererErrImpl(PreProcessor preproc) {
        this.preProcessor = preproc;
    }

    @Override
    public void print(String textToPrint) {
        textToPrint = preProcessor.process(textToPrint);
        System.err.println(textToPrint);
    }
}
