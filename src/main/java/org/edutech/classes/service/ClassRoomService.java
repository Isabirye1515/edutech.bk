package org.edutech.classes.service;

import java.util.List;

import org.edutech.classes.placeholders.ClassRoomDTO;
import org.edutech.classes.placeholders.ClassRooms;

public interface ClassRoomService {
    ClassRoomDTO getClassWithStreams(String uuid);

    void addClassRoom(ClassRooms classRoom);
    List<ClassRooms> getAllClassRooms();
    List<ClassRoomDTO> getAllClassRoomDTOs();
    ClassRooms getClassRoomByName(String className);
    ClassRooms getClassRoomById(int id);
    void updateClassRoom(ClassRooms classRoom);
    void deleteClassRoom(String className);
}
