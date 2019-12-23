package com.flowers.rest.service.impl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flowers.rest.beans.UserDetail;
import com.flowers.rest.repository.IUserDetailRepository;
import com.flowers.rest.service.IUserDetailService;

@Service
public class UserDetailService implements IUserDetailService {

	@Autowired
	IUserDetailRepository userDetailRepository;

	@Override
	public List<UserDetail> getUserDetails() {
		List<UserDetail> userDetails = userDetailRepository.getUserDetails();		
		return userDetails;
	}    

	@Override
	public List<UserDetail> getUniqueUsers() {
		List<UserDetail> userDetails = userDetailRepository.getUserDetails();
		// Get distinct objects by key
        List<UserDetail> distinctElements = userDetails.stream()
                                            .filter( distinctByKey(p -> p.getUserId()) )
                                            .collect( Collectors.toList() );
		System.out.println(distinctElements.toString());
		return distinctElements;
	}
	
	//Utility function
    private static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) 
    {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

	@Override
	public UserDetail updateUserDetailsById(int id, String value) {
		List<UserDetail> userDetails = getUserDetails();
		UserDetail userDetail = userDetails.stream().filter(user -> user.getId() == id).findAny().orElse(null);
		userDetail.setTitle(value);
		userDetail.setBody(value);
		return userDetail;
	}

}
