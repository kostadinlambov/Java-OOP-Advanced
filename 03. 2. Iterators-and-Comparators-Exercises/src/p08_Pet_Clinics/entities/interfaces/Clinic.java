package p08_Pet_Clinics.entities.interfaces;

import java.util.List;

public interface Clinic {
    //List<Pet> getRoomsArr();

    boolean hasEmptyRooms();

    boolean release();

    boolean addPetToClinic(Pet pet);

    Pet[] getRoomsArr();

    String getName();

    int getNumberOfRooms();

    void printRoom(int roomNumber);
}
