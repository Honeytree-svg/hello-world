package webserviceclient.entity;

public class FinalValue {

    public static String data = "<xs:schema id=\"NewDataSet\" xmlns=\"\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" xmlns:msdata=\"urn:schemas-microsoft-com:xml-msdata\" xmlns:msprop=\"urn:schemas-microsoft-com:xml-msprop\">\n" +
            "            <xs:element name=\"NewDataSet\" msdata:IsDataSet=\"true\" msdata:MainDataTable=\"Table\" msdata:UseCurrentLocale=\"true\">\n" +
            "                <xs:complexType>\n" +
            "                    <xs:choice minOccurs=\"0\" maxOccurs=\"unbounded\">\n" +
            "                        <xs:element name=\"Table\" msprop:REFCursorName=\"REFCursor\">\n" +
            "                            <xs:complexType>\n" +
            "                                <xs:sequence>\n" +
            "                                    <xs:element name=\"deptId\" msprop:OraDbType=\"126\" type=\"xs:string\" minOccurs=\"0\" />\n" +
            "                                    <xs:element name=\"deptName\" msprop:OraDbType=\"126\" type=\"xs:string\" minOccurs=\"0\" />\n" +
            "                                    <xs:element name=\"deptType\" msprop:OraDbType=\"126\" type=\"xs:string\" minOccurs=\"0\" />\n" +
            "                                    <xs:element name=\"parentId\" msprop:OraDbType=\"104\" type=\"xs:string\" minOccurs=\"0\" />\n" +
            "                                    <xs:element name=\"description\" msprop:OraDbType=\"104\" type=\"xs:string\" minOccurs=\"0\" />\n" +
            "                                </xs:sequence>\n" +
            "                            </xs:complexType>\n" +
            "                        </xs:element>\n" +
            "                    </xs:choice>\n" +
            "                </xs:complexType>\n" +
            "            </xs:element>\n" +
            "        </xs:schema>\n" +
            "        <diffgr:diffgram xmlns:msdata=\"urn:schemas-microsoft-com:xml-msdata\" xmlns:diffgr=\"urn:schemas-microsoft-com:xml-diffgram-v1\">\n" +
            "            <NewDataSet xmlns=\"\">\n" +
            "                <Table diffgr:id=\"Table1\" msdata:rowOrder=\"0\">\n" +
            "                    <deptId>3001</deptId>\n" +
            "                    <deptName>针灸推拿科</deptName>\n" +
            "                    <parentId>-1</parentId>\n" +
            "                </Table>\n" +
            "                <Table diffgr:id=\"Table2\" msdata:rowOrder=\"1\">\n" +
            "                    <deptId>3003</deptId>\n" +
            "                    <deptName>眼科门诊</deptName>\n" +
            "                    <parentId>-1</parentId>\n" +
            "                </Table>\n" +
            "            </NewDataSet>\n" +
            "        </diffgr:diffgram>";
}
