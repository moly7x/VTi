//
package com.moly7x.secureapp;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.moly7x.secureapp.model.User;

/**
 * This class is . 
 * 
 * @author: Tân
 * @create_date: 12/08/2020
 */
public class UserPrincipal implements UserDetails{

	//
	private static final long serialVersionUID = 1L;
	
	private User user;
	
	public UserPrincipal(User user) {
		super();
		this.user = user;
	}

	/* 
	* @see org.springframework.security.core.userdetails.UserDetails#getAuthorities()
	*/
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singleton(new SimpleGrantedAuthority("USER"));
	}

	/* 
	* @see org.springframework.security.core.userdetails.UserDetails#getPassword()
	*/
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	/* 
	* @see org.springframework.security.core.userdetails.UserDetails#getUsername()
	*/
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	/* 
	* @see org.springframework.security.core.userdetails.UserDetails#isAccountNonExpired()
	*/
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	/* 
	* @see org.springframework.security.core.userdetails.UserDetails#isAccountNonLocked()
	*/
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	/* 
	* @see org.springframework.security.core.userdetails.UserDetails#isCredentialsNonExpired()
	*/
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	/* 
	* @see org.springframework.security.core.userdetails.UserDetails#isEnabled()
	*/
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
