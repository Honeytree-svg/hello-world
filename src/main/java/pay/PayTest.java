package main.java.pay;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeCreateRequest;
import com.alipay.api.response.AlipayTradeCreateResponse;

public class PayTest {

    public static void main(String[] args) throws AlipayApiException {
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do","app_id","your private_key","json","UTF-8","alipay_public_key","RSA2");
        AlipayTradeCreateRequest request = new AlipayTradeCreateRequest();
        request.setNotifyUrl("");
        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", "20210817010101003");
        bizContent.put("total_amount", 0.00);
        bizContent.put("subject", "测试商品");
        bizContent.put("buyer_id", "2088102146225135");
        bizContent.put("timeout_express", "10m");


        request.setBizContent(bizContent.toString());
        AlipayTradeCreateResponse response = alipayClient.execute(request);
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
    }
}
