package com.example.web;

import com.example.dto.TransferRequest;
import com.example.dto.TransferStatus;
import com.example.service.TransferService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/transfer")
public class TransferController {

    private final TransferService transferService;


    @GetMapping
    public String transfer(Model model) {
        return "transfer-form";
    }

    @PostMapping
    public String doTransfer(
//            @RequestParam("amount") int amount,
//            @RequestParam("source") String source,
//            @RequestParam("destination") String destination,
              @ModelAttribute TransferRequest transferRequest,
            Model model) {

        TransferStatus transferStatus=transferService.transfer(transferRequest.getAmount(),transferRequest.getSource(),transferRequest.getDestination());
        model.addAttribute("status",transferStatus);

        return "transfer-status";
    }

}
