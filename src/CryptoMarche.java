import java.util.ArrayList;

public class CryptoMarche {

    private ArrayList<Portefeuille> portefeuilles;
    private static CryptoMarche marche;

    private CryptoMarche(){
        portefeuilles = new ArrayList<Portefeuille>();
    }

    public static CryptoMarche getInstance(){
        if(marche == null){ marche = new CryptoMarche();}
		return marche;
    }

    public void ajouter(Portefeuille p){
        portefeuilles.add(p);
    }

    /**
     * Cette fonction recherche sur le marché tous les portefeuilles 
     * du propriétaire et calcule son capital en euros. 
     * @param proprietare
     * @return capital en euros du propriétare.
     */
    public double capitalEnEuros(String proprietaire){
        /**
            FONCTION À IMPLEMENTER
        **/
       double total = 0;
       for (int i = 0; i < portefeuilles.size(); i++) 
        {
           Portefeuille p = portefeuilles.get(i);
           if(p.estProprietaire(proprietaire)){
               total += p.valeurEnEuros();
           }
        
       }

        return total;
    }

    /**
     * Cette fonction recherche sur le marché tous les portefeuilles 
     * d'un type de devise et calcule le volume total de capital de 
     * cette devise sur le marché 
     * @param monnaie
     * @return capital total en circulation de la cryptomonnaie (en euros).
     */
    public double capitalMonneaie(Cryptomonnaie monnaie){
        /**
			FONCTION À IMPLEMENTER
        **/
        double total = 0;
        for (int i = 0; i < portefeuilles.size(); i++) {
            Portefeuille p = portefeuilles.get(i);
            if (p.getMonnaie().getNom().equals(monnaie.getNom()))
            total += p.valeurEnEuros();
        }
        return total;
    }

    @Override
    public String toString() {
        String ret = "";
        for(Portefeuille p : this.portefeuilles){
            ret += p.toString() + "\n";
        }
        return ret;
    }

}
//