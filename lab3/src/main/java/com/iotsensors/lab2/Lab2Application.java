package com.iotsensors.lab2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.cloud.gcp.pubsub.integration.inbound.PubSubInboundChannelAdapter;
import org.springframework.cloud.gcp.pubsub.integration.outbound.PubSubMessageHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

@SpringBootApplication
public class Lab2Application {

    public static void main(String[] args) {
        SpringApplication.run(Lab2Application.class, args);
    }
//Receiving the message from PubSub

    @Bean
    public MessageChannel pubsubInputChannel() {
        return new DirectChannel();

    }

    @Bean
    public PubSubInboundChannelAdapter messageChannelAdapter(
            @Qualifier("pubsubInputChannel") MessageChannel inputChannel, PubSubTemplate
            pubSubTemplate) {
        PubSubInboundChannelAdapter adapter = new PubSubInboundChannelAdapter(pubSubTemplate, "testSub");
        adapter.setOutputChannel(inputChannel);
        // adapter.setAckMode(AckMode.MANUAL);
        return adapter;
    }


    @ServiceActivator(inputChannel = "pubsubInputChannel")
    public void messageReceiver(String payload) {
        System.out.println("Message from Subscription:::::::::;::::: " + payload);
    }

    //Sending the message to PubSub
    @Bean
    @ServiceActivator(inputChannel = "pubsubOutputChannel")
    public MessageHandler messageSender(PubSubTemplate pubsubTemplate) {
        return new PubSubMessageHandler(pubsubTemplate, "testTopic");

    }

    @MessagingGateway(defaultRequestChannel = "pubsubOutputChannel")
    public interface PubsubOutboundGateway {
        void sendToPubsub(String text);
    }


}