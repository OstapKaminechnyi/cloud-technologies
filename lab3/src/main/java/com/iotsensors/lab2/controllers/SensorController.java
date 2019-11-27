package com.iotsensors.lab2.controllers;


import com.iotsensors.lab2.Lab2Application;
import com.iotsensors.lab2.model.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SensorController {
    @Autowired
    private Lab2Application.PubsubOutboundGateway messagingGateway;

    @PostMapping("/publishMessage")
    public String publishMessage(@RequestBody Sensor message) {
        messagingGateway.sendToPubsub(message.toString());
        return "Message Published Successfully";
    }


}
