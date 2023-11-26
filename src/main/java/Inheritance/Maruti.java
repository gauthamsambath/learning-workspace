package Inheritance;

public class Maruti implements vehicleFunctionality {

    public void drivePublic(){
        System.out.println("driving in public");
    }

    protected void driveProtected(){
        System.out.println("driving in protected");
    }

    void driveInDefault2(){
        System.out.println("driving in default");
    }

    private void driveInPrivate(){
        System.out.println("driving in private");
    }

    public static void main(String[] args) {
        Maruti maruti = new Maruti();
        maruti.drivePublic();
        maruti.driveProtected();
        maruti.driveInDefault();
        maruti.driveInPrivate();
    }

    protected class GearShift {
        void gearShift(){
            driveInPrivate();
            driveProtected();
            driveInDefault();
            drivePublic();
        }
    }

}

interface vehicleFunctionality{
    default void driveInDefault(){
        System.out.println("driving in default");
    }
}

class Scorpio{
    public static void main(String[] args) {
        Maruti maruti = new Maruti();
        maruti.drivePublic();
        maruti.driveInDefault();
        maruti.driveProtected();
        Maruti.GearShift gearShift = maruti.new GearShift();
        gearShift.gearShift();
    }
}