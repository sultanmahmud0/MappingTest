package mapper;

import no.mentordigital.etlmodel.polopoly.PolopolyModel;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;

@MapperConfig(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface ArcAuthorMappingConfig extends ArcBaseContentMappingConfig {

    @InheritConfiguration(name = "mapArcBaseContent")
    void mapArcImage(PolopolyModel polopolyModel, @MappingTarget Author author);
}


