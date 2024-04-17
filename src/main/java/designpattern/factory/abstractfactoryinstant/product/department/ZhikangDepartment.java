package designpattern.factory.abstractfactoryinstant.product.department;

import designpattern.factory.abstractfactoryinstant.clan.DepartmentInfo;

/**
 * @author : sz
 * @Description :
 * @date : 2022-08-02 09:52
 **/
public class ZhikangDepartment implements DepartmentInfo {
    @Override
    public DepartmentInfo produce() {
        return new ZhikangDepartment();
    }
}
