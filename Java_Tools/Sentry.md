# Sentry | Error Tracking & Crash Reporting Tools --Microservice 
- src: https://www.youtube.com/watch?v=kGi6XTOnaEE&list=PLVz2XdJiJQxz_55RIJL8mjO6nx_T87LVD&index=12&ab_channel=JavaTechie
- git: https://github.com/Java-Techie-jt/courierservice-error-tracking-sentry
- Sentry is a software development platform designed to help developers identify, triage, and resolve errors in their applications. It provides real-time monitoring and tracking of errors and performance issues in web and mobile applications, and supports a wide range of programming languages and frameworks.
- With Sentry, developers can quickly identify and diagnose issues in their code, monitor the health of their applications, and improve the overall quality of their software. It also includes features such as release tracking, error aggregation, and alerting, allowing developers to stay on top of any issues that arise in their applications.
- Sentry is available both as a cloud-hosted solution and as a self-hosted option, and it integrates with many popular development tools and platforms, including GitHub, Jira, Slack, and more.

- create account
- add sentry dependecy 
- ![image](https://user-images.githubusercontent.com/69948118/224473117-ad116db1-08a2-4aa6-bc6f-19a4cb5b5264.png)
- add sentry configuration
```java
package com.javatechie.courier.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;

@Configuration
public class SentryConfig {
	
	@Bean
	public HandlerExceptionResolver sentryExceptionResolver() {
		return new io.sentry.spring.SentryExceptionResolver();
	}

}
```
![image](https://user-images.githubusercontent.com/69948118/224473256-fac42be7-cf0b-4e90-bfec-8ab11b8a2957.png)
![image](https://user-images.githubusercontent.com/69948118/224473273-a14cb7ec-0280-48b8-91c1-420f81244171.png)
![image](https://user-images.githubusercontent.com/69948118/224473374-34b50ddb-e5a9-40c8-b419-857ead7cfb4f.png)


