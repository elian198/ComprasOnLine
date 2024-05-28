package com.HouseBeer.service;

import com.HouseBeer.entity.Cliente;
import com.HouseBeer.entity.Foto;
import com.HouseBeer.entity.Pedido;
import com.HouseBeer.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> findAllPedidos(){
        return pedidoRepository.findAll();
    }

    public void savePedido(Pedido pedido){
        pedidoRepository.save(pedido);
    }

    public void deleteById(Long id){
        pedidoRepository.deleteById(id);
    }

    public Pedido findByDate(String date){
    return pedidoRepository.findByDate(date);
    }
}
