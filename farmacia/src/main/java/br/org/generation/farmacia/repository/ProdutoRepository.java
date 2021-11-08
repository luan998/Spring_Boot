package br.org.generation.farmacia.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.org.generation.farmacia.model.Produto;

@Repository	
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	public List<Produto> findAllByNomeContainingIgnoreCase(String nome);
	
	public List<Produto> findAllByNomeAndLaboratorio(String nome, String laboratorio);

	public List<Produto> findAllByNomeOrLaboratorio(String nome, String labotarotio);
	
	@Query(value = "select * from tb_produtos where preco between :inicio and :fim", nativeQuery = true)
	public List <Produto> buscarProdutosEntre(@Param("inicio") BigDecimal inicio, @Param("fim") BigDecimal fim);

	public List <Produto> findByPrecoLessThanOrderByPrecoDesc(BigDecimal preco);
	
	public List <Produto> findByPrecoGreaterThanOrderByPreco(BigDecimal preco);
}
