package org.SETrain.CareerNavigator.Service;

import org.SETrain.CareerNavigator.Entity.Interview;

import java.util.List;

public interface InterviewService {
    void newInterview(Interview interview);

    List<Interview> getAllInterview();

    void deleteInterview(Integer id);

    Interview getReportDetail(Integer id);
}
