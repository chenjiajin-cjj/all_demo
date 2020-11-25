package chenjiajin.controller.controller;

import chenjiajin.controller.controller.entity.TesEntity;
import chenjiajin.controller.controller.validata.Delete;
import chenjiajin.controller.controller.validata.Insert;
import chenjiajin.controller.controller.validata.Update;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/valid")
public class TestController {


    /**
     * 新增
     */
    @PostMapping("/insert")
    public R insert(@RequestBody @Validated(Insert.class) TesEntity tesEntity) {
        return R.ok().put("200", "新增成功");
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    public R update(@RequestBody @Validated(Update.class) TesEntity tesEntity) {
        return R.ok().put("200", "修改成功");
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public R delete(@RequestBody @Validated(Delete.class) TesEntity tesEntity) {
        return R.ok().put("200", "删除成功");
    }

}
