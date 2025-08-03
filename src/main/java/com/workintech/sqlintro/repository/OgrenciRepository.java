package com.workintech.sqlintro.repository;

import com.workintech.sqlintro.entity.Ogrenci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface OgrenciRepository extends JpaRepository<Ogrenci, Long> {

    // Kız öğrencileri döner
    @Query(value = "SELECT * FROM ogrenci WHERE cinsiyet = 'K'", nativeQuery = true)
    List<Ogrenci> findGirls();

    @Query(value = "SELECT DISTINCT sinif FROM ogrenci", nativeQuery = true)
    List<String> findAllClasses();

    @Query(value = "SELECT * FROM ogrenci WHERE sinif = '10A' AND cinsiyet = 'K'", nativeQuery = true)
    List<Ogrenci> find10AGirls();

    @Query(value = "SELECT * FROM ogrenci WHERE ogrno > 5 AND ogrno < 10 AND cinsiyet = 'K'", nativeQuery = true)
    List<Ogrenci> findGirlsWithOgrno();

    @Query(value = "SELECT * FROM ogrenci ORDER BY ad COLLATE 'utf8_turkish_ci'", nativeQuery = true)
    List<Ogrenci> findStudentsAlphabetically();

    @Query(value = "SELECT * FROM ogrenci WHERE sinif = '10A' ORDER BY ogrno DESC", nativeQuery = true)
    List<Ogrenci> find10AStudentsByOgrNo();

    @Query(value = "SELECT * FROM ogrenci ORDER BY dtarih DESC LIMIT 1", nativeQuery = true)
    Ogrenci findYoungestStudent();

    @Query(value = "SELECT * FROM ogrenci ORDER BY dtarih ASC LIMIT 1", nativeQuery = true)
    Ogrenci findElderStudent();

    @Query(value = "SELECT * FROM ogrenci WHERE ad LIKE '_e%'", nativeQuery = true)
    List<Ogrenci> findStudentsSecondLetterOfN();
}
