package mapper;

import model.Child;
import model.Source;
import org.mapstruct.*;

@MapperConfig(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface ChildMappingConfig extends ParentMappingConfig {

    @InheritConfiguration(name = "mapSourceToParent")
    @Mappings({
            @Mapping(source = "subTitle", target= "subTitle")
    })
    void mapSourceToChild(Source source, @MappingTarget Child child);
}
