package mapper;

import model.Child;
import model.Source;
import org.mapstruct.*;

@MapperConfig(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface ChildMappingConfig extends ParentMappingConfig{

    @InheritConfiguration(name = "mapParent")
    void mapChild(Source source, @MappingTarget Child child);
}
