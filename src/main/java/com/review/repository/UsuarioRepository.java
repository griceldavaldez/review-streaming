package com.review.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.review.bean.Usuario;

@Repository
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> , QueryByExampleExecutor<Usuario> {
	
	@Query("SELECT u FROM Usuario u WHERE u.fechaVencimiento < CURRENT_DATE")
	public List<Usuario> findExpiredUsersCredential();
}
