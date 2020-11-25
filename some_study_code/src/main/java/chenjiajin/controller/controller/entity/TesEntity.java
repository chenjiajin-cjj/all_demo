package chenjiajin.controller.controller.entity;

import chenjiajin.controller.controller.validata.Delete;
import chenjiajin.controller.controller.validata.Insert;
import chenjiajin.controller.controller.validata.Update;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.URL;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

/**
 * 分组校验，只有对应的注解打上了对应的分组才会对应的进行校验
 */

@Data
@ToString
public class TesEntity {

    @Null(groups = {Insert.class}, message = "新增不必传入主键")
    @NotBlank(groups = {Update.class, Delete.class}, message = "主键不能为空")
    private String id;

    @NotBlank(groups = {Insert.class, Update.class}, message = "名字不能为空")
    private String name;

    @Email(message = "不是正确的email", groups = {Insert.class, Update.class})
    @NotBlank(groups = {Insert.class}, message = "email 不能为空")
    private String email;

    @URL(message = "不是正确的 url 地址", groups = {Insert.class, Update.class})
    @NotBlank(groups = {Insert.class}, message = "url 不能为空")
    private String url;

    @NotNull(message = "数字不能为空", groups = {Insert.class})
    @Min(value = 0, message = "不能小于0", groups = {Insert.class, Update.class})
    private Integer number;

    @NotEmpty(groups = {Insert.class}, message = "长度不能小于0")
    private List<Object> list;

    @NotEmpty(groups = {Insert.class}, message = "里面的长度不能小于0")
    @Valid
    private List<Interior> interiorList;
}
