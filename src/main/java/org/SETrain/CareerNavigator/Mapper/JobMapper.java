package org.SETrain.CareerNavigator.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.SETrain.CareerNavigator.Entity.Job;
import java.util.List;

@Mapper
public interface JobMapper {
    // Fix: Change "jobs" to "job" to match the actual table name
    @Select("SELECT * FROM job")
    List<Job> findAllJobs();

    @Select("SELECT * FROM job WHERE id = #{id}")
    Job findJobById(Integer id);

    @Select("<script>" +
            "SELECT * FROM job " +
            "WHERE id IN " +
            "<foreach collection='list' item='id' open='(' separator=',' close=')'>" +
            "#{id}" +
            "</foreach>" +
            "</script>")
    List<Job> findJobsByIds(List<Integer> jobIds);

    // Moved the misplaced method declaration inside the interface body
    List<Job> findAll();
}