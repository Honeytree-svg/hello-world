package webserviceclient;

import main.java.xstream.OkHttpUtils;
import webserviceclient.entity.DeptInfo;
import webserviceclient.entity.FinalValue;
import webserviceclient.entity.Result;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class Okhttp {

    private static final String data = FinalValue.data;
    public static void main(String[] args) {

        //createXml();

        String input = new String(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<class_KD_INTERFACE_V3_result>\n" +
                        "    <data>"+data+"</data>\n" +
                        "    <resultCode>0</resultCode>\n" +
                        "    <resultMessage>sss</resultMessage>\n" +
                        "</class_KD_INTERFACE_V3_result>");

        String diff = " <diffgr:diffgram xmlns:msdata=\"urn:schemas-microsoft-com:xml-msdata\" xmlns:diffgr=\"urn:schemas-microsoft-com:xml-diffgram-v1\">\n" +
                "            <NewDataSet xmlns=\"\">\n" +
                "                <Table diffgr:id=\"Table1\" msdata:rowOrder=\"0\">\n" +
                "                    <deptId>3042</deptId>\n" +
                "                    <deptName>心血管内科二门诊</deptName>\n" +
                "                    <parentId>-1</parentId>\n" +
                "                </Table>\n" +
                "                <Table diffgr:id=\"Table2\" msdata:rowOrder=\"1\">\n" +
                "                    <deptId>3075</deptId>\n" +
                "                    <deptName>鉴定室</deptName>\n" +
                "                    <parentId>-1</parentId>\n" +
                "                </Table>\n" +
                "            </NewDataSet>\n" +
                "        </diffgr:diffgram>";


//        String data2 = input.split("<data>")[1].split("</data>")[0];
//        String main = data2.split("</xs:schema>")[1];
//        Map<String, Object> map = XmlUtil.xmlToMap(main);
//        Map<String, Object> tableMap = (Map<String, Object>)map.get("NewDataSet");
//        Object tableList = tableMap.get("Table");
//
//        String jsonString = JSONObject.toJSONString(tableList);
//        List<Table> tables = JSONObject.parseArray(jsonString, Table.class);
//        System.out.println(tables);

        String getdeptinfo = "<req><hospitalId>100448001</hospitalId>\n" +
                "\t<deptId/>\n" +
                "\t<deptType/>\n" +
                "</req>";
        String getSchedule = "<req>\n" +
                "<hospitalId>100448001</hospitalId>\n" +
                "<deptId>3003</deptId>\n" +
                "<deptType/>\n" +
                "<doctorId>0201</doctorId>\n" +
                "<searchCode></searchCode>\n" +
                "<startDate>2022-05-05</startDate>\n" +
                "<endDate>2022-05-12</endDate>\n" +
                "</req>";
        String getRegisterInfo ="<req>\n" +
               // "  <healthCardNo>V2918413</healthCardNo>\n" +
                "  <patientId>V2918413</patientId>\n" +
               // "  <patientName>李根</patientName>\n" +
              //  "  <idCardNo>412827199307032035</idCardNo>\n" +
                "</req>";
        String inputXml = "<req>"+
                "<hospitalId>100448001</hospitalId>"+
                "<scheduleId>蔡玉环</scheduleId>"+
                "<deptId>3003</deptId>"+
                "<doctorId>0201</doctorId>"+
                "<regDate>2022-05-05</regDate>"+
                "<shiftCode>2</shiftCode>"+
                "</req>";
        String inputXml2 = "<req>\n" +
                "  <hospitalId>100448001</hospitalId>\n" +
                "  <deptId>3020</deptId>\n" +
                "  <deptType></deptType>\n" +
                "  <doctorId></doctorId>\n" +
                "  <startDate>2022-05-05</startDate>\n" +
                "  <endDate>2022-05-12</endDate>\n" +
                "</req>";

        DeptInfo info = new DeptInfo();
        info.setHospitalId("100448001");
        JAXBContext jc = null;
        try {

            //OutputStream os = new ByteArrayOutputStream();
            StringWriter writer = new StringWriter();
            //根据Person类生成上下文对象
            jc = JAXBContext.newInstance(DeptInfo.class);
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
            ma.marshal(info, writer);
            getdeptinfo = writer.toString();
            System.out.println(getdeptinfo);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        String sync = OkHttpUtils.builder().url("http://222.138.30.213:83/KD_INTERFACE_V3.asmx/inMethon")
                .methonName("extend_inter.kd_interface_v3.appointment_getdeptinfo")
                .post(getdeptinfo)
                .sync();

        System.out.println(sync);
    }

    public static String createXml(){

        Result result = new Result();
        result.setResultCode("0");
        result.setResultMessage("sss");
        result.setData(data);

        JAXBContext jc = null;
        try {

            //OutputStream os = new ByteArrayOutputStream();
            StringWriter writer = new StringWriter();
            writer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "\n");
            //根据Person类生成上下文对象
            jc = JAXBContext.newInstance(Result.class);
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
            ma.marshal(result, writer);
            String s = writer.toString();
            System.out.println(s);
            return s;
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return "";
    }

    public static String doOkhttp(){

        String inputXml = "<req>\n" +
                "\t<hospitalId>100448001</hospitalId>\n" +
                "\t<scheduleId></scheduleId>\n" +
                "\t<deptId>7034229</deptId>\n" +
                "\t<clinicUnitId>401/clinicUnitId>\n" +
                "\t<doctorId>446</doctorId>\n" +
                "\t<regDate>2013-03-29</regDate>\n" +
                "\t<shiftCode>1</shiftCode>\n" +
                "</req>\n";
        OkHttpUtils post2 = OkHttpUtils.builder().url("http://222.138.30.213:83/KD_INTERFACE_V3.asmx/inMethon")
                .addRequestBody("MethonName=extend_inter.kd_interface_v3.appointment_getdeptinfo&InputXml=<req><hospitalId>100448001</hospitalId></req>")
                .post(false);

        String sync = post2.sync();
        System.out.println(sync);
        return sync;
    }

    public static <T> T generateBean(String beanStr, Class<T> bean) {

        JAXBContext jc = null;
        StringReader reader = new StringReader(beanStr);

        try {
            jc = JAXBContext.newInstance(bean);
            Unmarshaller uma = jc.createUnmarshaller();
            T result = (T) uma.unmarshal(reader);
            return result;
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return null;
    }
}
