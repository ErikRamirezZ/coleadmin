package com.raze.coleadmin.service;

import com.raze.coleadmin.domain.Repeticion;
import com.raze.coleadmin.repository.RepeticionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RepeticionServiceImpl implements RepeticionService {

	@Autowired
    RepeticionRepository repeticionRepository;

	public long countAllRepeticions() {
        return repeticionRepository.count();
    }

	public void deleteRepeticion(Repeticion repeticion) {
        repeticionRepository.delete(repeticion);
    }

	public Repeticion findRepeticion(Long id) {
        return repeticionRepository.findOne(id);
    }

	public List<Repeticion> findAllRepeticions() {
        return repeticionRepository.findAll();
    }

	public List<Repeticion> findRepeticionEntries(int firstResult, int maxResults) {
        return repeticionRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveRepeticion(Repeticion repeticion) {
        repeticionRepository.save(repeticion);
    }

	public Repeticion updateRepeticion(Repeticion repeticion) {
        return repeticionRepository.save(repeticion);
    }
}
