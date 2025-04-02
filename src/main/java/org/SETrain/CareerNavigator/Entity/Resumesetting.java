package org.SETrain.CareerNavigator.Entity;

import java.util.Objects;

public class Resumesetting {
    private Integer settingid;
    private Integer id;
    private Integer resumeid;
    private String themeColor1;
    private String themeColor2;
    private Integer fontSize;
    private Integer selectionSpacing;
    private Integer paragraphSpacing;
    private String currentTemplate;
    private Integer padding_top_bottom;
    private Integer padding_left_right;

    @Override
    public String toString() {
        return "Resumesetting{" +
                "settingid=" + settingid +
                ", id=" + id +
                ", resumeid=" + resumeid +
                ", themeColor1='" + themeColor1 + '\'' +
                ", themeColor2='" + themeColor2 + '\'' +
                ", fontSize=" + fontSize +
                ", selectionSpacing=" + selectionSpacing +
                ", paragraphSpacing=" + paragraphSpacing +
                ", currentTemplate='" + currentTemplate + '\'' +
                ", padding_top_bottom=" + padding_top_bottom +
                ", padding_left_right=" + padding_left_right +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resumesetting that = (Resumesetting) o;
        return Objects.equals(settingid, that.settingid) && Objects.equals(id, that.id) && Objects.equals(resumeid, that.resumeid) && Objects.equals(themeColor1, that.themeColor1) && Objects.equals(themeColor2, that.themeColor2) && Objects.equals(fontSize, that.fontSize) && Objects.equals(selectionSpacing, that.selectionSpacing) && Objects.equals(paragraphSpacing, that.paragraphSpacing) && Objects.equals(currentTemplate, that.currentTemplate) && Objects.equals(padding_top_bottom, that.padding_top_bottom) && Objects.equals(padding_left_right, that.padding_left_right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(settingid, id, resumeid, themeColor1, themeColor2, fontSize, selectionSpacing, paragraphSpacing, currentTemplate, padding_top_bottom, padding_left_right);
    }

    public Integer getSettingid() {
        return settingid;
    }

    public void setSettingid(Integer settingid) {
        this.settingid = settingid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getResumeid() {
        return resumeid;
    }

    public void setResumeid(Integer resumeid) {
        this.resumeid = resumeid;
    }

    public String getThemeColor1() {
        return themeColor1;
    }

    public void setThemeColor1(String themeColor1) {
        this.themeColor1 = themeColor1;
    }

    public String getThemeColor2() {
        return themeColor2;
    }

    public void setThemeColor2(String themeColor2) {
        this.themeColor2 = themeColor2;
    }

    public Integer getFontSize() {
        return fontSize;
    }

    public void setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
    }

    public Integer getSelectionSpacing() {
        return selectionSpacing;
    }

    public void setSelectionSpacing(Integer selectionSpacing) {
        this.selectionSpacing = selectionSpacing;
    }

    public Integer getParagraphSpacing() {
        return paragraphSpacing;
    }

    public void setParagraphSpacing(Integer paragraphSpacing) {
        this.paragraphSpacing = paragraphSpacing;
    }

    public String getCurrentTemplate() {
        return currentTemplate;
    }

    public void setCurrentTemplate(String currentTemplate) {
        this.currentTemplate = currentTemplate;
    }

    public Integer getPadding_top_bottom() {
        return padding_top_bottom;
    }

    public void setPadding_top_bottom(Integer padding_top_bottom) {
        this.padding_top_bottom = padding_top_bottom;
    }

    public Integer getPadding_left_right() {
        return padding_left_right;
    }

    public void setPadding_left_right(Integer padding_left_right) {
        this.padding_left_right = padding_left_right;
    }
}
