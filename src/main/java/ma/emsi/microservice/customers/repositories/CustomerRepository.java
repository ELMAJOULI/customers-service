package ma.emsi.microservice.customers.repositories;

import ma.emsi.microservice.customers.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CustomerRepository  extends JpaRepository<Customer,Long> {
}
