//
package com.Spring_Core.Component;

import com.Spring_Core.Entity.Accessories;
import com.Spring_Core.Entity.HairStyle;
import com.Spring_Core.Entity.Outfit;

/**
 * This class is . 
 * 
 * @author: Tân
 * @create_date: 05/06/2020
 */
public class Girl {
	private Outfit outfit;
	private Accessories accessories;
	private HairStyle hairStyle;
	
	public Girl(Outfit outfit, Accessories accessories, HairStyle hairStyle) {
		this.outfit = outfit;
		this.accessories = accessories;
		this.hairStyle = hairStyle;
	}

	@Override
	public String toString() {
		return "Girl [outfit=" + outfit + ", accessories=" + accessories + ", hairStyle=" + hairStyle + "]";
	}	
}
