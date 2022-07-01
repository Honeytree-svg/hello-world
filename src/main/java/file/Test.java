package file;

import java.io.File;

public class Test {
    public static void main(String[] args) {
        File file = new File("D:\\dicomPDF");
        if (file.isDirectory()){
            System.out.println("是目录");
        }else {
            System.out.println("不是目录");
        }
    }
}
