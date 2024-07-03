package wwx.springframe.learn.factory.support;

import wwx.springframe.learn.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {

    /**
     * 注册BeanDefinition
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
