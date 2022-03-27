package fr.unantes.sce.temp;

import fr.rtp.simplification.condwithstate.SystemAdmin;
import fr.rtp.simplification.condwithstate.SystemPermission;

public class Requested extends PermissionState {
    public Requested(String state) {
        super(state);
    }

    public void claimedBy(SystemAdmin admin, SystemPermission systemPermission) {

      systemPermission.willBeHandledBy(admin);
      systemPermission.setState(CLAIMED);
    }

    public void grantedBy(SystemAdmin admin, SystemPermission systemPermission) {

    }

    public void deniedBy(SystemAdmin admin, SystemPermission systemPermission) {

    }
}
