package org.SETrain.CareerNavigator.Entity;

import java.util.Objects;

public class Jobapply {
    private Integer id;
    private String username;
    private Integer jobid;
    private String applydate;
    private String status;

    @Override
    public String toString() {
        return "Jobapply{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", jobid=" + jobid +
                ", applydate='" + applydate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jobapply jobapply = (Jobapply) o;
        return Objects.equals(id, jobapply.id) && Objects.equals(username, jobapply.username) && Objects.equals(jobid, jobapply.jobid) && Objects.equals(applydate, jobapply.applydate) && Objects.equals(status, jobapply.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, jobid, applydate, status);
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

    public Integer getJobid() {
        return jobid;
    }

    public void setJobid(Integer jobid) {
        this.jobid = jobid;
    }

    public String getApplydate() {
        return applydate;
    }

    public void setApplydate(String applydate) {
        this.applydate = applydate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
