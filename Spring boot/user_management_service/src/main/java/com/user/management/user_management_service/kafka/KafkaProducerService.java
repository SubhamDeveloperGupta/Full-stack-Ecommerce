package com.user.management.user_management_service.kafka;

import com.user.management.user_management_service.entity.UserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

import static com.user.management.user_management_service.util.CommonUtil.USER_TOPIC;

@Service
@Slf4j
public class KafkaProducerService {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public String sendMessageToTopic(String message) {
        try {
            CompletableFuture<SendResult<String, Object>> resultKafka = kafkaTemplate.send(USER_TOPIC, message);

            resultKafka.whenComplete((t, ex) -> {
                if (ex == null) {
                    System.out.println("Result : " + message +
                            "\nTopic : " + t.getRecordMetadata().topic() +
                            "\nPartition : " + t.getRecordMetadata().partition() +
                            "\nto Offset[" + t.getRecordMetadata().offset() + "]");
                } else System.out.println("Exception : " + ex.getMessage());
            });

            return "Message Send Successfully.";
        } catch (Exception ex) {
            return "Kafka Server not working";
        }
    }

    public String sendObjectToKafkaTopic(UserDetails userDetails) {
        try {
            CompletableFuture<SendResult<String, Object>> resultKafka = kafkaTemplate.send(USER_TOPIC, userDetails);
            resultKafka.whenComplete((r, ex) -> {
                if(ex == null) {
                    log.info("User Object : {}",r.toString());
                } else {
                    log.error("Exception : {}",ex.getMessage());
                }
            });

            return "Object pushed to kafka topic";
        } catch (Exception ex) {
            return "Kafka Internal Server Error";
        }
    }

}
