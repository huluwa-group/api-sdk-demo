package cn.fangxinqian.api.sdk.demo.sms;

import cn.fangxinqian.api.sdk.FxqRquest;
import cn.fangxinqian.api.sdk.request.PublicBankReq;
import cn.fangxinqian.api.sdk.request.SmsSendReq;
import cn.fangxinqian.api.sdk.request.TokenReq;
import cn.fangxinqian.api.sdk.utils.ResultVO;

import java.io.IOException;

/**
 * @author mqz
 * @description
 * @since 2020/8/4
 */
public class SmsSendDemo {

    public static void main(String[] args) throws IOException {
        TokenReq tr = new TokenReq()
                .setKey("xcv123df4l")
                .setSecret("f60e1961fb788d2bbd99088cad4bbc00");
        String token = (String) FxqRquest.getToken(tr).getData();

        SmsSendReq ss = new SmsSendReq()
                .setContent("尊敬的用户，验证码是：1234")
                .setPhone("13128501234");
        ResultVO vo = FxqRquest.smsSend(ss,token);
        System.out.println(String.format("返回的数据为：%s",vo.toString()));
    }
}
