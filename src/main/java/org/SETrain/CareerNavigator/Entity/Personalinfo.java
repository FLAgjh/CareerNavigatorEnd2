package org.SETrain.CareerNavigator.Entity;

import java.util.Objects;

public class Personalinfo {
    private Integer id;
    private String name;
    private  String gender;
    private String phone;
    private String email;
    private String university;
    private String politicalstatus;
    private String  website;
    private String avatar;
    private String major;
    private Integer age;
    private String applicationPosition;
    private Integer resumeid;

    @Override
    public String toString() {
        return "Personalinfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", university='" + university + '\'' +
                ", politicalstatus='" + politicalstatus + '\'' +
                ", website='" + website + '\'' +
                ", avatar='" + avatar + '\'' +
                ", major='" + major + '\'' +
                ", age=" + age +
                ", applicationPosition='" + applicationPosition + '\'' +
                ", resumeid=" + resumeid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personalinfo that = (Personalinfo) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(gender, that.gender) && Objects.equals(phone, that.phone) && Objects.equals(email, that.email) && Objects.equals(university, that.university) && Objects.equals(politicalstatus, that.politicalstatus) && Objects.equals(website, that.website) && Objects.equals(avatar, that.avatar) && Objects.equals(major, that.major) && Objects.equals(age, that.age) && Objects.equals(applicationPosition, that.applicationPosition) && Objects.equals(resumeid, that.resumeid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gender, phone, email, university, politicalstatus, website, avatar, major, age, applicationPosition, resumeid);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getPoliticalstatus() {
        return politicalstatus;
    }

    public void setPoliticalstatus(String politicalstatus) {
        this.politicalstatus = politicalstatus;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getApplicationPosition() {
        return applicationPosition;
    }

    public void setApplicationPosition(String applicationPosition) {
        this.applicationPosition = applicationPosition;
    }

    public Integer getResumeid() {
        return resumeid;
    }

    public void setResumeid(Integer resumeid) {
        this.resumeid = resumeid;
    }
}
