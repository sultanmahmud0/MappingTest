package mapper;

import model.ArcBaseContent;
import model.DocData;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import utility.MapUtil;

@MapperConfig(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE,uses = MapUtil.class)
public interface ArcBaseContentMappingConfig {
    @Mappings({
            @Mapping(target="_id", ignore = true),
            @Mapping(target="version", expression = "java(new String(\"0.10.3\"))"),
            @Mapping(target="type", source = "aspects", qualifiedBy = MapUtil.Type.class),
            @Mapping(target="language", source = "aspects", qualifiedBy = MapUtil.Language.class),
            @Mapping(target="createdDate",source = "meta", qualifiedBy = MapUtil.CreationTime.class),
            @Mapping(target="lastUpdatedDate",source = "meta", qualifiedBy = MapUtil.ModificationTime.class)
    })
    void mapArcBaseContent(DocData docData, @MappingTarget ArcBaseContent arcBaseContent);
}
