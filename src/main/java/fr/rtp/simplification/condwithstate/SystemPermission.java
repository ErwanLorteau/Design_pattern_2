package fr.rtp.simplification.condwithstate;

import fr.unantes.sce.temp.PermissionState;

public class SystemPermission {

  private SystemProfile profile;
  private SystemUser requestor;
  private SystemAdmin admin;
  private boolean isGranted;
  private PermissionState state;

  public SystemPermission(SystemUser requestor, SystemProfile profile) {
    this.requestor = requestor;
    this.profile = profile;
    setState(PermissionState.REQUESTED);
    setGranted(false);
    notifyAdminOfPermissionRequest();
  }

  public void claimedBy(SystemAdmin admin) {
    getState().claimedBy(admin, this);
  }

  public void deniedBy(SystemAdmin admin) {
    getState().deniedBy(admin, this);
  }

  public void grantedBy(SystemAdmin admin) {
    getState().grantedBy(admin, this);
  }


  /**Following methods have been put in public beaucause in 6.1, path of extracting methods indicate to put the permission state méthod into unantes.sce.temp (error?)
   * But then, following methods are not accessible from sce.temp in protected visibility. I decided to put it in public to avoid undo the commit, but it should be protected and in the same package.

   * @param admin
   */
  public void willBeHandledBy(SystemAdmin admin) {
    this.setAdmin(admin);
  }

  public void notifyUserOfPermissionRequestResult() {
  }

  public void notifyAdminOfPermissionRequest() {
  }

  public PermissionState state() {
    return getState().getState();
  }

  public PermissionState getState() {
    return state;
  }

  public void setState(PermissionState state) {
    this.state = state;
  }

  public boolean isGranted() {
    return isGranted;
  }

  public void setGranted(boolean granted) {
    isGranted = granted;
  }

  public SystemAdmin getAdmin() {
    return admin;
  }

  public void setAdmin(SystemAdmin admin) {
    this.admin = admin;
  }
}


