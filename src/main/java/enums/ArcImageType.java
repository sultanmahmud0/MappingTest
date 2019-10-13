package enums;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public enum ArcImageType {

    PHOTOGRAPH("photograph"),
    GRAPHIC("graphic"),
    ILLUSRTATION("illustration"),
    THUMBNAIL("thumbnail");

    private final String displayName;
    private static Map<String, ArcImageType> byDisplayName;

    ArcImageType(String displayName) {
        this.displayName = displayName;
        getByDisplayName().put(displayName.toLowerCase(), this);
    }

    private static Map<String, ArcImageType> getByDisplayName() {
        if (Objects.isNull(byDisplayName)) byDisplayName = new HashMap<>();
        return byDisplayName;
    }

    public static ArcImageType of(String imageCategoryType) {
        return getByDisplayName().get(imageCategoryType.trim().toLowerCase());
    }

    public String getDisplayName() {
        return displayName;
    }
}
