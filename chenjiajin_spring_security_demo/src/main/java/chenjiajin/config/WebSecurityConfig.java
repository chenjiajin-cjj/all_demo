package chenjiajin.config;


import com.alibaba.fastjson.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true) //开启使用方法层面的注解验证
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //定义用户信息服务（查询用户信息） 基于内存的 不是查数据库的
    //可用来模拟数据
//    @Bean
//    public UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("zhangsan").password("123").authorities("p1","p3","p4").build());
//        manager.createUser(User.withUsername("lisi").password("123").authorities("p2").build());
//        return manager;
//    }

    //密码编码器
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //安全拦截机制
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         * 访问具体路径的放前边
         * 访问比较泛的路径放在后面
         */
        http
                .authorizeRequests()
                //一般用方法层面的注解比较常用所以这里注释了，但这里也能用就是了
//                .antMatchers("/r/r1").hasAnyAuthority("p1")//要求访问这个路径要有p1权限
//                .antMatchers("/r/r2").hasAnyAuthority("p2")//要求访问这个路径要有p2权限
//                .antMatchers("/r/r3").hasAnyAuthority("p3")//要求访问这个路径要有p3权限
//                .antMatchers("/r/**").authenticated()//所有/r/** 下的所有请求必须认证通过
//                .anyRequest().permitAll()//除了/r/**，其他的请求可以访问

                .antMatchers("/","/r/r1").permitAll()
//                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()

                .and()
                .formLogin()//允许表单登录
//                .loginPage("/login.html")//自定义登录页面
                .loginProcessingUrl("/login")//登录的路径，自定义登录页面一定要有
                .successForwardUrl("/login-success")//自定义登录成功的页面资料
                .and()
                .sessionManagement()//设置session过期后自动跳转的页面
                .invalidSessionUrl("/session_faild")//设置session过期后自动跳转的页面
//                .and()
//                .sessionManagement()//定义session的创建规则
//                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)//选择怎么使用session
//                .and()
//                .logout()//自定义退出
//                .logoutUrl("/logout")//自定义退出的url
//                .logoutSuccessUrl("/logouthtml")//退出后跳转的页面
                .and()
                .csrf().disable();//关闭csrf验证
        http.addFilterAt(customAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);


    }


    @Bean
    CustomAuthenticationFilter customAuthenticationFilter() throws Exception {
        CustomAuthenticationFilter filter = new CustomAuthenticationFilter();
        filter.setAuthenticationSuccessHandler(new AuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
                resp.setContentType("application/json;charset=utf-8");
                PrintWriter out = resp.getWriter();
                JSONObject js = new JSONObject();
                js.put("status", "200");
                js.put("msg", "登录成功");
                out.write(js.toString());
                out.flush();
                out.close();
            }
        });
        filter.setAuthenticationFailureHandler(new AuthenticationFailureHandler() {
            @Override
            public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp, AuthenticationException e) throws IOException, ServletException {
                resp.setContentType("application/json;charset=utf-8");
                PrintWriter out = resp.getWriter();
                JSONObject js = new JSONObject();
                js.put("status", "400");
                js.put("msg", "登录失败");
                out.write(js.toString());
                out.flush();
                out.close();
            }
        });
        filter.setAuthenticationManager(authenticationManagerBean());
        return filter;
    }

    /**
     *
     * session的创建与否
     *
     * always 如果没有session存在就创建一个
     * ifRequired 如果需要就创建一个Session
     * never Spring security 将不会创建session 但是如果应用中其他地方创建了Session，那么Spring Security将会使用它
     * stateless SpringSecurity 将绝对不会创建session 也不会使用session
     *
     * 正常用jwt 所以将不会使用session 使用 SessionCreationPolicy.STATELESS
     *
     * http
     *      .and()
     *      .sessionManagement()
     *      .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
     */

}
