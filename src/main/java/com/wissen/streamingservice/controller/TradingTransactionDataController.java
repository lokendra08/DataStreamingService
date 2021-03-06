package com.wissen.streamingservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wissen.streamingservice.model.UserTradingTransactionData;
import com.wissen.streamingservice.service.TradeDataStreamingService;


@RestController
public class TradingTransactionDataController {
	
	 private final TradeDataStreamingService tradeDataStreamingService;

	 public TradingTransactionDataController(TradeDataStreamingService tradeDataStreamingService) {
		this.tradeDataStreamingService = tradeDataStreamingService;
	 }
	

	 @RequestMapping(value="/create", method= {RequestMethod.POST}, produces={MediaType.APPLICATION_JSON_VALUE})
	 @ResponseStatus(HttpStatus.ACCEPTED)
	 public void createEmployee(@RequestBody UserTradingTransactionData userTradingTransactionData) {
		 tradeDataStreamingService.sendDataToKafkaTopic(userTradingTransactionData);
			
	 }
}
