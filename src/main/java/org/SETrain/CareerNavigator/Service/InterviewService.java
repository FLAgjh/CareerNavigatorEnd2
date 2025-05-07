package org.SETrain.CareerNavigator.Service;

import org.SETrain.CareerNavigator.Entity.Chat;
import org.SETrain.CareerNavigator.Entity.Interview;

import java.util.List;

public interface InterviewService {
    void newInterview(Interview interview);

    List<Interview> getAllInterview();

    void deleteInterview(Integer id);

    Interview getReportDetail(Integer id);

    List<Chat> getInterviewChat(Integer interviewid);


    void getAdvice(Integer interviewid, String advice);

    void getSkillsSummary(Integer interviewid, String skillsSummary);

    void getChangeScore(Integer interviewid, String changeScore);

    void getLogicScore(Integer interviewid, String logicScore);

    void getPreScore(Integer interviewid, String preScore);

    void getToalScore(Integer interviewid, String totalScore);
}
