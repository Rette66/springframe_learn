package wwx.springframe.learn.factory.support;

import java.util.HashMap;
import java.util.Map;

import cn.hutool.core.bean.BeanException;
import wwx.springframe.learn.factory.config.BeanDefinition;

public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry{
    
    private final Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();
    
    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition){
            beanDefinitionMap.put(beanName, beanDefinition);
            getBean(beanName);
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws BeanException{
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if(beanDefinition == null) throw new BeanException("No bean named '" + beanName + "' is defined");
        return beanDefinition;
    }

    

}
