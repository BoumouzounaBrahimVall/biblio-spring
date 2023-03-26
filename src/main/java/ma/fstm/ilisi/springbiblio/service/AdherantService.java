package ma.fstm.ilisi.springbiblio.service;

import ma.fstm.ilisi.springbiblio.bo.Adherant;
import ma.fstm.ilisi.springbiblio.dao.AdherentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AdherantService {
    @Autowired
    AdherentRepository repo;

    public AdherantService(){}
    public List<Adherant> listAll(){
        return repo.findAll();
    }
    public void save(Adherant a){
        repo.save(a);
    }

    public void delete(String id){
        repo.deleteById(id);
    }
    public Optional<Adherant> get(String id){
        return repo.findById(id);
    }

}
