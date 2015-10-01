package com.dealers.dealers.data;

/**
 * Created by gullumbroso on 4/16/15.
 */
public class ReportItem {

    private long reportID;
    private long dealID;
    private String report;
    private long reportingDealerID;

    public long getReportID() {
        return reportID;
    }

    public void setReportID(long reportID) {
        this.reportID = reportID;
    }

    public long getDealID() {
        return dealID;
    }

    public void setDealID(long dealID) {
        this.dealID = dealID;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public long getReportingDealerID() {
        return reportingDealerID;
    }

    public void setReportingDealerID(long reportingDealerID) {
        this.reportingDealerID = reportingDealerID;
    }

}
