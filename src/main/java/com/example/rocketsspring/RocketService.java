package com.example.rocketsspring;

import org.springframework.stereotype.Controller;

import javax.transaction.Transactional;
import java.util.List;

@Controller
public class RocketService {

    private RocketRepository rocketRepository;
    private PropellerRepository propellerRepository;

    public RocketService(RocketRepository rocketRepository,PropellerRepository propellerRepository) {
        this.rocketRepository = rocketRepository;
        this.propellerRepository = propellerRepository;
    }

    public List<Rocket> getAllRockets(){
        return rocketRepository.findAll();
    }


    public Rocket getRocket( Long id){
        return rocketRepository.findById(id).get();
    }


    public Rocket createRocket( Rocket rocket){
        return rocketRepository.save(rocket);
    }


    public Propeller createPropeller(Long id, Propeller propeller){
        Rocket rocket = rocketRepository.getById(id);
        propeller.setRocket(rocket);
        return propellerRepository.save(propeller);
    }

    public List<Propeller> getPropellers( Long id){
        Rocket rocket = rocketRepository.getById(id);
        return rocket.getPropeller();
    }

    @Transactional
    public Rocket moveRocket( Long id,  Movement movement) {

        Rocket rocket = rocketRepository.findById(id).get();
        for (int i = 0; i < movement.getTimes(); i++) {
            if(movement.getMovementType().equals(Movement.ACCELERATE)){
                rocket.accelerate();
            }else if(movement.getMovementType().equals(Movement.BRAKE)){
                rocket.slowDown();
            }
        }

        propellerRepository.saveAll(rocket.getPropeller());

        return rocket;
    }

    public void removeAllRockets() {
        rocketRepository.deleteAll();
    }

    public void removeRocket(Long id) {
        rocketRepository.deleteById(id);
    }

    public void removeAllPropellers(Long id) {

        propellerRepository.deleteAllByRocketId(id);
    }
}
