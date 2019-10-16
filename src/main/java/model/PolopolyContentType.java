package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public enum PolopolyContentType {

    ImageResourceBean("ImageResourceBean"),
    ImageContentDataBean("ImageContentDataBean"),
    ArticleBean("ArticleBean");

    private final String displayName;
    private static Map<String, PolopolyContentType> byDisplayName;

    PolopolyContentType(String displayName) {
        this.displayName = displayName;
        getByDisplayName().put(displayName.toLowerCase(), this);
    }

    private static Map<String, PolopolyContentType> getByDisplayName() {
        if (Objects.isNull(byDisplayName)) byDisplayName = new HashMap<>();
        return byDisplayName;
    }

    public static PolopolyContentType of(String arcContentType) {
        return getByDisplayName().get(arcContentType.trim().toLowerCase());
    }

    public String getDisplayName() {
        return displayName;
    }
}
