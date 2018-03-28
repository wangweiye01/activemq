package cc.wangweiye.activemq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivemqApplicationTests {
    @Resource
    private Producer producer;

    @Resource
    private Publisher publisher;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testMQ() {
        producer.sendMsg("test.queue", "Queue Message");
    }

    @Test
    public void testSub() {
        publisher.publish("test.topic", "订阅消息");
    }
}
