package fr.orsys.groupe3.gamerefback.controller;

import fr.orsys.groupe3.gamerefback.business.EconomicModel;
import fr.orsys.groupe3.gamerefback.service.EconomicModelService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "true")
public class EconomicModelRestController {
    private EconomicModelService economicModelService;

    @GetMapping("/economicModels")
    public List<EconomicModel> getEconomicModels() {
        return economicModelService.getEconomicModels();
    }
}
