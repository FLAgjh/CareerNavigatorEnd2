package org.SETrain.CareerNavigator.Entity;

import java.util.Objects;

public class Summary {
    private Integer summaryid;
    private String summary;
    private Integer resumeid;

    @Override
    public String toString() {
        return "Summary{" +
                "summaryid=" + summaryid +
                ", summary='" + summary + '\'' +
                ", resumeid=" + resumeid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Summary summary1 = (Summary) o;
        return Objects.equals(summaryid, summary1.summaryid) && Objects.equals(summary, summary1.summary) && Objects.equals(resumeid, summary1.resumeid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(summaryid, summary, resumeid);
    }

    public Integer getSummaryid() {
        return summaryid;
    }

    public void setSummaryid(Integer summaryid) {
        this.summaryid = summaryid;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getResumeid() {
        return resumeid;
    }

    public void setResumeid(Integer resumeid) {
        this.resumeid = resumeid;
    }
}
