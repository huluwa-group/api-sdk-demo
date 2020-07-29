package cn.fangxinqian.api.sdk.demo.sign;

import cn.fangxinqian.api.sdk.FxqRquest;
import cn.fangxinqian.api.sdk.request.AreaReq;
import cn.fangxinqian.api.sdk.request.SignReq;
import cn.fangxinqian.api.sdk.request.SignerReq;
import cn.fangxinqian.api.sdk.utils.FileUtils;
import cn.fangxinqian.api.sdk.utils.ResultVO;

import java.io.IOException;
import java.util.Arrays;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @GitHub https://github.com/niezhiliang
 * @Date 2020/7/29 下午3:59
 * 合同签署
 */
public class SignDemo {

    private static final String TOKEN = "123456";

    private static final String CONTRACT_PDF = "./data/contract.pdf";

    private static final String SEAL_PERSONAL = "./data/personal.png";

    private static final String SEAL_COMPANY = "./data/company.png";

    public static void main(String[] args) throws IOException {

        /**
         * 区域签署
         */
        ResultVO resultVO = portSign();
        if (resultVO.getCode() == 10000) {
            System.out.println("区域签署成功，签署文件放data目录下。。。。");
            FileUtils.base642File("./data/portsigned.pdf",resultVO.getData().toString());
        } else {
            System.out.println("区域签署异常状态码：【"+resultVO.getCode() + "】错误信息：【" + resultVO.getMsg() + "】");
        }

        /**
         * 关键词签署
         */
        resultVO = keySign();
        if (resultVO.getCode() == 10000) {
            System.out.println("关键词签署成功，签署文件放data目录下。。。。");
            FileUtils.base642File("./data/keysigned.pdf",resultVO.getData().toString());
        } else {
            System.out.println("区域签署异常状态码：【"+resultVO.getCode() + "】错误信息：【" + resultVO.getMsg() + "】");
        }


        /**
         * 骑缝章签署
         */
        resultVO = gapSign();
        if (resultVO.getCode() == 10000) {
            System.out.println("骑缝章签署成功，签署文件放data目录下。。。。");
            FileUtils.base642File("./data/gapsigned.pdf",resultVO.getData().toString());
        } else {
            System.out.println("骑缝章签署异常状态码：【"+resultVO.getCode() + "】错误信息：【" + resultVO.getMsg() + "】");
        }

    }

    /**
     * 区域签署
     * @return
     * @throws IOException
     */
    private static ResultVO portSign() throws IOException {

        //个人区域
        AreaReq personalSeal = new AreaReq()
                //合同签署的页数
                .setPage(1)
                //签署位置左下角x坐标
                .setX(100f)
                //签署位置左下角y坐标
                .setY(100f);

        //企业区域
        AreaReq companySeal = new AreaReq()
                .setPage(1)
                .setX(300)
                .setY(300);

        //个人信息
        SignerReq personalSigner = new SignerReq()
                .setName("张三丰")
                //身份证号码
                .setIdno("362201198925153621")
                //签署图片
                .setSeal(FileUtils.path2Base64(SEAL_PERSONAL))
                //签署区域
                .setAreas(Arrays.asList(personalSeal));

        SignerReq companySigner = new SignerReq()
                .setName("浙江葫芦娃网络集团有限公司")
                //统一信用代码
                .setIdno("362201198925153621")
                .setSeal(FileUtils.path2Base64(SEAL_COMPANY))
                //骑缝章高度 不传不签署骑缝章
                .setHeight(200)
                .setAreas(Arrays.asList(companySeal));

        SignReq signReq = new SignReq()
                .setContract(FileUtils.path2Base64(CONTRACT_PDF))
                .setSigners(Arrays.asList(personalSigner,companySigner));

        return FxqRquest.signByPort(signReq,TOKEN);
    }


    /**
     * 关键词签署
     * @return
     * @throws IOException
     */
    private static ResultVO keySign() throws IOException {

        //个人信息
        SignerReq personalSigner = new SignerReq()
                .setName("张三丰")
                //身份证号码
                .setIdno("362201198925153621")
                //签署图片
                .setSeal(FileUtils.path2Base64(SEAL_PERSONAL))
                .setKey("甲方（盖章）");

        SignerReq companySigner = new SignerReq()
                .setName("浙江葫芦娃网络集团有限公司")
                //统一信用代码
                .setIdno("362201198925153621")
                .setSeal(FileUtils.path2Base64(SEAL_COMPANY))
                //骑缝章高度 不传不签署骑缝章
                .setHeight(200)
                .setKey("乙方（盖章）");

        SignReq signReq = new SignReq()
                .setContract(FileUtils.path2Base64(CONTRACT_PDF))
                //关键词向右移动的px 负数表示向左移动
                .setMove(10)
                .setSigners(Arrays.asList(personalSigner,companySigner));

        return FxqRquest.signByKey(signReq,TOKEN);
    }

    /**
     * 骑缝章签署
     * @return
     * @throws IOException
     */
    private static ResultVO gapSign() throws IOException {


        SignerReq companySigner = new SignerReq()
                .setName("浙江葫芦娃网络集团有限公司")
                //统一信用代码
                .setIdno("362201198925153621")
                .setSeal(FileUtils.path2Base64(SEAL_COMPANY))
                //骑缝章高度 不传不签署骑缝章
                .setHeight(200);

        SignReq signReq = new SignReq()
                .setContract(FileUtils.path2Base64(CONTRACT_PDF))
                .setSigners(Arrays.asList(companySigner));

        return FxqRquest.signByGap(signReq,TOKEN);
    }

}
