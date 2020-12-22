package com.review.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.review.bean.Usuario;

@Repository
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long>{

}
