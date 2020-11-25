package chenjiajin.dao;


import chenjiajin.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsersSQLRepositoryDAO extends JpaSpecificationExecutor<Users>, JpaRepository<Users, Integer> {
    @Query(value = "SELECT a.* FROM t_users as a  WHERE a.id= :id",nativeQuery = true)
    List<Users> queryByIdUseHql01(@Param("id") Integer id);

    @Query(value = "SELECT * FROM t_users limit :page,:pagesize",nativeQuery = true)
    List<Users> findByPage(@Param("page")Integer page,@Param("pagesize")Integer pagesize);
}
