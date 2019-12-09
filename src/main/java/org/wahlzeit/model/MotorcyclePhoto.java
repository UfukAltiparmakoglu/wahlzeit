/*
 * Copyright (c) 2006-2009 by Dirk Riehle, http://dirkriehle.com
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Entity;

/**
 * A motorcycle photo extends photo.
 */
@Entity
public class MotorcyclePhoto extends Photo {

	private Location location;
	private String name;
	private int horsePower = -1;

	public MotorcyclePhoto() {
		super();
	}

	public MotorcyclePhoto(PhotoId myId) {
		super(myId);
	}

	public MotorcyclePhoto(PhotoId myId, String name, int horsePower) throws IllegalArgumentException{
		super(myId);
		setName(name);
		setHorsePower(horsePower);
	}

	public int getHorsePower(){
		return this.horsePower;
	}

	public void setHorsePower(int horsePower) throws IllegalArgumentException{
		assertIsValidInteger(horsePower);
		this.horsePower = horsePower;
	}

	public String getName(){
		return this.name;
	}

	public void setName(String name) throws IllegalArgumentException{
		assertIsValidName(name);
		this.name = name;
	}

	private void assertIsValidInteger(int horsePower) {
		if(horsePower <= 0 || horsePower > 1000) {
			throw new IllegalArgumentException("Provided horsePower is not between 1 and 1000!");
		}		
	}

	private void assertIsValidName(String name) {
		if(name == null || name.isBlank()) {
			throw new IllegalArgumentException("Provided name can not be blank!");
		}		
	}
}
