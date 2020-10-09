package com.ctrip.framework.apollo.portal.initdb;

import com.ctrip.framework.apollo.portal.entity.po.Authorities;
import com.ctrip.framework.apollo.portal.entity.po.ServerConfig;
import com.ctrip.framework.apollo.portal.entity.po.UserPO;
import com.ctrip.framework.apollo.portal.repository.AuthoritiesRepository;
import com.ctrip.framework.apollo.portal.repository.ServerConfigRepository;
import com.ctrip.framework.apollo.portal.repository.UserRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Created by Roney on 2020/9/15.
 *
 * @author Roney
 * @date 2020-09-15 14:31
 */
//@Component
public class InitDb {
    @Resource
    UserRepository userRepository;
    @Resource
    AuthoritiesRepository authoritiesRepository;
    @Resource
    ServerConfigRepository serverConfigRepository;
    @PostConstruct
    public void initUser() {
        UserPO userPO = new UserPO();
        userPO.setUsername("apollo");
        userPO.setPassword("$2a$10$7r20uS.BQ9uBpf3Baj3uQOZvMVvB1RN3PYoKE94gtz2.WAOuiiwXS");
        userPO.setEmail("apollo@acme.com");
        userPO.setEnabled(1);
        userRepository.save(userPO);
    }
    @PostConstruct
    public void initAuthorities(){
        Authorities authorities=new Authorities();
        authorities.setUsername("apollo");
        authorities.setAuthority("ROLE_user");
        authoritiesRepository.save(authorities);
    }

    @PostConstruct
    public void initServerConfig(){
        ServerConfig serverConfig=new ServerConfig();
        serverConfig.setKey("apollo.portal.envs");
        serverConfig.setValue("dev");
        serverConfig.setComment("可支持的环境列表");
        serverConfigRepository.save(serverConfig);
        ServerConfig serverConfig1=new ServerConfig();
        serverConfig1.setKey("organizations");
        serverConfig1.setValue("[{\"orgId\":\"TEST1\",\"orgName\":\"样例部门1\"},{\"orgId\":\"TEST2\",\"orgName\":\"样例部门2\"}]");
        serverConfig1.setComment("部门列表");
        serverConfigRepository.save(serverConfig1);
        ServerConfig serverConfig2=new ServerConfig();
        serverConfig2.setKey("superAdmin");
        serverConfig2.setValue("apollo");
        serverConfig2.setComment("Portal超级管理员");
        serverConfigRepository.save(serverConfig2);
        ServerConfig serverConfig3=new ServerConfig();
        serverConfig3.setKey("api.readTimeout");
        serverConfig3.setValue("10000");
        serverConfig3.setComment("http接口read timeout");
        serverConfigRepository.save(serverConfig3);
        ServerConfig serverConfig4=new ServerConfig();
        serverConfig4.setKey("consumer.token.salt");
        serverConfig4.setValue("someSalt");
        serverConfig4.setComment("consumer token salt");
        serverConfigRepository.save(serverConfig4);
        ServerConfig serverConfig5=new ServerConfig();
        serverConfig5.setKey("admin.createPrivateNamespace.switch");
        serverConfig5.setValue("true");
        serverConfig5.setComment("是否允许项目管理员创建私有namespace");
        serverConfigRepository.save(serverConfig5);
        ServerConfig serverConfig6=new ServerConfig();
        serverConfig6.setKey("configView.memberOnly.envs");
        serverConfig6.setValue("pro");
        serverConfig6.setComment("只对项目成员显示配置信息的环境列表，多个env以英文逗号分隔");
        serverConfigRepository.save(serverConfig6);
        ServerConfig serverConfig7=new ServerConfig();
        serverConfig7.setKey("apollo.portal.meta.servers");
        serverConfig7.setValue("{}");
        serverConfig7.setComment("各环境Meta Service列表");
        serverConfigRepository.save(serverConfig7);
    }
}
