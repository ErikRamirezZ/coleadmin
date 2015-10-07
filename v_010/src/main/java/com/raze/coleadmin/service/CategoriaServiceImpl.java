package com.raze.coleadmin.service;

import com.raze.coleadmin.catalog.Categoria;
import com.raze.coleadmin.repository.CategoriaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
    CategoriaRepository categoriaRepository;

	public long countAllCategorias() {
        return categoriaRepository.count();
    }

	public void deleteCategoria(Categoria categoria) {
        categoriaRepository.delete(categoria);
    }

	public Categoria findCategoria(Long id) {
        return categoriaRepository.findOne(id);
    }

	public List<Categoria> findAllCategorias() {
        return categoriaRepository.findAll();
    }

	public List<Categoria> findCategoriaEntries(int firstResult, int maxResults) {
        return categoriaRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveCategoria(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

	public Categoria updateCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
}
