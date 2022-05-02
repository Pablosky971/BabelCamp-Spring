package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import model.Cliente;


public interface ClientesDao extends JpaRepository<Cliente, String> {
	

}
