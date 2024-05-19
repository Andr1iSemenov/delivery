package app.delivery.core.shared_kernel;

import java.util.Objects;

public class Weight {

    private static final double MINIMUM_WEIGHT = 0;

    private final double kg;

    private Weight(double kg) {
        this.kg = kg;
    }

    public static Weight create(double kg) {
        if (kg <= MINIMUM_WEIGHT) {
            throw new IllegalArgumentException("Weight should be greater than " + MINIMUM_WEIGHT);
        }

        return new Weight(kg);
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
}
