package utility;

import enums.ArcContentType;
import enums.ArcLanguageSpec;
import enums.PolopolyContentType;
import model.ArcCreditsBy;
import model.Aspect;
import model.Meta;
import org.mapstruct.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MapUtil {

    final static String ARC_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.S'Z'";

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface Type { }

    @Type
    public String type(Map<String, Aspect> aspectMap) {
        Object typeObj = aspectMap.get("contentData").getData().get("_type");
        if(Objects.isNull(typeObj))
            return null;

        String polopolyType = typeObj.toString().substring(typeObj.toString().lastIndexOf(".")+1);
        PolopolyContentType enumType = PolopolyContentType.valueOf(polopolyType);

        switch(enumType){

            case ImageContentDataBean:
            case ImageResourceBean:
                return ArcContentType.IMAGE.getDisplayName();

            case ArticleBean:
                return ArcContentType.STORY.getDisplayName();
        }

        return null;
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface Language { }

    @Language
    public String language(Map<String, Aspect> aspectMap){
        String siteTaxonomy = aspectMap.get("atex.Metadata").getData().get("taxonomyIds").toString();
        String siteExt = siteTaxonomy.substring(siteTaxonomy.lastIndexOf(".")+1);

        switch(siteExt){
            case "no":
                return ArcLanguageSpec.NORWAY.getDisplayName();
            case "se":
                return ArcLanguageSpec.SWEDEN.getDisplayName();
        }
        return null;
    }


    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface CreationTime { }

    @CreationTime
    public String creationTime(Meta meta){
        return generateDateFromTimeString(meta.getOriginalCreationTime());
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface ModificationTime { }

    @ModificationTime
    public String modificationTime(Meta meta){
        return generateDateFromTimeString(meta.getModificationTime());
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface Headline { }

    @Headline
    public String headline(Map<String, Aspect> aspectMap){
        return aspectMap.get("contentData").getData().get("title").toString();
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface Description { }

    @Description
    public String description(Map<String, Aspect> aspectMap){
        return aspectMap.get("contentData").getData().get("description").toString();
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface Width { }

    @Width
    public int width(Map<String, Aspect> aspectMap){
        return Integer.parseInt(aspectMap.get("atex.Image").getData().get("width").toString());
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface Height { }

    @Height
    public int height(Map<String, Aspect> aspectMap){
        return Integer.parseInt(aspectMap.get("atex.Image").getData().get("height").toString());
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface AltText { }

    @AltText
    public String altText(Map<String, Aspect> aspectMap){
        return aspectMap.get("contentData").getData().get("altText").toString();
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface Photographer { }

    @Photographer
    public ArcCreditsBy[] photographer(Map<String, Aspect> aspectMap){
        String photoGrapherName = aspectMap.get("contentData").getData().get("photographer").toString();
        ArcCreditsBy[] byList = new ArcCreditsBy[1];
        ArcCreditsBy by = ArcCreditsBy.builder()
                        .byline(photoGrapherName)
                        .type(ArcContentType.AUTHOR.getDisplayName())
                        .version("0.10.3")
                        .name("")
                        .build();
        byList[0] = by;
        return byList;
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface ImageSourcePublicUrl { }

    @ImageSourcePublicUrl
    public Map<String,Object> imageSourcePublicUrl(Map<String, Aspect> aspectMap){
        Object object = aspectMap.get("contentData").getData().get("originalUrl");
        if(Objects.isNull(object)) return null;

        String sourceUrl = object.toString();
        Map<String,Object> propertiesMap = new HashMap<>();
        propertiesMap.put("originalUrl",sourceUrl);

        return propertiesMap;
    }

    private static String generateDateFromTimeString(String timeString){
        long timeInMills = Long.parseLong(timeString);
        Date creationDate = new Date(timeInMills);
        DateFormat df = new SimpleDateFormat(ARC_DATE_FORMAT);
        return df.format(creationDate);
    }
}