package chenjiajin.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {


    @RequestMapping("/login-success")
    public String loginSuccess() {
        return getUserName() + ":登录成功";
    }

    @RequestMapping("/r/r1")
    @PreAuthorize("hasAnyAuthority('p1')")
    public String ceshi1() {
        return getUserName() + ":访问资源 r1 ";
    }

    @RequestMapping("/r/r2")
    @PreAuthorize("hasAnyAuthority('p2')")
    public String ceshi2() {
        return getUserName() + ":访问资源 r2 ";
    }

    @RequestMapping("/r/r3")
    @PreAuthorize("hasAnyAuthority('p3')")
    public String ce21shi2() {
        return getUserName() + ":访问资源 r3 ";
    }

    @RequestMapping("/r/r4")
    @PreAuthorize("hasAnyAuthority('p1')") //拥有p1权限才能访问 但是通常一个方法对应一个权限 最常用
//    @PreAuthorize("hasAuthority('p1') and hasAnyAuthority('p3')")//同时拥有p1和p3权限的才可以访问 少用
//    @PreAuthorize("hasAnyAuthority('p1','p2')")//拥有p1或者p2的权限可以访问
    public String ce21221shi2() {
        return getUserName() + ":访问资源 r4 ";
    }

    @RequestMapping("/session_faild")
    public String ceshi3() {
        return getUserName() + ":session过期了";
    }


    //获取当前用户的信息
    private String getUserName() {
        String username = null;
        //得到当前认证的用户的身份
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //获取用户的身份
        Object principal = authentication.getPrincipal();
        if (null == principal) {
            username = "匿名";
        }

        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            username = userDetails.getUsername();
        } else {
            username = principal.toString();
        }
        return username;
    }

}
