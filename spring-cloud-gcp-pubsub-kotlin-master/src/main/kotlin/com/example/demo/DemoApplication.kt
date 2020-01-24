package com.example.demo

import com.example.demo.models.Sensor
import com.google.gson.Gson
import org.apache.http.HttpResponse
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.StringEntity
import org.apache.http.impl.client.HttpClientBuilder
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.text.SimpleDateFormat
import java.util.*


@SpringBootApplication
class DemoApplication

const val url = "http://circular-light-265709.appspot.com/publishMessage"
private var token = "Empty"

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
//    timer()

}


fun timer() {
    while (true) {
        val millis = System.currentTimeMillis()
        generateData()
        Thread.sleep(1000 - millis % 1000)
    }
}

fun postData(data: Sensor) {

    val gson: Gson = Gson()
    val httpClient: HttpClient = HttpClientBuilder.create().build()
    val post = HttpPost(url)
    val json = gson.toJson(data)
    val postingString = StringEntity(json)
    post.entity = postingString
    post.setHeader("Content-type", "application/json;charset=UTF-8")
//    post.setHeader("token", "5555zzz")
    val response: HttpResponse = httpClient.execute(post)

    print("\n $response")

}

fun generateData() {

    val date = Date()
    val modifiedDate = SimpleDateFormat("yyyy-MM-dd").format(date)
    val dateFormat = SimpleDateFormat("hh:mm:ss")

    val calendar = Calendar.getInstance()
    val time = dateFormat.format(calendar.time)

    val humiditySensor = Sensor(name = "humiditySensor", type = "humidity", date = modifiedDate,
            time = time, lat = (Math.random() * (20)).toFloat(),
            lng = (Math.random() * (20)).toFloat(), measurement = "testing")

    postData(humiditySensor)

    val temperatureSensor = Sensor(name = "temperatureSensor", type = "temperature", date = modifiedDate,
            time = time, lat = (Math.random() * ( 20 )).toFloat(),
            lng = (Math.random() * ( 20 )).toFloat(), measurement = "testing")

    postData(temperatureSensor)

    val proximitySensor = Sensor(name = "proximitySensor", type = "proximity", date = modifiedDate,
            time = time, lat = (Math.random() * ( 20 )).toFloat(),
            lng = (Math.random() * ( 20 )).toFloat(), measurement = "testing")

    postData(proximitySensor)

}

