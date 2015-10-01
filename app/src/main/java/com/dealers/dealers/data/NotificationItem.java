package com.dealers.dealers.data;

import java.util.Date;
import java.util.List;

/**
 * Created by gullumbroso on 4/16/15.
 */
public class NotificationItem {

    private long notificationID;
    private List<Integer> recipients;
    private String type;
    private DealerItem dealer;
    private long dealID;
    private String subjectTitle;
    private Date date;

    private boolean wasRead;
    private boolean noDuplicates;
    private boolean grouped;

    public long getNotificationID() {
        return notificationID;
    }

    public void setNotificationID(long notificationID) {
        this.notificationID = notificationID;
    }

    public List<Integer> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<Integer> recipients) {
        this.recipients = recipients;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public DealerItem getDealer() {
        return dealer;
    }

    public void setDealer(DealerItem dealer) {
        this.dealer = dealer;
    }

    public long getDealID() {
        return dealID;
    }

    public void setDealID(long dealID) {
        this.dealID = dealID;
    }

    public String getSubjectTitle() {
        return subjectTitle;
    }

    public void setSubjectTitle(String subjectTitle) {
        this.subjectTitle = subjectTitle;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isWasRead() {
        return wasRead;
    }

    public void setWasRead(boolean wasRead) {
        this.wasRead = wasRead;
    }

    public boolean isNoDuplicates() {
        return noDuplicates;
    }

    public void setNoDuplicates(boolean noDuplicates) {
        this.noDuplicates = noDuplicates;
    }

    public boolean isGrouped() {
        return grouped;
    }

    public void setGrouped(boolean grouped) {
        this.grouped = grouped;
    }
}
