package org.SETrain.CareerNavigator.Entity;

import java.util.Objects;

public class Interview {
    private Integer id;
    private String username;
    private String jobname;
    private String jobtype;
    private String interviewtime;
    private Integer score;
    private String  analysis;
    private String advice;
    private String review;

    @Override
    public String toString() {
        return "Interview{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", jobname='" + jobname + '\'' +
                ", jobtype='" + jobtype + '\'' +
                ", interviewtime='" + interviewtime + '\'' +
                ", score=" + score +
                ", analysis='" + analysis + '\'' +
                ", advice='" + advice + '\'' +
                ", review='" + review + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interview interview = (Interview) o;
        return Objects.equals(id, interview.id) && Objects.equals(username, interview.username) && Objects.equals(jobname, interview.jobname) && Objects.equals(jobtype, interview.jobtype) && Objects.equals(interviewtime, interview.interviewtime) && Objects.equals(score, interview.score) && Objects.equals(analysis, interview.analysis) && Objects.equals(advice, interview.advice) && Objects.equals(review, interview.review);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, jobname, jobtype, interviewtime, score, analysis, advice, review);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname;
    }

    public String getJobtype() {
        return jobtype;
    }

    public void setJobtype(String jobtype) {
        this.jobtype = jobtype;
    }

    public String getInterviewtime() {
        return interviewtime;
    }

    public void setInterviewtime(String interviewtime) {
        this.interviewtime = interviewtime;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
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

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
