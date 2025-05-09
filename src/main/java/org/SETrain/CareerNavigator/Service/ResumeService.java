package org.SETrain.CareerNavigator.Service;

import org.SETrain.CareerNavigator.Entity.Resume;
import java.util.List;

public interface ResumeService {
    Integer getLatestResumeIdByUsername(String username);
    String assessResume(String resumeContent);
    
    // 新增简历CRUD方法
    Resume createResume(Resume resume);
    Resume getResumeById(Integer id);
    Resume updateResume(Resume resume);
    void deleteResume(Integer id);
    
    // 新增：获取用户的简历列表
    List<Resume> getResumeListByUser(String username);
}