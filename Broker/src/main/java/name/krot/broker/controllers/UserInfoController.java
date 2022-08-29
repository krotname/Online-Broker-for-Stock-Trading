package name.krot.broker.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import name.krot.broker.dto.DtoUserInfo;
import name.krot.broker.service.UserInfoService;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("userinfo")
public class UserInfoController {
    private final UserInfoService userInfoService;

    @GetMapping("/{name}")
    public @ResponseBody
    DtoUserInfo getUserInfo(@PathVariable String name) {
        return userInfoService.getUserInfo(name);
    }
}
