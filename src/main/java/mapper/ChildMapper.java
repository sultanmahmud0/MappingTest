package mapper;

import model.Child;
import model.Source;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;

@Mapper(config = ChildMappingConfig.class)
public abstract class ChildMapper {

    @InheritConfiguration(name = "mapSourceToParent")
    public abstract Child mapChild(Source source);
}
