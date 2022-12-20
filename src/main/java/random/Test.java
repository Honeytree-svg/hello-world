package random;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.RandomUtil;

/**
 * @author : sz
 * @Description :
 * @date : 2022-11-17 19:33
 **/
public class Test {

    public static void main(String[] args) {
        System.out.println(RandomUtil.randomNumbers(6));
        byte[] decode = Base64.decode("5oKo55qE6aqM6K+B56CB5Li677yaMzUzMTQ577yM6K+l6aqM6K+B56CBNeWIhumSn+WGheacieaViOOAguWmgumdnuacrOS6uuaTjeS9nOivt+W/veeVpeacrOefreS/oeOAgg==");
        System.out.println(new String(decode));
    }
}
