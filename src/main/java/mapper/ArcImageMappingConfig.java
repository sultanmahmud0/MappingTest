package mapper;

import model.ArcImage;
import model.DocData;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;

@MapperConfig(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface ArcImageMappingConfig extends ArcBaseContentMappingConfig{

    @InheritConfiguration(name = "mapArcBaseContent")
    void mapArcImage(DocData docData, @MappingTarget ArcImage arcImage);
}
