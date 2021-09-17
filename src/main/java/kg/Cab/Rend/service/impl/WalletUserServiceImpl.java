package kg.Cab.Rend.service.impl;

import kg.Cab.Rend.dao.Repository.WalletUserRepository;
import kg.Cab.Rend.service.WalletUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletUserServiceImpl implements WalletUserService {
    @Autowired
    private WalletUserRepository walletUserRepository;
}
