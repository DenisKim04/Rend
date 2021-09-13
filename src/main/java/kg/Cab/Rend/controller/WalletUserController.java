package kg.Cab.Rend.controller;

import io.swagger.annotations.Api;
import kg.Cab.Rend.configuretions.Swagger2Config;
import kg.Cab.Rend.model.dto.WalletUserDto;
import kg.Cab.Rend.service.WalletUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {Swagger2Config.WALLET_USER})
@RestController
@RequestMapping(value = "/api/v1/wallet_user")
@CrossOrigin
public class WalletUserController {
    @Autowired
    WalletUserService walletUserService;
    @PostMapping
    public WalletUserDto saveWalletUsers(){
        return null;
    }
}
