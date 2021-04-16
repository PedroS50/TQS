# Ex. 1
## a) AssertJ expressive methods chaining examples
### EmployeeRepositoryTest:
* assertThat( found ).isEqualTo(alex);
* assertThat(fromDb).isNull();
* assertThat(fromDb.getEmail()).isEqualTo( emp.getEmail());
* assertThat(allEmployees).hasSize(3).extracting(Employee::getName).containsOnly(alex.getName(), ron.getName(), bob.getName());

## b) Example of mocking the behaviour of the repository
### EmployeeService_UnitTest:
Initialize mock...

@Mock( lenient = true)
private EmployeeRepository employeeRepository;

Define its behaviour...
Mockito.when(employeeRepository.findByName(alex.getName())).thenReturn(alex);

Test the method...
String name = "alex";
Employee found = employeeService.getEmployeeByName(name);
assertThat(found.getName()).isEqualTo(name);

## c) Difference between @Mock and @MockBean
@Mock: A part of Mockito's library, allows mocking a class or interface, recording and verifying their behaviours.
@MockBean: A part of spring-boot-test's library, allows adding mock in the ApplicationContext. If a bean compatible with the class exists insside the context, it is replaced by the mock, otherwise, adds the mock to the context as a bean.

## d) Role of "application-integrationtest.properties". In which conditions is it used?
It is used to configure the details of persistent storage.
Used whenever we want to test an application with persistent data.



