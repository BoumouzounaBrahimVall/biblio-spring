package ma.fstm.ilisi.springbiblio.service;

import ma.fstm.ilisi.springbiblio.dao.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LivreService {
    @Autowired
    private LivreRepository repo;


}
/**


 @Service
 @Transactional
 public class ProductService {
 @Autowired
 private ProductRepository repo;
 public ProductService(){}
 public List<Product> listAll(){
 return repo.findAll();
 }
 public  void save(Product product){
 repo.save(product);
 }
 public void delete(Long id){
 repo.deleteById(id);
 }
 public Optional<Product> get(Long id){
 return repo.findById(id);
 }

 }

  * */