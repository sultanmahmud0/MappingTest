package mapper;

import model.ArcImage;
import model.DocData;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import utility.MapUtil;

@Mapper(config = ArcImageMappingConfig.class,
        uses = MapUtil.class,
        unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface ImageMapper {

    @InheritConfiguration(name = "mapArcBaseContent")
    @Mappings({
            @Mapping(target="subtitle",source = "aspects", qualifiedBy = MapUtil.Headline.class),
            @Mapping(target="caption",source = "aspects", qualifiedBy = MapUtil.Description.class),
            @Mapping(target="altText",source = "aspects", qualifiedBy = MapUtil.AltText.class),
            @Mapping(target="width",source = "aspects", qualifiedBy = MapUtil.Width.class),
            @Mapping(target="height",source = "aspects", qualifiedBy = MapUtil.Height.class),
            @Mapping(target="credits.by",source = "aspects", qualifiedBy = MapUtil.Photographer.class),
            @Mapping(target="additionalProperties",source = "aspects", qualifiedBy = MapUtil.ImageSourcePublicUrl.class)
    })
    ArcImage mapArcImage(DocData docData);
}
