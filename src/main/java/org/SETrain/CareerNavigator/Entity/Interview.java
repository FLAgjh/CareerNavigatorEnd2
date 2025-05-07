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
    private String resumecontent;

    private String starttime;
    private String endtime;
    private Integer totalscore;
    private Integer prescore;
    private Integer logicscore;
    private Integer changescore;
    private String skillssummary;
    private String advice;

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
                ", resumecontent='" + resumecontent + '\'' +
                ", starttime='" + starttime + '\'' +
                ", endtime='" + endtime + '\'' +
                ", totalscore=" + totalscore +
                ", prescore=" + prescore +
                ", logicscore=" + logicscore +
                ", changescore=" + changescore +
                ", skillssummary='" + skillssummary + '\'' +
                ", advice='" + advice + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interview interview = (Interview) o;
        return Objects.equals(id, interview.id) && Objects.equals(username, interview.username) && Objects.equals(jobname, interview.jobname) && Objects.equals(jobtype, interview.jobtype) && Objects.equals(interviewtype, interview.interviewtype) && Objects.equals(intensity, interview.intensity) && Objects.equals(jobdescription, interview.jobdescription) && Objects.equals(resume, interview.resume) && Objects.equals(resumecontent, interview.resumecontent) && Objects.equals(starttime, interview.starttime) && Objects.equals(endtime, interview.endtime) && Objects.equals(totalscore, interview.totalscore) && Objects.equals(prescore, interview.prescore) && Objects.equals(logicscore, interview.logicscore) && Objects.equals(changescore, interview.changescore) && Objects.equals(skillssummary, interview.skillssummary) && Objects.equals(advice, interview.advice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, jobname, jobtype, interviewtype, intensity, jobdescription, resume, resumecontent, starttime, endtime, totalscore, prescore, logicscore, changescore, skillssummary, advice);
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

    public String getResumecontent() {
        return resumecontent;
    }

    public void setResumecontent(String resumecontent) {
        this.resumecontent = resumecontent;
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

    public Integer getTotalscore() {
        return totalscore;
    }

    public void setTotalscore(Integer totalscore) {
        this.totalscore = totalscore;
    }

    public Integer getPrescore() {
        return prescore;
    }

    public void setPrescore(Integer prescore) {
        this.prescore = prescore;
    }

    public Integer getLogicscore() {
        return logicscore;
    }

    public void setLogicscore(Integer logicscore) {
        this.logicscore = logicscore;
    }

    public Integer getChangescore() {
        return changescore;
    }

    public void setChangescore(Integer changescore) {
        this.changescore = changescore;
    }

    public String getSkillssummary() {
        return skillssummary;
    }

    public void setSkillssummary(String skillssummary) {
        this.skillssummary = skillssummary;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }
}
