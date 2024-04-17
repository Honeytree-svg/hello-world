package pdf;

import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreatePdf {
    public static void main(String[] args) throws Exception {

//        ClassPathResource classPathResource = new ClassPathResource("template/" + "title.ftl");
//        //获取文件
//        File file = classPathResource.getFile();
//        //获取路径
//        String path = classPathResource.getPath();
//        System.out.println("path:" + path);
//        //System.out.println("file:" + file);

        createPdf();
    }

    /**
     * Adobe Acrobat Pro DC 创建模板
     *
     * @throws Exception
     */
    public static void createPdf() throws Exception {
        // 填充创建pdf
        PdfReader reader = null;
        PdfStamper stamp = null;
        String pdfTemplatePath = "template/title.ftl";
        String createPath = "D:/";
        try {
            reader = new PdfReader(pdfTemplatePath);
            String time = new SimpleDateFormat("dd-HH-mm-ss").format(new Date());
            // 创建生成报告名称
            File stampFile = new File(createPath, time + ".pdf");
            stamp = new PdfStamper(reader, new FileOutputStream(stampFile));
            // 取出报表模板中的所有字段
            AcroFields form = stamp.getAcroFields();
            // 填充数据，对应文本域名称
            form.setField("index", "1");
            form.setField("phone", "21");
            form.setField("hobby", "91");

            // 插入图片
//            int pageNo = form.getFieldPositions("image").get(0).page;
//            Rectangle signRect = form.getFieldPositions("image").get(0).position;
//            float x = signRect.getLeft();
//            float y = signRect.getBottom();
            // 图片路径，url或绝对路径都可
            //Image image = Image.getInstance("https://pics1.baidu.com/feed/f2deb48f8c5494ee9189fe82cd246ff89b257ede.jpeg?token=e5fe9ba1fd2d2324f8981468d8ad329a");
            // 获取操作的页面
            //PdfContentByte under = stamp.getOverContent(pageNo);
            // 根据域的大小缩放图片
            //image.scaleToFit(signRect.getWidth(), signRect.getHeight());
            // 添加图片
            //image.setAbsolutePosition(x, y);
            //under.addImage(image);

            // 这里true表示pdf可编辑
            stamp.setFormFlattening(true);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stamp != null) {
                stamp.close();
            }
            if (reader != null) {
                reader.close();
            }
        }
    }

}

