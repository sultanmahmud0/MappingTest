package mapper;

import model.Child;
import model.Source;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import utility.SimpleUtil;

@Mapper(config = ChildMappingConfig.class,uses = SimpleUtil.class)
public abstract class ChildMapper{

    @InheritConfiguration(name = "mapParent")
    @Mappings({
            @Mapping(source = "childTitle", target= "secondaryTitle"),
            @Mapping(source = "childStatus", target= "secondaryStatus"),
            @Mapping(source = "childPlace", target= "secondaryPlace"),
            @Mapping(source = "sourceMap", target= "secondaryOrder",qualifiedBy = SimpleUtil.SecondaryOrder.class),
            @Mapping(source = "task", target= "taskNumber",qualifiedBy = SimpleUtil.TaskStatus.class)
    })
    public abstract Child mapChild(Source source);
}
