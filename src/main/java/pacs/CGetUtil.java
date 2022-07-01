package pacs;

public class CGetUtil {

    private final static String AE_Title = "JD_PacsServer";
    private final static String IP_Address = "192.168.1.9";
    private final static Integer Port = 3333;

    public static void get(String aeTitle,String ip,String port,String studyInstanceUID,String directory){

        String server = "%s@%s:%s";
        String[] param = {"-b","GETSCU@192.168.221.5:28087","-c",String.format(server, aeTitle,ip,port),"-m","StudyInstanceUID="+studyInstanceUID,"--directory",directory};
        CustomerGetSCU.main(param);
    }
}
