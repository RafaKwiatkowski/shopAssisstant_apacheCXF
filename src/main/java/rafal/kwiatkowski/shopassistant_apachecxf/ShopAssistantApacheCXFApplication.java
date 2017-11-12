package rafal.kwiatkowski.shopassistant_apachecxf;

import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import rafal.kwiatkowski.shopassistant_apachecxf.controller.ProductController;

import java.util.Arrays;

@SpringBootApplication
public class ShopAssistantApacheCXFApplication {
	@Autowired
	Bus bus;

	public static void main(String[] args) {
		SpringApplication.run(ShopAssistantApacheCXFApplication.class, args);

	}
	@Bean
	public Server rsServer() {
		JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
		endpoint.setBus(bus);
		endpoint.setAddress("/");
		// Register 2 JAX-RS root resources supporting "/sayHello/{id}" and "/sayHello2/{id}" relative paths
		endpoint.setServiceBeans(Arrays.<Object>asList(new ProductController()));
		return endpoint.create();
	}

}

