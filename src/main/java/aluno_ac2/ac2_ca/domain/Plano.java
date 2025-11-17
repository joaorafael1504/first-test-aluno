package aluno_ac2.ac2_ca.domain;

public enum Plano {
    BASICO,
    PREMIUM;

    public static Plano fromLabel(String label) {
        if (label == null) return BASICO;
        switch (label) {
            case "Premium":
                return PREMIUM;
            case "Básico":
            case "Basico":
                return BASICO;
            default:
                // fallback: try to match ignoring case
                if (label.equalsIgnoreCase("premium")) return PREMIUM;
                return BASICO;
        }
    }

    public String asLabel() {
        switch (this) {
            case PREMIUM:
                return "Premium";
            case BASICO:
            default:
                return "Básico";
        }
    }

    public boolean isPremium() {
        return this == PREMIUM;
    }
}