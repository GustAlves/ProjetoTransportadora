package com.projeto.Transportadora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.Transportadora.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
