package com.dealers.dealers.data;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by gullumbroso on 4/16/15.
 */
public class CommentItem {

    private long commentID;
    private String text;
    private int dealID;
    private DealerItem dealer;
    private Date uploadDate;
    private String type; // Deal or Post. Currently only Deal type exists
    private DateFormat dateFormatter;

    public long getCommentID() {
        return commentID;
    }

    public void setCommentID(long commentID) {
        this.commentID = commentID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getDealID() {
        return dealID;
    }

    public void setDealID(int dealID) {
        this.dealID = dealID;
    }

    public DealerItem getDealer() {
        return dealer;
    }

    public void setDealer(DealerItem dealer) {
        this.dealer = dealer;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public DateFormat getDateFormatter() {
        return dateFormatter;
    }

    public void setDateFormatter(DateFormat dateFormatter) {
        this.dateFormatter = dateFormatter;
    }

    public CommentItem() {
        this.dateFormatter = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
    }
}
