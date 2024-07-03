package wwx.springframe.learn.factory.support.interfaces;
import java.lang.reflect.Constructor;

import cn.hutool.core.bean.BeanException;
import wwx.springframe.learn.factory.config.BeanDefinition;


public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition, String BeanName, Constructor ctor, Object[] args) throws BeanException;
}
