package classtype;

import java.util.Arrays;
import java.util.Objects;

public abstract class ClassType {

    protected String name;
    protected Service[] services;

    public ClassType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract Service[] getServices();

    @Override
    public String toString() {
        return "ClassType{" +
                "name='" + name + '\'' +
                ", services=" + Arrays.toString(services) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassType classType = (ClassType) o;
        return Objects.equals(name, classType.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
