package chenjiajin.dao;

import chenjiajin.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 参数一 T :当前需要映射的实体
 * 参数二 ID :当前映射的实体中的OID的类型
 * 和mybatis的mapper一样吧
 */
public interface UsersRepository extends JpaRepository<Users, Integer> {

//方法名称必须要遵循驼峰式命名规则，findBy（关键字）+属性名称（首字母大写）+查询条件（首字母大写）
    List<Users> findByName(String name);

    List<Users> findByNameAndAge(String name, Integer age);

    List<Users> findByNameLike(String name);

}
