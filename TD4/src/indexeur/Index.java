package indexeur;

import java.util.List;
import java.util.Set;

public interface Index<K extends Comparable<K>, V extends Comparable<V>> {
    
	/**
     * Supprime une cl� de l'index et les valeurs associ�es
     *
     * @param cle
     */
    public void supprimer(K cle);

    /**
     * Supprime une valeur de l'index, supprime la cl� si c'�tait la derni�re
     * valeur pour cette cl�
     *
     * @param cle
     * @param valeur
     */
    public void supprimer(K cle, V valeur);

    /**
     * Ajoute une cl� et une valeur � l'index, si la cl� existe d�j�, ajoute la
     * valeur � la cl� existante
     *
     * @param cle
     * @param valeur
     */
    public void ajouter(K cle, V valeur);

    /**
     * Retourne les valeurs d'une cl� donn�e
     *
     * @param cle
     * @return une Liste de valeurs
     */
    public List<V> rechercher(K cle);

    /**
     * V�rifie si une cl� contient la valeur pass�e en param�tre
     *
     * @param cle
     * @param valeur
     * @return un bool�en vrai si l'index contient le couple cl�-valeur donn� en
     * param�tre
     */
    public boolean rechercher(K cle, V valeur);

    /**
     * Retourne le nombre de cl�s de l'index
     *
     * @return la taille de l'index
     */
    public int nbeCles();

    /**
     * V�rifie si l'index est vide
     *
     * @return un boul�en vrai si l'index est vide
     */
    public boolean estVide();

    /**
     * Vide l'index
     */
    public void vider();
 
    /**
     * Renvoie l'ensemble des cl�s de l'index
     *
     * @return les cl�s de l'index
     */
    public Set<K> obtenirCles();

    /**
     * Retourne une chaine de caract�res contenant les informations de l'index
     *
     * @return une cha�ne de caract�res
     */
    @Override
    public String toString();

}
