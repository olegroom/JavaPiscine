package preproc;

public class PreProcessorToUpperImpl implements PreProcessor {
    @Override
    public String process(String initString) {
        return initString.toUpperCase();
    }
}
