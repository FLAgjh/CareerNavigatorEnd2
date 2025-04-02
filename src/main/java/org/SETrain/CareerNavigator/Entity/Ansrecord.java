package org.SETrain.CareerNavigator.Entity;

import java.util.Objects;

public class Ansrecord {
    private Integer id;
    private String username;
    private Integer paperid;
    private Integer exeid;
    private String op;

    @Override
    public String toString() {
        return "Ansrecord{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", paperid=" + paperid +
                ", exeid=" + exeid +
                ", op='" + op + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ansrecord ansrecord = (Ansrecord) o;
        return Objects.equals(id, ansrecord.id) && Objects.equals(username, ansrecord.username) && Objects.equals(paperid, ansrecord.paperid) && Objects.equals(exeid, ansrecord.exeid) && Objects.equals(op, ansrecord.op);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, paperid, exeid, op);
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

    public Integer getPaperid() {
        return paperid;
    }

    public void setPaperid(Integer paperid) {
        this.paperid = paperid;
    }

    public Integer getExeid() {
        return exeid;
    }

    public void setExeid(Integer exeid) {
        this.exeid = exeid;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }
}
