package members.domain;

public enum Situation {
    Ativo("Ativo"), Inativo("Inativo");

    private String label;
    private Situation(String label) { this.label = label; }

    public static Situation findByLabel(String byLabel) {
        for (Situation s: Situation.values()) {
            if (s.label.equalsIgnoreCase(byLabel))
                return s;
        }
        return null;
    }
    public String getLabel() { return label; }
}