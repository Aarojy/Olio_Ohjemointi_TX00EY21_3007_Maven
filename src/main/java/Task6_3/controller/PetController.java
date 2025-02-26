package Task6_3.controller;

import Task6_3.view.PetInterface;
import Task6_3.model.Pet;

public class PetController {
    private PetInterface view;
    private Pet pet;

    public PetController (PetInterface view, int x, int y) {
        this.view = view;
        pet = new Pet(x/2,y/2);
    }

    public void setPetTarget (Double mousex, Double mousey) {
        pet.setTargetx(mousex);
        pet.setTargety(mousey);
    }

    public void updatePetPosition() {
        pet.moveTowardsMouse();
    }

    public double getPetX() {
        return pet.getX();
    }

    public double getPetY() {
        return pet.getY();
    }

    public void stopPet() {
        pet.setTargetx(pet.getX());
        pet.setTargety(pet.getY());
    }

}
