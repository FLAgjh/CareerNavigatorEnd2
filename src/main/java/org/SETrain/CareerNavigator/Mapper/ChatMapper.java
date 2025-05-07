package org.SETrain.CareerNavigator.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChatMapper {
    @Insert("insert into chat (msg,interviewid,chattime,role) values (#{msg},#{interviewid},#{chattime},#{role})")
    void recordChat(String msg, Integer interviewid,String chattime,String role);
}
