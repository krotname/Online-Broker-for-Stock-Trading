package name.krot.broker.service;

import lombok.RequiredArgsConstructor;
import name.krot.broker.dao.BalanceRepository;
import name.krot.broker.dao.UserRepository;
import name.krot.broker.dto.DtoUserInfo;
import name.krot.broker.entity.AppBalance;
import name.krot.broker.entity.AppUser;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserInfoService {

    private final BalanceRepository balanceRepository;
    private final UserRepository userRepository;

    public DtoUserInfo getUserInfo(String login) {
        AppUser appUser = userRepository.findAppUserByLogin(login);
        AppBalance appBalance = balanceRepository.findAppBalanceByUserId(appUser.getId());
        return DtoUserInfo.builder()
                .login(appUser.getLogin())
                .currency(appBalance.getCurrency())
                .balance(appBalance.getBalance())
                .build();

    }

}
