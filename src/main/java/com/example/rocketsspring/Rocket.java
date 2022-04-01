package com.example.rocketsspring;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Rocket {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    protected Long id;
    protected String codeRocket;

    @OneToMany(mappedBy = "rocket")
    @JsonManagedReference
    protected List<Propeller> propellers = new ArrayList<>();

    public Rocket() {
    }

    public Rocket(Long id, String codeRocket) {
        this.id = id;
        this.codeRocket = codeRocket;
    }

    public String getCodeRocket() {
        return codeRocket;
    }

    public void setCodeRocket(String codeRocket) {
        this.codeRocket = codeRocket;
    }

    public List<Propeller> getPropeller(){
        return this.propellers;
    }

    public void setPropellers(List<Propeller> propellers) {
        this.propellers = propellers;
    }

    public Long getId() {
        return id;
    }

    public void addPropeller (int powerPropeller) throws Exception {
        checkPowerPropeller (powerPropeller);
        Propeller propeller = new Propeller(powerPropeller);
        this.propellers.add(propeller);
    }

    private void checkPowerPropeller(int powerPropeller) throws Exception {
        if(powerPropeller <= 0) throw new Exception("El valor debe ser mayor a cero");
    }

    @JsonProperty(value = "currentPower")
    public String showPropellersStatus (){
        String result = "";
        int addAllCurrentPower = 0;
        int i=1;
        for (Propeller propeller: propellers)     {
            result += propeller.getCurrentPower() + ",";
            i++;
            addAllCurrentPower += propeller.getCurrentPower();
        }
        result = result + "La potencia total de los propulsores suma: " + addAllCurrentPower;
        return result;
    }

    public void slowDown(){
        for(Propeller propeller: propellers ){
            propeller.slowDown();
        }
    }
    public void accelerate(){
        for(Propeller propeller: propellers ){
            propeller.accelerate();
        }
    }

    @Override
    public String toString() {
        return " " + id +
                " " + codeRocket + '\'' +
                ": " + propellers +
                " ";
    }
}