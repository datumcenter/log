package io.gallery.log.ctr;

import io.gallery.db.util.DataBaseGenericCtr;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/log")
public class LogCtr extends DataBaseGenericCtr {
    LogCtr() {
        tableName = "log";
    }
}
