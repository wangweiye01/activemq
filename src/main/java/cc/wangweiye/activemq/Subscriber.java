package cc.wangweiye.activemq;

import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.stereotype.Service;

import javax.jms.ConnectionFactory;

@Service
public class Subscriber {
    @JmsListener(destination = "test.topic", containerFactory = "myJmsContainerFactory")
    public void subscribe(String text) {
        System.out.println("===<<<<收到订阅消息:" + text);
    }

    @Bean
    JmsListenerContainerFactory myJmsContainerFactory(ConnectionFactory connectionFactory) {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(true);
        return factory;
    }
}
