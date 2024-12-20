package study.ch13_ex1.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.ch13_ex1.model.Account;
import study.ch13_ex1.repositories.AccountRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransferService {

    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transferMoney(long idSender, long idReceiver, BigDecimal amount){
        Account sender = accountRepository.findAccountById(idSender);
        Account receiver = accountRepository.findAccountById(idReceiver);

        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

        if(senderNewAmount.compareTo(BigDecimal.ZERO) < 0){
            throw new RuntimeException("송금자 잔고 부족");
        }

        accountRepository.changeAmount(idSender, senderNewAmount);
        accountRepository.changeAmount(idReceiver, receiverNewAmount);
    }

    public List<Account> getAllAccounts(){
        return accountRepository.findAllAccounts();
    }
}
