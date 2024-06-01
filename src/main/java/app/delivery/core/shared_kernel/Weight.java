package app.delivery.core.shared_kernel;

import java.util.Objects;

public record Weight(double kg) implements Comparable<Weight> {

    public static final double MINIMUM_WEIGHT = 0;


    public Weight {
        if (kg <= MINIMUM_WEIGHT) {
            throw new IllegalArgumentException("Weight should be greater than " + MINIMUM_WEIGHT);
        }
    }

    public double getKilograms() {
        return kg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Weight weight)) return false;
        return Double.compare(kg, weight.kg) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(kg);
    }

    @Override
    public int compareTo(Weight o) {
        return Double.compare(this.kg, o.kg);
    }
}
