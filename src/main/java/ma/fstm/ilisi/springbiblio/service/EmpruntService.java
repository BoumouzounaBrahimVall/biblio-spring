package ma.fstm.ilisi.springbiblio.service;

import ma.fstm.ilisi.springbiblio.bo.Emprunt;
import ma.fstm.ilisi.springbiblio.bo.EmpruntId;
import ma.fstm.ilisi.springbiblio.dao.EmpruntRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmpruntService {
    @Autowired
    EmpruntRepository repo;
    public EmpruntService(){}
    public List<Emprunt> listAll(){
        return repo.findAll();
    }
    public void save(Emprunt em){
        repo.save(em);
    }
    public void delete(EmpruntId id){
        repo.deleteById(id);
    }
    public Optional<Emprunt> get(EmpruntId id){
        return repo.findById(id);
    }
}

