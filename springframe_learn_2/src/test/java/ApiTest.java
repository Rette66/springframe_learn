import org.junit.Test;

import bean.UserService;
import wwx.springframe.learn.factory.config.BeanDefinition;
import wwx.springframe.learn.factory.support.DefaultListableBeanFactory;

public class ApiTest {
    
    @Test
    public void BeanTest(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

        UserService userService2 = (UserService) beanFactory.getSingleton("userService");
        userService2.queryUserInfo();
    }
}
