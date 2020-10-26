//package com.ctrip.framework.apollo.portal.controller;
//
//import com.ctrip.framework.apollo.common.entity.App;
//import com.ctrip.framework.apollo.portal.component.PortalSettings;
//import com.ctrip.framework.apollo.portal.entity.model.AppModel;
//import com.ctrip.framework.apollo.portal.listener.AppCreationEvent;
//import com.ctrip.framework.apollo.portal.service.AppService;
//import com.ctrip.framework.apollo.portal.service.RoleInitializationService;
//import com.ctrip.framework.apollo.portal.service.RolePermissionService;
//import com.ctrip.framework.apollo.portal.spi.UserInfoHolder;
//import com.ctrip.framework.apollo.portal.util.RoleUtils;
//import org.springframework.context.ApplicationEventPublisher;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.util.CollectionUtils;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//
///**
// * Created by Roney on 2020/10/22 15:18.
// */
//@RestController
//@RequestMapping("/test")
//public class TestController {
//
//    private final UserInfoHolder userInfoHolder;
//    private final AppService appService;
//    private final PortalSettings portalSettings;
//    private final ApplicationEventPublisher publisher;
//    private final RolePermissionService rolePermissionService;
//    private final RoleInitializationService roleInitializationService;
//
//    public TestController(
//            final UserInfoHolder userInfoHolder,
//            final AppService appService,
//            final PortalSettings portalSettings,
//            final ApplicationEventPublisher publisher,
//            final RolePermissionService rolePermissionService,
//            final RoleInitializationService roleInitializationService) {
//        this.userInfoHolder = userInfoHolder;
//        this.appService = appService;
//        this.portalSettings = portalSettings;
//        this.publisher = publisher;
//        this.rolePermissionService = rolePermissionService;
//        this.roleInitializationService = roleInitializationService;
//    }
//
//    @RequestMapping(value = "/batchAapps" ,method = RequestMethod.POST)
//    public List<App> createBatch(@RequestBody List<AppModel> dtos) {
//
//        List<App> appDTOS = new ArrayList<>();
//
//        for (AppModel dto : dtos) {
//
//            appDTOS.add(this.create(dto));
//
//        }
//        return appDTOS;
//    }
//
//    public App create(@Valid @RequestBody AppModel appModel) {
//
//        App app = transformToApp(appModel);
//
//        App createdApp = appService.createAppInLocal(app);
//
//        publisher.publishEvent(new AppCreationEvent(createdApp));
//
//        Set<String> admins = appModel.getAdmins();
//        if (!CollectionUtils.isEmpty(admins)) {
//            rolePermissionService
//                    .assignRoleToUsers(RoleUtils.buildAppMasterRoleName(createdApp.getAppId()),
//                            admins, userInfoHolder.getUser().getUserId());
//        }
//
//        return createdApp;
//    }
//    private App transformToApp(AppModel appModel) {
//        String appId = appModel.getAppId();
//        String appName = appModel.getName();
//        String ownerName = appModel.getOwnerName();
//        String orgId = appModel.getOrgId();
//        String orgName = appModel.getOrgName();
//
//        return App.builder()
//                .appId(appId)
//                .name(appName)
//                .ownerName(ownerName)
//                .orgId(orgId)
//                .orgName(orgName)
//                .build();
//
//    }
//}
