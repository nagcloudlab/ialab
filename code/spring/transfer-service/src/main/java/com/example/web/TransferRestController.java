package com.example.web;

import com.example.dto.TransferRequest;
import com.example.dto.TransferStatus;
import com.example.exception.AccountBalanceException;
import com.example.exception.AccountNotFoundException;
import com.example.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/transfer")
public class TransferRestController {

    private final TransferService transferService;

    @PostMapping(
            consumes = {"application/json"},
            produces = {"application/json"})
    public TransferStatus doTransfer(
            @RequestBody TransferRequest transferRequest
    ) {
        TransferStatus transferStatus = transferService.transfer(transferRequest.getAmount(), transferRequest.getSource(), transferRequest.getDestination());
        return transferStatus;
    }

    @ExceptionHandler({
            AccountNotFoundException.class
    })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public TransferStatus handleAccountNotFound(Throwable e) {
        TransferStatus transferStatus = new TransferStatus();
        transferStatus.setMessage(e.getMessage());
        return transferStatus;
    }


    @ExceptionHandler({
            AccountBalanceException.class
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public TransferStatus handleAccountBalance(Throwable e) {
        TransferStatus transferStatus = new TransferStatus();
        transferStatus.setMessage(e.getMessage());
        return transferStatus;
    }

}
