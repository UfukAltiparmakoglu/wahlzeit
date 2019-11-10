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

import com.google.api.client.util.ArrayMap;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.images.Image;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Ignore;
import com.googlecode.objectify.annotation.Parent;
import org.wahlzeit.services.DataObject;
import org.wahlzeit.services.EmailAddress;
import org.wahlzeit.services.Language;
import org.wahlzeit.services.ObjectManager;

import java.util.Map;

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

	public MotorcyclePhoto(PhotoId myId, String name, int horsePower) {
		super(myId);
		this.name = name;
		this.horsePower = horsePower;
	}

	public int getHorsePower(){
		return this.horsePower;
	}

	public void setHorsePower(int horsePower){
		this.horsePower = horsePower;
	}

	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name = name;
	}
}
