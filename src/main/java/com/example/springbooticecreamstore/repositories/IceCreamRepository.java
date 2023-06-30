package com.example.springbooticecreamstore.repositories;

import com.example.springbooticecreamstore.models.IceCream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IceCreamRepository extends JpaRepository<IceCream, Long> {
}
