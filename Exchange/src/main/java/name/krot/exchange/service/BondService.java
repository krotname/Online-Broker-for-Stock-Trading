package name.krot.exchange.service;

import name.krot.grpc.ExchangeOuterClass;

public interface BondService {
    ExchangeOuterClass.ReplyCourse getCurrentPrice(String bondCode);

    ExchangeOuterClass.Reply getBondInfo(long id);
}
