package com.ctrip.framework.apollo.portal.repository;


import com.ctrip.framework.apollo.portal.entity.po.Authorities;

import org.springframework.data.repository.PagingAndSortingRepository;


/**
 * Created by Roney on 2020/9/15.
 *
 * @author Roney
 * @date 2020-09-15 14:31
 */
public interface AuthoritiesRepository extends PagingAndSortingRepository<Authorities, Long> {


    void deleteByUsername(String username);
}
