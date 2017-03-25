/**
 * Created by Ramazan on 20.03.2017.
 */
public class PlayStatistics {
    public String outlook;// прогноз
    public String humidity; // влажность
    public String temperature; // температура
    public String windy;// ветренно
    public boolean decision; // решение

    public PlayStatistics(String outlook, String humidity, String temperature, String windy, boolean decision) {
        this.outlook = outlook;
        this.humidity = humidity;
        this.temperature = temperature;
        this.windy = windy;
        this.decision = decision;
    }

    public String getOutlook() {
        return outlook;
    }

    public void setOutlook(String outlook) {
        this.outlook = outlook;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWindy() {
        return windy;
    }

    public void setWindy(String windy) {
        this.windy = windy;
    }

    public boolean isDecision() {
        return decision;
    }

    public void setDecision(boolean decision) {
        this.decision = decision;
    }
}
