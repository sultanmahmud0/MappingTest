package mapper;

import model.Child;
import model.Source;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(config = ChildMappingConfig.class)
public abstract class ChildMapper{

    @InheritConfiguration(name = "mapParent")
    @Mappings({
            @Mapping(source = "source.childTitle", target= "secondaryTitle"),
            @Mapping(source = "source.childStatus", target= "secondaryStatus"),
            @Mapping(source = "source.childPlace", target= "secondaryPlace")
    })
    public abstract Child mapChild(Source source);
}
