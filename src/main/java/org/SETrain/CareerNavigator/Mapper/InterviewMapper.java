package org.SETrain.CareerNavigator.Mapper;

import org.SETrain.CareerNavigator.Entity.Interview;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface InterviewMapper {
    @Insert("insert into interview (username, jobname, jobtype, interviewtype, intensity, jobdescription, resume,starttime ) " +
            "values (#{username}, #{jobname}, #{jobtype}, #{interviewtype}, #{intensity}, #{jobdescription}, #{resume},#{starttime} )")
    void newInterview(Interview interview);
    @Select("select * from interview where username=#{username}")
    List<Interview> getAllInterview(String username);
    @Delete("delete from interview where id=#{id}")
    void deleteInterview(Integer id);
    @Select("select * from interview where id=#{id} ")
    Interview getReportDetail(Integer id);
}
