package com.example.demo.controllers

import com.example.demo.models.Sensor
import com.google.gson.Gson
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.sql.Time
import java.util.*

@RestController
class SensorController(val pubSubTemplate: PubSubTemplate) {

    val gson: Gson = Gson()
    val topic = "testTopic"

    @RequestMapping("/publishMessage", method = [RequestMethod.POST],
            consumes = ["application/json;charset=UTF-8"])
    @ResponseBody
    fun publishMessage(@RequestBody message: Sensor): ResponseEntity<Sensor> {
        return try {
            this.pubSubTemplate.publish(topic, gson.toJson(message)).get()
            ResponseEntity.ok(message);
        } catch (t: Throwable) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
        }
    }

//    @RequestMapping("/publishMessage", method = [RequestMethod.POST],
//            consumes = ["text/plain;charset=utf-8"])
//    @ResponseBody
//    fun publishTextMessage(@RequestParam(required=false, name = "name" ) name: String,
//                           @RequestParam(required=false, name = "type") type: String,
//                           @RequestParam(required=false, name="date") date: Date,
//                           @RequestParam(required=false, name="time") time: Time,
//                           @RequestParam(required= false, name="lat") lat: Float,
//                           @RequestParam(required = false, name="lng") lng: Float,
//                           @RequestParam(required=false, name="measurement") measurement: String,
//                           @RequestBody message: Sensor) : ResponseEntity<Sensor>{
//        return try {
//            this.pubSubTemplate.publish(topic, message).get()
//            ResponseEntity.ok(message);
//        } catch (t: Throwable) {
//            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
//        }
//    }



}