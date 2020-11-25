package chenjiajin.service;

import chenjiajin.entity.TPermission;
import chenjiajin.entity.TUser;
import chenjiajin.mapper.TUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private TUserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //Spring security 自带的密码加密
//        String hashpw = BCrypt.hashpw("123",BCrypt.gensalt());
//        System.out.println(hashpw);
        //TODO 操作数据库拿到了用户数据了
        //TODO 外层会自己对用户输入的密码进行加密  然后和数据库查出来的密码进行比较 
//        UserDetails userDetails = User.withUsername("zhangsan").password("$2a$10$VNQjFq82Bbl6gNDbQUFzk.UGpLxHvSNjCJp/DHlo7kqhoiGUsSVEC").authorities("p1").build();

        //------------------------------------------------------------------------------

        //根据账号来查询用户
        TUser tUser = new TUser();
        tUser.setUsername(s);
        tUser = userMapper.selectOne(tUser);
        if (null == tUser) {
            //如果为空  provider会主动抛出异常
            return null;
        }
        //获取用户的权限的集合对象
        List<TPermission> permissionsByUserId = userMapper.findPermissionsByUserId(tUser.getId() + "");
        //只获取权限code
        List<String> list = new ArrayList<>();
        permissionsByUserId.forEach(v -> list.add(v.getCode()));
        //将权限code转换成数组
        String [] permissionArray = new String[list.size()];
        list.toArray(permissionArray);
        //拿到数据库查到的密码和用户输入的密码做比对  成功就可以登录了  最后传入权限数组
        UserDetails userDetails = User.withUsername(tUser.getUsername()).password(tUser.getPassword()).authorities(permissionArray).build();

        return userDetails;
    }
}
