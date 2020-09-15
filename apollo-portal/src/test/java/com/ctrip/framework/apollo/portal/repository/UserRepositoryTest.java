package com.ctrip.framework.apollo.portal.repository;


import com.ctrip.framework.apollo.portal.AbstractIntegrationTest;
import com.ctrip.framework.apollo.portal.PortalApplication;
import com.ctrip.framework.apollo.portal.entity.po.UserPO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Created by Roney on 2020/9/15.
 *
 * @author Roney
 * @date 2020-09-15 14:24
 */
// 获取启动类，加载配置，确定装载 Spring 程序的装载方法，它回去寻找 主配置启动类（被 @SpringBootApplication 注解的）
@SpringBootTest(classes = PortalApplication.class)
// 让 JUnit 运行 Spring 的测试环境， 获得 Spring 环境的上下文的支持
@RunWith(SpringRunner.class)
public class UserRepositoryTest  {

    @Resource
    UserRepository userRepository;

    @Test
    public void initUser() {
        UserPO userPO = new UserPO();
        userPO.setUsername("apollo");
        userPO.setPassword("$2a$10$7r20uS.BQ9uBpf3Baj3uQOZvMVvB1RN3PYoKE94gtz2.WAOuiiwXS");
        userPO.setEmail("apollo@acme.com");
        userPO.setEnabled(1);
        userRepository.save(userPO);
    }
}