package hello.core.scan.filter;

import java.util.logging.Filter;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

public class ComponentFilterAppConfigTest {


    @Test
    void filterScan() {
        new AnnotationConfigApplicationContext();
    }

    @Configuration
    @Component(includeFilters = @ComponentScan(type = Filter.ANNOTATION, basePackageClasses =))
    static class ComponentFilterAppConfig;


    ;
}
