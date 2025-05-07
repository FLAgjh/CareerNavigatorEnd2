package org.SETrain.CareerNavigator.Controller;

import org.SETrain.CareerNavigator.Entity.Chat;
import org.SETrain.CareerNavigator.Entity.Interview;
import org.SETrain.CareerNavigator.Entity.Result;
import org.SETrain.CareerNavigator.Service.InterviewService;
import org.SETrain.CareerNavigator.prompts.InterviewPrompts;
import org.SETrain.CareerNavigator.prompts.InterviewReportPrompts;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.ai.chat.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/interview")
public class InterviewController {
    private final ChatClient chatClient;

    public InterviewController(ChatClient chatClient ) {
        this.chatClient = chatClient;
    }

    @Autowired
    private InterviewService interviewService;

    @PostMapping("/new")
    public Result newInterview(@RequestBody Interview interview){
        interviewService.newInterview(interview);

        String sysSet=  String.format(
                InterviewPrompts.newInterviewPrompt
                        .replace("{jobname}", "%s")
                        .replace("{interviewtype}", "%s")
                        .replace("{intensity}", "%s")
                        .replace("{jobdescription}", "%s")
                        .replace("{resumecontent}", "%s"),
                interview.getJobname(), interview.getInterviewtype(), interview.getIntensity(), interview.getJobdescription(), interview.getResumecontent()
        );
        ChatController.setSystemPrompt(sysSet);

         return Result.success(interview.getId());
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

    @PostMapping("/extractText")
    public Result extractTextFromPdf(@RequestParam("file") MultipartFile file) {
        try {
            // 使用 PDFBox 解析 PDF 文档
            PDDocument document = PDDocument.load(file.getInputStream());
            PDFTextStripper pdfStripper = new PDFTextStripper();
            String text = pdfStripper.getText(document);
            document.close();
            return Result.success(text);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("无法解析 PDF 文档");
        }
    }
    @GetMapping("/getInterviewChat")
    public Result getInterviewChat(@RequestParam Integer interviewid){
        List<Chat> chat = interviewService.getInterviewChat(interviewid);
        return Result.success(chat);
    }
     @GetMapping ("/getInterviewAssignment")
     public Result getInterviewAssignment(Integer interviewid){
         List<Chat> chats=interviewService.getInterviewChat(interviewid);
         StringBuilder chatRecord= new StringBuilder();
         for (Chat chat:chats){
             chatRecord.append(chat.getRole()).append(":").append(chat.getMsg()+"\n");
         }
        String chatRecords= chatRecord.toString();
         System.out.println(chatRecords);
         getTolScore(interviewid,chatRecords);
            getPreScore(interviewid,chatRecords);
            getLogicScore(interviewid,chatRecords);
            getChangeScore(interviewid,chatRecords);
            getSkillsSummary(interviewid,chatRecords);
            getAdvice(interviewid,chatRecords);
         return Result.success();
     }
    public Result getTolScore(Integer interviewid, String chatRecords){
       String  BasePrompt= InterviewReportPrompts.getSore;

        String totalScore= chatClient.call(BasePrompt+chatRecords);
        interviewService.getToalScore(interviewid,totalScore);
        System.out.println(totalScore);
        return Result.success();
    }

    public Result getPreScore( Integer interviewid,String chatRecords){
         String BasePrompt=InterviewReportPrompts.getPreScore;
        String preScore= chatClient.call(BasePrompt+chatRecords);
        interviewService.getPreScore(interviewid,preScore);
        System.out.println(preScore);
        return Result.success();
    }

    public Result getLogicScore(Integer interviewid,String chatRecords){
        String BasePrompt=InterviewReportPrompts.getLogicScore;
        String logicScore= chatClient.call(BasePrompt+chatRecords);
        interviewService.getLogicScore(interviewid,logicScore);
        System.out.println(logicScore);
        return Result.success();
    }
    public Result getChangeScore(Integer interviewid,String chatRecords){
        String BasePrompt=InterviewReportPrompts.getChangeScore;
        String changeScore= chatClient.call(BasePrompt+chatRecords);
        interviewService.getChangeScore(interviewid,changeScore);
        System.out.println(changeScore);
        return Result.success();
    }
    public Result getSkillsSummary(Integer interviewid,String chatRecords){
         String BasePrompt=InterviewReportPrompts.getSkillsSummary;
        String skillsSummary= chatClient.call(BasePrompt+chatRecords);
        interviewService.getSkillsSummary(interviewid,skillsSummary);
        System.out.println(skillsSummary);
        return Result.success();
    }
    public Result getAdvice(Integer interviewid,String chatRecords){
        String BasePrompt=InterviewReportPrompts.getAdvice;
        String advice= chatClient.call(BasePrompt+chatRecords);
        interviewService.getAdvice(interviewid,advice);
        System.out.println(advice);
        return Result.success();
    }



}
