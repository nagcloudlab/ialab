package com.example;

//--------------------------------------------------------
// ThirdParty module
//--------------------------------------------------------

import java.io.IOException;

class ThirdPartyModule {
    public String getSomething() throws IOException {
        //..
        if (1 == 1)
            throw new IOException("something bad here");
        return "something";
    }
}


//--------------------------------------------------------
// My module-1
//--------------------------------------------------------

class MyModuleOne {
    public void doSomething() {
        ThirdPartyModule thirdPartyModule = new ThirdPartyModule();
        try {
            thirdPartyModule.getSomething();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (2 == 2)
            throw new RuntimeException("something bad here");

    }
}


//--------------------------------------------------------
// My module-2
//--------------------------------------------------------

class MyModuleTwo {
    public void doSomething() {
        MyModuleOne one = new MyModuleOne();
        one.doSomething();
    }
}


//--------------------------------------------------------
// My module-3
//--------------------------------------------------------

class MyModuleThree {
    public void doSomething() {
        try {
            MyModuleTwo two = new MyModuleTwo();
            two.doSomething();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}


public class Checked_UnChecked_Exception {
    public static void main(String[] args) {

        MyModuleThree three = new MyModuleThree();
        three.doSomething();

    }
}
