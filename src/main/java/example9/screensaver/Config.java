package example9.screensaver;

import org.springframework.context.annotation.*;

import java.awt.*;
import java.util.Random;

/**
 * @author Alexey Druzik on 3/25/2020
 */
@Configuration
@ComponentScan(basePackages = "example9.screensaver")
public class Config {
    @Bean
    @Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Color color() {
        Random random = new Random();
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        while (true) {
            context.getBean(ColorFrame.class).showOnRandomPlace();
            Thread.sleep(50);
        }
    }
}
