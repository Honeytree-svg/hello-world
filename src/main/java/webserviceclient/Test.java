package webserviceclient;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();

        String inputXml = "<req>\n" +
                "  <hospitalId>100448001</hospitalId>\n" +
                "  <deptId></deptId>\n" +
                "  <deptType></deptType>\n" +
                "</req>";

        String paramXml ="<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:tem=\"http://tempuri.org/\">\n" +
                "   <soap:Header/>\n" +
                "   <soap:Body>\n" +
                "      <inMethon>\n" +
                "         <!--Optional:-->\n" +
                "         <MethonName>extend_inter.kd_interface_v3.appointment_getdeptinfo</MethonName>\n" +
                "         <!--Optional:-->\n" +
                "         <InputXml><req><hospitalId>100448001</hospitalId></req></InputXml>\n" +
                "      </inMethon>\n" +
                "   </soap:Body>\n" +
                "</soap:Envelope>";

        String webservice = "http://222.138.30.213:83/KD_INTERFACE_V3.asmx/inMethon ";
        String methonName = "extend_inter.kd_interface_v3.appointment_getdeptinfo";
        HttpHeaders headers = new HttpHeaders();
        Map<String,String> map = new HashMap<>();
        map.put("MethonName",methonName);
        map.put("InputXml","<req><hospitalId>100448001</hospitalId></req>");
        headers.setContentType(org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED);
        ResponseEntity<String> responseEntity = restTemplate.exchange(webservice, HttpMethod.POST,
                new HttpEntity<>(map, headers), String.class);

        String body = responseEntity.getBody();

    }
}
