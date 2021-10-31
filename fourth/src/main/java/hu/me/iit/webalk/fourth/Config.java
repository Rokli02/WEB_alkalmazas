package hu.me.iit.webalk.fourth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	@Bean
	//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Kerek makeKerekek() {
		return new hu.me.iit.webalk.fourth.Impl.Kerek();
	}
	
	@Bean
	public Motor makeMotor10() {
		return new hu.me.iit.webalk.fourth.Impl.BelsoEgesuMotor();
	}
}
