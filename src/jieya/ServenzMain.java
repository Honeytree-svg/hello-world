package jieya;

import cn.hutool.core.util.ZipUtil;
import net.lingala.zip4j.ZipFile;
import net.sf.sevenzipjbinding.SevenZip;
import net.sf.sevenzipjbinding.simple.ISimpleInArchiveItem;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ServenzMain {

    public static void main(String[] args) throws IOException {

        Integer start = 7000;
        Integer end = 7300;
//        String passWord = "M" + start + "淦";
//        try {
//            String path = "C:\\Users\\13703\\Downloads\\Telegram Desktop\\Shinobi Girl_Ver2.10.7z";
//            File file = new File(path);
//            try {
//                SevenZFile zIn = new SevenZFile(file, passWord.toCharArray());
//                zIn.close();
//                System.out.println(passWord);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        for (int i = start ; i < end; i++) {

            String passWord = "M" + i + "淦";

            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        String path = "C:\\Users\\13703\\Downloads\\Telegram Desktop\\Witch Girl Ver 1.21.7z";
                        File file = new File(path);
                        try {
                            SevenZFile zIn = new SevenZFile(file, passWord.toCharArray());
                            zIn.close();
                            System.out.println(passWord);
                        }catch (Exception e){
//                            e.printStackTrace();
                        }

                    } catch (Exception e) {
//                        e.printStackTrace();
                    }
                }
            };
            Thread thread = new Thread(runnable);
            thread.start();
        }


    }


    private static String un7z(String rootPath, String sourceRarPath, String destDirPath, String passWord) {
        try {
            File srcFile = new File(rootPath + sourceRarPath);//获取当前压缩文件
            // 判断源文件是否存在
            if (!srcFile.exists()) {
                throw new Exception(srcFile.getPath() + "所指文件不存在");
            }
            //开始解压
            SevenZFile zIn = null;
            if (StringUtils.isNotBlank(passWord)) {
                zIn = new SevenZFile(srcFile, passWord.toCharArray());
            }  else {
                zIn = new SevenZFile(srcFile);
            }

            SevenZArchiveEntry entry = null;
            File file = null;
            while ((entry = zIn.getNextEntry()) != null) {
                if (!entry.isDirectory()) {
                    file = new File(rootPath + destDirPath, entry.getName());
                    if (!file.exists()) {
                        new File(file.getParent()).mkdirs();//创建此文件的上级目录
                    }
                    OutputStream out = new FileOutputStream(file);
                    BufferedOutputStream bos = new BufferedOutputStream(out);
                    int len = -1;
                    byte[] buf = new byte[1024];
                    while ((len = zIn.read(buf)) != -1) {
                        bos.write(buf, 0, len);
                    }
                    // 关流顺序，先打开的后关闭
                    bos.close();
                    out.close();
                }
            }

        } catch (Exception e) {
           e.printStackTrace();
        }
        return "";
    }




    @SuppressWarnings("resource")
    private static String unZip2(String sourceRarPath, String destDirPath, String passWord) {
        ZipFile zipFile = null;
        String result = "";
        try {
            //String filePath = sourceRarPath;
            String filePath = sourceRarPath;
            if (StringUtils.isNotBlank(passWord)) {
                zipFile = new ZipFile(filePath, passWord.toCharArray());
            } else {
                zipFile = new ZipFile(filePath);
            }
//            zipFile.setCharset(Charset.forName("UTF-8"));
            zipFile.extractAll(destDirPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


}
