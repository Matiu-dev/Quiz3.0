package pl.mateusz.quiz.configuration;

import org.springframework.context.annotation.Bean;

public class ModelMapper {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
