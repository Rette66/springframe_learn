package wwx.springframe.learn.factory.support;

import java.lang.reflect.Constructor;

import cn.hutool.core.bean.BeanException;
import wwx.springframe.learn.factory.config.BeanDefinition;
import wwx.springframe.learn.factory.support.interfaces.InstantiationStrategy;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    private InstantiationStrategy instantiateStrategy = new CglibSubclassingInstantiationStrategy();
    
    @Override
    public Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeanException{
        Object bean = null;
        try{
            bean = createBeanInstance(beanDefinition, beanName, args); 
        }catch(Exception e){
            throw new BeanException("Instantiation failed " + e);
        }

        setSingleton(beanName, bean);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args){
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for(Constructor ctor : declaredConstructors){
            if(null != args && ctor.getParameterTypes().length == args.length){
                constructorToUse = ctor;
                break;
            }
        }

        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    public InstantiationStrategy getInstantiationStrategy(){
        return this.instantiateStrategy;
    }

    public void SetInstantiationStrategy (InstantiationStrategy instantiationStrategy){
        this.instantiateStrategy = instantiationStrategy;
    }
}
