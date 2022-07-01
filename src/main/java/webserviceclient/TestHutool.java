package webserviceclient;

import cn.hutool.http.webservice.SoapClient;

import java.util.HashMap;

public class TestHutool {

    public static void main(String[] args) {

        SoapClient soapClient = SoapClient.create("http://222.138.30.213:83/KD_INTERFACE_V3.asmx");
        soapClient.setMethod("inMethon","http://tempuri.org/");

        HashMap<String, Object> param = new HashMap<>();
        param.put("MethonName","extend_inter.kd_interface_v3.appointment_getdeptinfo");
        param.put("InputXml","<req><hospitalId>100448001</hospitalId></req>");
        soapClient.setParams(param);
        //soapClient.setParam("MethonName","extend_inter.kd_interface_v3.appointment_getdeptinfo");
        //soapClient.setParam("InputXml","<req><hospitalId>100448001</hospitalId></req>");
        String send = soapClient.send(true);
        System.out.println(send);
    }
}
