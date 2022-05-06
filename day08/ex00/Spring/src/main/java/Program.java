import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import preproc.PreProcessor;
import preproc.PreProcessorToLowerImpl;
import preproc.PreProcessorToUpperImpl;
import printer.PrinterWithPrefixImpl;
import renderer.RendererErrImpl;


public class Program {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");
        PrinterWithPrefixImpl printer = applicationContext.getBean("printer", PrinterWithPrefixImpl.class);

        printer.print("Hello!");
    }
}
