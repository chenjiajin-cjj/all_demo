//package chenjiajin.config;
//
//
//import org.springframework.beans.factory.annotation.Configurable;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//
//@Configurable//就相当于SpringMVC.xml文件
////@EnableWebMvc
////@ComponentScan(basePackages = "chenjiajin",
////        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)})
//public class WebConfig implements WebMvcConfigurer {
//
//    //视频解析器
////    @Bean
////    public InternalResourceViewResolver viewResolver() {
////        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
////        viewResolver.setPrefix("/WEB-INF/view/");
////        viewResolver.setSuffix(".jsp");
////        return viewResolver;
////    }
//
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("redirect:/login");
//    }
//
//
//}
