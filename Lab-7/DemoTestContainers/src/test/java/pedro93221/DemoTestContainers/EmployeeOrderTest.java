package pedro93221.DemoTestContainers;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Testcontainers
@SpringBootTest
public class EmployeeOrderTest {

	@Container
	public static PostgreSQLContainer container = new PostgreSQLContainer()
			.withUsername("duke")
			.withPassword("password")
			.withDatabaseName("test");

	@Autowired
	private EmployeeRepository employeeRepository;

	@DynamicPropertySource
	static void properties(DynamicPropertyRegistry registry) {
		registry.add("spring.datasource.url", container::getJdbcUrl);
		registry.add("spring.datasource.password", container::getPassword);
		registry.add("spring.datasource.username", container::getUsername);
	}

	@Test
	void contentLoads() {
		Employee emp = new Employee();
		emp.setName("Pedro");
		emp.setEmail("pedro.miguel50@ua.pt");
		employeeRepository.save(emp);
	}

	@Test
	@Order(1)
	void createAnEmployee() {
		Employee emp = new Employee();
		emp.setName("Pedro");
		emp.setEmail("pedro.miguel50@ua.pt");
		employeeRepository.save(emp);
	}

	@Test
	@Order(2)
	void updateAnEmployee() {
		Employee emp = employeeRepository.findByEmail("pedro.miguel50@ua.pt");
		emp.setName("DefinitelyNotPedro");
		employeeRepository.save(emp);
	}

	@Test
	@Order(3)
	void deleteAnEmployee() {
		Employee emp = employeeRepository.findByEmail("pedro.miguel50@ua.pt");
		employeeRepository.delete(emp);
		Employee delEmp = employeeRepository.findByEmail("pedro.miguel50@ua.pt");
		assertEquals(delEmp, null);
	}
}