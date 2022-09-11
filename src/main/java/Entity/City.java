package Entity;

import java.util.Objects;

public class City {

    private Integer cityId;
    private String cityName;

    public City(Integer cityId, String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
    }

    public City() {
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return Objects.equals(getCityId(), city.getCityId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCityId());
    }
}
