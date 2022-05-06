import com.google.auto.service.AutoService;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.TypeElement;
import java.util.Set;


@SupportedAnnotationTypes({"annotations.HtmlForm", "annotations.HtmlInput"})
@AutoService(Processor.class)
public class HtmlProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
//        System.out.println("here");
//        for (TypeElement annotation : annotations) {
//            System.out.println(annotation.getSimpleName());
//        }
        System.out.println("here");
        return false;
    }
}
