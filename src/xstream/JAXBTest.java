package xstream;

import com.thoughtworks.xstream.XStream;
import xstream.msg.H;
import xstream.msg.Root;
import xstream.msg.SMS;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLEventWriter;
import java.io.*;

public class JAXBTest {

    public static void main(String[] args) {

//        String s = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
//                "<Root>\n" +
//                "\t<SMS>\n" +
//                "\t\t<Return State=\"0\">提交成功（Base64编码）</Return>\n" +
//                "\t</SMS>\n" +
//                "</Root>\n";
//
//        int index = s.indexOf("State");
//        char c = s.charAt(index + 7);
//        System.out.println(c);

        JAXBTest jaxbTest = new JAXBTest();
        //jaxbTest.generateXML();
        jaxbTest.generateBean();
    }

    public void generateXML() {
        Root root = createRoot();

        JAXBContext jc = null;
        try {

            //OutputStream os = new ByteArrayOutputStream();
            StringWriter writer = new StringWriter();
            writer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "\n");
            //根据Person类生成上下文对象
            jc = JAXBContext.newInstance(Root.class);
            //从上下文中获取Marshaller对象，用作将bean编组(转换)为xml
            Marshaller ma = jc.createMarshaller();
            //以下是为生成xml做的一些配置
            //格式化输出，即按标签自动换行，否则就是一行输出
            ma.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //设置编码（默认编码就是utf-8）
            ma.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            //是否省略xml头信息，默认不省略（false）
            ma.setProperty(Marshaller.JAXB_FRAGMENT, true);

            //编组
            ma.marshal(root, writer);
            String s = writer.toString();
            System.out.println(s);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


    public void generateBean() {

        JAXBContext jc = null;
        String input = new String("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<Root>\n" +
                "\t<SMS>\n" +
                "\t\t<Return State=\"0\">提交成功（Base64编码）</Return>\n" +
                "\t</SMS>\n" +
                "</Root>");
        StringReader reader = new StringReader(input);

        try {
            jc = JAXBContext.newInstance(Root.class);
            Unmarshaller uma = jc.createUnmarshaller();
            Root root = (Root) uma.unmarshal(reader);
            System.out.println(root.getSMS().getReturn());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public Root createRoot(){

        Root root = new Root();
        SMS sms = new SMS();
        H h = new H();

        root.setVersion("2.0");
        root.setUser("username");
        root.setPWD("password");
        root.setUserType("8");
        root.setCorpCode("0000");
        root.setSMS(sms);

        sms.setM("content");
        sms.setH(h);

        h.setM("phone");

        return root;
    }
}