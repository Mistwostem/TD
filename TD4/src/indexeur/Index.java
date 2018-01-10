package indexeur;

import java.util.List;
import java.util.Set;

public interface Index<K extends Comparable<K>, V extends Comparable<V>> {
    
	/**
     * Supprime une clé de l'index et les valeurs associées
     *
     * @param cle
     */
    public void supprimer(K cle);

    /**
     * Supprime une valeur de l'index, supprime la clé si c'était la dernière
     * valeur pour cette clé
     *
     * @param cle
     * @param valeur
     */
    public void supprimer(K cle, V valeur);

    /**
     * Ajoute une clé et une valeur à l'index, si la clé existe déjà, ajoute la
     * valeur à la clé existante
     *
     * @param cle
     * @param valeur
     */
    public void ajouter(K cle, V valeur);

    /**
     * Retourne les valeurs d'une clé donnée
     *
     * @param cle
     * @return une Liste de valeurs
     */
    public List<V> rechercher(K cle);

    /**
     * Vérifie si une clé contient la valeur passée en paramètre
     *
     * @param cle
     * @param valeur
     * @return un booléen vrai si l'index contient le couple clé-valeur donné en
     * paramètre
     */
    public boolean rechercher(K cle, V valeur);

    /**
     * Retourne le nombre de clés de l'index
     *
     * @return la taille de l'index
     */
    public int nbeCles();

    /**
     * Vérifie si l'index est vide
     *
     * @return un bouléen vrai si l'index est vide
     */
    public boolean estVide();

    /**
     * Vide l'index
     */
    public void vider();
 
    /**
     * Renvoie l'ensemble des clés de l'index
     *
     * @return les clés de l'index
     */
    public Set<K> obtenirCles();

    /**
     * Retourne une chaine de caractères contenant les informations de l'index
     *
     * @return une chaîne de caractères
     */
    @Override
    public String toString();

}
