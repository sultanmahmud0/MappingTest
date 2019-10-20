package utility;

import model.Order;
import model.Task;
import org.mapstruct.Named;
import org.mapstruct.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;

public class SimpleUtil {

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.CLASS)
    public @interface TemplateStatus { }

    @TemplateStatus
    public String template(Map<String,Object> sourceMap){
        return sourceMap.get("childTemplate").toString();
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface Type { }

    @Type
    public String type(Map<String,Object> sourceMap){
        return sourceMap.get("childType").toString();
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface SecondaryOrder { }

    @SecondaryOrder
    public Order secondaryOrder(Map<String,Object> sourceMap){
        String orderNumber = sourceMap.get("childOrder").toString();
        return Order.builder().orderNumber(orderNumber).orderId(123).build();
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface TaskStatus { }

    @TaskStatus
    public String taskNumber(Task task){
        return task.getTaskName();
    }

}
