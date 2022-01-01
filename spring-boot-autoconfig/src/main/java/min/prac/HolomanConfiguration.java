package min.prac;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(HolomanProperties.class)
public class HolomanConfiguration {

    @Bean
    @ConditionalOnMissingBean
//    @ConditionalOnMissingBean은 해당 어플리케이션이 다른 곳에 의존성으로 쓰일때 아래와 같은 bean을 직접 등록한다면
    //아래의 Holoman빈은 등록 우선순위가 밀려나게 하는 역할을 한다
    public Holoman holoman(HolomanProperties holomanProperties) {
        Holoman holoman = new Holoman();
        holoman.setHowLong(holomanProperties.getHowLong());
        holoman.setName(holomanProperties.getName());
        return holoman;
    }
    /*이렇게 properties의 값에 맡기게 되면 동적으로 사용자마다 각각 원하는 값으로 사용할 수 있게되어 유연성과 확장성이 보장된다고 생각한다..*/
}
