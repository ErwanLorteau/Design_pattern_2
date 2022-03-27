package fr.unantes.sce.temp;

import java.util.Objects;

public class PermissionState {

    private final String state;

    public final static PermissionState REQUESTED = new PermissionState("REQUESTED");
    public final static PermissionState CLAIMED = new PermissionState("CLAIMED");
    public final static PermissionState DENIED = new PermissionState("DENIED");
    public final static PermissionState GRANTED = new PermissionState("GRANTED");

    public PermissionState(String state) {
        this.state = state;
    }

    public PermissionState getState() {
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PermissionState that = (PermissionState) o;
        return Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(state);
    }
}
