package st010500.frederick.DAO;

import org.springframework.data.repository.CrudRepository;
import st010500.frederick.Models.Customer;

/**
 * Created by bf on 18.01.18.
 */
public interface CustomerRepository extends CrudRepository<Customer, String > {



}
