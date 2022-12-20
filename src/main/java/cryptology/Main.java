package cryptology;

import cn.hutool.core.codec.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author : sz
 * @Description :
 * @date : 2022-11-16 10:57
 **/
public class Main {
    public static String KEY = "RZRffr^j^VBfRfB\\";

    public static String IV = "hdJJhRZJfh^`d`dd";

    public static String Encrypt(String sSrc, String key, String iv) throws Exception {
        if (key == null) {
            System.out.print("Key为空null");
            return null;
        }
        // 判断Key是否为16位
        if (key.length() != 16) {
            System.out.print("Key长度不是16位");
            return null;
        }
        byte[] raw = key.getBytes("utf-8");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");//"算法/模式/补码方式"
        IvParameterSpec iv1 = new IvParameterSpec(iv.getBytes());//使用CBC模式，需要一个向量iv，可增加加密算法的强度
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv1);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes());
        return new Base64().encode(encrypted);//此处使用BASE64做转码功能，同时能起到2次加密的作用。
    }

    // 解密
    public static String Decrypt(String sSrc, String key, String iv) throws Exception {
        try {
            // 判断Key是否正确
            if (key == null) {
                System.out.print("Key为空null");
                return null;
            }
            // 判断Key是否为16位
            if (key.length() != 16) {
                System.out.print("Key长度不是16位");
                return null;
            }
            byte[] raw = key.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec iv1 = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv1);
            byte[] encrypted1 = new Base64().decode(sSrc);//先用base64解密
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original);
                return originalString;
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        /*
         * 加密用的Key 可以用26个字母和数字组成，最好不要用保留字符，虽然不会错，至于怎么裁决，个人看情况而定
         * 此处使用AES-128-CBC加密模式，key需要为16位。
         */
        String KEY = "RZRffr^j^VBfRfB\\";

        String IV = "hdJJhRZJfh^`d`dd";
        // 需要加密的字串
        String cSrc = "{\n" +
                "    \"username\":\"王六菊\",\n" +
                "    \"password\":\"test123\",\n" +
                "    \"url\":\"https://www.baidu.com\",\n" +
                "    \"originCode\":\"3306240101\"\n" +
                "}";
        System.out.println(cSrc);
        // 加密
        long lStart = System.currentTimeMillis();
        String enString = Main.Encrypt(cSrc, KEY,IV);
        System.out.println("加密后的字串是：" + enString);

        long lUseTime = System.currentTimeMillis() - lStart;
        System.out.println("加密耗时：" + lUseTime + "毫秒");
        // 解密
        lStart = System.currentTimeMillis();
        String s = "p1JrxZh5q0rZY2cElaVsINT0jRl4tvRrZuQDYHXbKHgi1HjuulmaB7G9iSPnRwmmSPVsyhQkQfvRLZ/ApZLzJTIexlN5Wm9RiDAH3/BT3O5o1z26D86gIF5xKcqGaJ/QstG2NeYxoigxwXt4Rud2Uwd6FrU55CTEOH0VmKVBACc=";
        String DeString = Main.Decrypt(enString, KEY,IV);
        System.out.println("解密后的字串是：" + DeString);
        lUseTime = System.currentTimeMillis() - lStart;
        System.out.println("解密耗时：" + lUseTime + "毫秒");
    }
}
