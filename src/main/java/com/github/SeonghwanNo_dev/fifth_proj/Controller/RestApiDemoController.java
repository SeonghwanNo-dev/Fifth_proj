package com.github.SeonghwanNo_dev.fifth_proj.Controller;

import com.github.SeonghwanNo_dev.fifth_proj.Entity.Coffee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
public class RestApiDemoController {
    private List<Coffee> coffees = new ArrayList<>();

    public RestApiDemoController() {
        coffees.addAll(List.of(
                new Coffee("Cafe Cereza"),
                new Coffee("Cafe Ganador"),
                new Coffee("Cafe Lareno"),
                new Coffee("Cafe Tres Pontas")
        ));
    }

    @GetMapping("/coffees")
    Iterable<Coffee> getCoffees(){
        return coffees;
    }

    @GetMapping("/coffees/{id}")
    Optional<Coffee> getCoffeeById(@PathVariable String id)
    {
        for (Coffee c: coffees)
        {
            if (c.getId().equals(id)) return Optional.of(c);
        }
        return Optional.empty();
    }

    @PostMapping("/coffees")
    Coffee postCoffee(@RequestBody Coffee coffee)
    {
        coffees.add(coffee);
        return coffee;
    }

    // U, D는 생략
}
