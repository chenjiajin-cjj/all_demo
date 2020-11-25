package chenjiajin.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author chenjiajin@Jowim.com
 * @since 2020-06-20
 */
@TableName("t_role_permission")
public class TRolePermission extends Model<TRolePermission> {

    private static final long serialVersionUID = 1L;

    @TableId("role_id")
    private String roleId;
    @TableField("permission_id")
    private String permissionId;


    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    protected Serializable pkVal() {
        return this.roleId;
    }

    @Override
    public String toString() {
        return "TRolePermission{" +
        ", roleId=" + roleId +
        ", permissionId=" + permissionId +
        "}";
    }
}
