package chenjiajin.entity;

import com.baomidou.mybatisplus.activerecord.Model;
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
@TableName("t_permission")
public class TPermission extends Model<TPermission> {

    private static final long serialVersionUID = 1L;

    private String id;
    /**
     * 权限标识符
     */
    private String code;
    /**
     * 描述
     */
    private String description;
    /**
     * 请求地址
     */
    private String url;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TPermission{" +
        ", id=" + id +
        ", code=" + code +
        ", description=" + description +
        ", url=" + url +
        "}";
    }
}
