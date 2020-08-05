package cn.fangxinqian.api.sdk.demo.company;

import cn.fangxinqian.api.sdk.FxqRquest;
import cn.fangxinqian.api.sdk.request.BankCard3Req;
import cn.fangxinqian.api.sdk.request.CompanyAuth3Req;
import cn.fangxinqian.api.sdk.request.TokenReq;
import cn.fangxinqian.api.sdk.utils.ResultVO;

import java.io.IOException;

/**
 * @author mqz
 * @description
 * @since 2020/8/4
 */
public class CompanyAuth3Demo {

    public static void main(String[] args) throws IOException {
        TokenReq tr = new TokenReq()
                .setKey("xcv123df4l")
                .setSecret("f60e1961fb788d2bbd99088cad4bbc00");
        String token = (String) FxqRquest.token(tr).getData();

        CompanyAuth3Req ca3 = new CompanyAuth3Req()
                .setKeyword("123526364077430325C")
                .setName("大拿网络科技有限公司")
                .setLegalPerson("蒙大拿");
        ResultVO vo = FxqRquest.companyAuth3(ca3,token);
        System.out.println(String.format("返回的数据为：%s",vo.toString()));
    }
}
