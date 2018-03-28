package cc.wangweiye.activemq;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;

@Service
public class Publisher {
    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void publish(String destName, String message) {
        Destination destination = new ActiveMQTopic(destName);

        jmsMessagingTemplate.convertAndSend(destination, message);
    }
}
