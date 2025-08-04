package org.edutech.classes.placeholders;






public class StreamDTO {
    private int id;
    private String streamName;
    private String streamNumber;
    private String description;
 

    // Getters and Setters
    
    public String getStreamName() { return streamName; }
    public void setStreamName(String streamName) { this.streamName = streamName; }

    public String getStreamNumber() { return streamNumber; }
    public void setStreamNumber(String streamNumber) { this.streamNumber = streamNumber; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
