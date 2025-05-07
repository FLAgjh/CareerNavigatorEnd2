package org.SETrain.CareerNavigator.Mapper;

import org.SETrain.CareerNavigator.Entity.Chat;
import org.SETrain.CareerNavigator.Entity.Interview;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface InterviewMapper {
    @Insert("insert into interview (username, jobname, jobtype, interviewtype, intensity, jobdescription, resume,resumecontent,starttime ) " +
            "values (#{username}, #{jobname}, #{jobtype}, #{interviewtype}, #{intensity}, #{jobdescription}, #{resume},#{resumecontent},#{starttime} )")
    @Options(useGeneratedKeys = true, keyProperty = "id")

    void newInterview(Interview interview);
    @Select("select * from interview where username=#{username}")
    List<Interview> getAllInterview(String username);
    @Delete("delete from interview where id=#{id}")
    void deleteInterview(Integer id);
    @Select("select * from interview where id=#{id} ")
    Interview getReportDetail(Integer id);
    @Select("select * from chat where interviewid=#{interviewid} order by chattime")
    List<Chat> getInterviewChat(Integer interviewid);
    @Update("update interview set totalScore=#{scoreInt} where id=#{interviewid}")
    void getToalScore(Integer interviewid, Integer scoreInt);
    @Update("update interview set preScore=#{scoreInt} where id=#{interviewid}")
    void getPreScore(Integer interviewid, Integer scoreInt);
    @Update("update interview set logicScore=#{scoreInt} where id=#{interviewid}")
    void getLogicScore(Integer interviewid, Integer scoreInt);
    @Update("update interview set changeScore=#{scoreInt} where id=#{interviewid}")
    void getChangeScore(Integer interviewid, Integer scoreInt);
    @Update("update interview set skillsSummary=#{skillsSummary} where id=#{interviewid}")
    void getSkillsSummary(Integer interviewid, String skillsSummary);
    @Update("update interview set advice=#{advice} where id=#{interviewid}")
    void getAdvice(Integer interviewid, String advice);
}
