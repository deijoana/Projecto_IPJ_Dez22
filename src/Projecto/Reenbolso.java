package Projecto;

import java.io.Serializable;
import java.util.Objects;

public class Reenbolso implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final Reenbolso NO_REENBOLSO = new Reenbolso(0.0);
    private final Double value;

    public Reenbolso(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }


    @Override
    public String toString() {
        return "%.2f".formatted(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reenbolso reenbolso = (Reenbolso) o;
        return Objects.equals(value, reenbolso.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
