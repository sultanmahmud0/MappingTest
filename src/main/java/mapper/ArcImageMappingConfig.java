package mapper;

import model.ArcImage;
import model.DocData;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import utility.MapUtil;

@MapperConfig(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE,uses = MapUtil.class)
public interface ArcImageMappingConfig extends ArcBaseMappingConfig {

    @Mappings({
            @Mapping(target="subtitle",source = "aspects", qualifiedBy = MapUtil.Headline.class),
            @Mapping(target="caption",source = "aspects", qualifiedBy = MapUtil.Description.class),
            @Mapping(target="altText",source = "aspects", qualifiedBy = MapUtil.AltText.class),
            @Mapping(target="width",source = "aspects", qualifiedBy = MapUtil.Width.class),
            @Mapping(target="height",source = "aspects", qualifiedBy = MapUtil.Height.class),
            @Mapping(target="additionalProperties",source = "aspects", qualifiedBy = MapUtil.ImageSourcePublicUrl.class)
    })
    void mapSourceToArcImage(DocData docData, @MappingTarget ArcImage arcImage);
}
