package com.oussema.produits;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.oussema.produits.entities.Categorie;
import com.oussema.produits.entities.Produit;
import com.oussema.produits.repos.ProduitRepository;

@SpringBootTest
class ProduitsApplicationTests {

	@Autowired
	private ProduitRepository produitRepository;

	@Test
	public void testCreateProduit() {
		Produit prod = new Produit("Imprimente Epsen", 3500.2, new Date());
		produitRepository.save(prod);
	}

	@Test
	public void testFindProduit() {
		Produit p = produitRepository.findById(1L).get();
		System.out.println(p);
	}

	@Test
	public void testUpdateProduit() {
		Produit pr = produitRepository.findById(2L).get();
		pr.setPrixProduit(1000.00);
		produitRepository.save(pr);
		System.out.println(pr);
	}

	@Test
	public void testDeleteProduit() {
		produitRepository.deleteById(1L);
	}

	@Test
	public void testFindAllProduits() {
		List<Produit> prods = produitRepository.findAll();
		for (Produit p : prods)
			System.out.println(p);
	}

	@Test
	public void testFindProduitByNom() {
		String nom = "PC Dell";
		List<Produit> prods = produitRepository.findByNomProduit(nom);

		for (Produit p : prods) {
			System.out.println(p);
		}
	}
	
	@Test
	public void testFindProduitContainsNom() {
		String nom = "PC";
		List<Produit> prods = produitRepository.findByNomProduitContains(nom);

		for (Produit p : prods) {
			System.out.println(p);
		}
	}
	
	@Test
	public void testFindProduitNomPrix() {
		String nom = "PC Dell";
		Double prix = 900.0;
		List<Produit> prods = produitRepository.findByNomPrix(nom, prix);

		for (Produit p : prods) {
			System.out.println(p);
		}
	}
	
	@Test
	public void testFindByCategorie() {
		Categorie cat = new Categorie();
		cat.setIdCat(1L);
		List<Produit> prods = produitRepository.findByCtegorie(cat);

		for (Produit p : prods) {
			System.out.println(p);
		}
	}
	
	@Test
	public void testFindByCategorieIdCat() {
		List<Produit> prods = produitRepository.findByCategorieIdCat(2L);

		for (Produit p : prods) {
			System.out.println(p);
		}
	}
	
	@Test
	public void testFindByOrderNomProduitAsc() {
		List<Produit> prods = produitRepository.findByOrderByNomProduitAsc();

		for (Produit p : prods) {
			System.out.println(p);
		}
	}
	
	@Test
	public void testTrierProduitsNomPrix() {
		List<Produit> prods = produitRepository.trierProduitsNomPrix();

		for (Produit p : prods) {
			System.out.println(p);
		}
	}
}