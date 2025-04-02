package org.SETrain.CareerNavigator.Entity;

import java.util.Objects;

public class Chat {
    private Integer id;
    private String msg;
    private Integer interviewid;
    private String chattime;
    private String role;

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", interviewid=" + interviewid +
                ", chattime='" + chattime + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chat chat = (Chat) o;
        return Objects.equals(id, chat.id) && Objects.equals(msg, chat.msg) && Objects.equals(interviewid, chat.interviewid) && Objects.equals(chattime, chat.chattime) && Objects.equals(role, chat.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, msg, interviewid, chattime, role);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getInterviewid() {
        return interviewid;
    }

    public void setInterviewid(Integer interviewid) {
        this.interviewid = interviewid;
    }

    public String getChattime() {
        return chattime;
    }

    public void setChattime(String chattime) {
        this.chattime = chattime;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
