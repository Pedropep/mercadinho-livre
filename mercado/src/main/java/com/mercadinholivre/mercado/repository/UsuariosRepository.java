package com.mercadinholivre.mercado.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mercadinholivre.mercado.model.Usuarios;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long>{    
    public Optional<Usuarios> findByEmail(String email);
    
}
