package com.dc.evans.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.dc.evans.jobhandler.TransplaceEDIJobHandler;

@Component
public class Scheduler {

	@Autowired
	TransplaceEDIJobHandler jobHandler;
	
	@Scheduled(fixedDelay = 10000) // 3600000 milliseconds = 1 hour
	//@Scheduled(cron = "0 0 * * * *")
	public void fetchEDIMessages() {
		jobHandler.downloadMessage();
	}
}
