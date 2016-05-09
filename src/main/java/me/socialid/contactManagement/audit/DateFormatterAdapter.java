package me.socialid.contactManagement.audit;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.Date;

public final class DateFormatterAdapter extends XmlAdapter<String, Date> {

    DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public Date unmarshal(String v) throws Exception {
        return formatter.parseDateTime(v).toDate();
    }

    @Override
    public String marshal(Date value) throws Exception {
        return formatter.print(value.getTime());
    }

}