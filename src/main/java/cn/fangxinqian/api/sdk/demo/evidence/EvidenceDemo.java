package cn.fangxinqian.api.sdk.demo.evidence;

import cn.fangxinqian.api.sdk.FxqRquest;
import cn.fangxinqian.api.sdk.request.EvidenceReq;
import cn.fangxinqian.api.sdk.request.UserInfo;
import cn.fangxinqian.api.sdk.utils.FileUtils;
import cn.fangxinqian.api.sdk.utils.ResultVO;
import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.util.Arrays;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @GitHub https://github.com/niezhiliang
 * @Date 2020/7/29 下午3:50
 * 合同存证
 * 123
 */
public class EvidenceDemo {

    private static final String TOKEN = "123456";

    public static void main(String[] args) throws IOException {

        UserInfo userInfo = new UserInfo()
                .setUserName("张三丰")
                .setCustomerType(0)
                .setIdentificationNo("362202198925953621")
                .setIdentificationType(0);
        UserInfo userInfo2 = new UserInfo()
                .setUserName("浙江葫芦娃网络集团有限公司")
                .setCustomerType(1)
                .setIdentificationNo("362202198925953621")
                .setIdentificationType(8);


        EvidenceReq evidenceReq = new EvidenceReq()
                .setContract(FileUtils.path2Base64("./data/test.pdf"))
                .setTitle("电子合同")
                .setUserInfos(Arrays.asList(userInfo,userInfo2))
                .setIndustry(1);
        //data中返回的值都跟合同关联起来，然后存库
        ResultVO resultVO = FxqRquest.evidenceSave(evidenceReq, TOKEN);
        System.out.println(JSON.toJSONString(resultVO));
    }
}
