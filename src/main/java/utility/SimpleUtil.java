package utility;

import org.mapstruct.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class SimpleUtil {

    String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.S'Z'";

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface UID {
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface DateTime {
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface HiddenStatus {
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface HiddenPlace {
    }

    @UID
    public String uid(long id) {
        return Long.toString(id);
    }

    @HiddenStatus
    public boolean hiddenStatus(Map<String,Object> sourceMap) {
        String status = sourceMap.get("hiddenMessage").toString();
        return status.equals("true") ? true : false;
    }

    @DateTime
    public String date(Date date) {
        DateFormat df = new SimpleDateFormat(DATE_FORMAT);
        return df.format(date);
    }

    @HiddenPlace
    public String hiddenPlace(Map<String,Object> sourceMap){
        return sourceMap.get("hiddenPlace").toString();
    }
}
