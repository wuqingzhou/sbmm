package wqz.model.sbmm.busproject.listener;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import wqz.model.sbmm.busproject.mapper.*;

/**
 * ContextRefreshedEvent事件监听
 * 此处可以加载一些应用将来会用到的缓存数据
 */
@Component
public class ContextRefreshedEventHandle implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    TbCodeMapper tbCodeMapper;
    @Autowired
    TbComplexMapper tbComplexMapper;
    @Autowired
    TbLicenseMapper tbLicenseMapper;
    @Autowired
    TbUserMapper tbUserMapper;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("触发事件： " + contextRefreshedEvent.getClass().getName());
        if (contextRefreshedEvent.getApplicationContext().getParent() == null) {
            System.out.println("spring容器初始化完成");
            System.out.println(JSONArray.parse(JSON.toJSONString(tbCodeMapper.selectAll(), true)));
            System.out.println(JSONArray.parse(JSON.toJSONString(tbComplexMapper.selectAll(), true)));
            System.out.println(JSONArray.parse(JSON.toJSONString(tbLicenseMapper.selectAll(), true)));
            System.out.println(JSONArray.parse(JSON.toJSONString(tbUserMapper.selectAll(), true)));
        }
    }
}
