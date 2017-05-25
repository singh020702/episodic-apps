package com.example.shows;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

import javax.transaction.Transactional;
import java.util.Map;

/**
 * Created by singh on 5/23/2017.
 */
@Configuration
public class EpisodicProgressListener implements RabbitListenerConfigurer {

    @RabbitListener(queues = "episodic-progress")
    public void receiveMessage(final Message message) {
        System.out.println("************************************************");
        System.out.println(message.toString());
        System.out.println("************************************************");
    }

    @Bean
    public DefaultMessageHandlerMethodFactory messageHandlerMethodFactory() { // <-- 2
        DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
        factory.setMessageConverter(new MappingJackson2MessageConverter());
        return factory;
    }

    @Override
    public void configureRabbitListeners(final RabbitListenerEndpointRegistrar registrar) {  // <-- 3
        registrar.setMessageHandlerMethodFactory(messageHandlerMethodFactory());
    }


    public static class Message {


        public Long userId;
        public Long episodeId;
        public String createdAt;
        public int offset;

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public Long getEpisodeId() {
            return episodeId;
        }

        public void setEpisodeId(Long episodeId) {
            this.episodeId = episodeId;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        @Override
        public String toString() {
            return "Message{" +
                    "userId=" + userId +
                    ", episodeId=" + episodeId +
                    ", createdAt='" + createdAt + '\'' +
                    ", offset=" + offset +
                    '}';
        }
    }
}
