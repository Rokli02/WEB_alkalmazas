package hu.me.iit.webalk.third;

import org.springframework.beans.factory.annotation.Value;

public class ServiceImpl implements Service {
	private String value;
	
	public ServiceImpl() {
		this.value = Double.toString(Math.random());
	}
	
	@Value("${sajat-cucc}")
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
