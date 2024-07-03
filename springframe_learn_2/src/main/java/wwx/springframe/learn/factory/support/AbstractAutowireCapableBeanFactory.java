package wwx.springframe.learn.factory.support;

import cn.hutool.core.bean.BeanException;
import wwx.springframe.learn.factory.config.BeanDefinition;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{
    
    @Override
    public Object createBean(String beanName, BeanDefinition beanDefinition) throws BeanException{
        Object bean = null;
        try{
            bean = beanDefinition.getBeanClass().newInstance();
        }catch(InstantiationException | IllegalAccessException e){
            throw new BeanException(e);
        }

        setSingleton(beanName, bean);
        return bean;
    }
}
