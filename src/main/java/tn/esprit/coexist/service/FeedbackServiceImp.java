package tn.esprit.coexist.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.coexist.entity.FeedBack;
import tn.esprit.coexist.repository.FeedBackRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class FeedbackServiceImp implements FeedbackService{

FeedBackRepository feedBackRepository;
    @Override
    public FeedBack addFedback(FeedBack feedBack) {
        return feedBackRepository.save(feedBack);
    }

    @Override
    public void updateFeedback(Integer feedBackId, FeedBack feedBack) {
        feedBack.setFeedBackId(feedBackId);
        feedBackRepository.save(feedBack);
    }

    @Override
    public List<FeedBack> getAllFedback() {
        return feedBackRepository.findAll();
    }
}
