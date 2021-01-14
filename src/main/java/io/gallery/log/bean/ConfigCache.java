package io.gallery.log.bean;

import io.gallery.db.bean.ConfigCacheLocal;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * 缓存配置
 */
@Configuration
@EnableCaching
public class ConfigCache extends ConfigCacheLocal {

}
