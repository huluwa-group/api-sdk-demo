package cn.fangxinqian.api.sdk.demo.bkc;

import cn.fangxinqian.api.sdk.FxqRquest;
import cn.fangxinqian.api.sdk.request.BankCard3Req;
import cn.fangxinqian.api.sdk.request.BankCard4Req;
import cn.fangxinqian.api.sdk.request.TokenReq;
import cn.fangxinqian.api.sdk.utils.ResultVO;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author mqz
 * @description
 * @since 2020/8/4
 */
@Slf4j
public class BankCardDemo {

    static class BankCard3{
        public static void main(String[] args) throws IOException {
            TokenReq tr = new TokenReq()
                    .setKey("xcv123df4l")
                    .setSecret("f60e1961fb788d2bbd99088cad4bbc00");
            String token = (String) FxqRquest.token(tr).getData();

            BankCard3Req bc3 = new BankCard3Req()
                    .setBankCardNo("123456789012345678")
                    .setIdCardNo("360731199602030212")
                    .setName("蒙大拿");
            ResultVO vo = FxqRquest.bankCard3(bc3,token);
            System.out.println(String.format("返回的数据为：%s",vo.toString()));
        }
    }

    static class BankCard4{
        public static void main(String[] args) throws IOException {
            TokenReq tr = new TokenReq()
                    .setKey("xcv123df4l")
                    .setSecret("f60e1961fb788d2bbd99088cad4bbc00");
            String token = (String) FxqRquest.token(tr).getData();
            BankCard4Req bc4 = new BankCard4Req()
                    .setBankCardNo("123456789012345678")
                    .setIdCardNo("360731199602030212")
                    .setName("蒙大拿")
                    .setMobile("13128501234");
            ResultVO vo = FxqRquest.bankCard4(bc4,token);
            System.out.println(String.format("返回的数据为：%s",vo.toString()));
        }
    }


}
