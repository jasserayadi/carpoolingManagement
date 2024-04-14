package tn.esprit.coexist.service;

import tn.esprit.coexist.entity.FeedBack;

import java.util.List;

public interface FeedbackService {
    public FeedBack addFedback(FeedBack feedBack);
    public void updateFeedback(Integer feedBackId,FeedBack feedBack);
    public List<FeedBack> getAllFedback();

}
