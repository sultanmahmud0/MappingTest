package enums;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public enum ArcStatus {

    published("published"),
    unpublished("unpublished"),
    embargoed("embargoed");

    private final String displayName;
    private static Map<String, ArcStatus> byDisplayName;

    ArcStatus(String displayName) {
        this.displayName = displayName;
        getByDisplayName().put(displayName.toLowerCase(), this);
    }

    private static Map<String, ArcStatus> getByDisplayName() {
        if (Objects.isNull(byDisplayName)) byDisplayName = new HashMap<>();
        return byDisplayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static ArcStatus of(String statusType) {
        return getByDisplayName().get(statusType.trim().toLowerCase());
    }

    public static Optional<ArcStatus> getByName(String name){
        return byDisplayName.values().stream().filter(e -> e.name().equals(name)).findFirst();
    }
}
