package aluno_ac2.ac2_ca.domain;

import java.util.Objects;

public final class CursosLiberados {
    private final int value;

    private CursosLiberados(int value) {
        this.value = value;
    }

    public static CursosLiberados of(int value) {
        if (value < 0) throw new IllegalArgumentException("CursosLiberados cannot be negative");
        return new CursosLiberados(value);
    }

    public int value() {
        return value;
    }

    public boolean isZero() {
        return value == 0;
    }

    public CursosLiberados add(int add) {
        if (add < 0) throw new IllegalArgumentException("add must be non-negative");
        return CursosLiberados.of(this.value + add);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CursosLiberados that = (CursosLiberados) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}