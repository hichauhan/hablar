package com.expedia.expspeech.repository;

import org.springframework.data.repository.CrudRepository;

import com.expedia.expspeech.POJO.Sms;

public interface SmsRepository extends CrudRepository<Sms, Integer> {
}
