import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface Test {
	
	public boolean enable() default true; // Determines if it will run the unit test or not

}
