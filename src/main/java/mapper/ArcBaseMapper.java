package mapper;

import model.ArcBaseContent;
import model.ArcImage;
import model.DocData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import utility.MapUtil;

@Mapper(uses = MapUtil.class)
public interface ArcBaseMapper {

//    ArcBaseMapper MAPPER = Mappers.getMapper(ArcBaseMapper.class);
//
//    @Mappings({
//            @Mapping(target="_id", source="id"),
//            @Mapping(target="version", source="version"),
//            @Mapping(target="type", source = "aspects",qualifiedBy = MapUtil.Type.class),
//            @Mapping(target="status",source = "aspects",qualifiedBy = MapUtil.Status.class),
//            @Mapping(target="createdDate",expression = "java(polopolyModel.getMeta().getOriginalCreationTime())")
//    })
//    ArcBaseContent toArcBaseContent(DocData polopolyModel);
}
