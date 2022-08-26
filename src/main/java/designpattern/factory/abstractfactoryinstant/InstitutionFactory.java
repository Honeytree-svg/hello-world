package designpattern.factory.abstractfactoryinstant;

import designpattern.factory.abstractfactoryinstant.clan.*;

public interface InstitutionFactory {
    AppointmentInfo getAppointmentInfo();
    DepartmentInfo getDepartmentInfo();
    ScheduleInfo getScheduleInfo();
}
