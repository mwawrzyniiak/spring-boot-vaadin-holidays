package pl.wawrzyniak.holidays.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Holiday {

    @JsonProperty("date")
    private Date date;
    @JsonProperty("localName")
    private String localName;
    @JsonProperty("name")
    private String name;
    @JsonProperty("countryCode")
    private String countryCode;
    @JsonProperty("fixed")
    private boolean fixed;
    @JsonProperty("global")
    private boolean global;
    @JsonProperty("counties")
    private String counties;
    @JsonProperty("launchYear")
    private Integer launchYear;
    @JsonProperty("type")
    private String type;

    @Override
    public String toString() {
        return "Holiday{" +
                "date=" + date +
                ", localName='" + localName + '\'' +
                ", name='" + name + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", fixed=" + fixed +
                ", global=" + global +
                ", counties='" + counties + '\'' +
                ", launchYear=" + launchYear +
                ", type='" + type + '\'' +
                '}';
    }
}
