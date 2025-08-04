package org.edutech.classes.service;

import java.util.List;
import java.util.stream.Collectors;

import org.edutech.classes.dao.StreamsDao;
import org.edutech.classes.placeholders.Stream;
import org.edutech.classes.placeholders.StreamDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StreamServiceImp implements StreamService {

    @Autowired
    private StreamsDao streamsDao;

    public void setStreamDao(StreamsDao streamsDao) {
        this.streamsDao = streamsDao;
    }

    @Override
    public Stream getStreamByStreamNumber(String streamNumber) {
        return streamsDao.getStreamByStreamNumber(streamNumber);
    }

    @Override
    public Stream getStreamById(int id) {
        return streamsDao.getStreamById(id);
    }

    @Override
    public List<Stream> getAllStreams() {
        return streamsDao.getAllStreams();
    }

    @Override
    public void deleteStream(int id) {
        streamsDao.deleteStream(id);
    }

    @Override
    public void updateStream(Stream stream) {
        streamsDao.updateStream(stream);
    }

    @Override
    public void addStream(Stream stream) {
        streamsDao.addStream(stream);
    }

    // ---------- NEW DTO METHODS ----------

    public StreamDTO mapToDto(Stream stream, boolean includeStudents) {
        StreamDTO dto = new StreamDTO();
        dto.setStreamName(stream.getStreamName());
        dto.setStreamNumber(stream.getStreamNumber());
        dto.setDescription(stream.getDescription());

     

        return dto;
    }

   

    public List<StreamDTO> getAllStreamDTOs(boolean includeStudents) {
        return streamsDao.getAllStreams().stream()
                .map(stream -> mapToDto(stream, includeStudents))
                .collect(Collectors.toList());
    }

    public StreamDTO getStreamDTOById(int id, boolean includeStudents) {
        Stream stream = includeStudents
                ? streamsDao.getStreamWithStudentsById(id)
                : streamsDao.getStreamById(id);

        return stream != null ? mapToDto(stream, includeStudents) : null;
    }
}
