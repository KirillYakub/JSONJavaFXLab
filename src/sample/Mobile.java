package sample;

import java.util.ArrayList;
import java.util.List;

public class Mobile
{
    private boolean status;
    private List<Device> device = new ArrayList<>();

    /**
     * No args constructor for use in serialization
     */
    public Mobile()
    { }

    /**
     * @param device
     * @param status
     */
    public Mobile(boolean status, List<Device> device)
    {
        super();
        this.status = status;
        this.device = device;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Device> getDevice() {
        return device;
    }

    public void setDevice(List<Device> device) {
        this.device = device;
    }

    public void addDevice(Device device) {
        this.device.add(device);
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("Mobile: ");
        sb.append("Status=").append(status);
        sb.append(",\n");
        sb.append("Devices=").append(device);
        sb.append(".\n");
        return sb.toString();
    }
}