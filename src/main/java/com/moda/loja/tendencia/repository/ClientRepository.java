package com.moda.loja.tendencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moda.loja.tendencia.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
