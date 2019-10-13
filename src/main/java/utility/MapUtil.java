package utility;

import enums.ArcContentType;
import enums.ArcLanguageSpec;
import enums.ArcStatus;
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
import java.util.Map;

public class MapUtil {

    final String ARC_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.S'Z'";

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }

    @Type
    public String type(Map<String, Aspect> aspectMap) {
        return ArcContentType.IMAGE.getDisplayName();
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface Status {
    }

    @Status
    public String status(Map<String, Aspect> aspectMap){
        String status = aspectMap.get("contentData").getData().get("status").toString();
        for(ArcStatus e : ArcStatus.values()){
            if(status.equals(e.getDisplayName()))
                return e.getDisplayName();
        }
        return null;
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface Language {
    }

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
    public @interface CreationTime {
    }

    @CreationTime
    public String creationTime(Meta meta){
        return generateDateFromTimeString(meta.getOriginalCreationTime());
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface ModificationTime {
    }

    @ModificationTime
    public String modificationTime(Meta meta){
        return generateDateFromTimeString(meta.getModificationTime());
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface Headline {
    }

    @Headline
    public String headline(Map<String, Aspect> aspectMap){
        return aspectMap.get("contentData").getData().get("title").toString();
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface Description {
    }

    @Description
    public String description(Map<String, Aspect> aspectMap){
        return aspectMap.get("contentData").getData().get("description").toString();
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface Width {
    }

    @Width
    public int width(Map<String, Aspect> aspectMap){
        return Integer.parseInt(aspectMap.get("atex.Image").getData().get("width").toString());
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface Height {
    }

    @Height
    public int height(Map<String, Aspect> aspectMap){
        return Integer.parseInt(aspectMap.get("atex.Image").getData().get("height").toString());
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface AltText {
    }

    @AltText
    public String altText(Map<String, Aspect> aspectMap){
        return aspectMap.get("contentData").getData().get("altText").toString();
    }

    private String generateDateFromTimeString(String timeString){
        long timeInMills = Long.parseLong(timeString);
        Date creationDate = new Date(timeInMills);
        DateFormat df = new SimpleDateFormat(ARC_DATE_FORMAT);
        return df.format(creationDate);
    }
}