package ma.fstm.ilisi.springbiblio.service;

import ma.fstm.ilisi.springbiblio.bo.Livre;
import ma.fstm.ilisi.springbiblio.dao.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LivreService {
 @Autowired
 private LivreRepository repo;

 public LivreService() {
 }

 public List<Livre> listAll() {
  return repo.findAll();
 }

 public void save(Livre l) {
  repo.save(l);
 }

 public void delete(String id) {
  repo.deleteById(id);
 }

 public Optional<Livre> get(String id){
  return repo.findById(id);
 }
}
