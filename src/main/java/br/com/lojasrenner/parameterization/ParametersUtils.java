package br.com.lojasrenner.parameterization;

import org.aeonbits.owner.Config;

@Config.Sources({"file:src/main/resources/parameters.properties"})
public interface ParametersUtils extends Config {
    @Key("url")
    String url();
}
