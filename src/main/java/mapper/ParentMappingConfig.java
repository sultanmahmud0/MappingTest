package mapper;

import model.Parent;
import model.Source;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@MapperConfig(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface ParentMappingConfig {

    @Mappings({
            @Mapping(source = "sourceId", target= "id"),
            @Mapping(source = "sourceNumber", target= "number"),
            @Mapping(source = "sourceStatus", target= "status")
    })
    void mapSourceToParent(Source source, @MappingTarget Parent parent);
}
