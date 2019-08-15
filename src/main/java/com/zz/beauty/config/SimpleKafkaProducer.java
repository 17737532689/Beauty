package com.zz.beauty.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zz.beauty.dao.ShopMapper;
import com.zz.beauty.entity.Shop;
import com.zz.beauty.vo.R;
import lombok.ToString;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Properties;


@Configuration
public class SimpleKafkaProducer {
    private KafkaProducer<String, String> producer;
    @Bean
    public  Properties SimpleKafkaProducer(){
        Properties props = new Properties();
        props.put("bootstrap.servers", "172.168.10.120:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        //设置分区类,根据key进行数据分区
     //   producer = new KafkaProducer<String, String>(props);
        return props;
    }

}