package com.example.springbooticecreamstore.controllers;

import com.example.springbooticecreamstore.models.IceCream;
import com.example.springbooticecreamstore.repositories.IceCreamRepository;
import com.example.springbooticecreamstore.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/icecream")
public class IceCreamController {
    @Autowired
    private IceCreamRepository iceCreamRepository;

    // get all ice creams
    @GetMapping
    public List<IceCream> getAllIceCreams() {
        return iceCreamRepository.findAll();
    }

    // create a new ice cream
    @PostMapping
    public IceCream createIceCream(@RequestBody IceCream iceCream) {
        return iceCreamRepository.save(iceCream);
    }

    // get ice cream by id
    @GetMapping("/{id}")
    public ResponseEntity<IceCream> getIceCreamById(@PathVariable Long id) {
        IceCream iceCream = iceCreamRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ice Cream not exist with id: " + id));
        return ResponseEntity.ok(iceCream);
    }

    // update ice cream
    @PutMapping("/{id}")
    public ResponseEntity<IceCream> updateIceCream(@PathVariable Long id, @RequestBody IceCream iceCreamDetails) {
        IceCream iceCream = iceCreamRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ice Cream not exist with id: " + id));
        iceCream.setName(iceCreamDetails.getName());
        iceCream.setPrice(iceCreamDetails.getPrice());
        return ResponseEntity.ok(iceCream);
    }

    // delete user rest api
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteIceCream(@PathVariable Long id) {
        IceCream iceCream = iceCreamRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ice Cream not exist with id: " + id));
        iceCreamRepository.delete(iceCream);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
