package cn.fangxinqian.api.sdk.demo.ocr;

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
public class OcrDemo {

    static class OcrBusinessLicense{
        public static void main(String[] args) throws IOException {
            TokenReq tr = new TokenReq()
                    .setKey("xcv123df4l")
                    .setSecret("f60e1961fb788d2bbd99088cad4bbc00");
            String token = (String) FxqRquest.token(tr).getData();

            OcrReq ocr = new OcrReq().setImage("*********");
            ResultVO vo = FxqRquest.ocrBusinessLicense(ocr,token);
            System.out.println(String.format("返回的数据为：%s",vo.toString()));
        }
    }

    static class OcrIdCard{
        public static void main(String[] args) throws IOException {
            TokenReq tr = new TokenReq()
                    .setKey("xcv123df4l")
                    .setSecret("f60e1961fb788d2bbd99088cad4bbc00");
            String token = (String) FxqRquest.token(tr).getData();
            OcrIdCardReq oic = new OcrIdCardReq()
                    .setIdCardSide("front")
                    .setImage("*********");
            ResultVO vo = FxqRquest.ocrIdCard(oic,token);
            System.out.println(String.format("返回的数据为：%s",vo.toString()));
        }
    }

    static class OcrVehicleLicense{
        public static void main(String[] args) throws IOException {
            TokenReq tr = new TokenReq()
                    .setKey("xcv123df4l")
                    .setSecret("f60e1961fb788d2bbd99088cad4bbc00");
            String token = (String) FxqRquest.token(tr).getData();
            OcrReq ocr = new OcrReq().setImage("*********");
            ResultVO vo = FxqRquest.ocrVehicleLicense(ocr,token);
            System.out.println(String.format("返回的数据为：%s",vo.toString()));
        }
    }

    static class OcrDriveLicense{
        public static void main(String[] args) throws IOException {
            TokenReq tr = new TokenReq()
                    .setKey("xcv123df4l")
                    .setSecret("f60e1961fb788d2bbd99088cad4bbc00");
            String token = (String) FxqRquest.token(tr).getData();
            OcrReq ocr = new OcrReq().setImage("*********");
            ResultVO vo = FxqRquest.ocrDriveLicense(ocr,token);
            System.out.println(String.format("返回的数据为：%s",vo.toString()));
        }
    }

    static class OcrBankCard{
        public static void main(String[] args) throws IOException {
            TokenReq tr = new TokenReq()
                    .setKey("xcv123df4l")
                    .setSecret("f60e1961fb788d2bbd99088cad4bbc00");
            String token = (String) FxqRquest.token(tr).getData();
            OcrReq ocr = new OcrReq().setImage("*********");
            ResultVO vo = FxqRquest.ocrBankCard(ocr,token);
            System.out.println(String.format("返回的数据为：%s",vo.toString()));
        }
    }


}
