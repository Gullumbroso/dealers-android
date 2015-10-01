package com.dealers.dealers.data;

import android.media.Image;

import java.util.Date;
import java.util.List;

/**
 * Created by gullumbroso on 4/15/15.
 */
public class DealItem {

    private long dealID;
    private String title;
    private StoreItem store;
    private double price;
    private String currency;
    private int discountValue;
    private String discountType;
    private String category;
    private Date expirationDate;
    private String description;

    private String photoURL;
    private Image photo;
    private int photoSum;
    private Boolean downloadingPhoto;

    private String type;
    private Date uploadDate;
    private DealAttribItem dealAttrib;
    private DealerItem dealer;

    public long getDealID() {
        return dealID;
    }

    public void setDealID(long dealID) {
        this.dealID = dealID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public StoreItem getStore() {
        return store;
    }

    public void setStore(StoreItem store) {
        this.store = store;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(int discountValue) {
        this.discountValue = discountValue;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public Image getPhoto() {
        return photo;
    }

    public void setPhoto(Image photo) {
        this.photo = photo;
    }

    public int getPhotoSum() {
        return photoSum;
    }

    public void setPhotoSum(int photoSum) {
        this.photoSum = photoSum;
    }

    public Boolean getDownloadingPhoto() {
        return downloadingPhoto;
    }

    public void setDownloadingPhoto(Boolean downloadingPhoto) {
        this.downloadingPhoto = downloadingPhoto;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public DealAttribItem getDealAttrib() {
        return dealAttrib;
    }

    public void setDealAttrib(DealAttribItem dealAttrib) {
        this.dealAttrib = dealAttrib;
    }

    public DealerItem getDealer() {
        return dealer;
    }

    public void setDealer(DealerItem dealer) {
        this.dealer = dealer;
    }
}
