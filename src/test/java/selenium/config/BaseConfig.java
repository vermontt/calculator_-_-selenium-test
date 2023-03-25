package selenium.config;

import org.aeonbits.owner.Config;

/**
 * Интерфйс с основной конфигурацией проекта
 */
@Config.Sources({"classpath:config.properties"})
public interface BaseConfig extends Config{

    String url();
    String driverPath();
    String driverProperty();

}
