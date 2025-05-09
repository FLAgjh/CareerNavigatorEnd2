package org.SETrain.CareerNavigator.Entity;

import java.util.Objects;

public class Interview {
    private Integer id;
    private String username; // 用户名
    private String jobname; // 岗位名称
    private String jobtype; // 岗位类型
    private String interviewtype; // 面试类型
    private Integer intensity; // 面试强度
    private String jobdescription; // 岗位描述
    private String resume; // 简历URL
    private String interviewtime; // 面试时间
    private Integer score; // 面试评分
    private String analysis; // 面试分析
    private String review; // 面试回顾
    private String advice; // 面试建议
    private String starttime;
    private String endtime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interview interview = (Interview) o;
        return Objects.equals(id, interview.id) && Objects.equals(username, interview.username) && Objects.equals(jobname, interview.jobname) && Objects.equals(jobtype, interview.jobtype) && Objects.equals(interviewtype, interview.interviewtype) && Objects.equals(intensity, interview.intensity) && Objects.equals(jobdescription, interview.jobdescription) && Objects.equals(resume, interview.resume) && Objects.equals(interviewtime, interview.interviewtime) && Objects.equals(score, interview.score) && Objects.equals(analysis, interview.analysis) && Objects.equals(review, interview.review) && Objects.equals(advice, interview.advice) && Objects.equals(starttime, interview.starttime) && Objects.equals(endtime, interview.endtime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, jobname, jobtype, interviewtype, intensity, jobdescription, resume, interviewtime, score, analysis, review, advice, starttime, endtime);
    }

    @Override
    public String toString() {
        return "Interview{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", jobname='" + jobname + '\'' +
                ", jobtype='" + jobtype + '\'' +
                ", interviewtype='" + interviewtype + '\'' +
                ", intensity=" + intensity +
                ", jobdescription='" + jobdescription + '\'' +
                ", resume='" + resume + '\'' +
                ", interviewtime='" + interviewtime + '\'' +
                ", score=" + score +
                ", analysis='" + analysis + '\'' +
                ", review='" + review + '\'' +
                ", advice='" + advice + '\'' +
                ", starttime='" + starttime + '\'' +
                ", endtime='" + endtime + '\'' +
                '}';
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
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

    public String getInterviewtype() {
        return interviewtype;
    }

    public void setInterviewtype(String interviewtype) {
        this.interviewtype = interviewtype;
    }

    public Integer getIntensity() {
        return intensity;
    }

    public void setIntensity(Integer intensity) {
        this.intensity = intensity;
    }

    public String getJobdescription() {
        return jobdescription;
    }

    public void setJobdescription(String jobdescription) {
        this.jobdescription = jobdescription;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
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

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }
}
