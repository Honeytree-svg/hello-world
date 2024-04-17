package cryptology;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESUtilDemo {


    /**
     * 算法/模式/填充                    16字节加密后数据长度         不满16字节加密后长度
     *
     * AES/CBC/NoPadding                  16                         不支持
     * AES/CBC/PKCS5Padding               32                          16
     * AES/CBC/ISO10126Padding            32                          16
     * AES/CFB/NoPadding                  16                          原始数据长度
     * AES/CFB/PKCS5Padding               32                          16
     * AES/CFB/ISO10126Padding            32                          16
     * AES/ECB/NoPadding                  16                          不支持
     * AES/ECB/PKCS5Padding               32                          16
     * AES/ECB/ISO10126Padding            32                          16
     * AES/OFB/NoPadding                  16                          原始数据长度
     * AES/OFB/PKCS5Padding               32                          16
     * AES/OFB/ISO10126Padding            32                          16
     * AES/PCBC/NoPadding                 16                          不支持
     * AES/PCBC/PKCS5Padding              32                          16
     * AES/PCBC/ISO10126Padding           32                          16
     */

    public static final String AES = "AES";
    public static final String AES_CBC_NO_PADDING = "AES/CBC/PKCS5Padding";
    public static final int KEY_LENGTH = 16;
    public static final int IV_LENGTH = 16;

    public static void main(String[] args) throws Exception {
        String key = "aaaabbbbccccdddd";
        String iv = "hdJJhRZJfh^`d`dd";
        AESUtilDemo aesUtilDemo = new AESUtilDemo();
        String hello = aesUtilDemo.Encryption(key, iv, "zmm");
        System.out.println(hello);
        String decrypt = aesUtilDemo.Decrypt(key, iv, hello);
        System.out.println(decrypt);
    }

    /**
     * AES/CBC加密
     * @param key  密钥
     * @param iv   偏移矢量
     * @param content 加密的内容
     * @return
     */
    public String Encryption(String key, String iv, String content) throws Exception {
        //检查是否为16位
//        checkKey(key);
//        checkIV(iv);

        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), AES);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
        Cipher cipher = Cipher.getInstance(AES_CBC_NO_PADDING);
        // AES/CBC/NoPadding  加密后的字节长度位16   需要自己去补成16位
        int blockSize = cipher.getBlockSize();
        int length = content.getBytes().length;
        if (length % blockSize != 0){
            length = length + blockSize - (length % blockSize);
        }

        byte[] bytes1 = new byte[length];
        System.arraycopy(content.getBytes(), 0, bytes1, 0, content.getBytes().length);


        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
        byte[] bytes = cipher.doFinal(bytes1);

        //base64加密
        return new BASE64Encoder().encode(bytes);

    }

    /**
     * 判断key
     * @param key
     * @throws Exception
     */
    private void checkKey(String key) throws Exception {
        if (key == null || key.length() != KEY_LENGTH){
            throw new Exception("密钥不正确");
        }
    }

    /**
     * 判断iv
     * @param iv
     * @throws Exception
     */
    private void checkIV(String iv) throws Exception {
        if (iv == null || iv.length() != IV_LENGTH){
            throw new Exception("偏移矢量不正确");
        }
    }

    /**
     * 解密
     * @param key  密钥
     * @param iv   偏移矢量
     * @param content 解密内容
     * @return
     * @throws Exception
     */
    public String Decrypt(String key, String iv, String content) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), AES);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
        Cipher cipher = Cipher.getInstance(AES_CBC_NO_PADDING);

        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);

        //先解开base64加密
        byte[] bytes1 = new BASE64Decoder().decodeBuffer(content);
        byte[] bytes = cipher.doFinal(bytes1);

        return new String(bytes);

    }

}