package org.SETrain.CareerNavigator.Entity;

import java.util.Objects;

public class Skills {
    private Integer skillid;
    private Integer id;
    private String skillName;
    private Integer resumeid;

    @Override
    public String toString() {
        return "Skills{" +
                "skillid=" + skillid +
                ", id=" + id +
                ", skillName='" + skillName + '\'' +
                ", resumeid=" + resumeid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skills skills = (Skills) o;
        return Objects.equals(skillid, skills.skillid) && Objects.equals(id, skills.id) && Objects.equals(skillName, skills.skillName) && Objects.equals(resumeid, skills.resumeid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(skillid, id, skillName, resumeid);
    }

    public Integer getSkillid() {
        return skillid;
    }

    public void setSkillid(Integer skillid) {
        this.skillid = skillid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public Integer getResumeid() {
        return resumeid;
    }

    public void setResumeid(Integer resumeid) {
        this.resumeid = resumeid;
    }
}
