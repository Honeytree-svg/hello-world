package cryptology;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import java.nio.charset.StandardCharsets;

/**
 * @author : sz
 * @Description :
 * @date : 2022-11-14 16:10
 **/
public class Test {

    public static void main(String[] args) {

        long l = System.currentTimeMillis();
        SecretKey secretKey = SecureUtil.generateKey("AES");
        long l1 = System.currentTimeMillis();
        System.out.println(l1 -l);
        SymmetricCrypto symmetricCrypto = new SymmetricCrypto(SymmetricAlgorithm.AES);
        String name = symmetricCrypto.encryptHex("王六菊");
        String pwd = symmetricCrypto.encryptHex("123456");
        System.out.println(name);
        System.out.println(pwd);
        String s = symmetricCrypto.decryptStr(name);
        SymmetricCrypto b = new SymmetricCrypto(SymmetricAlgorithm.AES);
        String s1 = b.decryptStr(pwd);
        System.out.println(s1);
    }
}
