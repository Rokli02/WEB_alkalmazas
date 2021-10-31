package hu.me.iit.webalk.fourth;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FourthApplication implements CommandLineRunner {
	private final ApplicationContext context;
	
	public FourthApplication(ApplicationContext applicationContext) {
		this.context = applicationContext;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(FourthApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Fut");
		Kerek[] kerekek = make4kerek();
		Motor motor = context.getBean("makeMotor10", Motor.class);
		
		Auto auto = new Auto(motor, kerekek, "Opel Corsa");
		System.out.println(auto);
	}
	
	private Kerek[] make4kerek() {
		Kerek kerekek[] = new Kerek[4];
		
		for (int i = 0; i < kerekek.length; i++) {
			kerekek[i] = context.getBean("makeKerekek" , Kerek.class);
			
		}
		return kerekek;
	}
}
