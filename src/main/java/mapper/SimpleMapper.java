package mapper;

import model.Source;
import model.Target;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import utility.SimpleUtil;

@Mapper(uses = SimpleUtil.class,
        unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface SimpleMapper {

    SimpleMapper MAPPER = Mappers.getMapper(SimpleMapper.class);

    @Mappings({
            @Mapping(target="uid", source = "id", qualifiedBy = SimpleUtil.UID.class),
            @Mapping(target="msg", expression = "java(new String(\"Hello World\"))"),
            @Mapping(target="date", source = "date", qualifiedBy = SimpleUtil.UID.class),
            @Mapping(target="hiddenStatus", source = "sourceMap", qualifiedBy = SimpleUtil.HiddenStatus.class),
            @Mapping(target="hiddenPlace", source = "sourceMap", qualifiedBy = SimpleUtil.HiddenPlace.class)
    })
    Target toTarget(Source source);
}
