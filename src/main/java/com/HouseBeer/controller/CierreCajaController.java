package com.HouseBeer.controller;

import com.HouseBeer.service.CierreCajaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CierreCajaController {

    @Autowired
    private CierreCajaService cierreCajaService;
}
