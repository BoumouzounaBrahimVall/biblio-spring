package ma.fstm.ilisi.springbiblio.service;

import ma.fstm.ilisi.springbiblio.bo.Adherent;
import ma.fstm.ilisi.springbiblio.dao.AdherentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AdherentService {
    @Autowired
    AdherentRepository repo;

    public AdherentService(){}
    public List<Adherent> listAll(){
        return repo.findAll();
    }
    public void save(Adherent a){
        repo.save(a);
    }

    public void delete(String id){
        repo.deleteById(id);
    }
    public Optional<Adherent> get(String id){
        return repo.findById(id);
    }

}
