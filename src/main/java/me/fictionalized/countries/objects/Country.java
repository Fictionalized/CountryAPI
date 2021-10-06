package me.fictionalized.countries.objects;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Country {

    private String name, alpha2Code, alpha3Code, capital, region, subregion, population, demonym, nativeName, numericCode, flag, cioc;

    private List<String> topLevelDomains, callingCodes, altSpellings, timezones, borders;

    private List<Language> languages;
    private List<Region> regionalBlocs;

    private Map<String, String> translations;

}
