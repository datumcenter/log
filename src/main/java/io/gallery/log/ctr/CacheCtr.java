package io.gallery.log.ctr;

import io.gallery.db.util.DataBaseCacheCtr;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/cache", produces = MediaType.APPLICATION_JSON_VALUE)
public class CacheCtr extends DataBaseCacheCtr {
}
