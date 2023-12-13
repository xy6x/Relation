package com.example.relation.Service;

import com.example.relation.ApiException.ApiException;
import com.example.relation.DTO.ProfileDTO;
import com.example.relation.Model.Customer;
import com.example.relation.Model.Profile;
import com.example.relation.Repository.CustomerRepository;
import com.example.relation.Repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileService {
    private final CustomerRepository customerRepository;
    private final ProfileRepository profileRepository;
    public List<Profile> getAllProfile(){
        return profileRepository.findAll();
    }
    public void  addProfile(ProfileDTO profileDTO){
        Customer customer =customerRepository.findCustomerById(profileDTO.getCustomer_id());
        if (customer == null) {
            throw  new ApiException("the customer not found");
        }
        Profile profile =new Profile(null,profileDTO.getName(),profileDTO.getEmail(), profileDTO.getAge(), profileDTO.getGender(), customer);
        profileRepository.save(profile);
    }
    public void updateProfile(Integer id ,Profile profile){
        Profile oldProfile =profileRepository.findProfileById(id);
        if (oldProfile == null) {
            throw  new ApiException("the customer not found");
        }

        oldProfile.setEmail(profile.getEmail());
        oldProfile.setAge(profile.getAge());
        oldProfile.setGender(profile.getGender());
        profileRepository.save(oldProfile);

    }
    public void delleteProfile(Integer id){
        Customer customer=customerRepository.findCustomerById(id);
        if (customer!=null) {
            customer.setProfile(null);
        }
        Profile profile =profileRepository.findProfileById(id);
        profileRepository.delete(profile);

    }
}
