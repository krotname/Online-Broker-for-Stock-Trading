package name.krot.broker.service;

import name.krot.broker.dto.DtoUserInfo;

public interface UserInfoService {

    DtoUserInfo getAllUserInfo(String login);

    DtoUserInfo getUserInfo(String login);
}
