package fr.unantes.sce.temp;

import fr.rtp.simplification.condwithstate.SystemAdmin;
import fr.rtp.simplification.condwithstate.SystemPermission;

public class Claimed extends PermissionState {
    public Claimed(String state) {
        super(state);
    }

    public void claimedBy(SystemAdmin admin, SystemPermission systemPermission) {

    }

    public void grantedBy(SystemAdmin admin, SystemPermission systemPermission) {

      if (!admin.equals(systemPermission.getAdmin())) {
        return;
      }
      systemPermission.setState(GRANTED);
      systemPermission.setGranted(true);
      systemPermission.notifyUserOfPermissionRequestResult();
    }

    public void deniedBy(SystemAdmin admin, SystemPermission systemPermission) {

      if (!admin.equals(systemPermission.getAdmin())) {
        return;
      }
      systemPermission.setGranted(false);
      systemPermission.setState(DENIED);
      systemPermission.notifyUserOfPermissionRequestResult();
    }
}
