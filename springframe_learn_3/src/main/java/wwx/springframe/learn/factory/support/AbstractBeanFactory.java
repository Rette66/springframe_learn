package wwx.springframe.learn.factory.support;

import cn.hutool.core.bean.BeanException;
import wwx.springframe.learn.factory.BeanFactory;
import wwx.springframe.learn.factory.config.BeanDefinition;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    
    @Override
    public Object getBean(String beanName) throws BeanException{
        return doGetBean(beanName, null);
    }

    @Override
    public Object getBean(String beanName, Object... args){
        return doGetBean(beanName, args);
    }

    protected <T> T doGetBean(String beanName, Object[] args){
        Object bean = getSingleton(beanName);
        if(bean != null)
            return (T) bean;

        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        
        return (T) createBean(beanName, beanDefinition, args);
    }


    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeanException;
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeanException;
} 
