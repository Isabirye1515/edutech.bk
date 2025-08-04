package org.edutech.classes.service;

import java.util.List;

import org.edutech.classes.placeholders.Stream;
import org.edutech.classes.placeholders.StreamDTO;

public interface StreamService {

    // Existing Entity Operations
    void addStream(Stream stream);
    List<Stream> getAllStreams();
    Stream getStreamByStreamNumber(String streamNumber);
    Stream getStreamById(int id);
    void updateStream(Stream stream);
    void deleteStream(int id);

    // ✅ New DTO-based operations
    List<StreamDTO> getAllStreamDTOs(boolean includeStudents);
    StreamDTO getStreamDTOById(int id, boolean includeStudents);
}
