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
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
public class EconomicModelRestController {

    private EconomicModelService economicModelService;

    @GetMapping("/ecomodels")
    public List<EconomicModel> getEconomicModels() {
        return economicModelService.getEconomicModels();
    }
}
