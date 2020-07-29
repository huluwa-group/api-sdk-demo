package cn.fangxinqian.api.sdk.demo.seal;

import cn.fangxinqian.api.sdk.FxqRquest;
import cn.fangxinqian.api.sdk.request.SealReq;
import cn.fangxinqian.api.sdk.utils.FileUtils;
import cn.fangxinqian.api.sdk.utils.ResultVO;

import java.io.IOException;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @GitHub https://github.com/niezhiliang
 * @Date 2020/7/29 下午3:36
 */
public class SealDemo {

    private static final String TOKEN = "123456.123456.123456";

    public static void main(String[] args) throws IOException {
        /**
         * 个人签章生成
         */
        ResultVO resultVO = personal();
        if (resultVO.getCode() == 10000) {
            System.out.println("个人签章生成成功，文件放data目录下。。。。");
            FileUtils.base642File("./data/personal.png",resultVO.getData().toString());
        } else {
            System.out.println("替换异常状态码：【"+resultVO.getCode() + "】错误信息：【" + resultVO.getMsg() + "】");
        }

        /**
         * 企业公章生成
         */
        resultVO = company();
        if (resultVO.getCode() == 10000) {
            System.out.println("企业签章生成成功，文件放data目录下。。。。");
            String base64 = resultVO.getData().toString();
            FileUtils.base642File("./data/company.png",base64.substring(base64.lastIndexOf(",")+1));
        } else {
            System.out.println("替换异常状态码：【"+resultVO.getCode() + "】错误信息：【" + resultVO.getMsg() + "】");
        }


    }

    /**
     * 生成个人章
     * @return
     * @throws IOException
     */
    public static ResultVO personal() throws IOException {
        SealReq sealReq = new SealReq()
                .setName("张三丰");

        return FxqRquest.sealPersonal(sealReq,TOKEN);
    }

    /**
     * 生成企业公章
     * @return
     * @throws IOException
     */
    public static ResultVO company() throws IOException {
        SealReq sealReq = new SealReq()
                .setName("浙江葫芦娃网络集团有限公司")
                .setTitle("合同专用章")
                .setSeqNo("1234567899876");

        return FxqRquest.sealCompany(sealReq,TOKEN);
    }
}
