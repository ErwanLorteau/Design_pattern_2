package fr.unantes.sce.temp;

import fr.rtp.simplification.condwithstate.SystemAdmin;
import fr.rtp.simplification.condwithstate.SystemPermission;

public class Denied extends PermissionState {
    public Denied(String state) {
        super(state);
    }

    public void claimedBy(SystemAdmin admin, SystemPermission systemPermission) {

    }

    public void grantedBy(SystemAdmin admin, SystemPermission systemPermission) {

    }

    public void deniedBy(SystemAdmin admin, SystemPermission systemPermission) {

    }
}
