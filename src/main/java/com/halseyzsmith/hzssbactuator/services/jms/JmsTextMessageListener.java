package com.halseyzsmith.hzssbactuator.services.jms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@Slf4j
@Component
public class JmsTextMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            log.info("### " + message.getBody(String.class) + " ###" );
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
