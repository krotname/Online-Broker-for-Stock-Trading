package name.krot.broker.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import name.krot.broker.dto.DtoUserInfo;
import name.krot.broker.service.UserInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class UserInfoController {
    private final UserInfoService userInfoService;

    @GetMapping("userinfo/{name}")
    public DtoUserInfo getUserInfo(@PathVariable String name) {
        log.info(name);
        return userInfoService.getUserInfo(name);
    }

    @GetMapping("userinfo/all/{name}")
    public DtoUserInfo getUserAllInfo(@PathVariable String name) {
        log.info(name);
        return userInfoService.getAllUserInfo(name);
    }
}
