package org.SETrain.CareerNavigator.Entity;

import java.util.Objects;

public class Honors {
    private Integer honorid;
    private Integer id;
    private String honorName;
    private String  date;
    private String description;
    private Integer resumeid;

    @Override
    public String toString() {
        return "Honors{" +
                "honorid=" + honorid +
                ", id=" + id +
                ", honorName='" + honorName + '\'' +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", resumeid=" + resumeid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Honors honors = (Honors) o;
        return Objects.equals(honorid, honors.honorid) && Objects.equals(id, honors.id) && Objects.equals(honorName, honors.honorName) && Objects.equals(date, honors.date) && Objects.equals(description, honors.description) && Objects.equals(resumeid, honors.resumeid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(honorid, id, honorName, date, description, resumeid);
    }

    public Integer getHonorid() {
        return honorid;
    }

    public void setHonorid(Integer honorid) {
        this.honorid = honorid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHonorName() {
        return honorName;
    }

    public void setHonorName(String honorName) {
        this.honorName = honorName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
