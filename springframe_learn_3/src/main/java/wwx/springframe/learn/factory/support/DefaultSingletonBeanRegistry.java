package wwx.springframe.learn.factory.support;

import java.util.HashMap;
import java.util.Map;

import wwx.springframe.learn.factory.config.SingletonBeanRegistry;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String, Object> singletonObject = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObject.get(beanName);
    }

    public void setSingleton(String beanName, Object singletonObject){
        this.singletonObject.put(beanName, singletonObject);
    }
    
}
