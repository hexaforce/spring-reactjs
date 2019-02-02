package io.hexaforce.petclinic.web.api;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.hexaforce.petclinic.model.Vet;
import io.hexaforce.petclinic.service.ClinicService;

@RestController
public class VetResource extends AbstractResourceController {

    private final ClinicService clinicService;

    @Autowired
    public VetResource(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @GetMapping(value = "/vets")
    public Collection<Vet> showResourcesVetList() {
        return this.clinicService.findVets();
    }
}
