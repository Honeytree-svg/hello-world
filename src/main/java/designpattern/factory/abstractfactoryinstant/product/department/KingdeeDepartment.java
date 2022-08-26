package designpattern.factory.abstractfactoryinstant.product.department;

import designpattern.factory.abstractfactoryinstant.clan.DepartmentInfo;

/**
 * @author : sz
 * @Description :
 * @date : 2022-08-02 09:55
 **/
public class KingdeeDepartment implements DepartmentInfo {
    @Override
    public DepartmentInfo produce() {
        return new KingdeeDepartment();
    }
}
