package tn.esprit.coexist.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.coexist.entity.FeedBack;
import tn.esprit.coexist.service.FeedbackService;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class FeedbackController {
    FeedbackService feedbackService;
    @PostMapping("/addFeedback")
    public FeedBack addFeedback(@RequestBody FeedBack feedBack){
        return feedbackService.addFedback(feedBack);

    }
    @PutMapping("/updateFeedback/{feedBackId}")
    public void updateFeedback(@PathVariable Integer feedBackId,@RequestBody FeedBack feedBack){
        feedbackService.updateFeedback(feedBackId,feedBack);
    }
    @GetMapping("/getAllFeedback") // Corrected endpoint mapping

    public List<FeedBack> getAllFedback(){
        return feedbackService.getAllFedback();
    }
}
