package com.expedia.expspeech.repository;

import org.springframework.data.repository.CrudRepository;

import com.expedia.expspeech.POJO.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
