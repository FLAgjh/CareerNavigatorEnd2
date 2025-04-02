package org.SETrain.CareerNavigator.Entity;

import java.util.Objects;

public class Comment {
    private Integer id;
    private String username;
    private Integer jobid;
    private String commentdate;
    private String content;
    private String type;
    private Integer fatherid;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", jobid=" + jobid +
                ", commentdate='" + commentdate + '\'' +
                ", content='" + content + '\'' +
                ", type='" + type + '\'' +
                ", fatherid=" + fatherid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(id, comment.id) && Objects.equals(username, comment.username) && Objects.equals(jobid, comment.jobid) && Objects.equals(commentdate, comment.commentdate) && Objects.equals(content, comment.content) && Objects.equals(type, comment.type) && Objects.equals(fatherid, comment.fatherid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, jobid, commentdate, content, type, fatherid);
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

    public String getCommentdate() {
        return commentdate;
    }

    public void setCommentdate(String commentdate) {
        this.commentdate = commentdate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getFatherid() {
        return fatherid;
    }

    public void setFatherid(Integer fatherid) {
        this.fatherid = fatherid;
    }
}
