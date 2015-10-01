package com.dealers.dealers.data;

/**
 * Created by gullumbroso on 4/16/15.
 */
public class InvitationItem {

    private long invitationID;
    private String passcode;
    private long dealerID;

    public long getInvitationID() {
        return invitationID;
    }

    public void setInvitationID(long invitationID) {
        this.invitationID = invitationID;
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    public long getDealerID() {
        return dealerID;
    }

    public void setDealerID(long dealerID) {
        this.dealerID = dealerID;
    }
}
