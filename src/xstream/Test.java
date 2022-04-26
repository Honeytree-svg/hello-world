package xstream;


import com.thoughtworks.xstream.XStream;
import xstream.msg.H;
import xstream.msg.Root;
import xstream.msg.SMS;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Test {


    public static void main(String[] args) throws UnsupportedEncodingException {

        String username = "root";
        String password = "123456";
        String ipAddress = "http://218.206.201.28:10657/";
        String serviceType = "SMS";

        String phone = "15958268657";
        String content = "test";

        String sendMsg = encryptBase64(createXml(username, password, "",phone,content));


//        OkHttpUtils post = OkHttpUtils.builder().url(ipAddress + serviceType)
//                .addHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8")
//                .addRequestBody(sendMsg)
//                .post(false);

        OkHttpUtils post2 = OkHttpUtils.builder().url("http://localhost:28089/getPEReport")
                .addParam("id","1812110003")
                .addRequestBody(sendMsg)
                .post(true);

        String sync = post2.sync();

        System.out.println(sync);
    }


    private static String encryptBase64(String data) throws UnsupportedEncodingException {

        byte[] bytes = data.getBytes("UTF-8");
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(bytes);
    }

    private static String createXml(String username,String password,String corpCode,String phone,String content){

        Root root = new Root();
        SMS sms = new SMS();
        H h = new H();

        root.setVersion("2.0");
        root.setUser(username);
        root.setPWD(password);
        root.setUserType("8");
        root.setCorpCode("0000");
        root.setSMS(sms);

        //sms.setM(content);
        sms.setH(h);

        h.setM(phone);

        XStream xStream = new XStream();
        xStream.alias("Root", Root.class);
        xStream.alias("SMS", SMS.class);

        xStream.useAttributeFor(Root.class, "version");
        xStream.useAttributeFor(Root.class, "User");
        xStream.useAttributeFor(Root.class, "PWD");
        xStream.useAttributeFor(Root.class, "UserType");
        xStream.useAttributeFor(Root.class, "CorpCode");

        xStream.useAttributeFor(H.class, "M");

        StringBuilder sb = new StringBuilder("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
        sb.append(xStream.toXML(root));

        return sb.toString();
    }
}
