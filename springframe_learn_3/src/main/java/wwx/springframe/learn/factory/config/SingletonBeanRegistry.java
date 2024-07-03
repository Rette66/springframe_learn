package wwx.springframe.learn.factory.config;

public interface SingletonBeanRegistry {
    
    Object getSingleton(String beanName);

}
