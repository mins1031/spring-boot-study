# spring-boot-study
1) 의존성 관리의 이해
  - pom.xml이나 build.gradle을 보면 의존성 부분들에 버전이 명시되지 않은 부분들도 있다. ex) 
```
- maven
 <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
 </dependency>
- gradle
 dependencies {
        implementation 'org.springframework.boot:spring-boot-starter'
        testImplementation group: 'junit', name: 'junit', version: '4.12'
 }
       
```
  - 이부분들은 스프링부트 버전별로 설정 파일중 최상위 설정 파일에 해당 의존성에 대한 기본 버전이 명시되어 있기 때문이다.
  - spring-boot-starter-parent 의존성의 상위 설정엔 spring사용에 필요한 의존성들이 명시되어 있다.(인텔리제이 기준 오른쪽바 maven or gradle 의존성 항목을 보면 확인가능)
  - 결국 스프링부트가 제공하는 의존성을 사용하게 되면 어느정도 편해진다. 다만 제공되는 버전이 아닌 다른버전을 사용하고 싶은경우는 최하위 = pom.xml에 버전을 명시해주면 해당 버전으로 적용되게 된다.
  - 그럼 이렇게 관리함은 무엇이 좋은가
     -> 스프링 사용엔 정말 수많은 의존성들이 필요한데 그걸 스프링부트가 제공하는 의존성 하나면 수많은 의존성을 관리할 일이 줄어들게 된다.(개발자가 할일이 줄어든다.)
  - spring-boot-starter-parent를 만약 사용하지 않는다면 방법은 있지만 spring-boot-starter-parent가 제공하는 수많은 기본셋팅들을 포기하면서 까지 다른 parent를 사용하는건 많은 수고가 들것같다.. 

2) 자동설정
  - @EnableAutoConfiguratoin(@SpringBootApplication 내에 있음)
  - 빈은 두단계에 걸쳐 집계되고, 주입된다
    - @ComponentScan : @Component, @Configuration, @Repository, @Service, @Controller, @restController 어노테이션이 달린 클래스를 빈으로 만들어 ApplicationContext에 등록
    - @EnableAutoConfiguration : 등록된 빈들을 @Autowired와 그외 주입 어노테이션이 있는 부분에 주입해주는 역할을 한다.
  - @EnableAutoConfiguration은 스프링 라이브러리중 'spring-boot-autoconfiguration'의 spring.factories의  org.springframework.boot.autoconfigure.EnableAutoConfiguration를 키로 가진 벨류들을 모두 빈으로 등록해준다.(조건에 따라 다르게 적용해줄수 있다)
  - 이를 통해 레거시 스프링의 많고 복잡한 설정들을 간단하게 해준다  
    
