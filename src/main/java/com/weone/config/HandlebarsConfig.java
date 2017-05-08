package com.weone.config;

import java.io.IOException;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;
import com.github.jknack.handlebars.springmvc.HandlebarsViewResolver;
import com.github.jknack.handlebars.springmvc.SpringTemplateLoader;

@Configuration
public class HandlebarsConfig {
	@Autowired
	private ApplicationContext applicationContext;

	@Bean
	public HandlebarsViewResolver viewResolver() {
		HandlebarsViewResolver viewResolver = new HandlebarsViewResolver();

		Helper<Object> helper = new Helper<Object>() {
			@Override
			public Object apply(final Object context, final Options options) throws IOException {
				return "Spring Helper";
			}
		};

		viewResolver.registerHelper("spring", helper);
		viewResolver.setHelpers(Arrays.asList(HandlebarsConfig.class));
		viewResolver.setCache(false);
		viewResolver.setBindI18nToMessageSource(true);
		viewResolver.setPrefix("classpath:WEB-INF/views/");
		viewResolver.setSuffix(".hbs");
		return viewResolver;
	}

	@Bean
	public HandlebarsViewResolver parameterizedHandlebarsViewResolver() {
		HandlebarsViewResolver viewResolver = new HandlebarsViewResolver(
				new Handlebars(new SpringTemplateLoader(applicationContext)));
		// viewResolver.setCache(false);
		return viewResolver;
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}

	@Bean
	public HandlebarsViewResolver viewResolverWithoutMessageHelper() {
		return new HandlebarsViewResolver().withoutMessageHelper();
	}

	public static CharSequence helperSource() {
		return "helper source!";
	}
}
