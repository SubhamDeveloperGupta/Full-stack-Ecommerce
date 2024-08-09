package com.user.management.user_management_service.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.user.management.user_management_service.util.CommonUtil.USER_TOPIC;

@Configuration
public class KafkaConfiguration {

    @Bean
    public NewTopic newTopic() {
        return new NewTopic(USER_TOPIC,3, (short) 1);
    }

}
