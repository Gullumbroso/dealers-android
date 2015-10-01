package com.dealers.dealers.data;

import java.util.List;

/**
 * Created by gullumbroso on 4/16/15.
 */
public class DealAttribItem {

    private long dealAttribID;
    private long dealID;
    private int objectiveRank;
    private int dealReliability;
    private List<Integer> dealersThatLiked;
    private List<Integer> dealersThatShared;

    public long getDealAttribID() {
        return dealAttribID;
    }

    public void setDealAttribID(long dealAttribID) {
        this.dealAttribID = dealAttribID;
    }

    public long getDealID() {
        return dealID;
    }

    public void setDealID(long dealID) {
        this.dealID = dealID;
    }

    public int getObjectiveRank() {
        return objectiveRank;
    }

    public void setObjectiveRank(int objectiveRank) {
        this.objectiveRank = objectiveRank;
    }

    public int getDealReliability() {
        return dealReliability;
    }

    public void setDealReliability(int dealReliability) {
        this.dealReliability = dealReliability;
    }

    public List<Integer> getDealersThatLiked() {
        return dealersThatLiked;
    }

    public void setDealersThatLiked(List<Integer> dealersThatLiked) {
        this.dealersThatLiked = dealersThatLiked;
    }

    public List<Integer> getDealersThatShared() {
        return dealersThatShared;
    }

    public void setDealersThatShared(List<Integer> dealersThatShared) {
        this.dealersThatShared = dealersThatShared;
    }
}
