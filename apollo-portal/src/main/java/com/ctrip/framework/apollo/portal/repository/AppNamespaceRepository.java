package com.ctrip.framework.apollo.portal.repository;

import com.ctrip.framework.apollo.common.entity.AppNamespace;
import java.util.List;

import com.ctrip.framework.apollo.portal.entity.po.PortalAppNamespace;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AppNamespaceRepository extends PagingAndSortingRepository<PortalAppNamespace, Long> {

  PortalAppNamespace findByAppIdAndName(String appId, String namespaceName);

  List<PortalAppNamespace> findByNameAndIsPublic(String namespaceName, boolean isPublic);

  List<PortalAppNamespace> findByIsPublicTrue();

  List<PortalAppNamespace> findByAppId(String appId);

  @Modifying
  @Query("UPDATE PortalAppNamespace SET isDeleted=1,dataChangeLastModifiedBy=?2 WHERE appId=?1")
  int batchDeleteByAppId(String appId, String operator);

  @Modifying
  @Query("UPDATE PortalAppNamespace SET isDeleted=1,dataChangeLastModifiedBy = ?3 WHERE appId=?1 and name = ?2")
  int delete(String appId, String namespaceName, String operator);
}
