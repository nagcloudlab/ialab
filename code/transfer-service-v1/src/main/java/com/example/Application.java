package com.example;

import com.example.service.UPITransferService;

public class Application {

    public static void main(String[] args) {

        // phase-1 : init / booting
        UPITransferService transferService = new UPITransferService();

        System.out.println("-".repeat(100));

        //phase-2 : use
        transferService.transfer(100.00, "1", "2");
        System.out.println("-".repeat(50));
        transferService.transfer(100.00, "1", "2");

        System.out.println("-".repeat(100));
        //phase-3 : Destroy
        // proper clean-up


    }

}
