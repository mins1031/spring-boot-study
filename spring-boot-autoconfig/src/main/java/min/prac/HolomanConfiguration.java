package min.prac;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HolomanConfiguration {

    @Bean
    @ConditionalOnMissingBean
//    @ConditionalOnMissingBean은 해당 어플리케이션이 다른 곳에 의존성으로 쓰일때 아래와 같은 bean을 직접 등록한다면
    //아래의 Holoman빈은 등록 우선순위가 밀려나게 하는 역할을 한다
    public Holoman holoman() {
        Holoman holoman = new Holoman();
        holoman.setHowLong(5);
        holoman.setName("min");
        return holoman;
    }
}
