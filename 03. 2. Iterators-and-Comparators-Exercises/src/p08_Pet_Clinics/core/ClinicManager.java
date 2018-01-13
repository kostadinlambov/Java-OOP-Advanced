package p08_Pet_Clinics.core;

import p08_Pet_Clinics.entities.implementations.ClinicImpl;
import p08_Pet_Clinics.entities.implementations.PetImpl;
import p08_Pet_Clinics.entities.interfaces.Clinic;
import p08_Pet_Clinics.entities.interfaces.Pet;


import java.util.LinkedHashMap;
import java.util.Map;

public class ClinicManager {
    private Map<String, Pet> petMap;
    private Map<String, Clinic> clinicMap;

    public ClinicManager() {
        this.petMap = new LinkedHashMap<>();
        this.clinicMap = new LinkedHashMap<>();

    }

    public void createPet(String name, int age, String kind) {
        Pet pet = new PetImpl(name, age, kind);
        petMap.putIfAbsent(name, pet);
    }

    public void createClinic(String name, int numberOfRooms) {
        Clinic clinic = new ClinicImpl(name, numberOfRooms);
        clinicMap.putIfAbsent(name, clinic);
    }

    public boolean add(String petName, String clinicName) {
        if(!petMap.containsKey(petName)){
           throw new IllegalArgumentException("Invalid Operation!");
        }
        Pet pet = petMap.get(petName);
        return  clinicMap.get(clinicName).addPetToClinic(pet);
    }

    public boolean release(String clinicName) {
        return clinicMap.get(clinicName).release();
    }

    public boolean hasEmptyRooms(String clinicName) {
        return clinicMap.get(clinicName).hasEmptyRooms();
    }

    public void print(String clinicName) {
        System.out.println(clinicMap.get(clinicName).toString());

    }

    public void print(String clinicName, int roomNumber) {
        clinicMap.get(clinicName).printRoom(roomNumber);
    }
}
