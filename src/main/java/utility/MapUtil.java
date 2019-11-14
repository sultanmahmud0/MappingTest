package utility;

import no.mentordigital.etlmodel.ans.image.CreditsBy;
import no.mentordigital.etlmodel.ans.image.Image;
import no.mentordigital.etlmodel.enums.ArcContentType;
import no.mentordigital.etlmodel.enums.ArcLanguageSpec;
import no.mentordigital.etlmodel.enums.PolopolyContentType;
import no.mentordigital.etlmodel.polopoly.Aspect;
import no.mentordigital.etlmodel.polopoly.Meta;
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

            case UserDataBean:
                return ArcContentType.AUTHOR.getDisplayName();
        }

        return null;
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface Language { }

    @Language
    public String language(Map<String, Aspect> aspectMap){

        if(!aspectMap.containsKey("atex.Metadata"))
            return null;

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
    public CreditsBy[] photographer(Map<String, Aspect> aspectMap){
        String photoGrapherName = aspectMap.get("contentData").getData().get("photographer").toString();
        CreditsBy[] byList = new CreditsBy[1];
        CreditsBy by = CreditsBy.builder()
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

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface ImageReference{ }

    @ImageReference
    public Image imageReference(Map<String, Aspect> aspectMap){
        Object object = aspectMap.get("contentData").getData().get("image");
        if(Objects.isNull(object)) return null;

        String imageId = object.toString();
        Image image = new Image();
        image.set_id(imageId);

        return image;
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface FirstName{ }

    @FirstName
    public String firstName(Map<String, Aspect> aspectMap){
        Object object = aspectMap.get("contentData").getData().get("firstname");
        if(Objects.isNull(object)) return null;
        return object.toString();
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface LastName{ }

    @LastName
    public String lastName(Map<String, Aspect> aspectMap){
        Object object = aspectMap.get("contentData").getData().get("surname");
        if(Objects.isNull(object)) return null;
        return object.toString();
    }

    private static String generateDateFromTimeString(String timeString){
        long timeInMills = Long.parseLong(timeString);
        Date creationDate = new Date(timeInMills);
        DateFormat df = new SimpleDateFormat(ARC_DATE_FORMAT);
        return df.format(creationDate);
    }
}