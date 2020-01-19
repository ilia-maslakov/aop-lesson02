package sut.ism71z.maslakoviv.lesson02.aspect;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;
import sut.ism71z.maslakoviv.lesson02.Greeting;

@Aspect
@Component
public class Cheat {

    // ловим контекст метода
    @Pointcut("execution(public * sut.ism71z.maslakoviv.lesson02.GreetingController.greeting(String))")
    public void catchedGreeting() { }

    // навешиваем свой обработчик
    @Around("catchedGreeting()")
    public Object afterGreeting(ProceedingJoinPoint jp) throws Throwable {
        Greeting greeting = (Greeting) jp.proceed();
        System.out.println("afterGreeting");
        // увеличиваем результат на 10 (накручиваем счетчик)
        return new Greeting(greeting.getId() * 10, greeting.getContent());
    }

}
