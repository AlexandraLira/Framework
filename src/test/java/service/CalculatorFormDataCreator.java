package service;

import model.CalculatorFormData;

public final class CalculatorFormDataCreator {
    public static final String TESTDATA_NUMBER_OF_INSTANCES = "testdata.numberOfInstances";
    public static final String TESTDATA_OPERATING_SYSTEM = "testdata.operatingSystem";
    public static final String TESTDATA_MODEL = "testdata.model";
    public static final String TESTDATA_SERIES = "testdata.series";
    public static final String TESTDATA_MACHINE_TYPE = "testdata.machineType";
    public static final String TESTDATA_GPU_TYPE = "testdata.gpuType";
    public static final String TESTDATA_NUMBER_OF_GPUS = "testdata.numberOfGPUs";
    public static final String TESTDATA_SSD = "testdata.ssd";
    public static final String TESTDATA_DATA_CENTER_LOCATION = "testdata.dataCenterLocation";
    public static final String TESTDATA_COMMITTED_USAGE = "testdata.committedUsage";

    public static CalculatorFormData getDataFromProperties() {
        return new CalculatorFormData(TestDataCalculatorFormReader.getTestData(TESTDATA_NUMBER_OF_INSTANCES),
                TestDataCalculatorFormReader.getTestData(TESTDATA_OPERATING_SYSTEM),
                TestDataCalculatorFormReader.getTestData(TESTDATA_MODEL),
                TestDataCalculatorFormReader.getTestData(TESTDATA_SERIES),
                TestDataCalculatorFormReader.getTestData(TESTDATA_MACHINE_TYPE),
                TestDataCalculatorFormReader.getTestData(TESTDATA_GPU_TYPE),
                TestDataCalculatorFormReader.getTestData(TESTDATA_NUMBER_OF_GPUS),
                TestDataCalculatorFormReader.getTestData(TESTDATA_SSD),
                TestDataCalculatorFormReader.getTestData(TESTDATA_DATA_CENTER_LOCATION),
                TestDataCalculatorFormReader.getTestData(TESTDATA_COMMITTED_USAGE));
    }
}
