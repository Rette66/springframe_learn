package wwx.springframe.learn.factory;

import cn.hutool.core.bean.BeanException;

public interface BeanFactory {
    
    Object getBean(String name) throws BeanException;

    // Object getBean(String name, Object... args) throws BeanException;
}
