package pacs;

import pacs.CGetUtil;

public class Test {

    private final static String AE_Title = "JD_PacsServer";
    private final static String IP_Address = "192.168.1.9";
    private final static String Port = "3333";

    public static void main(String[] args) {

        String directory = "D:\\dicomPDF";
        CGetUtil.get(AE_Title,IP_Address,Port,"10879423",directory);
    }
}
