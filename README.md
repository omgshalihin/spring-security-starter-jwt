# Spring Authentication & Authorization With JWT
### visit [Spring Authentication & Authorization Without JWT](https://github.com/omgshalihin/spring-security-starter)

## Background
...
...
...
![JWT explanation.png](src%2Fmain%2Fresources%2Fpictures%2FJWT%20explanation.png)

[//]: # ()
[//]: # (## Spring Frameworks)

[//]: # (- Spring Web)

[//]: # (- Spring Security)

[//]: # (- Spring Data MongoDB)

[//]: # (- Lombok)

[//]: # ()
[//]: # (## To Get Started)

[//]: # (### setup)

[//]: # (clone this git repository into your local folder)

[//]: # (```)

[//]: # (git clone git@github.com:omgshalihin/spring-security-starter.git)

[//]: # (```)

[//]: # (go into the folder and open with your favorite IDE &#40;intelliJ&#41;)

[//]: # (```)

[//]: # (cd <folder> && idea pom.xml)

[//]: # (```)

[//]: # (inside main/resources, create a file called env.properties and then update the MongoDB Atlas connection string)

[//]: # (```)

[//]: # (DB_USER=<mongoDB_user>)

[//]: # (DB_PWD=<mongoDB_password>)

[//]: # (DB_ENDPOINT=<mongoDB_endpoint>)

[//]: # (DB_NAME=<mongoDB_name>)

[//]: # (```)

[//]: # (### create user and store into database)

[//]: # (POST http://localhost:8080/users/new)

[//]: # (- JSON body example)

[//]: # (```)

[//]: # ({)

[//]: # (    "username" : "shalihin",)

[//]: # (    "password" : "password",)

[//]: # (    "email" : "shalihin@mail.com",)

[//]: # (    "roles" : "role_admin,role_user")

[//]: # (})

[//]: # (```)

[//]: # (- expected output)

[//]: # (```)

[//]: # (User [shalihin] has been added to the database)

[//]: # (```)

[//]: # ()
[//]: # (## [Authentication]&#40;https://docs.spring.io/spring-security/reference/servlet/authentication/index.html&#41;)

[//]: # (Create a new `class` called `SecurityConfig` and annotate the class with the following:)

[//]: # (- @Configuration )

[//]: # (- @EnableWebSecurity )

[//]: # (- @EnableMethodSecurity)

[//]: # ()
[//]: # (Reading Username/Password: [Form Login]&#40;https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/form.html&#41;)

[//]: # (- config/SecurityConfig.java)

[//]: # (```)

[//]: # (@Bean)

[//]: # (public SecurityFilterChain securityFilterChain&#40;HttpSecurity http&#41; throws Exception {)

[//]: # (    return http.csrf&#40;&#41;.disable&#40;&#41;)

[//]: # (        .authorizeHttpRequests&#40;&#41;)

[//]: # (        .requestMatchers&#40;"/users/new", "/products/welcome"&#41;.permitAll&#40;&#41;)

[//]: # (        .and&#40;&#41;)

[//]: # (        .authorizeHttpRequests&#40;&#41;.requestMatchers&#40;"/products/**"&#41;)

[//]: # (        .authenticated&#40;&#41;.and&#40;&#41;.formLogin&#40;&#41;.and&#40;&#41;.build&#40;&#41;;)

[//]: # (})

[//]: # (```)

[//]: # ()
[//]: # (Password Storage: Custom data stores with [UserDetailsService]&#40;https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/user-details-service.html&#41;)

[//]: # (- config/SecurityConfig.java)

[//]: # (```)

[//]: # (@Bean)

[//]: # (public UserDetailsService userDetailsService&#40;&#41; {)

[//]: # (    return new DatabaseUserDetailsService&#40;&#41;;)

[//]: # (})

[//]: # (```)

[//]: # (- config/DatabaseUserDetailsService.java)

[//]: # (```)

[//]: # (@Component)

[//]: # (public class DatabaseUserDetailsService implements UserDetailsService {)

[//]: # ()
[//]: # (    @Autowired)

[//]: # (    private UserRepository userRepository;)

[//]: # ()
[//]: # (    @Override)

[//]: # (    public UserDetails loadUserByUsername&#40;String username&#41; throws UsernameNotFoundException {)

[//]: # (        Optional<UserModel> userModel = userRepository.findUserModelByUsername&#40;username&#41;;)

[//]: # (        return userModel.map&#40;UserModelUserDetails::new&#41;)

[//]: # (                .orElseThrow&#40;&#40;&#41; -> new UsernameNotFoundException&#40;String.format&#40;"User [%s] not found", username&#41;&#41;&#41;;)

[//]: # (    })

[//]: # (})

[//]: # (```)

[//]: # (- config/UserModelUserDetails.java)

[//]: # (```)

[//]: # (public class UserModelUserDetails implements UserDetails {)

[//]: # ()
[//]: # (    private String username;)

[//]: # (    private String password;)

[//]: # (    private List<GrantedAuthority> authorities;)

[//]: # ()
[//]: # (    public UserModelUserDetails&#40;UserModel userModel&#41; {)

[//]: # (        username = userModel.getUsername&#40;&#41;;)

[//]: # (        password = userModel.getPassword&#40;&#41;;)

[//]: # (        authorities = Arrays.stream&#40;userModel.getRoles&#40;&#41;.split&#40;","&#41;&#41;)

[//]: # (                .map&#40;SimpleGrantedAuthority::new&#41;)

[//]: # (                .collect&#40;Collectors.toList&#40;&#41;&#41;;)

[//]: # (    })

[//]: # ()
[//]: # (    @Override)

[//]: # (    public Collection<? extends GrantedAuthority> getAuthorities&#40;&#41; {)

[//]: # (        return authorities;)

[//]: # (    })

[//]: # ()
[//]: # (    @Override)

[//]: # (    public String getPassword&#40;&#41; {)

[//]: # (        return password;)

[//]: # (    })

[//]: # ()
[//]: # (    @Override)

[//]: # (    public String getUsername&#40;&#41; {)

[//]: # (        return username;)

[//]: # (    })

[//]: # ()
[//]: # (    @Override)

[//]: # (    public boolean isAccountNonExpired&#40;&#41; {)

[//]: # (        return true;)

[//]: # (    })

[//]: # ()
[//]: # (    @Override)

[//]: # (    public boolean isAccountNonLocked&#40;&#41; {)

[//]: # (        return true;)

[//]: # (    })

[//]: # ()
[//]: # (    @Override)

[//]: # (    public boolean isCredentialsNonExpired&#40;&#41; {)

[//]: # (        return true;)

[//]: # (    })

[//]: # ()
[//]: # (    @Override)

[//]: # (    public boolean isEnabled&#40;&#41; {)

[//]: # (        return true;)

[//]: # (    })

[//]: # (})

[//]: # (```)

[//]: # ()
[//]: # (Password Storage: [Password Encoder]&#40;https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/password-encoder.html&#41;)

[//]: # (- config/SecurityConfig.java)

[//]: # (```)

[//]: # (@Bean)

[//]: # (public PasswordEncoder passwordEncoder&#40;&#41; {)

[//]: # (    return new BCryptPasswordEncoder&#40;&#41;;)

[//]: # (})

[//]: # (```)

[//]: # ()
[//]: # (Password Storage: [DaoAuthenticationProvider]&#40;https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/dao-authentication-provider.html&#41;)

[//]: # (- config/SecurityConfig.java)

[//]: # (```)

[//]: # (@Bean)

[//]: # (public AuthenticationProvider authenticationProvider&#40;&#41; {)

[//]: # (    DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider&#40;&#41;;)

[//]: # (    authenticationProvider.setUserDetailsService&#40;userDetailsService&#40;&#41;&#41;;)

[//]: # (    authenticationProvider.setPasswordEncoder&#40;passwordEncoder&#40;&#41;&#41;;)

[//]: # (    return authenticationProvider;)

[//]: # (})

[//]: # (```)

[//]: # ()
[//]: # ()
[//]: # (## [Authorization]&#40;https://docs.spring.io/spring-security/reference/servlet/authorization/index.html&#41;)

[//]: # ([Expression-Based Access Control]&#40;https://docs.spring.io/spring-security/reference/servlet/authorization/expression-based.html&#41;:)

[//]: # (- `controller/ProductController.java` OR `controller/UserController.java`)

[//]: # (```)

[//]: # (@PreAuthorize&#40;"hasAuthority&#40;'ROLE_ADMIN'&#41;"&#41;)

[//]: # (@PreAuthorize&#40;"hasAuthority&#40;'ROLE_USER'&#41;"&#41;)

[//]: # (```)
