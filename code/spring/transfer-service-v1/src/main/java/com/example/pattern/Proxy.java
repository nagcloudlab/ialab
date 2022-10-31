package com.example.pattern;

class BankService {
    public void getBankService1() {
        System.out.println("getBankService1");
    }

    // join point
    public void getBankService2() {
        System.out.println("getBankService2");
    }
}


// Aspect
class SecurityAspect {
    // Advice
    public void securityCheck() {
        System.out.println("security check");
    }
}


class BankServiceProxy {
    private SecurityAspect securityAspect = new SecurityAspect();
    private BankService bankService = new BankService();

    public void getBankService1() {
        securityAspect.securityCheck();
        bankService.getBankService1();
    }

    public void getBankService2() {
        securityAspect.securityCheck();
        bankService.getBankService2();
    }
}

// imp-note : spring provides dynamic proxies to apply enterprise service to components ( AOP )

public class Proxy {
    public static void main(String[] args) {

      BankServiceProxy bankServiceProxy = new BankServiceProxy();
      bankServiceProxy.getBankService1();

    }
}
