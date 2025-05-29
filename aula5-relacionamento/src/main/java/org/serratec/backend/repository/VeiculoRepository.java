package org.serratec.backend.repository;

import org.serratec.backend.entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

	public Veiculo findByPlaca(String placa);

}
