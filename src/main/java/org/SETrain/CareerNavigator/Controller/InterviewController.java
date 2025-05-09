package org.SETrain.CareerNavigator.Controller;

import org.SETrain.CareerNavigator.Entity.Interview;
import org.SETrain.CareerNavigator.Entity.Result;
import org.SETrain.CareerNavigator.Service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interview")
public class InterviewController {
    @Autowired
    private InterviewService interviewService;
    @PostMapping("/new")
    public Result newInterview(@RequestBody Interview interview){
        interviewService.newInterview(interview);
        return Result.success();
    }
    @GetMapping("/getAll")
    public Result getAllInterview(){
       List<Interview>interviews= interviewService.getAllInterview();
        return Result.success(interviews);
    }
    @DeleteMapping("/delete")
    public Result deleteInterview(@RequestParam Integer id){
        interviewService.deleteInterview(id);
        return Result.success();
    }
    @GetMapping("/detail")
    public Result getReportDetail(@RequestParam Integer id){
        Interview interview = interviewService.getReportDetail(id);
        return Result.success(interview);
    }
}
