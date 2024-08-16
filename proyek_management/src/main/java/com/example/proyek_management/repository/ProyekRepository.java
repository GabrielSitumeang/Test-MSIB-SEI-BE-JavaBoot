package com.example.proyek_management.repository;

import com.example.proyek_management.model.Proyek;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyekRepository extends JpaRepository<Proyek, Integer> {
}
