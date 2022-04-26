package xstream;

import com.thoughtworks.xstream.XStream;
import xstream.msg.H;
import xstream.msg.Root;
import xstream.msg.SMS;

import java.io.FileNotFoundException;

public class Xml {

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println(createXml());
    }

    private static String createXml(){

        Root root = new Root();
        SMS sms = new SMS();
        H h = new H();
        //M m = new M();

        root.setVersion("2.0");
        root.setUser("ssss");
        root.setPWD("12134");
        root.setUserType("8");
        root.setCorpCode("0000");
        root.setSMS(sms);

        sms.setM("contnt");
        sms.setH(h);

        //m.setM("content");
        h.setM("phone");

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

        XStream xStream1 = new XStream();
        Object o = xStream1.fromXML(sb.toString());
        return sb.toString();
    }
}
