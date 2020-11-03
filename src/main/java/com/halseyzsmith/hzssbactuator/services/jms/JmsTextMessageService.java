package com.halseyzsmith.hzssbactuator.services.jms;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JmsTextMessageService {

    @Value("${myqueue}")
    private String queue;

    private final JmsTemplate jmsTemplate;

    public void sendTextMessage(String msg) {
        this.jmsTemplate.convertAndSend(queue, msg);
    }
}
