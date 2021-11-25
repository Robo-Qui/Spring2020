package tp.part1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tp.part1.data.component.interfaces.IRun;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private IRun iRun;

    @Override
    public void run(String... args) throws Exception {
        this.iRun.run();
    }

    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}
