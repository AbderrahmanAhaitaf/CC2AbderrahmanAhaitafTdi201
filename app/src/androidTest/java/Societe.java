import java.io.StringBufferInputStream;

public class Societe {
    int id;
    String nom;
    String secteur;
    int nombreEmploye;

    public Societe(int id, String nom, String secteur, int nombreEmploye) {
        this.id = id;
        this.nom = nom;
        this.secteur = secteur;
        this.nombreEmploye = nombreEmploye;
    }

    public Societe(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSecteur() {
        return secteur;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    public int getNombreEmploye() {
        return nombreEmploye;
    }

    public void setNombreEmploye(int nombreEmploye) {
        this.nombreEmploye = nombreEmploye;
    }
}
