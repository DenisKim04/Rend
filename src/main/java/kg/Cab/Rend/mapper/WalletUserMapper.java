package kg.Cab.Rend.mapper;

import kg.Cab.Rend.model.User;
import kg.Cab.Rend.model.WalletUser;
import kg.Cab.Rend.model.dto.UserDto;
import kg.Cab.Rend.model.dto.WalletUserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface WalletUserMapper {
    WalletUserMapper INSTANCE = Mappers.getMapper(WalletUserMapper.class);

    // Перевод в в Dto
    WalletUserDto toUserDto(WalletUser walletUser);

    List<WalletUserDto> toUserDtoList(List<WalletUser> walletUserList);

    // Перевод обратно в WalletUser
    WalletUser toUser(WalletUserDto walletUserDto);

    List<WalletUser> toUserList(List<WalletUserDto> walletUserDtoList);

}
