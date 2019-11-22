package mapper;

import no.mentordigital.etlmodel.polopoly.PolopolyModel;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import utility.MapUtil;

@Mapper(config = ArcAuthorMappingConfig.class,
        uses = MapUtil.class,
        unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface AuthorMapper {

    @InheritConfiguration(name = "mapArcBaseContent")
    @Mappings({
            @Mapping(target="_id", source = "aspects", qualifiedBy = MapUtil.ID.class),
            @Mapping(target="image",source = "aspects", qualifiedBy = MapUtil.ImageReference.class),
            @Mapping(target="firstName",source = "aspects", qualifiedBy = MapUtil.FirstName.class),
            @Mapping(target="lastName",source = "aspects", qualifiedBy = MapUtil.LastName.class)
    })
    Author mapArcAuthor(PolopolyModel polopolyModel);
}



