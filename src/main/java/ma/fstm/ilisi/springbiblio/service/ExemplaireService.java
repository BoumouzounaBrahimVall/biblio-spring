package ma.fstm.ilisi.springbiblio.service;

import ma.fstm.ilisi.springbiblio.bo.Exemplaire;
import ma.fstm.ilisi.springbiblio.dao.ExemplaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ExemplaireService {
    @Autowired
    ExemplaireRepository repo;
    public ExemplaireService(){}
    public List<Exemplaire> listAll(){
        return repo.findAll();
    }
    public void save(Exemplaire e){
        repo.save(e);
    }
    public void delete(Long id){
        repo.deleteById(id);
    }
    public Optional<Exemplaire> get(Long id){
        return repo.findById(id);
    }
    public List<Exemplaire> findByIsbn(String isbn){
        return repo.findByIsbn(isbn);
    }
    public List<Exemplaire> findEmpruntedByIsbn(String isbn){
        return repo.findEmpruntedByIsbn(isbn);
    }
}
