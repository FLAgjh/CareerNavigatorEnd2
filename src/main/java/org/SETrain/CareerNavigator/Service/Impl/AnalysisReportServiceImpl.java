package org.SETrain.CareerNavigator.Service.Impl;

import org.SETrain.CareerNavigator.Entity.AnalysisReport;
import org.SETrain.CareerNavigator.Entity.Resume;
import org.SETrain.CareerNavigator.Mapper.AnalysisReportMapper;  // Ensure this class exists in the Mapper package
import org.SETrain.CareerNavigator.Service.AIAssessmentService;
import org.SETrain.CareerNavigator.Service.AnalysisReportService;
import org.SETrain.CareerNavigator.Service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;  // Add missing import for List

@Service
public class AnalysisReportServiceImpl implements AnalysisReportService {

    @Autowired
    private ResumeService resumeService;
    @Autowired
    private AIAssessmentService aiAssessmentService;
    @Autowired
    private AnalysisReportMapper analysisReportMapper;  // Requires AnalysisReportMapper to exist

    @Override
    public AnalysisReport generateReport(Integer resumeId, String userId) {
        Resume resume = resumeService.getResumeById(resumeId);
        if (resume == null) throw new RuntimeException("简历不存在");
        
        String reportContent = aiAssessmentService.assessResume(resume.getContent());  // Requires Resume.getContent() to exist
        AnalysisReport report = new AnalysisReport();
        report.setUserId(userId);
        report.setResumeId(resumeId);
        report.setReportContent(reportContent);
        report.setGenerateTime(new Date());
        
        analysisReportMapper.insert(report);
        return report;
    }

    @Override
    public List<AnalysisReport> getReportsByUser(String userId) {  // Now uses List due to added import
        return analysisReportMapper.selectByUserId(userId);
    }

    @Override
    public AnalysisReport getReportById(Integer id) {
        return analysisReportMapper.selectById(id);
    }
}