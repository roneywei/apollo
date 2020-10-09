package com.ctrip.framework.apollo.configservice.initdb;



import com.ctrip.framework.apollo.biz.entity.ServerConfig;
import com.ctrip.framework.apollo.biz.repository.ServerConfigRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Created by Roney on 2020/9/15.
 *
 * @author Roney
 * @date 2020-09-15 14:31
 */
@Component
public class InitDb {

    @Resource
    ServerConfigRepository serverConfigRepository;


    @PostConstruct
    public void initServerConfig(){
        ServerConfig serverConfig=new ServerConfig();
        serverConfig.setKey("eureka.service.url");
        serverConfig.setCluster("default");
        serverConfig.setValue("http://localhost:8080/eureka/");
        serverConfig.setComment("Eureka服务Url，多个service以英文逗号分隔");
        serverConfigRepository.save(serverConfig);

        ServerConfig serverConfig1=new ServerConfig();
        serverConfig1.setKey("namespace.lock.switch");
        serverConfig1.setCluster("default");
        serverConfig1.setValue("false");
        serverConfig1.setComment("一次发布只能有一个人修改开关");
        serverConfigRepository.save(serverConfig1);

        ServerConfig serverConfig2=new ServerConfig();
        serverConfig2.setKey("item.key.length.limit");
        serverConfig2.setCluster("default");
        serverConfig2.setValue("128");
        serverConfig2.setComment("item key 最大长度限制");
        serverConfigRepository.save(serverConfig2);

        ServerConfig serverConfig3=new ServerConfig();
        serverConfig3.setKey("item.value.length.limit");
        serverConfig3.setCluster("default");
        serverConfig3.setValue("20000");
        serverConfig3.setComment("item value最大长度限制");
        serverConfigRepository.save(serverConfig3);

        ServerConfig serverConfig4=new ServerConfig();
        serverConfig4.setKey("config-service.cache.enabled");
        serverConfig4.setCluster("default");
        serverConfig4.setValue("false");
        serverConfig4.setComment("ConfigService是否开启缓存，开启后能提高性能，但是会增大内存消耗！");
        serverConfigRepository.save(serverConfig4);

    }
}
