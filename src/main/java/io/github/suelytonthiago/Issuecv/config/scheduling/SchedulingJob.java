package io.github.suelytonthiago.Issuecv.config.scheduling;

import io.github.suelytonthiago.Issuecv.rest.services.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulingJob {

    @Autowired
    private IssueService issueService;

    @Scheduled(fixedDelay = 300000)
    public void updateIssueStatus(){
        issueService.setStatusCVToWaitingConfirmation();
    }
}
