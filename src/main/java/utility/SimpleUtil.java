package utility;

import org.mapstruct.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;

public class SimpleUtil {

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface SecondaryStatus { }

    @SecondaryStatus
    public String secondaryStatus(Map<String,Object> sourceMap){
        return sourceMap.get("childStatus").toString();
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface SecondaryPlace { }

    @SecondaryPlace
    public String secondaryPlace(Map<String,Object> sourceMap){
        return sourceMap.get("childPlace").toString();
    }

}
