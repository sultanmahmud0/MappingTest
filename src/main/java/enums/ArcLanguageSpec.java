package enums;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public enum ArcLanguageSpec {

    NORWAY("nb-NO"),
    SWEDEN("sv-SE");

    private final String displayName;
    private static Map<String, ArcLanguageSpec> byDisplayName;

    ArcLanguageSpec(String displayName) {
        this.displayName = displayName;
        getByDisplayName().put(displayName.toLowerCase(), this);
    }

    private static Map<String, ArcLanguageSpec> getByDisplayName() {
        if (Objects.isNull(byDisplayName)) byDisplayName = new HashMap<>();
        return byDisplayName;
    }

    public static ArcLanguageSpec of(String arcContentType) {
        return getByDisplayName().get(arcContentType.trim().toLowerCase());
    }

    public String getDisplayName() {
        return displayName;
    }
}
