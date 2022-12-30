package Projecto;

import java.io.Serializable;
import java.util.Objects;

public class Reembolso implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final Reembolso NO_REEMBOLSO = new Reembolso(0.0);
    private final Double value;

    public Reembolso(Double value) {
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
        Reembolso reembolso = (Reembolso) o;
        return Objects.equals(value, reembolso.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
