package mapper;

import model.Parent;
import model.Source;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@MapperConfig
public interface ParentMappingConfig {

    @Mappings({
            @Mapping(source = "source.sourceId", target= "parent.id"),
            @Mapping(source = "source.sourceNumber", target= "parent.number"),
            @Mapping(source = "source.sourceStatus", target= "parent.status")
    })
    void mapParent(Source source, @MappingTarget Parent parent);
}
