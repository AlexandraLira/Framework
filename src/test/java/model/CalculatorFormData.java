package model;

public class CalculatorFormData {

    private final String numberOfInstances;
    private final String operatingSystem;
    private final String model;
    private final String series;
    private final String machineType;
    private final String gpuType;
    private final String numberOfGPUs;
    private final String ssd;
    private final String dataCenterLocation;
    private final String committedUsage;

    public CalculatorFormData(String numberOfInstances, String operatingSystem, String model, String series,
                              String machineType, String gpuType, String numberOfGPUs,
                              String ssd, String location, String committedUsage) {
        this.numberOfInstances = numberOfInstances;
        this.operatingSystem = operatingSystem;
        this.model = model;
        this.series = series;
        this.machineType = machineType;
        this.gpuType = gpuType;
        this.numberOfGPUs = numberOfGPUs;
        this.ssd = ssd;
        this.dataCenterLocation = location;
        this.committedUsage = committedUsage;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getModel() {
        return model;
    }

    public String getSeries() {
        return series;
    }

    public String getMachineType() {
        return machineType;
    }

    public String getGpuType() {
        return gpuType;
    }

    public String getNumberOfGPUs() {
        return numberOfGPUs;
    }

    public String getSsd() {
        return ssd;
    }

    public String getDataCenterLocation() {
        return dataCenterLocation;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

}
