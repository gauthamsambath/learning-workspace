package Inheritance;

public class Animal {

    private int var2 = 10;
    public int var1 = 10;
    public static int variabel = 1;

    public static int getVariabel() {
        return variabel;
    }

    public void Animal() {
        System.out.println("function with constructor name");
    }
    public static void setVariabel(int variabel) {
        Animal.variabel = variabel;
    }

    public void  makeSound() {
        System.out.println("Random sound");
        function1();
    }

    private void function1() {
        System.out.println("in function 1");
    }

    public static void getFood() {
        System.out.println("get food");
    }

    public static void main(String[] args) {
        Animal animal1 = new Animal();
        Animal animal2 = new Cheetah();
        Cheetah cheetah = new Cheetah();
        animal2.makeSound();

    }
}

class Cheetah extends Animal {

    static {
        System.out.println("inside the static block");
    }

    {
        System.out.println("inside the unnamed block");
    }

    public int var1 = 20;
    public static int variabel = 5;

    public String makeSound2() {
        return "roar";
    }


    public static void getFood() {
        System.out.println("get non veg food");
    }

    @Override
    public void makeSound() {
        System.out.println("roar");
    }

    public static void main(String[] args) {
        new Animal().Animal();
////        System.out.println(Cheetah.variabel);
//        Animal animal2 = new Cheetah();
//        Cheetah cheetah = new Cheetah();
////        System.out.println(Cheetah.variabel);
    }

}

class CheetahCub extends Cheetah {
    public void makeSound() {
        super.makeSound();
        System.out.println("make tiny roar");
    }

    public static void main(String[] args) {
        Animal animal1 = new CheetahCub();

    }
}

class X
{
    int m = 1111;

    {
        m = m++;

        System.out.println(m);
    }
}

class Y extends X
{
    {
        System.out.println(methodOfY());
    }

    int methodOfY()
    {
        return m-- + --m;
    }
}

class MainClass
{
    public static void main(String[] args)
    {
        Y y = new Y();
    }
}



