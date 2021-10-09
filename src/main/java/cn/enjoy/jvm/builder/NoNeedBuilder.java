package cn.enjoy.jvm.builder;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class NoNeedBuilder {

    private final Date birthDate;

    public NoNeedBuilder(Date birthDate) {
        this.birthDate = birthDate;
    }

    private static final Date Begin;

    static {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        cal.set(1990, Calendar.JANUARY, 1, 0, 0, 0);
        Begin = cal.getTime();
    }

    public boolean is90s(){
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        cal.set(1990, Calendar.JANUARY, 1, 0, 0, 0);
        Date Begin = cal.getTime();
        return false;
    }


}
