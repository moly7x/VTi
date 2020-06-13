//
package com.Spring_Core.Component;

import com.Spring_Core.Entity.Outfit;

/**
 * This class is . 
 * 
 * @author: Tân
 * @create_date: 05/06/2020
 */
public class Bikini implements Outfit {

	/* 
	* @see com.Spring_Core.Entity.Outfit#wear()
	*/
	@Override
	public void wear() {
		System.out.println("Đã mặc bikini!!");
	}

}
