package sample;

public class Car {


    private String carName;
    private String carColor;
    private Integer carEngineSize;
    private Long id;

    public Car(String carName, Long id, Integer carEngineSize, String carColor) {
        this.setCarName(carName);
        this.setCarColor(carColor);
        this.setCarEngineSize(carEngineSize);
        this.setId(id);
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Integer getCarEngineSize() {
        return carEngineSize;
    }

    public void setCarEngineSize(Integer carEngineSize) {
        this.carEngineSize = carEngineSize;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarColor() {
        return carColor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
