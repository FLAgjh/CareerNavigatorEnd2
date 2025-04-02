package org.SETrain.CareerNavigator.Entity;

import java.util.Objects;

public class Job {
    private Integer id;
    private String jobname;
    private String company;
    private String salary;
    private String location;
    private String experience;
    private String education;
    private String jobtype;
    private String jobdescription;
    private String requirement;
    private  String publishdate;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return Objects.equals(id, job.id) && Objects.equals(jobname, job.jobname) && Objects.equals(company, job.company) && Objects.equals(salary, job.salary) && Objects.equals(location, job.location) && Objects.equals(experience, job.experience) && Objects.equals(education, job.education) && Objects.equals(jobtype, job.jobtype) && Objects.equals(jobdescription, job.jobdescription) && Objects.equals(requirement, job.requirement) && Objects.equals(publishdate, job.publishdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, jobname, company, salary, location, experience, education, jobtype, jobdescription, requirement, publishdate);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getJobtype() {
        return jobtype;
    }

    public void setJobtype(String jobtype) {
        this.jobtype = jobtype;
    }

    public String getJobdescription() {
        return jobdescription;
    }

    public void setJobdescription(String jobdescription) {
        this.jobdescription = jobdescription;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(String publishdate) {
        this.publishdate = publishdate;
    }
}
