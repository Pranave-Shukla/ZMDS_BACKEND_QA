package com.zoetis.zdms.config;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import com.ulisesbocchio.jasyptspringboot.properties.JasyptEncryptorConfigurationProperties;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.StandardEnvironment;

@Configuration
@EnableEncryptableProperties
public class JasyptConfig {

    @SuppressWarnings("squid:S2068")
    private static final String PASSWORD = "zmds-secret-key";

    @Bean("jasyptEncryptor")
    public StringEncryptor jasyptEncryptor(StandardEnvironment environment) {
        JasyptEncryptorConfigurationProperties configurationProperties = JasyptEncryptorConfigurationProperties.bindConfigProps(environment);

        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = of(configurationProperties);
        encryptor.setConfig(config);

        return encryptor;
    }

    private SimpleStringPBEConfig of(JasyptEncryptorConfigurationProperties configurationProperties) {
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(PASSWORD);
        config.setAlgorithm(configurationProperties.getAlgorithm());
        config.setKeyObtentionIterations(configurationProperties.getKeyObtentionIterations());
        config.setPoolSize(configurationProperties.getPoolSize());
        config.setProviderName(configurationProperties.getProviderName());
        config.setSaltGeneratorClassName(configurationProperties.getSaltGeneratorClassname());
        config.setIvGeneratorClassName(configurationProperties.getIvGeneratorClassname());
        config.setStringOutputType(configurationProperties.getStringOutputType());

        return config;
    }
}
