package com.halseyzsmith.hzssbactuator.config;

import com.halseyzsmith.hzssbactuator.services.jms.JmsTextMessageListener;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

import javax.jms.ConnectionFactory;

@Configuration
@RequiredArgsConstructor
public class JMSConfig {

    private final ConnectionFactory connectionFactory;

    @Value("${myqueue}")
    private String queue;

    @Bean
    public DefaultMessageListenerContainer messageListener() {
        DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
        container.setConnectionFactory(this.connectionFactory);
        container.setDestinationName(queue);
        container.setMessageListener(new JmsTextMessageListener());
        return container;
    }
}
