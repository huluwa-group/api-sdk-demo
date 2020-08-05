package cn.fangxinqian.api.sdk.demo.pb;

import cn.fangxinqian.api.sdk.FxqRquest;
import cn.fangxinqian.api.sdk.request.CompanyAuth3Req;
import cn.fangxinqian.api.sdk.request.PublicBankReq;
import cn.fangxinqian.api.sdk.request.TokenReq;
import cn.fangxinqian.api.sdk.utils.ResultVO;

import java.io.IOException;

/**
 * @author mqz
 * @description
 * @since 2020/8/4
 */
public class PublicBankPaymentDemo {

    public static void main(String[] args) throws IOException {
        TokenReq tr = new TokenReq()
                .setKey("xcv123df4l")
                .setSecret("f60e1961fb788d2bbd99088cad4bbc00");
        String token = (String) FxqRquest.token(tr).getData();

        PublicBankReq pb = new PublicBankReq()
                .setNo("123526364077430325C")
                .setAccountName("蒙大拿")
                .setBankName("中国工商银行");
        ResultVO vo = FxqRquest.publicBankPayment(pb,token);
        System.out.println(String.format("返回的数据为：%s",vo.toString()));
    }
}
