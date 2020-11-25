package chenjiajin.springs.domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLife {

    private String context;

    public BeanLife() {
        System.out.println("第一步 执行无参数构造方法 创建 bean 实例");
    }

    public void setContext(final String context) {
        this.context = context;
        System.out.println("第二步 调用 set 方法设置属性值");
    }

    //创建执行的初始化方法
    public void init() {
        System.out.println("第三步 执行初始化的方法");
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("BeanLife.xml");
        BeanLife beanLife = context.getBean("beanLife", BeanLife.class);
        System.out.println("第四步 获取 bean 对象");
        System.out.println(beanLife.context);
        context.close();
    }

    //创建销毁方法
    public void destory() {
        System.out.println("第五步 执行销毁方法");
    }
}

class myPostBean implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("执行初始化之前的方法");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("执行初始化之后的方法");
        return bean;
    }
}