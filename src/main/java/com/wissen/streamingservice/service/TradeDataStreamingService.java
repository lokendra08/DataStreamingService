package com.wissen.streamingservice.service;

import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import com.wissen.streamingservice.configuration.IBrokerChannel;
import com.wissen.streamingservice.model.UserTradingTransactionData;




@Service 
public class TradeDataStreamingService {
    private final IBrokerChannel iBrokerChannnel;

	public TradeDataStreamingService(IBrokerChannel iBrokerChannnel) {
		this.iBrokerChannnel = iBrokerChannnel;
	}
   
	 public void sendDataToKafkaTopic(final UserTradingTransactionData userTradingTransactionData) {
	        MessageChannel messageChannel = iBrokerChannnel.inbound();
	        messageChannel.send(MessageBuilder
	                .withPayload(userTradingTransactionData)
	                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
	                .build());
	    }
}
