package com.HouseBeer.service;

import com.HouseBeer.repository.CierreCajaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CierreCajaService {

    @Autowired
    private CierreCajaRepository cierreCajaRepository;
}
