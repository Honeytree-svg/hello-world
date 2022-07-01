package pacs;

public class GetSCU2 {
//    private static final Logger LOG = LoggerFactory.getLogger(GetSCU2.class);
//    public static enum InformationModel {
//        PatientRoot(UID.PatientRootQueryRetrieveInformationModelGET, "STUDY"),
//        StudyRoot(UID.StudyRootQueryRetrieveInformationModelGET, "STUDY"),
//        PatientStudyOnly(UID.PatientStudyOnlyQueryRetrieveInformationModelGETRetired, "STUDY"),
//        CompositeInstanceRoot(UID.CompositeInstanceRootRetrieveGET, "IMAGE"),
//        WithoutBulkData(UID.CompositeInstanceRetrieveWithoutBulkDataGET, null),
//        HangingProtocol(UID.HangingProtocolInformationModelGET, null);
//        //ColorPalette(UID.ColorPaletteQueryRetrieveInformationModelGET, null);
//
//        private final String cuid;
//        private final String level;
//
//        InformationModel(String cuid, String level) {
//            this.cuid = cuid;
//            this.level = level;
//        }
//
//        public void adjustQueryOptions(EnumSet<QueryOption> queryOptions) {
//            if (level == null) {
//                queryOptions.add(QueryOption.RELATIONAL);
//                queryOptions.add(QueryOption.DATETIME);
//            }
//        }
//    }
//
//
//    private static ResourceBundle rb =
//            ResourceBundle.getBundle("message");
//
//    private static final int[] DEF_IN_FILTER = {
//            Tag.SOPInstanceUID,
//            Tag.StudyInstanceUID,
//            Tag.SeriesInstanceUID
//    };
//
//    private final Device device = new Device("getscu");
//    private final ApplicationEntity ae;
//    private final Connection conn = new Connection();
//    private final Connection remote = new Connection();
//    private final AAssociateRQ rq = new AAssociateRQ();
//    private int priority;
//    private InformationModel model;
//    private Attributes keys = new Attributes();
//    private int[] inFilter = DEF_IN_FILTER;
//    private Association as;
//    private int cancelAfter;
//
//    private static String[] IVR_LE_FIRST = new String[]{"1.2.840.10008.1.2", "1.2.840.10008.1.2.1",
//            "1.2.840.10008.1.2.2"};
//
//
//    private static final String DCM_EXT = ".dcm";
//    private String storageDir = "D:/upload/dicom/"; //接收到dicom文件的存储目录
////private String storageDir = "/data/service/upload/dicom/"; //接收到dicom文件的存储目录
//
//    private BasicCStoreSCP storageSCP = new BasicCStoreSCP("*") {
//
//
//        public void onClose(Association as) {
//            //一次信息传输结束,开始AI分析
//            //查询study表中所有待分析的数据,进行AI分析
//        }
//    };
//
//    public GetSCU2() throws IOException {
//        ae = new ApplicationEntity("GETSCU");
//        device.addConnection(conn);
//        device.addApplicationEntity(ae);
//        ae.addConnection(conn);
//        device.setDimseRQHandler(createServiceRegistry());
//    }
//
//    public ApplicationEntity getApplicationEntity() {
//        return ae;
//    }
//
//    public Connection getRemoteConnection() {
//        return remote;
//    }
//
//    public AAssociateRQ getAAssociateRQ() {
//        return rq;
//    }
//
//    public Association getAssociation() {
//        return as;
//    }
//
//    public Device getDevice() {
//        return device;
//    }
//
//    public Attributes getKeys() {
//        return keys;
//    }
//
//
//
//    private DicomServiceRegistry createServiceRegistry() {
//        DicomServiceRegistry serviceRegistry = new DicomServiceRegistry();
//        serviceRegistry.addDicomService(storageSCP);
//        return serviceRegistry;
//    }
//
//    public final void setPriority(int priority) {
//        this.priority = priority;
//    }
//    private void setInformationModel(InformationModel model, String[] tss, EnumSet<QueryOption> queryOptions) {
//        this.model = model;
//        rq.addPresentationContext(new PresentationContext(1, model.cuid, tss));
//        if (!queryOptions.isEmpty()) {
//            model.adjustQueryOptions(queryOptions);
//            rq.addExtendedNegotiation(
//                    new ExtendedNegotiation(model.cuid, QueryOption.toExtendedNegotiationInformation(queryOptions)));
//        }
//        if (model.level != null)
//            addLevel(model.level);
//    }
//
//    public void addLevel(String s) {
//        keys.setString(Tag.QueryRetrieveLevel, VR.CS, s);
//    }
//
//    public void addKey(int tag, String... ss) {
//        VR vr = ElementDictionary.vrOf(tag, keys.getPrivateCreator(tag));
//        keys.setString(tag, vr, ss);
//    }
//
//    public final void setInputFilter(int[] inFilter) {
//        this.inFilter  = inFilter;
//    }
//
//
//    /**
//     * 配置远程连接
//     *
//     * @param conn Connection
//     * @param rq   AAssociateRQ
//     */
//    private static void configureConnect(Connection conn, AAssociateRQ rq) throws ParseException {
//        // 获取title属性值
//        String title = "GetSCp";//修改成你的
//        if (org.apache.commons.lang3.StringUtils.isBlank(title)) {
//            throw new ParseException("title cannot be missing");
//        }
//        // 设置AE title
//        rq.setCalledAET(title);
//        // 读取host和port属性值
//        String host = "172.16.117.112";//修改成你的
//        String port = "10010";//修改成你的
//        if (org.apache.commons.lang3.StringUtils.isBlank(host) || org.apache.commons.lang3.StringUtils.isBlank(port)) {
//            throw new ParseException("host or port cannot be missing");
//        }
//        // 设置host和por
//        conn.setHostname(host);
//        conn.setPort(Integer.parseInt(port));
//    }
//    private void configureKeys(Attributes keys) {
//        this.keys.addAll(keys);
//    }
//    private static EnumSet<QueryOption> queryOptionsOf() {
//        return EnumSet.noneOf(QueryOption.class);
//    }
//
//    /**
//     * 设置Information Model
//     *
//     * @param main
//     * @throws ParseException
//     */
//    private static void configureServiceClass(GetSCU2 main) throws ParseException {
//        main.setInformationModel(informationModelOf(), IVR_LE_FIRST, queryOptionsOf());
//    }
//    private static InformationModel informationModelOf() throws ParseException {
//        try {
//            String model = rb.getString("model");
//            // 如果model为空，默认StudyRoot
//            return StringUtils.isBlank(model) ? InformationModel.valueOf(model) : InformationModel.StudyRoot;
//        } catch (IllegalArgumentException e) {
//            throw new ParseException(MessageFormat.format(rb.getString("invalid-model-name"), rb.getString("model")));
//        }
//    }
//    private static void configureRetrieve(GetSCU2 main) {
//        if (StringUtils.isNotBlank(rb.getString("level"))) {
//            // Retrieve是指SCU通过Query 拿到信息后，要求对方根据请求级别 (Patient/Study/Series/Image) 发送影像给己方。
//            // 默认Patient
//            main.addLevel(rb.getString("level"));
//        }
//    }
//    private static int priorityOf() {
//        String high = rb.getString("prior-high");
//        String low = rb.getString("prior-low");
//        return StringUtils.isNotBlank(high) ? 1 : (StringUtils.isNotBlank(low) ? 2 : 0);
//    }
//
//    public static void matchingKeys(Attributes attrs) {
//        try {
//            GetSCU2 main = new GetSCU2();
//            configureConnect(main.remote, main.rq); // 设置连接ip和端口 (远程)
//            main.remote.setTlsProtocols(main.conn.getTlsProtocols()); // 设置Tls协议
//            main.remote.setTlsCipherSuites(main.conn.getTlsCipherSuites());
//            configureServiceClass(main); // 设置Information Model
//            configureRetrieve(main); // 设置检索级别
//            //configureCancel(main); // 配置 --cancel
//            main.setPriority(priorityOf()); // 设置优先级
//            ExecutorService executorService = Executors.newSingleThreadExecutor(); // 单线程化线程池
//            ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(); // 定时任务
//            main.device.setExecutor(executorService);
//            main.device.setScheduledExecutor(scheduledExecutorService);
//            try {
//                main.open(); // 打开链接
//                main.configureKeys(attrs);
//                main.retrieve(); // 查询
//            } finally {
//                main.close();
//                executorService.shutdown();
//                scheduledExecutorService.shutdown();
//            }
//        } catch (ParseException | InterruptedException | IncompatibleConnectionException | GeneralSecurityException
//                | IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public void close() throws IOException, InterruptedException {
//        if (as != null && as.isReadyForDataTransfer()) {
//            as.waitForOutstandingRSP();
//            as.release();
//        }
//    }
//
//    public static void main (String[]args){
//        try {
//            Attributes attrs = new Attributes();
//            //attrs.setString(Tag.ModalitiesInStudy, VR.CS, "CT");
//            attrs.setString(Tag.StudyInstanceUID,VR.CS,"1.2.840.31314.14143234.20210201000000.380809");
//            GetSCU2.matchingKeys(attrs);
//        } catch (Exception e) {
//            System.err.println("getscu: " + e.getMessage());
//            e.printStackTrace();
//            System.exit(2);
//        }
//    }
//
//    private void open()
//            throws IOException, InterruptedException, IncompatibleConnectionException, GeneralSecurityException {
//        as = ae.connect(conn, remote, rq);
//    }
//    public void retrieve() throws IOException, InterruptedException {
//        retrieve(keys);
//    }
//
//    private void retrieve(Attributes keys) throws IOException, InterruptedException {
//        final DimseRSPHandler rspHandler = new DimseRSPHandler(as.nextMessageID()) {
//
//            @Override
//            public void onDimseRSP(Association as, Attributes cmd,
//                                   Attributes data) {
//                super.onDimseRSP(as, cmd, data);
//            }
//        };
//
//        retrieve (keys, rspHandler);
//    }
//
//    public void retrieve(DimseRSPHandler rspHandler) throws IOException, InterruptedException {
//        retrieve(keys, rspHandler);
//    }
//
//    private void retrieve(Attributes keys, DimseRSPHandler rspHandler) throws IOException, InterruptedException {
//        as.cget(model.cuid, priority, keys, null, rspHandler);
//    }
}
