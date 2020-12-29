package ma.emsi.microservice.customers;

import ma.emsi.microservice.customers.model.Customer;
import ma.emsi.microservice.customers.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CustomersApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomersApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration restConfiguration){
        return args -> {
            restConfiguration.exposeIdsFor(Customer.class);
            List<Customer> customers = new ArrayList<>();
            for (int i = 0; i < 15; i++) {
                customers.add(new Customer(null,"name"+i,"name"+i+"@gmail.com"));
            }
            customerRepository.saveAll(customers);
        };
    }
}
