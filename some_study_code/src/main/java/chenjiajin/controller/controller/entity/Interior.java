package chenjiajin.controller.controller.entity;

import chenjiajin.controller.controller.validata.Delete;
import chenjiajin.controller.controller.validata.Insert;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.URL;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Data
@ToString
public class Interior {


    @Null(message = "新增不必传入主键", groups = {Insert.class})
    @NotBlank(message = "主键不能为空")
    private String id;

    @NotBlank(message = "名字不能为空", groups = {Insert.class})
    private String name;

    @Email(message = "不是正确的email")
    @NotBlank(message = "email 不能为空")
    private String email;

    @URL(message = "不是正确的 url 地址")
    @NotBlank(message = "url 不能为空")
    private String url;

    @NotNull(message = "数字不能为空")
    @Min(value = 0, message = "不能小于0")
    private Integer number;

    @NotEmpty(message = "长度不能小于0")
    private List<Object> list;


}
