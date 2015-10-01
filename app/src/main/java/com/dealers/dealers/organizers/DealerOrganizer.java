package com.dealers.dealers.organizers;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.dealers.dealers.data.DealerItem;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by gullumbroso on 5/8/15.
 */
public class DealerOrganizer {

    public static final String USER_DETAILS = "user_details";

    private SharedPreferences mPreferences;
    private DealerItem mDealer;

    public DealerOrganizer(Context context, DealerItem dealer) {
        mPreferences = context.getSharedPreferences(USER_DETAILS, Context.MODE_PRIVATE);
        mDealer = dealer;
    }

    public void saveUserDetails() {
        if (mDealer != null) {
            SharedPreferences.Editor editor = mPreferences.edit();
            editor.putLong("id", mDealer.getId());
            editor.putString("email", mDealer.getEmail());
            editor.putString("username", mDealer.getUser().getUsername());
            editor.putString("fullName", mDealer.getFullName());
            if (mDealer.getDateOfBirth() != null)
                editor.putLong("dateOfBirth", mDealer.getDateOfBirth().getTime());
            editor.putString("gender", mDealer.getGender());
            editor.putString("location", mDealer.getLocation());
            editor.putString("about", mDealer.getAbout());
            editor.putLong("registerDate", mDealer.getRegisterDate().getTime());
            editor.putString("photo", mDealer.getPhoto());
            editor.putString("uploadedDeals", listToJson(mDealer.getUploadedDeals()));
            editor.putString("likedDeals", listToJson(mDealer.getLikedDeals()));
            editor.putString("sharedDeals", listToJson(mDealer.getSharedDeals()));
            editor.putString("followedBy", listToJson(mDealer.getFollowedBy()));
            editor.putString("followings", listToJson(mDealer.getFollowings()));
            editor.putInt("badReportsCounter", mDealer.getBadReportsCounter());
            editor.putInt("score", mDealer.getScore());
            editor.putString("rank", mDealer.getRank());
            editor.putInt("reliability", mDealer.getReliability());
            editor.putInt("invitationCounter", mDealer.getInvitationCounter());
            editor.apply();
        } else {
            Log.d("DealerOrganizer", "Dealer is null!");
        }
    }

    public DealerItem updateUser() {
        if (mDealer != null) {
            mDealer.setId(mPreferences.getLong("id", 0));
            mDealer.setEmail(mPreferences.getString("email", null));
            mDealer.getUser().setUsername(mPreferences.getString("username", null));
            mDealer.setFullName(mPreferences.getString("fullName", null));
            mDealer.setDateOfBirth(new Date(mPreferences.getLong("dateOfBirth", 0)));
            mDealer.setGender(mPreferences.getString("gender", null));
            mDealer.setLocation(mPreferences.getString("location", null));
            mDealer.setAbout(mPreferences.getString("about", null));
            mDealer.setRegisterDate(new Date(mPreferences.getLong("registerDate", 0)));
            mDealer.setPhoto(mPreferences.getString("photo", null));
            mDealer.setUploadedDeals(jsonToList(mPreferences.getString("uploadedDeals", null)));
            mDealer.setLikedDeals(jsonToList(mPreferences.getString("likedDeals", null)));
            mDealer.setSharedDeals(jsonToList(mPreferences.getString("sharedDeals", null)));
            mDealer.setFollowedBy(jsonToList(mPreferences.getString("followedBy", null)));
            mDealer.setFollowings(jsonToList(mPreferences.getString("followings", null)));
            mDealer.setBadReportsCounter(mPreferences.getInt("badReportsCounter", 0));
            mDealer.setScore(mPreferences.getInt("score", 0));
            mDealer.setRank(mPreferences.getString("rank", null));
            mDealer.setReliability(mPreferences.getInt("reliability", 0));
            mDealer.setInvitationCounter(mPreferences.getInt("invitationCounter", 0));
            return mDealer;
        } else {
            Log.d("DealerOrganizer", "Dealer is null!");
            return null;
        }
    }

    public void saveToken(String token) {
        if (token != null) {
            SharedPreferences.Editor editor = mPreferences.edit();
            editor.putString("token", token);
            editor.apply();
        }
    }

    public String getToken() {
        return mPreferences.getString("token", null);
    }

    private List<Long> jsonToList(String json) {
        Gson gson = new Gson();
        Long[] idItems = gson.fromJson(json, Long[].class);
        return Arrays.asList(idItems);
    }

    private String listToJson(List<Long> idList) {
        Gson gson = new Gson();
        return gson.toJson(idList);
    }
}
