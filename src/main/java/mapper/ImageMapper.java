package mapper;

import model.ArcImage;
import model.DocData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import utility.MapUtil;

@Mapper(componentModel = "spring",
        imports = MapUtil.class,
        unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface ImageMapper {

    ImageMapper MAPPER = Mappers.getMapper(ImageMapper.class);

    @Mappings({
            @Mapping(target="_id", ignore = true),
            @Mapping(target="version", expression = "java(new String(\"0.10.3\"))"),
            @Mapping(target="type", expression = "java(MapUtil.type(polopolyModel.getAspects()))"),
            @Mapping(target="language", expression = "java(MapUtil.language(polopolyModel.getAspects()))"),
            @Mapping(target="createdDate",expression = "java(MapUtil.creationTime(polopolyModel.getMeta()))"),
            @Mapping(target="lastUpdatedDate",expression = "java(MapUtil.modificationTime(polopolyModel.getMeta()))"),
            @Mapping(target="subtitle",expression = "java(MapUtil.headline(polopolyModel.getAspects()))"),
            @Mapping(target="caption",expression = "java(MapUtil.description(polopolyModel.getAspects()))"),
            @Mapping(target="altText",expression = "java(MapUtil.altText(polopolyModel.getAspects()))"),
            @Mapping(target="width",expression = "java(MapUtil.width(polopolyModel.getAspects()))"),
            @Mapping(target="height",expression = "java(MapUtil.height(polopolyModel.getAspects()))"),
            @Mapping(target="credits.by",expression = "java(MapUtil.photographer(docData.getAspects()))"),
            @Mapping(target="additionalProperties",expression = "java(MapUtil.imageSourcePublicUrl(polopolyModel.getAspects()))")
    })
    ArcImage toArcImage(DocData polopolyModel);
}
