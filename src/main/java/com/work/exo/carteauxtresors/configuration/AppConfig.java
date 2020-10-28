package com.work.exo.carteauxtresors.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class AppConfig {

    @Value("${inputFile.path}")
    public String inputFilePath;

    @Value("${outputFile.path}")
    public String outputFilePath;

}
