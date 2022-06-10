package com.oussema.produits.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oussema.produits.entities.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {

}
