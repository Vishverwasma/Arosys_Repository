package com.app.JobSchedular.Scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.app.JobSchedular.ServiceAndImplementation.JobSchedulerService;

@Component
public class JobSchedulerTask {

    @Autowired
    private JobSchedulerService jobSchedulerService;

    @Scheduled(fixedRate = 30000)
    public void run() {
        jobSchedulerService.scheduleJobs();
    }
}
