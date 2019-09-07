package wqz.model.sbmm.busproject.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wqz.model.sbmm.busproject.mapper.TbUserMapper;
import wqz.model.sbmm.busproject.model.TbUser;

import java.util.List;

@RestController
@RequestMapping("/tbUser")
public class UserController {
    @Autowired
    TbUserMapper tbUserMapper;

    @RequestMapping("/list")
    public JSONObject getList(){
        List<TbUser> userList = tbUserMapper.selectAll();
        JSONObject resultJson = new JSONObject();
        resultJson.put("userList", userList);
        return resultJson;
    }


}
