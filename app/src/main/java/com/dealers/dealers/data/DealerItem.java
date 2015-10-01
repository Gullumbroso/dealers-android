package com.dealers.dealers.data;

import android.media.Image;

import com.google.gson.annotations.Expose;

import java.util.Date;
import java.util.List;

/**
 * Created by gullumbroso on 4/16/15.
 */
public class DealerItem {

    @Expose
    private long id;
    @Expose
    private String email;
    @Expose
    private UserItem user;
    @Expose
    private String fullName;
    @Expose
    private Date dateOfBirth;
    @Expose
    private String gender;
    @Expose
    private String about;
    @Expose
    private String location;

    @Expose
    private String photo;
    private boolean downloadingPhoto;

    @Expose
    private Date registerDate;
    @Expose
    private int badReportsCounter;
    @Expose
    private int score;
    @Expose
    private String rank;
    @Expose
    private int reliability;

    @Expose
    private List<Long> uploadedDeals;
    @Expose
    private List<Long> likedDeals;
    @Expose
    private List<Long> sharedDeals;
    @Expose
    private List<Long> followings;
    @Expose
    private List<Long> followedBy;

    @Expose
    private int invitationCounter;
    @Expose
    private List<DeviceItem> devices;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserItem getUser() {
        return user;
    }

    public void setUser(UserItem user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public boolean isDownloadingPhoto() {
        return downloadingPhoto;
    }

    public void setDownloadingPhoto(boolean downloadingPhoto) {
        this.downloadingPhoto = downloadingPhoto;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public int getBadReportsCounter() {
        return badReportsCounter;
    }

    public void setBadReportsCounter(int badReportsCounter) {
        this.badReportsCounter = badReportsCounter;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getReliability() {
        return reliability;
    }

    public void setReliability(int reliability) {
        this.reliability = reliability;
    }

    public List<Long> getUploadedDeals() {
        return uploadedDeals;
    }

    public void setUploadedDeals(List<Long> uploadedDeals) {
        this.uploadedDeals = uploadedDeals;
    }

    public List<Long> getLikedDeals() {
        return likedDeals;
    }

    public void setLikedDeals(List<Long> likedDeals) {
        this.likedDeals = likedDeals;
    }

    public List<Long> getSharedDeals() {
        return sharedDeals;
    }

    public void setSharedDeals(List<Long> sharedDeals) {
        this.sharedDeals = sharedDeals;
    }

    public List<Long> getFollowings() {
        return followings;
    }

    public void setFollowings(List<Long> followings) {
        this.followings = followings;
    }

    public List<Long> getFollowedBy() {
        return followedBy;
    }

    public void setFollowedBy(List<Long> followedBy) {
        this.followedBy = followedBy;
    }

    public int getInvitationCounter() {
        return invitationCounter;
    }

    public void setInvitationCounter(int invitationCounter) {
        this.invitationCounter = invitationCounter;
    }

    public List<DeviceItem> getDevices() {
        return devices;
    }

    public void setDevices(List<DeviceItem> devices) {
        this.devices = devices;
    }
}