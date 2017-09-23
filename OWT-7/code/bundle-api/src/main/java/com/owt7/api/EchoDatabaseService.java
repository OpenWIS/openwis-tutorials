package com.owt7.api;

import com.owt7.api.dto.MessageDTO;


public interface EchoDatabaseService {

	Integer create(MessageDTO messageDTO);
	MessageDTO get(Integer id);
	void update(Integer id);
	
}
