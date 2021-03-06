# Spring study
* Spring MVC<br>
    MVC 패턴 기반 웹 개발 프레임워크

* Spring MVC 구성 주요 컴포넌트 

  - DispatcherServlet

  - Front Controller (Spring Container가 제공)

  - HandlerMapping
      Client의 요청을 처리할 Contoller를 찾는 작업 처리

  - Controller
      Client 요청 처리를 수행하는 Controller

  - ModelAndView
      응답할 View와 View에게 전달할 값을 저장하는 용도의 객체

  - ViewResolver
      응답할 View와 View에게 전달할 값을 저장하는 용도의 객체

  - View
      응답하는 로직을 처리

* Spring MVC 흐름

  - 요청 처리 순서
  
      1. DispatcherServlet이 요청을 수신
      
      2. DispatcherServlet은 HandlerMapping에 어느 컨트롤러를 사용할 것인지 문의

      3. DispatcherServlet은 요청을 컨트롤러에게 전송하고 컨트롤러는 요청을 처리한 후 결과 리턴

      4. ModelAndView를 생성하여 DispatcherServlet에 리턴

      5. ModelAndView 정보를 바탕으로 ViewResolver에게 View를 요청

      6. View는 결과정보를 사용하여 화면을 표현함
      
      <br>
      <br>
      <br>
      <br>

![spring_mvc](https://user-images.githubusercontent.com/34940800/41592127-a2e58188-73f6-11e8-935f-0162778b044c.png)




출처: http://gap85.tistory.com/entry/Spring-Spring-mvc [Joo studio]
