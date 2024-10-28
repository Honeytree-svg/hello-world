package aggrefile;

import java.io.*;

public class FileContentWriter {

    public static void main(String[] args) {
        // 定义文件夹路径和输出文件路径
        String folderPath = "你的文件夹路径";  // 替换成目标文件夹路径
        String outputPath = "输出文件路径.txt";  // 替换成输出文件路径

        File folder = new File(folderPath);
        File outputFile = new File(outputPath);

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8"))) {
            listFilesAndWriteContent(folder, writer);
            System.out.println("文件内容已写入：" + outputFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("发生错误: " + e.getMessage());
        }
    }

    public static void listFilesAndWriteContent(File folder, BufferedWriter writer) throws IOException {
        File[] files = folder.listFiles();
        
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // 如果是文件夹，递归遍历
                    listFilesAndWriteContent(file, writer);
                } else {
                    // 如果是文件，写入内容
                    writeFileContent(file, writer);
                }
            }
        }
    }

    public static void writeFileContent(File file, BufferedWriter writer) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            writer.write("文件: " + file.getAbsolutePath());  // 文件路径作为标题
            writer.newLine();
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            writer.newLine(); // 添加一个空行作为分隔
        } catch (IOException e) {
            System.out.println("读取文件时发生错误: " + file.getAbsolutePath());
        }
    }
}
