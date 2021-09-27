package kg.Cab.Rend.service.impl;

import kg.Cab.Rend.dao.Repository.WalletUserRepository;
import kg.Cab.Rend.mapper.WalletUserMapper;
import kg.Cab.Rend.model.WalletUser;
import kg.Cab.Rend.model.dto.WalletUserDto;
import kg.Cab.Rend.service.WalletUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WalletUserServiceImpl implements WalletUserService {
    @Autowired
    private WalletUserRepository walletUserRepository;

    @Override
    public WalletUserDto saveWalletUser(WalletUserDto walletUserDto) {
        WalletUser walletUser = WalletUserMapper.INSTANCE.toUser(walletUserDto);
        WalletUser walletUserSaver = walletUserRepository.save(walletUser);
        return WalletUserMapper.INSTANCE.toUserDto(walletUserSaver);

    }

    @Override
    public WalletUserDto findWalletUserById(Long id) {
        WalletUser walletUser =walletUserRepository.getById(id);
        return WalletUserMapper.INSTANCE.toUserDto(walletUser);
    }
}
