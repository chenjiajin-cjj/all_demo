package chenjiajin.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author chenjiajin@Jowim.com
 * @since 2020-06-20
 */
@TableName("t_user_role")
public class TUserRole extends Model<TUserRole> {

    private static final long serialVersionUID = 1L;

    @TableId("user_id")
    private String userId;
    @TableField("role_id")
    private String roleId;
    @TableField("create_time")
    private Date createTime;
    private String creator;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

    @Override
    public String toString() {
        return "TUserRole{" +
        ", userId=" + userId +
        ", roleId=" + roleId +
        ", createTime=" + createTime +
        ", creator=" + creator +
        "}";
    }
}
