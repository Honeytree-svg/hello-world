package wuliao;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author : sz
 * @Description :
 * @date : 2022-07-08 16:31
 **/
public class Test {

    public static void main(String[] args) {

        String name = Regigster.RegistType.EXECUTOR.name();
        System.out.println(CommonCodeEnum.getCommonCodeValue("tests"));
        String tests = CommonCodeEnum.getCommonCodeValue("tests");
    }

    @Getter
    @AllArgsConstructor
    enum CommonCodeEnum {
        MAN("1", "男"),
        WOMAN("2", "女"),
        TESTS("tests", "检验报告列表"),
        TEST("test", "检验报告详情"),
        EXAMS("exams", "检查报告列表"),
        EXAM("exam", "检查报告详情"),
        RMYY("0101001", "新昌县人民医院"),
        ZYY("0201001", "新昌县中医院"),
        WINDOWS("Windows", "PC端")
        ;
        /**
         * 编码
         */
        private String code;
        /**
         * 值域
         */
        private String value;

        /**
         * 获取标准CODE值
         * @param code
         * @return
         */
        public static String getCommonCodeValue(String code) {
            for (CommonCodeEnum t : CommonCodeEnum.values()) {
                if (t.code.equals(code)) {
                    return t.getValue();
                }
            }
            return "";
        }
    }
}
