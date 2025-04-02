package org.SETrain.CareerNavigator.Entity;

import java.util.Objects;

public class Projects {
    private Integer projectid;
    private Integer id;
    private String projectName;
    private String role;
    private String startDate;
    private String endDate;
    private String description;
    private String briefIntroduction;
    private Integer resumeid;

    @Override
    public String toString() {
        return "Projects{" +
                "projectid=" + projectid +
                ", id=" + id +
                ", projectName='" + projectName + '\'' +
                ", role='" + role + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", description='" + description + '\'' +
                ", briefIntroduction='" + briefIntroduction + '\'' +
                ", resumeid=" + resumeid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Projects projects = (Projects) o;
        return Objects.equals(projectid, projects.projectid) && Objects.equals(id, projects.id) && Objects.equals(projectName, projects.projectName) && Objects.equals(role, projects.role) && Objects.equals(startDate, projects.startDate) && Objects.equals(endDate, projects.endDate) && Objects.equals(description, projects.description) && Objects.equals(briefIntroduction, projects.briefIntroduction) && Objects.equals(resumeid, projects.resumeid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectid, id, projectName, role, startDate, endDate, description, briefIntroduction, resumeid);
    }

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBriefIntroduction() {
        return briefIntroduction;
    }

    public void setBriefIntroduction(String briefIntroduction) {
        this.briefIntroduction = briefIntroduction;
    }

    public Integer getResumeid() {
        return resumeid;
    }

    public void setResumeid(Integer resumeid) {
        this.resumeid = resumeid;
    }
}
