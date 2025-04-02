package org.SETrain.CareerNavigator.Entity;

import java.util.Objects;

public class Assessment {
    private Integer id;
    private Integer paperid;
    private String username;
    private String analysis;
    private String advice;
    private String assessmenttime;

    @Override
    public String toString() {
        return "Assessment{" +
                "id=" + id +
                ", paperid=" + paperid +
                ", username='" + username + '\'' +
                ", analysis='" + analysis + '\'' +
                ", advice='" + advice + '\'' +
                ", assessmenttime='" + assessmenttime + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assessment that = (Assessment) o;
        return Objects.equals(id, that.id) && Objects.equals(paperid, that.paperid) && Objects.equals(username, that.username) && Objects.equals(analysis, that.analysis) && Objects.equals(advice, that.advice) && Objects.equals(assessmenttime, that.assessmenttime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, paperid, username, analysis, advice, assessmenttime);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPaperid() {
        return paperid;
    }

    public void setPaperid(Integer paperid) {
        this.paperid = paperid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public String getAssessmenttime() {
        return assessmenttime;
    }

    public void setAssessmenttime(String assessmenttime) {
        this.assessmenttime = assessmenttime;
    }
}
