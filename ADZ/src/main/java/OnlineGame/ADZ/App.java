package OnlineGame.ADZ;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableJpaAuditing
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
