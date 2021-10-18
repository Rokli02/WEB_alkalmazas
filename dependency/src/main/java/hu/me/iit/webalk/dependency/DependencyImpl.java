package hu.me.iit.webalk.dependency;

import org.springframework.stereotype.Component;

@Component
public class DependencyImpl implements Dependency {
    @Override
    public void helpNoParameterNoReturnValue() {

    }

    @Override
    public int helpNoParameterReturnValue() {
        return 45;
    }

	@Override
	public void helpWithParameterNoReturnValue(int a) {
		
	}
	
	public String important(String s) {
		return "<b>"+s+"</b>";
	}
}
