package preproc;

public class PreProcessorToLowerImpl implements PreProcessor {
    @Override
    public String process(String initString) {
        return initString.toLowerCase();
    }
}
