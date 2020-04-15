package com.wissen.streamingservice.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import com.wissen.streamingservice.model.UserTradingTransactionData;


@Component
public class TradeDataStreamListener {
	 @Autowired
	    private SimpMessagingTemplate template;

	    @StreamListener(target = "inbound")
	    public void processMessage(UserTradingTransactionData pushMessage){
	        this.template.convertAndSend("/topic/pushNotification", pushMessage);
	    }
}
