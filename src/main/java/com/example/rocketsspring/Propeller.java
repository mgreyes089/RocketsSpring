package com.example.rocketsspring;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Propeller {

    @Id
    @GeneratedValue
    private Long id;
    private int maxPower;
    private int currentPower = 0;

    @ManyToOne
    @JsonBackReference
    private Rocket rocket;

    public Propeller() {
    }

    public Propeller(int powerPropeller) throws Exception {
        checkValidPowerPropeller(powerPropeller);
        this.maxPower = powerPropeller;
    }

    private void checkValidPowerPropeller(int powerPropeller) throws Exception {
        if(powerPropeller<=0) throw new Exception("La potencia máxima debe ser mayor a cero");
    }

    public int getMaxPower() {
        return maxPower;
    }


    public int getCurrentPower() {
        return currentPower;
    }


    public void slowDown() {
        currentPower = currentPower - 10;
        if (currentPower < 0) {
            currentPower=0;
        }
    }

    public void accelerate() {
        currentPower = currentPower + 10;
        if (currentPower > maxPower) {
            currentPower=maxPower;
        }
    }

    public Long getId() {
        return id;
    }


    public void setMaxPower(int maxPower) {
        this.maxPower = maxPower;
    }

    public void setCurrentPower(int currentPower) {
        this.currentPower = currentPower;
    }

    public Rocket getRocket() {
        return rocket;
    }

    public void setRocket(Rocket rocket) {
        this.rocket = rocket;
    }

    @Override
    public String toString() {
        return " " +
                " " + maxPower +
                " ";
    }
}