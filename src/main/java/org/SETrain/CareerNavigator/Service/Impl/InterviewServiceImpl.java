package org.SETrain.CareerNavigator.Service.Impl;

import org.SETrain.CareerNavigator.Entity.Interview;
import org.SETrain.CareerNavigator.Mapper.InterviewMapper;
import org.SETrain.CareerNavigator.Service.InterviewService;
import org.SETrain.CareerNavigator.Util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InterviewServiceImpl implements InterviewService {
    @Autowired
    private InterviewMapper interviewMapper;
    @Override
    public void newInterview(Interview interview) {
        Map<String, Object> mp = ThreadLocalUtil.get();
        String username = (String) mp.get("username");
        interview.setUsername(username);
        String starttime = LocalDateTime.now().toString().substring(0, 19);
        interview.setStarttime(starttime);
        interviewMapper.newInterview(interview);
    }

    @Override
    public List<Interview> getAllInterview() {
        Map<String, Object> mp = ThreadLocalUtil.get();
        String username = (String) mp.get("username");
        return  interviewMapper.getAllInterview(username);
    }

    @Override
    public void deleteInterview(Integer id) {
        interviewMapper.deleteInterview(id);
    }

    @Override
    public Interview getReportDetail(Integer id) {
        return interviewMapper.getReportDetail(id);
    }
}
