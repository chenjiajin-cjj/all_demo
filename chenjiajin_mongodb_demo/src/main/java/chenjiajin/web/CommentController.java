package chenjiajin.web;

import chenjiajin.domain.Comment;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mongodb")
public class CommentController {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 保存数据到mongodb
     * @param comment
     * @return
     */
    @PostMapping("/save_data")
    public Object saveData(@RequestBody Comment comment){
        mongoTemplate.save(comment, "comment");
        return "ok";
    }

    /**
     * 根据条件来查询
     * @param json
     * @return
     */
    @PostMapping("/get_data")
    public Object saveData(@RequestBody String json){
        String id = JSONObject.parseObject(json).getString("id");
        String other = JSONObject.parseObject(json).getString("other");
        //有多个条件就addCriteria
        Query query = Query.query(Criteria.where("_id").is(id)).addCriteria(Criteria.where("state").is(other));
        Comment comment = mongoTemplate.findOne(query, Comment.class,"comment");
        return comment;
    }

    /**
     * 修改单条数据
     * @param json
     * @return
     */
    @PostMapping("update_data")
    public Object updateData(@RequestBody String json){
        String _id = JSONObject.parseObject(json).getString("_id");
        String content = JSONObject.parseObject(json).getString("content");
        String createdatetime = JSONObject.parseObject(json).getString("createdatetime");
        Query query = new Query(Criteria.where("_id").is(_id));
        Update update = new Update();
        update.set("content",content);
        update.set("createdatetime",createdatetime);
        //只修改符合条件的一条
        return mongoTemplate.updateFirst(query,update,"comment");
    }

    /**
     * 为指定条件的文档添加一个字段（可批量）
     * @param json
     * @return
     */
    @PostMapping("add_data_document")
    public Object addDataDocument(@RequestBody String json){
        String _id = JSONObject.parseObject(json).getString("_id");
        String data = JSONObject.parseObject(json).getString("data");
        Query query = new Query(Criteria.where("_id").is(_id));
        Update update = new Update();
        update.set(data,"0");
        //为符合条件的query添加字段
        return mongoTemplate.updateMulti(query,update,"comment");
    }

    /**
     * 分页查询
     * @param json
     * @return
     */
    @PostMapping("find_page")
    public Object findPage(@RequestBody String json){
        String _id = JSONObject.parseObject(json).getString("_id");
        String data = JSONObject.parseObject(json).getString("data");
        Integer limit = JSONObject.parseObject(json).getInteger("limit");
        Integer skip = JSONObject.parseObject(json).getInteger("skip")-1;
        Query query = new Query();
        query.addCriteria(Criteria.where("userid").is(data));
        query.skip(skip);
        query.limit(limit);
        //为符合条件的query添加字段
        return mongoTemplate.find(query,Comment.class,"comment");
    }
    /**
     * 根据条件来删除
     * @param json
     * @return
     */
    @PostMapping("delete_for")
    public Object delete(@RequestBody String json){
        String _id = JSONObject.parseObject(json).getString("_id");
        return mongoTemplate.remove(new Query(Criteria.where("_id").is(_id)), "comment");
    }

}
