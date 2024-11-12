package classtype;

public class BusinessClass extends ClassType {

    public BusinessClass() {
        super("Business class");
    }

    @Override
    public Service[] getServices() {
        return new Service[]{
                new Service("Comfortable seating", true, true, true, 20.0)

        };
    }
}
