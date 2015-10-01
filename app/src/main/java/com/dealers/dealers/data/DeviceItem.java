package com.dealers.dealers.data;

import java.util.Date;

/**
 * Created by gullumbroso on 4/16/15.
 */
public class DeviceItem {

    private long deviceID;
    private long dealerID;
    private String UDID;
    private String token;
    private String os; // iOS; Android; Browser;
    private String arn;
    private int badge;
    private Date lastUpdateDate;
    private Date creationDate;

    public long getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(long deviceID) {
        this.deviceID = deviceID;
    }

    public long getDealerID() {
        return dealerID;
    }

    public void setDealerID(long dealerID) {
        this.dealerID = dealerID;
    }

    public String getUDID() {
        return UDID;
    }

    public void setUDID(String UDID) {
        this.UDID = UDID;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getArn() {
        return arn;
    }

    public void setArn(String arn) {
        this.arn = arn;
    }

    public int getBadge() {
        return badge;
    }

    public void setBadge(int badge) {
        this.badge = badge;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
