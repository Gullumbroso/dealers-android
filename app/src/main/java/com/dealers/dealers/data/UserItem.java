package com.dealers.dealers.data;

import com.google.gson.annotations.Expose;

/**
 * Created by gullumbroso on 4/16/15.
 */
public class UserItem {

    @Expose
    private long id;
    @Expose
    private String username;
    @Expose
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
