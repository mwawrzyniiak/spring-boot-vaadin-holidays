package pl.wawrzyniak.holidays.client;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.wawrzyniak.holidays.model.Holiday;


@Service

public class HolidaysClient {

    private static RestTemplate restTemplate = new RestTemplate();

    private static String BASE_URL = "https://date.nager.at/api/v2/PublicHolidays/";

    //we can also create getHolidays class which returns the list of HolidayObject.
    //it requires changing several elements of the downloaded Json - [ -> { and ] -> }.
    //TODO: method implementation that returns a list of objects rather than an array
    public Holiday[] getHolidays(String year, String countryCode) {
        ResponseEntity<Holiday[]> exchange = restTemplate.exchange(
                generateURL(year, countryCode),
                HttpMethod.GET,
                HttpEntity.EMPTY,
                Holiday[].class);

        return exchange.getBody();
    }

    //a method that generates a link to the API based on BASE_URL, and two parameters: year&&countryCode
    //exemplary output: for year = 2001 && countryCode = PL:
    //https://date.nager.at/api/v2/PublicHolidays/2001/PL
    private String generateURL(String year, String countryCode) {
        String url="";
        url = BASE_URL + year + "/";
        url = url + countryCode;
        return url;
    }
}
