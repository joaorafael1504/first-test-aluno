package firstTest.modelo;

import java.util.Objects;

public final class CursosConcluidos {
    private final int value;

    private CursosConcluidos(int value) {
        this.value = value;
    }

    public static CursosConcluidos of(int value) {
        if (value < 0) throw new IllegalArgumentException("CursosConcluidos cannot be negative");
        return new CursosConcluidos(value);
    }

    public int value() {
        return value;
    }

    public boolean isAtLeast(int threshold) {
        return value >= threshold;
    }

    public CursosConcluidos increment() {
        return CursosConcluidos.of(this.value + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CursosConcluidos that = (CursosConcluidos) o;
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
package firstTest.modelo;

import java.util.Objects;

public final class CursosConcluidos {
    private final int value;

    private CursosConcluidos(int value) {
        this.value = value;
    }

    public static CursosConcluidos of(int value) {
        if (value < 0) throw new IllegalArgumentException("CursosConcluidos cannot be negative");
        return new CursosConcluidos(value);
    }

    public int value() {
        return value;
    }

    public boolean isAtLeast(int threshold) {
        return value >= threshold;
    }

    public CursosConcluidos increment() {
        return CursosConcluidos.of(this.value + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CursosConcluidos that = (CursosConcluidos) o;
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
