package wwx.springframe.learn.factory.support;

import cn.hutool.core.bean.BeanException;
import wwx.springframe.learn.factory.BeanFactory;
import wwx.springframe.learn.factory.config.BeanDefinition;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    
    @Override
    public Object getBean(String beanName) throws BeanException{

        Object bean = getSingleton(beanName);
        
        if(bean != null)
            return bean;

        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return createBean(beanName, beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeanException;
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeanException;
} 
