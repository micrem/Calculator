package com.example.mrem0106.demomremSpringDemo2;

        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.CommandLineRunner;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.jdbc.core.JdbcTemplate;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RequestParam;
        import org.springframework.web.bind.annotation.RestController;

        import java.sql.ResultSet;
        import java.util.Arrays;
        import java.util.List;
        import java.util.stream.Collectors;

@RestController
@SpringBootApplication
public class jdbcController implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(jdbcController.class);

//    public static void main(String args[]) {
//        SpringApplication.run(jdbcController.class, args);
//    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... strings) throws Exception {

        log.info("Creating tables");

        jdbcTemplate.execute("DROP TABLE customers IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE customers(" +
                "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");

        // Split up the array of whole names into an array of first/last names
        List<Object[]> splitUpNames = Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long").stream()
                .map(name -> name.split(" "))
                .collect(Collectors.toList());

        // Use a Java 8 stream to print out each tuple of the list
        splitUpNames.forEach(name -> log.info(String.format("Inserting customer record for %s %s", name[0], name[1])));

        // Uses JdbcTemplate's batchUpdate operation to bulk load data
        jdbcTemplate.batchUpdate("INSERT INTO customers(first_name, last_name) VALUES (?,?)", splitUpNames);

        log.info("Querying for customer records where first_name = 'Josh':");
        jdbcTemplate.query(
                "SELECT id, first_name, last_name FROM customers WHERE first_name = ?", new Object[] { "Josh" },
                (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
        ).forEach(customer -> log.info(customer.toString()));
    }

    @GetMapping(path = "/restGetCustomerById")
    public Customer getCustomerById(@RequestParam int id) {
        String sql = "SELECT id, first_name, last_name FROM customers WHERE id = ?";
        Customer foundCustomer = jdbcTemplate.queryForObject(sql, new Object[] {id}, new CustomerRowMapper());
        return foundCustomer;
    }

    @GetMapping(path = "/restCreateCustomer")
    public Customer createCustomer(@RequestParam String first_name, @RequestParam String last_name) {
        // Uses JdbcTemplate's batchUpdate operation to bulk load data
        jdbcTemplate.update("INSERT INTO customers(first_name, last_name) VALUES (?,?)", first_name, last_name);

        String sql = "SELECT id, first_name, last_name FROM customers WHERE first_name = ? and last_name = ?";

        ResultSet rs = jdbcTemplate.ex;

        Customer createdCustomer = jdbcTemplate.queryForObject(
                sql, new Object[] { id },
                (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name")));

        return createdCustomer;
    }
}