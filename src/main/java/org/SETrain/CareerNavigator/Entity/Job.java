package org.SETrain.CareerNavigator.Entity;

import java.util.Objects;

public class Job {
    private Integer id;
    private String jobname;  // 对应数据库 jobname 列（岗位名称）
    private String company;  // 公司名称
    private String salary;   // 薪资范围
    private String location; // 工作地点
    private String experience; // 经验要求
    private String education;  // 学历要求
    private String jobtype;    // 岗位类型
    private String jobdescription; // 岗位描述
    private String requirement;    // 任职要求
    private String publishdate;    // 发布时间

    // 所有字段的 getter 方法
    public Integer getId() {
        return id;
    }

    public String getJobname() {
        return jobname;
    }

    public String getCompany() {
        return company;
    }

    public String getSalary() {
        return salary;
    }

    public String getLocation() {
        return location;
    }

    public String getExperience() {
        return experience;
    }

    public String getEducation() {
        return education;
    }

    public String getJobtype() {
        return jobtype;
    }

    public String getJobdescription() {
        return jobdescription;
    }

    public String getRequirement() {
        return requirement;
    }

    public String getPublishdate() {
        return publishdate;
    }

    // 所有字段的 setter 方法
    public void setId(Integer id) {
        this.id = id;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setJobtype(String jobtype) {
        this.jobtype = jobtype;
    }

    public void setJobdescription(String jobdescription) {
        this.jobdescription = jobdescription;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public void setPublishdate(String publishdate) {
        this.publishdate = publishdate;
    }

    // 重写 toString 方法（方便调试）
    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", jobname='" + jobname + '\'' +
                ", company='" + company + '\'' +
                ", salary='" + salary + '\'' +
                ", location='" + location + '\'' +
                ", experience='" + experience + '\'' +
                ", education='" + education + '\'' +
                ", jobtype='" + jobtype + '\'' +
                ", jobdescription='" + jobdescription + '\'' +
                ", requirement='" + requirement + '\'' +
                ", publishdate='" + publishdate + '\'' +
                '}';
    }

    // 重写 equals 和 hashCode 方法（基于所有字段比较）
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return Objects.equals(id, job.id) &&
                Objects.equals(jobname, job.jobname) &&
                Objects.equals(company, job.company) &&
                Objects.equals(salary, job.salary) &&
                Objects.equals(location, job.location) &&
                Objects.equals(experience, job.experience) &&
                Objects.equals(education, job.education) &&
                Objects.equals(jobtype, job.jobtype) &&
                Objects.equals(jobdescription, job.jobdescription) &&
                Objects.equals(requirement, job.requirement) &&
                Objects.equals(publishdate, job.publishdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, jobname, company, salary, location, experience, education, jobtype, jobdescription, requirement, publishdate);
    }
}
