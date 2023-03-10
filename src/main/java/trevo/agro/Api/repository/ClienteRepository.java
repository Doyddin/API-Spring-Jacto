package trevo.agro.Api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trevo.agro.Api.entidade.cliente.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
