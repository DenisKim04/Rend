package kg.Cab.Rend.controller;

import io.swagger.annotations.Api;
import kg.Cab.Rend.configuretions.Swagger2Config;
import kg.Cab.Rend.model.dto.WalletUserDto;
import kg.Cab.Rend.service.WalletUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {Swagger2Config.WALLET_USER})
@RestController
@RequestMapping(value = "/api/v1/wallet_user")
@CrossOrigin
public class WalletUserController {
    @Autowired
    WalletUserService walletUserService;
    @PostMapping("SaveWaller")
    public WalletUserDto saveWalletUsers(@RequestBody WalletUserDto walletUserDto){

        return walletUserService.saveWalletUser(walletUserDto);
    }
    @GetMapping("findById")
    public WalletUserDto findById(@RequestParam Long id){
        return walletUserService.findWalletUserById(id);
    }
}
