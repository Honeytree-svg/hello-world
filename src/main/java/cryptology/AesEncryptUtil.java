package cryptology;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

public class AesEncryptUtil {
    //使用AES-128-CBC加密模式，key需要为16位,key和iv可以相同！
        private static String KEY = "abcdefg123456789";
        
        private static String IV = "abcdefg123456789";
        
        
        /**
         * 加密方法
         * @param data  要加密的数据
         * @param key 加密key
         * @param iv 加密iv
         * @return 加密的结果
         * @throws Exception
         */
        public static String encrypt(String data, String key, String iv) throws Exception {
            try {
 
                Cipher cipher = Cipher.getInstance("AES/CBC/ISO10126Padding");//"算法/模式/补码方式"
                int blockSize = cipher.getBlockSize();
 
                byte[] dataBytes = data.getBytes();
                int plaintextLength = dataBytes.length;
                if (plaintextLength % blockSize != 0) {
                    plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
                }
 
                byte[] plaintext = new byte[plaintextLength];
                System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);
 
                SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
                IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());
 
                cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
                byte[] encrypted = cipher.doFinal(plaintext);
 
                return new Base64().encodeToString(encrypted);
 
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
 
        /**
         * 解密方法
         * @param data 要解密的数据
         * @param key  解密key
         * @param iv 解密iv
         * @return 解密的结果
         * @throws Exception
         */
        public static String desEncrypt(String data, String key, String iv) throws Exception {
            try {
                byte[] encrypted1 = new Base64().decode(data);
 
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
                IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());
 
                cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);

                byte[] original = cipher.doFinal(encrypted1);
                return new String(original);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        
        /**
         * 使用默认的key和iv加密
         * @param data
         * @return
         * @throws Exception
         */
        public static String encrypt(String data) throws Exception {
            return encrypt(data, KEY, IV);
        }
        
        /**
         * 使用默认的key和iv解密
         * @param data
         * @return
         * @throws Exception
         */
        public static String desEncrypt(String data) throws Exception {
            return desEncrypt(data, KEY, IV);
        }
        
        
        
        /**
        * 测试
        */
        public static void main(String args[]) throws Exception {
 
            String name = "zmm";
            String password = "123456";
 
            String data = null;
            //String key = "imissyouokashisanforwardnextmeet";
            //String iv = "treetimestop2022";
            String key = "RZRffr^j^VBfRfB\\";
            String iv = "hdJJhRZJfh^`d`dd";

            String n = encrypt(name, key, iv);
            String p = encrypt(password, key, iv);

            String s = desEncrypt(n, key, iv);
            //String replace = s.replace("\u0000", "");
            System.out.println(n);
            System.out.println(s);
        }
}