package extracteur;

public class InfosMot {

    private String mot;
    private int ligne;
    private int colonne;

    public InfosMot(String mot, int ligne, int colonne) {
        this.mot = mot;
        this.ligne = ligne;
        this.colonne = colonne;
    }

    public InfosMot() {
    }

    public String getMot() {
        return this.mot;
    }

    public int getLigne() {
        return this.ligne;
    }

    public int getColonne() {
        return this.colonne;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getMot());
        sb.append(" ->  ligne : ");
        sb.append(this.getLigne());
        sb.append("  colonne : ");
        sb.append(this.getColonne());
        return sb.toString();
    }    
}
