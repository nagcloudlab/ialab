package com.example.service;

import com.example.dto.TransferStatus;

public interface TransferService {
    TransferStatus transfer(double amount, String source, String destination);
}
