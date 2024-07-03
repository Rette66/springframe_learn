package wwx.springframe.learn.factory.support;

import java.lang.reflect.Constructor;

import cn.hutool.core.bean.BeanException;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import wwx.springframe.learn.factory.config.BeanDefinition;
import wwx.springframe.learn.factory.support.interfaces.InstantiationStrategy;

public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy{

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String BeanName, Constructor ctor, Object[] args)
            throws BeanException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp(){
            @Override
            public int hashCode(){
                return super.hashCode();
            }
        });
        if(ctor == null) return enhancer.create();
        return enhancer.create(ctor.getParameterTypes(), args);
    }
    
}
