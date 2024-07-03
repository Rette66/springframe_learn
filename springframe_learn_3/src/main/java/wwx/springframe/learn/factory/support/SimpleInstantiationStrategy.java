package wwx.springframe.learn.factory.support;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import cn.hutool.core.bean.BeanException;
import wwx.springframe.learn.factory.config.BeanDefinition;
import wwx.springframe.learn.factory.support.interfaces.InstantiationStrategy;

public class SimpleInstantiationStrategy implements InstantiationStrategy {

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String BeanName, Constructor ctor, Object[] args)
            throws BeanException {
        Class clazz = beanDefinition.getBeanClass();
        try{
            if(ctor != null){
                return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            }else {
                return clazz.getDeclaredConstructor().newInstance();
            }
        }catch(NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e){
            throw new BeanException("Failed to instantiate [" + clazz.getName() + "]", e);
        }
    }
}
