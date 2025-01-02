package study.test.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import study.test.DTO.TransferRequestDTO;
import study.test.services.UserService;
import study.test.services.UserServiceImpl;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
public class TransferController {

    private final UserServiceImpl userService;

    @PostMapping("/transfer")
    public void transferMoney(@RequestBody TransferRequestDTO transferRequestDTO){
        Long senderId = transferRequestDTO.getSenderId();
        Long receiverId = transferRequestDTO.getReceiverId();
        BigDecimal amount = transferRequestDTO.getAmount();

        boolean success = userService.transferBalance(senderId, receiverId, amount);
        if(success){
            System.out.println("success");
        }else{
            System.out.println("failed");
        }
    }
}
