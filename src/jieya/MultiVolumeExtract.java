package jieya;

import java.io.IOException;

public class MultiVolumeExtract {
    public static void main(String[] args) {
        // 分卷压缩文件的目录和文件名前缀
        String archivePath = "C:\\Users\\13703\\Downloads\\Telegram Desktop\\支配女巫电脑版.7z.001";

        // 创建7z命令行工具的进程
        ProcessBuilder pb = new ProcessBuilder("7z", "x", archivePath);

        // 设置工作目录，即解压到的目标文件夹
        pb.directory(new java.io.File("path/to/extract/directory"));
        try {
            Process p = pb.start();

            // 等待命令执行完成
            p.waitFor();

            System.out.println("解压完成.");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
