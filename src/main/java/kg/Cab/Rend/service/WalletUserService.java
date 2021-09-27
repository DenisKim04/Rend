package kg.Cab.Rend.service;

import kg.Cab.Rend.model.dto.WalletUserDto;

public interface WalletUserService {
    public WalletUserDto saveWalletUser(WalletUserDto walletUserDto);
    public WalletUserDto findWalletUserById(Long id);
}
