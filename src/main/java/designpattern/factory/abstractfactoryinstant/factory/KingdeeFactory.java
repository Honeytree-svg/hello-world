package designpattern.factory.abstractfactoryinstant.factory;

import designpattern.factory.abstractfactoryinstant.InstitutionFactory;
import designpattern.factory.abstractfactoryinstant.clan.AppointmentInfo;
import designpattern.factory.abstractfactoryinstant.clan.DepartmentInfo;
import designpattern.factory.abstractfactoryinstant.clan.ScheduleInfo;
import designpattern.factory.abstractfactoryinstant.product.appointment.KingdeeAppointmentInfo;
import designpattern.factory.abstractfactoryinstant.product.appointment.ZhikangAppointmentInfo;
import designpattern.factory.abstractfactoryinstant.product.department.KingdeeDepartment;
import designpattern.factory.abstractfactoryinstant.product.schedule.KingdeeScheduleInfo;

/**
 * @author : sz
 * @Description :
 * @date : 2022-08-02 10:03
 **/
public class KingdeeFactory implements InstitutionFactory {
    
    @Override
    public AppointmentInfo getAppointmentInfo() {
        return new KingdeeAppointmentInfo();
    }

    @Override
    public DepartmentInfo getDepartmentInfo() {
        return new KingdeeDepartment();
    }

    @Override
    public ScheduleInfo getScheduleInfo() {
        return new KingdeeScheduleInfo();
    }
}
