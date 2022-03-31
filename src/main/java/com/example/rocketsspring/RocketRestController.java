package com.example.rocketsspring;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RocketRestController {
    public RocketService rocketService;

    public RocketRestController(RocketService rocketService) {
        this.rocketService = rocketService;

    }

    @GetMapping("/rockets")
    public List<Rocket> getAllRockets(){
        return rocketService.getAllRockets();
    }

    @GetMapping("/rockets/{id}")
    public Rocket getRocket(@PathVariable Long id){
        return rocketService.getRocket( id);
    }

    @PostMapping("/rockets")
    public Rocket createRocket(@RequestBody Rocket rocket){
        return rocketService.createRocket(rocket);
    }

    @PostMapping("/rockets/{id}/propellers")
    public Propeller createPropeller(@PathVariable Long id, @RequestBody Propeller propeller){
        return rocketService.createPropeller(id, propeller);
    }
    @GetMapping("/rockets/{id}/propellers")
    public List<Propeller> getPropellers(@PathVariable Long id){
        return rocketService.getPropellers(id);
    }
    @PostMapping("/rockets/{id}/movement")
    public Rocket moveRocket(@PathVariable Long id, @RequestBody Movement movement) {
        return rocketService.moveRocket(id, movement);
    }
    @DeleteMapping("/rockets")
    public void removeAllRockets() {
        rocketService.removeAllRockets();
    }

    @DeleteMapping("/restaurants/{id}")
    public void removeRockets(@PathVariable Long id) {
        rocketService.removeRocket(id);
    }

    @DeleteMapping("/rockets/{id}/propeller")
    public void removeAllPropellers(@PathVariable Long id) throws Exception {
        rocketService.removeAllPropellers(id);
    }
}
