package p08_Pet_Clinics.entities.implementations;

import p08_Pet_Clinics.entities.interfaces.Clinic;
import p08_Pet_Clinics.entities.interfaces.Pet;

import java.util.Arrays;

public class ClinicImpl implements Clinic {
    private String name;
    private int numberOfRooms;
    private Pet[] roomsArr;

    public ClinicImpl(String name, int numberOfRooms) {
        this.setName(name);
        this.setNumberOfRooms(numberOfRooms);
        this.setRoomsArr();
    }

    @Override
    public boolean hasEmptyRooms(){
        for (int i = 0; i < getNumberOfRooms(); i++) {
            if (this.roomsArr[i] == null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean release(){
        int currentIndex = this.getNumberOfRooms() / 2 ;

        for (int i = 0; i < getNumberOfRooms(); i++) {
            if (this.roomsArr[currentIndex] != null) {
                this.roomsArr[currentIndex] = null;
                return true;
            }
            if (i == getNumberOfRooms()-1) {
                currentIndex = -1;
            }
            currentIndex++;
        }
        return false;
    }

    @Override
    public boolean addPetToClinic(Pet pet) {
        int currentIndex = this.getNumberOfRooms() / 2;
        int indexLeft = currentIndex - 1;
        int indexRight = currentIndex + 1;

        for (int i = 0; i < getNumberOfRooms(); i++) {
            if (this.roomsArr[currentIndex] == null) {
                this.roomsArr[currentIndex] = pet;
                return true;
            }
            if (i % 2 == 0) {
                currentIndex = indexLeft;
                indexLeft--;
            } else {
                currentIndex = indexRight;
                indexRight++;
            }
        }
        return false;
    }

    @Override
    public Pet[] getRoomsArr() {
        return this.roomsArr;
    }

    private void setRoomsArr() {
        this.roomsArr = new Pet[this.numberOfRooms];
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public int getNumberOfRooms() {
        return this.numberOfRooms;
    }

    private void setNumberOfRooms(int numberOfRooms) {
        if (numberOfRooms % 2 == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        }
        this.numberOfRooms = numberOfRooms;
    }

    @Override
    public void printRoom(int roomNumber){
        if(this.roomsArr[roomNumber-1] == null){
            System.out.println("Room empty");
        }else{
            System.out.println(this.roomsArr[roomNumber-1]);
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(roomsArr).forEach(x -> {
            if(x == null){
                sb.append("Room empty").append(System.lineSeparator());
            }else{
                sb.append(x.toString()).append(System.lineSeparator());
            }
        });

        return sb.toString().trim();
    }
}
