package org.SETrain.CareerNavigator.Service.Impl;

import org.SETrain.CareerNavigator.Controller.ChatController;
import org.SETrain.CareerNavigator.Entity.Chat;
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

    @Override
    public List<Chat> getInterviewChat(Integer interviewid) {
        return interviewMapper.getInterviewChat(interviewid);
    }

    @Override
    public void getAdvice(Integer interviewid, String advice) {
        interviewMapper.getAdvice(interviewid, advice);
    }

    @Override
    public void getSkillsSummary(Integer interviewid, String skillsSummary) {
        interviewMapper.getSkillsSummary(interviewid, skillsSummary);
    }

    @Override
    public void getChangeScore(Integer interviewid, String changeScore) {
        // 提取出changeScore中的数字
        String score = changeScore.replaceAll("[^0-9]", "");
        // 将score转换为整数
        Integer scoreInt = Integer.parseInt(score);
        // 将scoreInt存入数据库
        interviewMapper.getChangeScore(interviewid, scoreInt);

    }

    @Override
    public void getLogicScore(Integer interviewid, String logicScore) {
        // 提取出logicScore中的数字
        String score = logicScore.replaceAll("[^0-9]", "");
        // 将score转换为整数
        Integer scoreInt = Integer.parseInt(score);
        // 将scoreInt存入数据库
        interviewMapper.getLogicScore(interviewid, scoreInt);
    }

    @Override
    public void getPreScore(Integer interviewid, String preScore) {
        // 提取出preScore中的数字
        String score = preScore.replaceAll("[^0-9]", "");
        // 将score转换为整数
        Integer scoreInt = Integer.parseInt(score);
        // 将scoreInt存入数据库
        interviewMapper.getPreScore(interviewid, scoreInt);
    }

    @Override
    public void getToalScore(Integer interviewid, String totalScore) {
        // 提取出totalScore中的数字
        String score = totalScore.replaceAll("[^0-9]", "");
        // 将score转换为整数
        Integer scoreInt = Integer.parseInt(score);
        // 将scoreInt存入数据库
        interviewMapper.getToalScore(interviewid, scoreInt);
    }


}
