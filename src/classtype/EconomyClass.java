package classtype;

public class EconomyClass extends ClassType {

    public EconomyClass() {
        super("Economy class");
    }

    @Override
    public Service[] getServices() {
        return new Service[]{
                new Service("Regular seating", false, true, false, 10.0)
        };
    }
}

