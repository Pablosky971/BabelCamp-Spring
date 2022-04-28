package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"controller"})
public class MvcConfig implements WebMvcConfigurer { 
	
	@Bean
	public InternalResourceViewResolver resolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	//Navegaciones estáticas
	// Para establecer una página de bienvenida.
	@Override
	public void addViewControllers(ViewControllerRegistry registry ) {
		registry.addViewController("/").setViewName("login");
	}

	//Registro de los recursos estaticos (imagenes, videos, documentos,...)
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	registry.addResourceHandler("/*").addResourceLocations("/");
	registry.addResourceHandler("/*.png").addResourceLocations("/img");
	registry.addResourceHandler("/*.css").addResourceLocations("/css");
	}
}
