package pacs;

import org.apache.commons.cli.ParseException;
import org.dcm4che3.data.Attributes;
import org.dcm4che3.data.Tag;
import org.dcm4che3.data.VR;
import org.dcm4che3.net.*;
import org.dcm4che3.net.pdu.AAssociateRQ;
import org.dcm4che3.net.pdu.PresentationContext;

import java.io.*;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class GetSCUTets {


    private final static String AE_Title = "JD_PacsServer";
    private final static String IP_Address = "192.168.1.9";
    private final static Integer Port = 3333;

    public static void main(String[] args) throws IOException, InterruptedException, IncompatibleConnectionException, GeneralSecurityException {

        // 1. A-ASSOCIATE main.java.request
        Device device = new Device("getscu");
        ApplicationEntity locAE = new ApplicationEntity("THIS_JAVA_APP");
        locAE.setSupportedCharacterSets("UTF-8");
        Connection conn = new Connection();
        Connection remote = new Connection();
        AAssociateRQ rq = new AAssociateRQ();

        device.addConnection(conn);
        device.addApplicationEntity(locAE);
        locAE.addConnection(conn);

        ApplicationEntity remAE = new ApplicationEntity();
        remAE.setAETitle(AE_Title);
        remAE.setSupportedCharacterSets("UTF-8");

        remote.setCommonName("rem_conn");
        remote.setHostname(IP_Address);
        remote.setPort(Port);
        remote.setProtocol(Connection.Protocol.DICOM);
        remAE.addConnection(remote);

        rq.setCalledAET(remAE.getAETitle());
        rq.setCallingAET(locAE.getAETitle());
        rq.setApplicationContext("1.2.840.10008.3.1.1.1");
        //rq.setImplClassUID("1.2.40.0.13.1.3");
        rq.setImplVersionName("dcm4che-3.3.7");
        rq.setMaxPDULength(16384);
        rq.setMaxOpsInvoked(0);
        rq.setMaxOpsPerformed(0);
        rq.addPresentationContext(new PresentationContext(
                1, "1.2.840.10008.5.1.4.1.2.2.3", "1.2.840.10008.1.2"));

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        device.setExecutor(executorService);
        device.setScheduledExecutor(scheduledExecutorService);

        //Opens association and connects to remote server
        Association as = locAE.connect(conn, remote, rq);

        // 2. C-GET main.java.request
        Attributes keys = new Attributes();
        keys.setString(Tag.StudyInstanceUID,VR.CS,"00856553");
        DimseRSPHandler rspHandler = new DimseRSPHandler(as.nextMessageID()) {

            @Override
            public void onDimseRSP(Association as, Attributes cmd,
                                   Attributes data) {
                super.onDimseRSP(as, cmd, data);
            }
        };

        as.cget("1.2.840.10008.5.1.4.1.2.2.3",0,keys,null,rspHandler);
        Socket socket = as.getSocket();
        byte[] bytes = new byte[1024];
        InputStream inputStream = socket.getInputStream();
//        ByteArrayOutputStream os = new ByteArrayOutputStream(1024);
//        int read = inputStream.read(bytes);
//        while (read != -1){
//            inputStream.read(bytes,0,read);
//            os.write(bytes);
//        }
//        os.toByteArray().toString();


        AAssociateRQ aAssociateRQ = as.getAAssociateRQ();
        PresentationContext context = aAssociateRQ.getPresentationContext(1);
        int result = context.getResult();
        System.out.println("==================================\n");
        System.out.println(context.toString());
        System.out.println("==================================\n");
        //as.release();
        // 3. A-RELEASE reqeust

    }

    private static void configureConnect(Connection conn, AAssociateRQ rq) throws ParseException {
        // 获取title属性值
        String title = "GetSCp";//修改成你的
        if (org.apache.commons.lang3.StringUtils.isBlank(title)) {
            throw new ParseException("title cannot be missing");
        }
        // 设置AE title
        rq.setCalledAET(title);
        // 读取host和port属性值
        String host = "172.16.117.112";//修改成你的
        String port = "10010";//修改成你的
        if (org.apache.commons.lang3.StringUtils.isBlank(host) || org.apache.commons.lang3.StringUtils.isBlank(port)) {
            throw new ParseException("host or port cannot be missing");
        }
        // 设置host和por
        conn.setHostname(host);
        conn.setPort(Integer.parseInt(port));
    }
}
