package org.edutech.classes.service;



import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.edutech.classes.dao.ClassDao;
import org.edutech.classes.placeholders.ClassRoomDTO;
import org.edutech.classes.placeholders.ClassRooms;
import org.edutech.classes.placeholders.StreamDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ClassRoomServiceImpl implements ClassRoomService {

    @Autowired
    private ClassDao classDao;

    public void setClassDao(ClassDao classDao) {
        this.classDao = classDao;
    }

    // Save a class
    @Override
    public void addClassRoom(ClassRooms classRoom) {
        classDao.addClassRoom(classRoom);
    }

    // Return raw entity list
    @Override
    public List<ClassRooms> getAllClassRooms() {
        return classDao.getAllClassRooms();
    }

    // Return DTO list
    @Override
    public List<ClassRoomDTO> getAllClassRoomDTOs() {
        return classDao.getAllClassRooms().stream().map(entity -> {
            ClassRoomDTO dto = new ClassRoomDTO();
            dto.setId(entity.getId());
            dto.setUuid(entity.getUuid());
            dto.setClassName(entity.getClassName());

            List<StreamDTO> streamDTOs = entity.getStreams().stream().map(stream -> {
                StreamDTO s = new StreamDTO();
                s.setId(stream.getId());
                s.setStreamName(stream.getStreamName());
                s.setStreamNumber(stream.getStreamNumber());
                s.setDescription(stream.getDescription());
                return s;
            }).collect(Collectors.toList());

            dto.setStreams(streamDTOs);
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public ClassRooms getClassRoomByName(String className) {
        return classDao.getClassRoomByName(className);
    }

    @Override
    public ClassRooms getClassRoomById(int id) {
        // Implement if your DAO supports it
        return null;
    }

    @Override
    public void updateClassRoom(ClassRooms classRoom) {
        classDao.updateClassRoom(classRoom);
    }

    @Override
    public void deleteClassRoom(String className) {
        classDao.deleteClassRoom(className);
    }

    @Override
    public ClassRoomDTO getClassWithStreams(String className) {
        ClassRooms entity = classDao.getClassRoomByName(className);
        if (entity == null) return null;

        ClassRoomDTO dto = new ClassRoomDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setClassName(entity.getClassName());

        List<StreamDTO> streamDTOs = entity.getStreams().stream().map(stream -> {
            StreamDTO sdto = new StreamDTO();
            sdto.setId(stream.getId());
            sdto.setStreamName(stream.getStreamName());
            sdto.setStreamNumber(stream.getStreamNumber());
            sdto.setDescription(stream.getDescription());
            return sdto;
        }).collect(Collectors.toList());

        dto.setStreams(streamDTOs);
        return dto;
    }
}
