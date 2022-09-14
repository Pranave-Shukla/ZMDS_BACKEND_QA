package com.zoetis.zdms;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations="classpath:application.yml")
public abstract class IntegrationTest {
}
