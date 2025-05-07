package org.SETrain.CareerNavigator.Service.Impl;

import org.SETrain.CareerNavigator.Mapper.ChatMapper;
import org.SETrain.CareerNavigator.Service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ChatServiceImpl implements ChatService {
    @Autowired
    private ChatMapper chatMapper;
    @Override
    public void recordChat(String msg ,Integer interviewid,String role) {
    String time= LocalDateTime.now().toString();
    chatMapper.recordChat(msg   ,interviewid,time,role);
    }
}
