package pacs;

import org.dcm4che3.data.Tag;
import org.dcm4che3.net.*;
import org.dcm4che3.net.pdu.AAssociateRQ;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class TTT {

    private final static String AE_Title = "JD_PacsServer";
    private final static String IP_Address = "192.168.1.9";
    private final static Integer Port = 3333;

    public static void main(String[] args) throws IOException, IncompatibleConnectionException, GeneralSecurityException, InterruptedException {

        CustomerGetSCU scu = new CustomerGetSCU();

        ApplicationEntity locAE = scu.getApplicationEntity();
        //locAE.setSupportedCharacterSets("UTF-8");
        Connection conn = new Connection();
        conn.setCommonName("lcoal");
        conn.setHostname("localhost");
        conn.setPort(29812);
        conn.setProtocol(Connection.Protocol.DICOM);

        Device device = scu.getDevice();
        device.addConnection(conn);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        device.setExecutor(executorService);
        device.setScheduledExecutor(scheduledExecutorService);

        locAE.addConnection(conn);
        // new 了一个PresentationContext
        //scu.setInformationModel(GetSCU.InformationModel.StudyRoot,new String[]{"1.2.840.10008.1.2"},false);

        Connection remote = scu.getRemoteConnection();
        remote.setCommonName("rem_conn");
        remote.setHostname(IP_Address);
        remote.setPort(Port);
        remote.setProtocol(Connection.Protocol.DICOM);

        ApplicationEntity remAE = new ApplicationEntity();
        remAE.setAETitle(AE_Title);
       // remAE.setSupportedCharacterSets("UTF-8");
        remAE.addConnection(remote);

        AAssociateRQ rq = scu.getAAssociateRQ();
        rq.setCalledAET(remAE.getAETitle());
        rq.setCallingAET(locAE.getAETitle());
//        rq.setApplicationContext("1.2.840.10008.3.1.1.1");
//        //rq.setImplClassUID("1.2.40.0.13.1.3");
//        rq.setImplVersionName("dcm4che-3.3.7");
//        //rq.setMaxPDULength(16384);
//        rq.setMaxOpsInvoked(0);
//        rq.setMaxOpsPerformed(0);
//        rq.addPresentationContext(new PresentationContext(
//                1, "1.2.840.10008.5.1.4.1.2.2.3", "1.2.840.10008.1.2"));



        scu.setStorageDirectory(new File("D:\\TESTPANDA"));
        scu.setPriority(0);
        scu.addKey(Tag.StudyInstanceUID,"00856553");
        scu.open();
        File file = new File("D:\\TESTPANDA\\" + UUID.randomUUID().toString() + ".dicom");
        file.createNewFile();
        scu.retrieve();
        //GetSCU.main(new String[]{"-c","JD_PacsServer@192.168.1.9:3333","-m","StudyID=05572224"});
    }
}
