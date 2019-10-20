package mapper;

import model.Child;
import model.Source;
import org.mapstruct.*;
import utility.SimpleUtil;

@Mapper(config = ChildMappingConfig.class,uses = SimpleUtil.class)
public interface ChildMapper{

    @InheritConfiguration(name = "mapParent")
    @Mappings({
            @Mapping(source = "childTitle", target= "secondaryTitle"),
            @Mapping(source = "childStatus", target= "secondaryStatus"),
            @Mapping(source = "childPlace", target= "secondaryPlace"),
            @Mapping(source = "sourceMap", target= "secondaryOrder",qualifiedBy = SimpleUtil.SecondaryOrder.class),
            @Mapping(source = "sourceMap", target= "template",qualifiedBy = SimpleUtil.TemplateStatus.class),
            @Mapping(source = "sourceMap", target= "type",qualifiedBy = SimpleUtil.Type.class),
            @Mapping(source = "task", target= "taskNumber",qualifiedBy = SimpleUtil.TaskStatus.class)
    })
    Child mapChild(Source source);
}


