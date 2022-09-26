package com.booksmanagement.magazine.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MagazineRepository extends JpaRepository<MagazineEntity, String> {
    List<MagazineEntity> findMagazineEntitiesByAuthorsEmail(String author);
}
