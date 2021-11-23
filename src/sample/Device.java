package sample;

public class Device
{
    private int brandId;
    private String brandName;
    private String brandSlug;
    private int deviceCount;
    private String detail;

    /**
     * No args constructor for use in serialization
     */
    public Device()
    { }

    /**
     * @param brandSlug
     * @param brandName
     * @param deviceCount
     * @param brandId
     * @param detail
     */
    public Device(int brandId, String brandName, String brandSlug, int deviceCount, String detail)
    {
        super();
        this.brandId = brandId;
        this.brandName = brandName;
        this.brandSlug = brandSlug;
        this.deviceCount = deviceCount;
        this.detail = detail;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandSlug() {
        return brandSlug;
    }

    public void setBrandSlug(String brandSlug) {
        this.brandSlug = brandSlug;
    }

    public int getDeviceCount() {
        return deviceCount;
    }

    public void setDeviceCount(int deviceCount) {
        this.deviceCount = deviceCount;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString()
    {
        return "\nDevice: " +
                "BrandId=" + brandId + ",\n" +
                "BrandName='" + brandName + ",\n" +
                "BrandSlug='" + brandSlug + ",\n" +
                "DeviceCount=" + deviceCount + ",\n" +
                "Detail=" + detail + ".\n";
    }
}