package com.example.relation.Repository;

import com.example.relation.Model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile,Integer> {
    Profile findProfileById(Integer id);
}
