package cn.fangxinqian.api.sdk.demo.template;

import cn.fangxinqian.api.sdk.FxqRquest;
import cn.fangxinqian.api.sdk.request.ReplaceReq;
import cn.fangxinqian.api.sdk.utils.FileUtils;
import cn.fangxinqian.api.sdk.utils.ResultVO;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @GitHub https://github.com/niezhiliang
 * @Date 2020/7/29 下午2:24
 */
public class TemplateDemo {

    private static final String TEMPLATE_PDF = "./data/test.pdf";

    private static final String TEMPLATE_DOCX = "./data/test.docx";

    private static final String TOKEN = "123456.123456.123456";

    public static void main(String[] args) throws IOException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name1","测试公司");
        jsonObject.put("name2","测试乙方公司");
        jsonObject.put("address1","浙江省杭州市江干区");
        jsonObject.put("address2","浙江省杭州市江干区下沙街道");


        ResultVO resultVO = docxTeplate(jsonObject);
        if (resultVO.getCode() == 10000) {
            System.out.println("docx替换成功，文件放data目录下。。。。");
            FileUtils.base642File("./data/success.docx",resultVO.getData().toString());
        } else {
            System.out.println("替换异常状态码：【"+resultVO.getCode() + "】错误信息：【" + resultVO.getMsg() + "】");
        }

        resultVO = pdfTeplate(jsonObject);
        if (resultVO.getCode() == 10000) {
            System.out.println("pdf替换成功。。。。");
            System.out.println(resultVO.getData());
        } else {
            System.out.println("替换异常状态码：【"+resultVO.getCode() + "】错误信息：【" + resultVO.getMsg() + "】");
        }

    }


    /**
     * pdf模板替换，使用这个要注意关键词不能使用
     * 一些特定的字母具体参考开放平台接口文档
     * @param object
     * @return
     * @throws IOException
     */
    public static ResultVO pdfTeplate(Object object) throws IOException {
        ReplaceReq req = new ReplaceReq()
                .setContract(FileUtils.path2Base64(TEMPLATE_PDF))
                //0返回base64 1返回oss地址
                .setRtype(1)
                .setReplaces(object);
        return FxqRquest.templatePdf(req,TOKEN);
    }

    /**
     * docx关键词替换
     * @param object
     * @return
     * @throws IOException
     */
    public static ResultVO docxTeplate(Object object) throws IOException {
        ReplaceReq req = new ReplaceReq()
                .setContract(FileUtils.path2Base64(TEMPLATE_DOCX))
                //0返回base64 1返回oss地址
                .setRtype(0)
                .setReplaces(object);
        return FxqRquest.templateDocx(req,TOKEN);
    }

}
