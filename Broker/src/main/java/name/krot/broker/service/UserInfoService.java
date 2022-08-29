package name.krot.broker.service;

import io.grpc.StatusRuntimeException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import name.krot.broker.dao.BalanceRepository;
import name.krot.broker.dao.UserRepository;
import name.krot.broker.dto.DtoBond;
import name.krot.broker.dto.DtoUserInfo;
import name.krot.broker.entity.AppBalance;
import name.krot.broker.entity.AppUser;
import name.krot.grpc.ExchangeGrpc;
import name.krot.grpc.ExchangeOuterClass;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserInfoService {

    private final BalanceRepository balanceRepository;
    private final UserRepository userRepository;
    private final ExchangeGrpc.ExchangeBlockingStub blockingStub;

    public DtoUserInfo getUserInfo(String login) {
        AppUser appUser = userRepository.findAppUserByLogin(login);
        AppBalance appBalance = balanceRepository.findAppBalanceByUserId(appUser.getId());
        return DtoUserInfo.builder()
                .login(appUser.getLogin())
                .currency(appBalance.getCurrency())
                .balance(appBalance.getBalance())
                .build();
    }

    public DtoUserInfo getAllUserInfo(String login) {
        AppUser appUser = userRepository.findAppUserByLogin(login);
        log.info(String.valueOf(appUser));
        AppBalance appBalance = balanceRepository.findAppBalanceByUserId(appUser.getId());

        ExchangeOuterClass.Request request = ExchangeOuterClass.Request
                .newBuilder()
                .setOwner(login)
                .setOwnerId(appUser.getId())
                .build();
        ExchangeOuterClass.Reply response = null;
        try {
            response = blockingStub.getBond(request);
            log.info("response: " + response);
        } catch (StatusRuntimeException e) {
            log.warn("RPC failed: {0}", e.getStatus());
        }

        return DtoUserInfo.builder()
                .login(appUser.getLogin())
                .currency(appBalance.getCurrency())
                .balance(appBalance.getBalance())
                .bonds(List.of(DtoBond.builder()
                        .bondName(response.getName())
                        .bondCount(response.getCount())
                        .bondTotalPrice(response.getPrice() * response.getCount())
                        .build()))
                .build();
    }

}
