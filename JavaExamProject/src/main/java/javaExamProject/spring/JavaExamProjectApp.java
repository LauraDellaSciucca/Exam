package javaExamProject.spring;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication(scanBasePackages={"javaExamProject.spring"})
public class JavaExamProjectApp {
	public static void main(String[] args) {
			SpringApplication.run(JavaExamProjectApp.class, args);
	}
}
