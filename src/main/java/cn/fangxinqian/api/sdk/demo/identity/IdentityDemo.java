package cn.fangxinqian.api.sdk.demo.identity;

import cn.fangxinqian.api.sdk.FxqRquest;
import cn.fangxinqian.api.sdk.request.*;
import cn.fangxinqian.api.sdk.utils.ResultVO;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author mqz
 * @description
 * @since 2020/8/4
 */
@Slf4j
public class IdentityDemo {

    static class Identity2{
        public static void main(String[] args) throws IOException {
            TokenReq tr = new TokenReq()
                    .setKey("xcv123df4l")
                    .setSecret("f60e1961fb788d2bbd99088cad4bbc00");
            String token = (String) FxqRquest.token(tr).getData();

            Identity2Req i2 = new Identity2Req()
                    .setIdCardNo("360731199602030212")
                    .setRealName("蒙大拿");
            ResultVO vo = FxqRquest.identity2(i2,token);
            System.out.println(String.format("返回的数据为：%s",vo.toString()));
        }
    }

    static class Identity3{
        public static void main(String[] args) throws IOException {
            TokenReq tr = new TokenReq()
                    .setKey("xcv123df4l")
                    .setSecret("f60e1961fb788d2bbd99088cad4bbc00");
            String token = (String) FxqRquest.token(tr).getData();
            Identity3Req i3 = new Identity3Req()
                    .setIdCardNo("360731199602030212")
                    .setRealName("蒙大拿")
                    .setMobile("13128501234");
            ResultVO vo = FxqRquest.identity3(i3,token);
            System.out.println(String.format("返回的数据为：%s",vo.toString()));
        }
    }


}
