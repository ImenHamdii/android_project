package iset.beja.correctionplanet;

public class Planet {
        private int id;
        private String nom ;
        private int rayon;

        public Planet() {
        }

        public Planet(int id, String nom) {
            this.id = id;
            this.nom = nom;
        }

        public Planet(int id, String nom, int rayon) {
            this.id = id;
            this.nom = nom;
            this.rayon = rayon;
        }
        public int getId() { return id; }
        public void setId(int id) {this.id = id; }
        public String getNom() {  return nom; }
        public void setNom(String nom) { this.nom = nom;}
        public int getRayon() { return rayon; }
        public void setRayon(int rayon) { this.rayon = rayon; }
    }


