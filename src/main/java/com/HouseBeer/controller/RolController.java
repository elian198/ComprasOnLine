package com.HouseBeer.controller;

import com.HouseBeer.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RolController {

    @Autowired
    private RolService rolService;
}
