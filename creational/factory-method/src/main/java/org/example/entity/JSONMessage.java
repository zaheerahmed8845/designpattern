package org.example.entity;

public class JSONMessage extends Message{
    @Override
    public String getContent() {
        return """
                {
                 "JSON" : []
                }
                """;
    }
}
