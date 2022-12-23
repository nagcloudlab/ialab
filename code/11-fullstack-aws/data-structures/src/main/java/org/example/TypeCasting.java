package org.example;

class LivingThing {
    public void eat() {
        System.out.println("LT::eat");
    }

    public void sleep() {
        System.out.println("LT::sleep");
    }

    public void work() {
        System.out.println("LT::work");
    }
}

class Animal extends LivingThing {
}


class Human extends LivingThing {
    public void study() {
        System.out.println("Human::study");
    }

    public void work() {
        System.out.println("Human::work");
    }
}

class Robot extends LivingThing {
    public void eat() {
        System.out.println("Robot::eat");
    }

    public void work() {
        System.out.println("Robot::work");
    }
}

class God {
    //    public void manageHuman(Human human) {
//        human.eat();
//        human.sleep();
//        human.study();
//        human.work();
//    }
//
//    public void manageAnimal(Animal animal) {
//        animal.eat();
//        animal.sleep();
//        animal.work();
//    }
    public void manageLT(LivingThing livingThing) {
        livingThing.eat();
        livingThing.sleep();
        if (livingThing instanceof Human) {
            Human human = (Human) livingThing;
            human.study();
        }
        livingThing.work();
    }
}


public class TypeCasting {
    public static void main(String[] args) {

        God god = new God();

        god.manageLT(new Human());
        System.out.println();
        god.manageLT(new Animal());
        System.out.println();
        god.manageLT(new Robot());
        System.out.println();


    }
}
