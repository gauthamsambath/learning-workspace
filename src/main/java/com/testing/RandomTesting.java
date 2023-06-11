package com.testing;

//
public class RandomTesting {

    public static class Animal {
        public void makeSound() {
            System.out.println("make random sound");
        }
    }

    public static class Lion extends Animal {
        public void makeSound() {
            System.out.println("roar");
        }

        public void catchPrey() {
            System.out.println("killed dear");
        }
    }

//    public static void main(String[] args) {
//        StringBuilder stringBuilder = new StringBuilder("Gautham");
//        stringBuilder.insert(1,'a');
//        System.out.println(stringBuilder);
//        stringBuilder.replace(1,2,"");
//        System.out.println(stringBuilder.substring(0,stringBuilder.length()));
//
//        functionManipulating(stringBuilder);
//        System.out.println(stringBuilder);
//
//    }

    public static void main(String[] args) {
//        Map<String,Object > map1 = new HashMap<>();
//        map1.put("IF_START_DATE",new Timestamp(1619300000000l));
//        Timestamp timestamp = (Timestamp) map1.get("IF_START_DATE");
//        System.out.println(timestamp.toString());

//        try {
//            int x = 6;
//            assert x == 5 : "x should be 5";
//            System.out.println("x is " + x);
//        } catch (AssertionError e) {
//            System.out.println(e.getMessage());
//        }

        Animal animal = new Animal();
        animal.makeSound();
        Animal animal1 = new Lion();
        animal.makeSound();


    }


    private static void functionManipulating(StringBuilder stringBuilder) {
        stringBuilder.append("g");
    }


}
