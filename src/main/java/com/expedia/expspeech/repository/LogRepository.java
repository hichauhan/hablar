package com.expedia.expspeech.repository;

import org.springframework.data.repository.CrudRepository;

import com.expedia.expspeech.POJO.Log;

public interface LogRepository extends CrudRepository<Log, Integer> {
}
