package InheritanceTwo;

import Inheritance.Maruti;

public class Mercedes extends Maruti {
    public static void main(String[] args) {
        Maruti maruti = new Maruti();
        maruti.driveInDefault();
        maruti.drivePublic();
        Mercedes mercedes = new Mercedes();
        mercedes.drivePublic();
        mercedes.driveInDefault();
        mercedes.driveProtected();
    }
}

class VolksWagon{
    public static void main(String[] args) {
        Maruti maruti = new Maruti();
        maruti.drivePublic();
        maruti.driveInDefault();
    }
}

