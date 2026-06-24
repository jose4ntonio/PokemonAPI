package com.example.PokemonAPI.controller;

import com.example.PokemonAPI.model.Pokemon;
import com.example.PokemonAPI.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pokemones")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @GetMapping
    public List<Pokemon> obtenerTodos(){
        return pokemonService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Pokemon obtenerPorId(@PathVariable Long id){
        return pokemonService.obtenerPorId(id).orElse(null);
    }
    @PostMapping
    public Pokemon crearPokemon(@RequestBody Pokemon pokemon){
        return pokemonService.crearPokemon(pokemon);
    }

    // --- Métodos añadidos para completar el CRUD ---

    // Actualización completa (Reemplaza todo el objeto)
    @PutMapping("/{id}")
    public Pokemon actualizarPokemonCompleto(@PathVariable Long id, @RequestBody Pokemon pokemon) {
        return pokemonService.actualizarPokemonCompleto(id, pokemon);
    }

    // Actualización parcial (Solo modifica los campos que le envíes)
    @PatchMapping("/{id}")
    public Pokemon actualizarPokemonParcial(@PathVariable Long id, @RequestBody Pokemon pokemon) {
        return pokemonService.actualizarPokemonParcial(id, pokemon);
    }

    // Eliminar un Pokémon por ID
    @DeleteMapping("/{id}")
    public void eliminarPokemon(@PathVariable Long id) {
        pokemonService.eliminarPokemon(id);
    }
}