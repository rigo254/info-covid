package co.edu.udea.infocovid.feign_client;

import co.edu.udea.infocovid.config.FeignWeatherConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "covid-api", url = "${covid.api}", configuration = FeignWeatherConfiguration.class)
public interface CovidFeign {

    @GetMapping()
    String getInformation(@RequestParam("q") String city,
                          @RequestParam("appid") String clientId);

}
