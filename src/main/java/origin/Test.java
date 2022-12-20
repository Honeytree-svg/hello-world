package origin;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author : sz
 * @Description :
 * @date : 2022-11-11 10:36
 **/
public class Test {

    public static void main(String[] args) {

        Field[] fields = Role.class.getFields();
        Field[] declaredFields = Role.class.getDeclaredFields();
        String name = Role.class.getName();
        Constructor<?>[] constructors = Role.class.getConstructors();
        Constructor<?>[] declaredConstructors = Role.class.getDeclaredConstructors();
        Method[] methods = Role.class.getMethods();
        Method[] declaredMethods = Role.class.getDeclaredMethods();
        Package aPackage = Role.class.getPackage();
        String typeName = Role.class.getTypeName();

        String sqlWandaHasFdsNone = "select w.sfzh, w.xm, NULL as qyrq, NULL as sxrq, NULL as jsrq, NULL as ysxm, NULL as tdmc, NULL as jgmc, " +
                "w.qyrq as wdqyrq, w.sxrq as wdsxrq, w.jsrq as wdjsrq, w.ysxm as wdysxm, w.tdmc as wdtdmc, w.jgmc as wdjgmc " +
                "from tmp_wanda_qyjl w left join tmp_fds_qyjl f on f.sfzh = w.sfzh " +
                "where f.id is null limit 20000";

        String sqlDifferent = "select f.sfzh, f.xm, f.qyrq, f.sxrq, f.jsrq, f.ysxm, f.tdmc, f.jgmc, " +
                "w.qyrq as wdqyrq, w.sxrq as wdsxrq, w.jsrq as wdjsrq, w.ysxm as wdysxm, w.tdmc as wdtdmc, w.jgmc as wdjgmc " +
                "from tmp_fds_qyjl f left join tmp_wanda_qyjl w on f.sfzh = w.sfzh " +
                "where w.id is null or (f.jgmc != w.jgmc or f.qyrq != w.qyrq) limit 20000";
        System.out.println(sqlDifferent);
    }
}
