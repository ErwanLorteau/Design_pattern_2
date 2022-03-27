package fr.unantes.sce.temp;



import fr.rtp.simplification.condwithstate.SystemAdmin;
import fr.rtp.simplification.condwithstate.SystemPermission;

import java.util.Objects;

public abstract class PermissionState {

    private final String state;
    public final static PermissionState REQUESTED = new Requested("REQUESTED");
    public final static PermissionState CLAIMED = new Claimed("CLAIMED");
    public final static PermissionState DENIED = new Denied("DENIED");
    public final static PermissionState GRANTED = new Granted("GRANTED");



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

    public void claimedBy(SystemAdmin admin, SystemPermission systemPermission) {
      if (!systemPermission.getState().equals(REQUESTED)) {
        return;
      }
      systemPermission.willBeHandledBy(admin);
      systemPermission.setState(CLAIMED);
    }

    public void deniedBy(SystemAdmin admin, SystemPermission systemPermission) {
      if (!systemPermission.getState().equals(CLAIMED)) {
        return;
      }
      if (!admin.equals(systemPermission.getAdmin())) {
        return;
      }
      systemPermission.setGranted(false);
      systemPermission.setState(DENIED);
      systemPermission.notifyUserOfPermissionRequestResult();
    }

    public void grantedBy(SystemAdmin admin, SystemPermission systemPermission) {
      if (!systemPermission.getState().equals(CLAIMED)) {
        return;
      }
      if (!admin.equals(systemPermission.getAdmin())) {
        return;
      }
      systemPermission.setState(GRANTED);
      systemPermission.setGranted(true);
      systemPermission.notifyUserOfPermissionRequestResult();
    }
}
