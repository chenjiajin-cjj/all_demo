package chenjiajin.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="t_users")
//@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Users implements Serializable {

    @Id	//主键id
    @GeneratedValue(strategy= GenerationType.IDENTITY)//主键生成策略
//    @GeneratedValue(generator = "jpa-uuid")//主键uuid
    @Column(name="id")//数据库字段名
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="age")
    private Integer age;

    @Column(name="address")
    private String address;

//    @ManyToOne(cascade = CascadeType.PERSIST)	//表示多方
//    @JoinColumn(name ="role_id")	//维护一个外键，外键在Users一侧
//    private Roles roles;
//
//    public Roles getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Roles roles) {
//        this.roles = roles;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Users{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", address='").append(address).append('\'');
        sb.append('}');
        return sb.toString();
    }
}