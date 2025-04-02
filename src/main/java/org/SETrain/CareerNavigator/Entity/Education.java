package org.SETrain.CareerNavigator.Entity;

import java.util.Objects;

public class Education {
    private Integer eduid;
    private Integer id;
    private String school;
    private String degree;
    private String major;
    private String startDate;
    private String endDate;
    private Integer resumeid;

    @Override
    public String toString() {
        return "Education{" +
                "eduid=" + eduid +
                ", id=" + id +
                ", school='" + school + '\'' +
                ", degree='" + degree + '\'' +
                ", major='" + major + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", resumeid=" + resumeid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Education education = (Education) o;
        return Objects.equals(eduid, education.eduid) && Objects.equals(id, education.id) && Objects.equals(school, education.school) && Objects.equals(degree, education.degree) && Objects.equals(major, education.major) && Objects.equals(startDate, education.startDate) && Objects.equals(endDate, education.endDate) && Objects.equals(resumeid, education.resumeid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eduid, id, school, degree, major, startDate, endDate, resumeid);
    }

    public Integer getEduid() {
        return eduid;
    }

    public void setEduid(Integer eduid) {
        this.eduid = eduid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getResumeid() {
        return resumeid;
    }

    public void setResumeid(Integer resumeid) {
        this.resumeid = resumeid;
    }
}
