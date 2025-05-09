package org.SETrain.CareerNavigator.Entity;

import java.util.Date;

public class ResumeAssessmentRecord {
    private Integer id;
    private Integer resumeId;  // 关联的简历ID
    private String assessmentResult;  // 评估结果内容
    private Date assessmentTime;  // 评估时间

    // 构造方法、getter和setter省略（实际需补充）
    public ResumeAssessmentRecord() {}

    public ResumeAssessmentRecord(Integer resumeId, String assessmentResult, Date assessmentTime) {
        this.resumeId = resumeId;
        this.assessmentResult = assessmentResult;
        this.assessmentTime = assessmentTime;
    }

    // 以下为自动生成的getter和setter
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getResumeId() { return resumeId; }
    public void setResumeId(Integer resumeId) { this.resumeId = resumeId; }
    public String getAssessmentResult() { return assessmentResult; }
    public void setAssessmentResult(String assessmentResult) { this.assessmentResult = assessmentResult; }
    public Date getAssessmentTime() { return assessmentTime; }
    public void setAssessmentTime(Date assessmentTime) { this.assessmentTime = assessmentTime; }
}