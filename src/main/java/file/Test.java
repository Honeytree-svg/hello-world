package file;

import java.io.File;

public class Test {
    public static void main(String[] args) {
        File file = new File("");
        if (file.exists()){
            System.out.println("是目录");
        }else {
            System.out.println("不是目录");
        }
        System.out.println(512 << 10);
        System.out.println(0x7FFFFFFF);
    }
}
