package org.ipc.synapsis.curriculumvitae.bean.exception;

/**
 * Created by mbasri on 16/07/2016.
 */
public class ResourceNotFound {

    private String code;
    private String label;
    private String resourceID;
    private String resourceName;


    public ResourceNotFound() {
    }

    public ResourceNotFound(String code, String label, String resourceID, String resourceName) {
        this.code = code;
        this.label = label;
        this.resourceID = resourceID;
        this.resourceName = resourceName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getResourceID() {
        return resourceID;
    }

    public void setResourceID(String resourceID) {
        this.resourceID = resourceID;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    @Override
    public String toString() {
        return "ResourceNotFound{" +
                "code='" + code + '\'' +
                ", label='" + label + '\'' +
                ", resourceID='" + resourceID + '\'' +
                ", resourceName='" + resourceName + '\'' +
                '}';
    }
}