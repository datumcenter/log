package io.gallery.log.ctr;

import io.gallery.db.bean.DataBaseConfig;
import io.gallery.db.util.DB;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/")
public class IndexCtr implements Serializable {
    private static final Log logger = LogFactory.getLog(IndexCtr.class);
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    DataBaseConfig dataBaseConfig;

    @GetMapping("/")
    @ResponseBody
    public Object index() {
        return DB.selectOne("select now()");
    }


    @GetMapping("/config")
    @ResponseBody
    public Object config(@RequestParam Map<String, Object> params) {
        return dataBaseConfig;
    }

    @GetMapping("/direct")
    @ResponseBody
    public Object direct() {
        String id = String.valueOf(UUID.randomUUID());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id);
        map.put("content", "direct");
        map.put("sjcjsj", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        rabbitTemplate.convertAndSend("logDirectExchange", "logDirectRouting", map);
        rabbitTemplate.convertAndSend("logDirectExchange4", "logDirectRouting4", map);
        return map;
    }

    @GetMapping("/topic")
    @ResponseBody
    public Object topic() {
        String id = String.valueOf(UUID.randomUUID());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id);
        map.put("content", "topic");
        map.put("sjcjsj", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        rabbitTemplate.convertAndSend("logTopicExchange", "log.add", map);
        rabbitTemplate.convertAndSend("logTopicExchange", "log.del", map);
        return map;
    }

    @GetMapping("/fanout")
    @ResponseBody
    public Object fanout() {
        String id = String.valueOf(UUID.randomUUID());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id);
        map.put("content", "fanout");
        map.put("sjcjsj", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        rabbitTemplate.convertAndSend("logFanoutExchange", "", map);
        return map;
    }

}
