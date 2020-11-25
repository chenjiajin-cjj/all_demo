package chenjiajin.springs.domain;

import org.springframework.beans.factory.FactoryBean;

public class MyBeanFactory implements FactoryBean<Video> {

    @Override
    public Video getObject() throws Exception {
        Video video = new Video();
        video.setId(11);
        video.setTitle("factory bean");
        return video;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
