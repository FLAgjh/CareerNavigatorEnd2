package org.SETrain.CareerNavigator.Entity;

import java.util.Objects;

public class Workexperience {
    private Integer workid;
    private  Integer id;
    private String company;
    private String position;
    private String startdate;
    private String enddate;
    private String description;
    private Integer resumeid;

    public Integer getWorkid() {
        return workid;
    }

    @Override
    public String toString() {
        return "Workexperience{" +
                "workid=" + workid +
                ", id=" + id +
                ", company='" + company + '\'' +
                ", position='" + position + '\'' +
                ", startdate='" + startdate + '\'' +
                ", enddate='" + enddate + '\'' +
                ", description='" + description + '\'' +
                ", resumeid=" + resumeid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Workexperience that = (Workexperience) o;
        return Objects.equals(workid, that.workid) && Objects.equals(id, that.id) && Objects.equals(company, that.company) && Objects.equals(position, that.position) && Objects.equals(startdate, that.startdate) && Objects.equals(enddate, that.enddate) && Objects.equals(description, that.description) && Objects.equals(resumeid, that.resumeid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workid, id, company, position, startdate, enddate, description, resumeid);
    }

    public void setWorkid(Integer workid) {
        this.workid = workid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getResumeid() {
        return resumeid;
    }

    public void setResumeid(Integer resumeid) {
        this.resumeid = resumeid;
    }
}
