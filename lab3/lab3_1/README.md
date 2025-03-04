a)

Na classe B_EmployeeService_UnitTest, todos os testes utilizam o método _assertThat()_ do AssertJ. Um exemplo de "expressive methods chaining" é: _assertThat(allEmployees).hasSize(3).extracting(Employee::getName).contains(alex.getName(), john.getName(), bob.getName());_.
Também existe este exemplo na classe A_EmployeeRepositoryTest:_assertThat(results).hasSize(2).extracting(Employee::getEmail).containsExactlyInAnyOrder("bob@ua.pt", "ron@ua.pt");_.

b)

@DataJpaTest inclui: 
- @Target({ElementType. TYPE})
- @Retention(RetentionPolicy. RUNTIME)
- @Documented
- @Inherited
- @BootstrapWith(org.springframework. boot. test. autoconfigure. orm. jpa. DataJpaTestContextBootstrapper.class)
- @ExtendWith({org.springframework. test. context. junit. jupiter. SpringExtension.class})
- @OverrideAutoConfiguration(enabled = false)
- @TypeExcludeFilters({org.springframework. boot. test. autoconfigure. orm. jpa. DataJpaTypeExcludeFilter.class})
- @Transactional
- @AutoConfigureCache
- @AutoConfigureDataJpa
- @AutoConfigureTestDatabase
- @AutoConfigureTestEntityManager
- @ImportAutoConfiguration

Uma das anotações faladas na aula prática é a "@AutoConfigureTestDatabase", que substitui a base de dados real por uma _in-memory_ (H2).

c)

Na classe B_EmployeeService_UnitTest, os testes são feitos ao serviço através de um Mock do repositório, onde podemos observar determinado comportamento perante o que pretendemos fazer com o repositório:
- Mockito.when(employeeRepository.findByName(john.getName())).thenReturn(john);
- Mockito.when(employeeRepository.findByName(alex.getName())).thenReturn(alex);
- Mockito.when(employeeRepository.findByName("wrong_name")).thenReturn(null);
- Mockito.when(employeeRepository.findById(john.getId())).thenReturn(Optional.of(john));
- Mockito.when(employeeRepository.findAll()).thenReturn(allEmployees);
- Mockito.when(employeeRepository.findById(-99L)).thenReturn(Optional.empty());

d)

A anotação @Mock serve para criar _mocks_ de todas as classes, excepto as classes _Spring-managed_, que necessitam do @MockBean.
A anotação @MockBean está obsoleta, sendo que atualmente recomenda-se o uso de @MockitoBean.

e)

Este ficheiro define propriedades para aceder à base de dados. É usado quando usamos a notação @TestPropertySource( locations = "application-integrationtest.properties") e em testes de integração apenas.

f)

As 3 implementações dos testes diferem no que de facto testam.
A C, foca-se em testar a camada do controller apenas. Os outros beans não são carregados, sendo que devem ser explicitamente _mocked_.
Posso usar o MockMvc para simular pedidos e respostas HTTP sem o web server.

A D, é um teste de integração que carrega todo o "ApplicationContext", mas usa um ambiente web _mocked_.
Desta forma, é mais completo do que o anterior na medida em que não precisa de fazer um _mock_ dos restantes beans (excepto possíveis dependências externas).

A E, é um teste de integração full-stack. Naturalmente é mais lento mas simula a utilização da aplicação no mundo real.
