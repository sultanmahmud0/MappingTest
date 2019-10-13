package mapper;

import model.ArcImage;
import model.DocData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import utility.MapUtil;

@Mapper(uses = MapUtil.class)
public interface ImageMapper {

    ImageMapper MAPPER = Mappers.getMapper(ImageMapper.class);

    @Mappings({
            @Mapping(target="_id", ignore = true),
            @Mapping(target="version", expression = "java(new String(\"0.10.4\"))"),
            @Mapping(target="type", source = "aspects",qualifiedBy = MapUtil.Type.class),
            @Mapping(target="language", source = "aspects",qualifiedBy = MapUtil.Language.class),
            @Mapping(target="createdDate",source = "meta",qualifiedBy = MapUtil.CreationTime.class),
            @Mapping(target="lastUpdatedDate",source = "meta",qualifiedBy = MapUtil.ModificationTime.class),
            @Mapping(target="headlines.basic",source = "aspects",qualifiedBy = MapUtil.Headline.class),
            @Mapping(target="caption",source = "aspects",qualifiedBy = MapUtil.Description.class),
            @Mapping(target="altText",source = "aspects",qualifiedBy = MapUtil.AltText.class),
            @Mapping(target="status",source = "aspects",qualifiedBy = MapUtil.Status.class),
            @Mapping(target="width",source = "aspects",qualifiedBy = MapUtil.Width.class),
            @Mapping(target="height",source = "aspects",qualifiedBy = MapUtil.Height.class)
    })
    ArcImage toArcImage(DocData polopolyModel);
}
