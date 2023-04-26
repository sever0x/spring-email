package com.shdwraze.springemail.mapper;

import com.shdwraze.springemail.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE)
public interface Mappers {
    default UserDetails toUserDetails(UserEntity userEntity) {
        return User.withUsername(userEntity.getEmail())
                .password(userEntity.getPassword()).build();
    }
}
