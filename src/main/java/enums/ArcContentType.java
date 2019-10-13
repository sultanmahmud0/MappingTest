package enums;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public enum ArcContentType {

    STORY("story"),
    AUTHOR("author"),
    IMAGE("image");

    private final String displayName;
    private static Map<String, ArcContentType> byDisplayName;

    ArcContentType(String displayName) {
        this.displayName = displayName;
        getByDisplayName().put(displayName.toLowerCase(), this);
    }

    private static Map<String, ArcContentType> getByDisplayName() {
        if (Objects.isNull(byDisplayName)) byDisplayName = new HashMap<>();
        return byDisplayName;
    }

    public static ArcContentType of(String arcContentType) {
        return getByDisplayName().get(arcContentType.trim().toLowerCase());
    }

    public String getDisplayName() {
        return displayName;
    }
}
