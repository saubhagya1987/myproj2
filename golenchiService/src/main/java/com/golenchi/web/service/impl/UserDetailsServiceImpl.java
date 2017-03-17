package com.golenchi.web.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.golenchi.web.dao.UserDao;
import com.golenchi.web.roles.Role;

@Service("customUserDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao userDao;
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Map<String, Object> map = new HashMap<>();
		map.put("username", username);
		com.golenchi.web.user.User user = userDao.findSingleResultByNameQuery("User.findByUsername", map);
		
		if(user == null){
			throw new UsernameNotFoundException("User Not Found");
		}
		
		List<Role> groups = user.getRoles();
		//Set<Feature> features  = new HashSet<>();
		Set<String> features  = new HashSet<>();
		
		
		groups.forEach((Role group) -> {
			features.addAll(group.getFeatures());
		
		});
		
		/*Set<GrantedAuthority> authorities = new HashSet<>();
		features.forEach((Feature feature) ->{
			authorities.add(new SimpleGrantedAuthority(feature.getRole()));
			
		});*/
		
		Set<GrantedAuthority> authorities = new HashSet<>();
		features.forEach((String feature) ->{
			authorities.add(new SimpleGrantedAuthority("ROLE_"+feature));
			
		});

		UserDetails details = new User(username, user.getPassword(), authorities);
		return details;

	}
}