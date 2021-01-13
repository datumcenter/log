package io.github.gallery.ctr;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/")
public class IndexCtr {
    private static final Log logger = LogFactory.getLog(IndexCtr.class);

    @GetMapping("/")
    public String index() {
        return "log";
    }


    @GetMapping("/config")
    @ResponseBody
    public Object config(@RequestParam Map<String, Object> params) {
        return null;
    }

    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("/send")
    @ResponseBody
    public Object send() {
        String id = String.valueOf(UUID.randomUUID());
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("bz", "hi");
        map.put("sjcjsj", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        rabbitTemplate.convertAndSend("logExchange", "logRouting", map);
        return id;
    }
}
