#Spring-boot 활용
## SpringApplication 2부 (1부는 실행시 배너 부분 커스텀하는 내용인데 음.. 관심생길때 보는게 나을듯하여 패스)
  -  회사에서 많이 사용하던 Event와 EventListener에 대한 내용이다.
  - 어플리케이션 메인 메서드에서
  ```
  // 보통 생성하면 이렇게 구성되어있지만 저렇게 한다면 스프링부트가 제공하는 다양한 커스터마이징을 사용하기가 어렵다
  SpringApplication.run(SpringBootUtilizationApplication.class, args);

  //그래서 아래처럼 app 인스턴스를 만들고 run시켜도 동일하게 실행되고 커스터마이징 사용이 용이하게 된다.
  SpringApplication app = new SpringApplication(SpringBootUtilizationApplication.class);
          app.run(args);
  ```
  ### Event
  - 이벤트는 스프링에서 제공하는 이벤트와 리스너도 있고 내가 직접 실행하고픈 이벤트를 만들수도 있다. 회사에서 사용한건 모두 직접 만든거지만 강의에선 제공되는 이벤트를 사용했다
  - 이벤트를 실행하려면 우선 이벤트 객체와 이벤트 리스너 객체가 있어야 사용가능하다
  - 또 어플리케이션 실행시 같이 실행되게 하려면
  ```
  SpringApplication app = new SpringApplication(SpringBootUtilizationApplication.class);
          app.addListeners(new SampleListener());
          app.run(args);
  이처럼 어플리케이션 인스턴스 자체에 리스터를 추가해주는 방법도 있다.
  ```
  - 추가적으로 앞으로 어플리케이션 실행시에 뭔가 동작을 시켜주고 싶다면 요 ApplicationStartingEvent 나 ApplicationStartedEvent 이벤트를 사용하는것도 유용할 것 같다.
  - 다만 회사에선 리스너 대신 핸들러를 사용해서 썻었다. 두개의 차이도 같이 공부할것.
  ### ApplicationArguments
  - ApplicationArguments에 대한 내용은 자바 프로그램이나 스프링 어플리케이션을 os환경에서 구동 시킬때 java -jar ,... --name = l ... 이런식으로 --를 붙혀 설정값을 주는 경우가 있다.
  - 이렇게 구동시 여러 부가 정보들을 메인 메서드의 args 파라미터가 가지고 있게 된다고한다.
  - 이러한 args인자의 내용을 가지고 있는게 ApplicationArguments 클래스이고 이를 통해 여러 정보들을 확인할 수 있다.
