package com.example.relation.controller;

import com.example.relation.DTO.ProfileDTO;
import com.example.relation.Model.Profile;
import com.example.relation.Service.ProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/profile")
public class ProfileController {
    private final ProfileService profileService;
@GetMapping("/get")
    public ResponseEntity getAllProfile(){
        return ResponseEntity.status(HttpStatus.OK).body(profileService.getAllProfile());
    }
    @PostMapping("/post")
    public ResponseEntity addProfile(@RequestBody @Valid ProfileDTO profileDTO){
        profileService.addProfile(profileDTO);
        return ResponseEntity.status(HttpStatus.OK).body("added profile");

    }
    @PutMapping("/put/{id}")
    public ResponseEntity updateProfile(@PathVariable Integer id,@RequestBody @Valid Profile profile){
    profileService.updateProfile(id, profile);
        return ResponseEntity.status(HttpStatus.OK).body("update profile");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
    profileService.delleteProfile(id);
        return ResponseEntity.status(HttpStatus.OK).body("delete profile");

    }
}
