package com.notification.service.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.notification.service.util.CommonUtil.GROUP_ID;
import static com.notification.service.util.CommonUtil.USER_TOPIC;

@Service
@Slf4j
public class KafkaWelcomeUserConsumer {

    @KafkaListener(topics = USER_TOPIC, groupId = GROUP_ID)
    public void welcomeUserConsumer(String email) {
        log.info("Consumer User Email : {} ",email);
    }

}
