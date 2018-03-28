package cc.wangweiye.activemq;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;

@Service
public class Producer {
    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void sendMsg(String destName, String message) {
        Destination destination = new ActiveMQQueue(destName);
        jmsMessagingTemplate.convertAndSend(destination, message);
    }
}
