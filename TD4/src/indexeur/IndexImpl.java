package indexeur;

import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class IndexImpl<K extends Comparable<K>, V extends Comparable<V>> implements Index<K,V> {

	/**
    * SortedMap pour stocker les clés et les valeurs de l'index
    */
    private final SortedMap<K, List<V>> sortedMap;
    
    /**
     * Constructeur vide, par défaut implémentation de la SortedMap avec une
     * TreeMap
     */
    public IndexImpl() {
        this.sortedMap = new TreeMap<>(Collator.getInstance());
    }

    /**
     * Constructeur prenant en paramètre une SortedMap : implémentation laissée
     * au choix de l'utilisateur.
     *
     * @param m SortedMap
     */
    public IndexImpl(SortedMap m) {
        this.sortedMap = m;
    }
	
	public void supprimer(K cle) {
		this.sortedMap.remove(cle);
    }

    public void supprimer(K cle, V valeur) {
    	this.sortedMap.get(cle).remove(valeur);
        if (this.sortedMap.get(cle).isEmpty()) {
            this.supprimer(cle);
        }
    }

    public void ajouter(K cle, V valeur) {
    	 if (this.sortedMap.containsKey(cle)) {
             this.sortedMap.get(cle).add(valeur);
         }else {
             this.sortedMap.put(cle, new ArrayList<>());
             this.sortedMap.get(cle).add(valeur);
         } 
    }

    public List<V> rechercher(K cle) {
    	return this.sortedMap.get(cle); 
    }

    public boolean rechercher(K cle, V valeur) {
    	List<V> listeV = this.rechercher(cle);
        return listeV.contains(valeur); 
    }

    public int nbeCles() {
    	return this.sortedMap.size();
    }

    public boolean estVide() {
    	return this.sortedMap.isEmpty(); 
    }

    public void vider() {
    	this.sortedMap.clear(); 
    }

    public Set<K> obtenirCles() {
    	return this.sortedMap.keySet();
    }
    
    public String toString(){
    	StringBuilder sb = new StringBuilder();
        for (K key : this.obtenirCles()) {
            sb.append(key);
            sb.append(" : ");
            sb.append(this.rechercher(key));
            sb.append('\n');
        }
        return sb.toString();
    }
}
