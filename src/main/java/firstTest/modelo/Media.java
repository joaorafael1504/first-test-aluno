package firstTest.modelo;

import java.util.Objects;

public final class Media {
    private final double value;

    private Media(double value) {
        this.value = value;
    }

    public static Media of(double value) {
        if (Double.isNaN(value) || value < 0.0 || value > 10.0) {
            throw new IllegalArgumentException("media must be between 0 and 10");
        }
        return new Media(value);
    }

    public double value() {
        return value;
    }

    public boolean isAtLeast(double threshold) {
        return value >= threshold;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Media media = (Media) o;
        return Double.compare(media.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
