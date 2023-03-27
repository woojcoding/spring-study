package woojcoding.springcore.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import woojcoding.springcore.AppConfig;

public class ApplicationContextTest {

    AnnotationConfigApplicationContext ac =
            new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("All Bean")
    void findAllBean() throws Exception {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);

            System.out.println("name = "
                    + beanDefinitionName
                    + " Object = "
                    + bean
            );
        }
    }

    @Test
    @DisplayName("All Application Bean")
    void findApplicationBean() throws Exception {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition =
                    ac.getBeanDefinition(beanDefinitionName);

            // Role_APPLICATION - 내가 애플리케이션을 개발하기 위해 직접 등록한 Bean
            // Role_INFRASTRUCTURE : 스프링이 내부에서 사용하는 Bean
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefinitionName);

                System.out.println("name = "
                        + beanDefinitionName
                        + " Object = "
                        + bean
                );
            }
        }
    }
}
