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

import java.util.Date;

import com.googlecode.objectify.annotation.Entity;

/**
 * A motorcycle photo extends photo.
 */
@Entity
public class MotorcyclePhoto extends Photo {

	private static final long serialVersionUID = 1L;
	private Motorcycle motorcycle;
	private Date timeTaken;

	public MotorcyclePhoto() {
		super();
		this.motorcycle = MotorcycleManager.getInstance().createMotorcycle("default");
	}

	public MotorcyclePhoto(PhotoId myId) {
		super(myId);
		this.motorcycle = MotorcycleManager.getInstance().createMotorcycle("default");
	}
	
	public MotorcyclePhoto(PhotoId myId, String name) {
		super(myId);
		this.motorcycle = MotorcycleManager.getInstance().createMotorcycle("default", name);
	}

	public MotorcyclePhoto(PhotoId myId, String name, int horsePower) {
		super(myId);
		this.motorcycle = MotorcycleManager.getInstance().createMotorcycle("default", name, horsePower);
	}
	
	public Motorcycle getMotorcycle() {
		return this.motorcycle;
	}
	
	public void setMotorcycle(Motorcycle motorcycle) {
		assertIsValidMotorcycle(motorcycle);
		this.motorcycle = motorcycle;
	}
	
	public Date getTimeTaken() {
		return this.timeTaken;
	}
	
	public void setTimeTaken(Date timeTaken) {
		assertIsValidDate(timeTaken);
		this.timeTaken = timeTaken;
	}	
	
	
	private void assertIsValidMotorcycle(Motorcycle motorcycle){
		if(motorcycle == null) {
			throw new IllegalArgumentException("Provided motorcycle can not be null!");
		}
	}
	
	private void assertIsValidDate(Date timeTaken){
		if(timeTaken == null) {
			throw new IllegalArgumentException("Provided date can not be null!");
		}
	}
	
}
