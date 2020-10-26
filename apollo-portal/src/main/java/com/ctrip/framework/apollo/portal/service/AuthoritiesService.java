package com.ctrip.framework.apollo.portal.service;

import com.ctrip.framework.apollo.portal.entity.po.Authorities;
import com.ctrip.framework.apollo.portal.repository.AuthoritiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Roney on 2020/10/22 21:01.
 */
@Service
public class AuthoritiesService {
    @Autowired
    private AuthoritiesRepository authoritiesRepository;

    public Authorities save(Authorities authorities) {
        return authoritiesRepository.save(authorities);
    }

    public void deleteByUsername(String username) {
        authoritiesRepository.deleteByUsername(username);
    }
}
